package kr.ac.sejong.config.auth;

import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.domain.member.MemberRepository;
import kr.ac.sejong.web.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * CustomAuthenticatinoProvider에서 반환한 UsernamePasswordAuthenticationToken가
 * authentication 자라에 들어감.
 */
@Log
@RequiredArgsConstructor
@Component("loginSuccessHandler")
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    private static int TIME = 30 * 60; // 30분

    private RequestCache requestCache = new HttpSessionRequestCache();          //spring security 제공.
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();  //spring security 제공.
    private final CustomUserDetailsService customUserDetailsService;
    private final MemberRepository memberRepository;

    @Override /* authentication : 로그인 한 유저 정보 */
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws ServletException, IOException {

        //세션에서 로그인실패기록 지움 + 유저 정보 넘겨줌
        resetNewAuthenticationAttributes(request, auth);

        //세션 지속시간 설정 : 세션의 기본 객체가 사용될 때마다 세션의 최근 접근 시간은 갱신된다.
        request.getSession().setMaxInactiveInterval(TIME);

        //로그인 한 날짜 기록
        updateLoginTime(auth);

        //로그인 후 redirect
        resultRedirectStrategy(request, response);
    }

    protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        SavedRequest savedRequest = requestCache.getRequest(request, response); /*RequestCache 객체를 통해 SavedRequest 객체를 가져온다.*/
        String defaultUrl = "/";

        if (savedRequest != null) { /*세션에 이동할 url의 정보가 담겨져 있을때 즉, 인증 권한이 필요한 페이지에 접근했을 경우를 뜻한다.*/
            String targetUrl = savedRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request, response, targetUrl); /*savedRequest 객체를 통해 getRedirectUrl (로그인화면을 보기 전에 갔던 url)을 가져온다.*/
        } else {                    /*직접 로그인 화면으로 이동했을 경우*/
            redirectStrategy.sendRedirect(request, response, defaultUrl);
        }

    }

    protected void resetNewAuthenticationAttributes(HttpServletRequest request, Authentication auth) {

        HttpSession session = request.getSession(false);

        //로그인실패기록,메시지 지우기
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            session.removeAttribute("loginErrorMsg");
        }

        //유저 세션 설정
        CustomUserDetails target = (CustomUserDetails) auth.getPrincipal(); //인자 Authentication으로 가져오기 - loadUser로 가져왔을 때
        CustomUserDetails result = (CustomUserDetails) customUserDetailsService.loadUserByUserId(target.getUserId());
        result.updatePasswordInvisible();

        session.setAttribute("userModel", result);
    }

    protected void updateLoginTime(Authentication auth) {
        /** auth.getName()은 auth의 Principal의 종류를 매칭한 후
         * (이 경우 CustomUserDetails)
         * 그 객체의 name정보를 가져오는 것 */
        String user_id = ((CustomUserDetails) auth.getPrincipal()).getUserId();

        Member member = memberRepository.findByUserId(user_id).get();
        member.updateLoginTime();
        memberRepository.save(member);
    }
}
