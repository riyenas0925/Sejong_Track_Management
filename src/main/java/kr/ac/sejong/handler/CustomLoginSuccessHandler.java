package kr.ac.sejong.handler;

import kr.ac.sejong.domain.CustomUserDetails;
import kr.ac.sejong.domain.Member;
import kr.ac.sejong.persistence.MemberRepository;
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

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

@Log
@Component("loginSuccessHandler")
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    private static int TIME = 10; // 30분

    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Inject
    private MemberRepository memberRepository;

    @Override /* authentication : 로그인 한 유저 정보 */
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws ServletException, IOException {

        //로그인 실패 후 로그인 성공시 : 실패했을 때 에러가 세션에 남아있게 됨.
        clearAuthenticationAttributes(request);

        //세션 지속시간 설정 : 세션의 기본 객체가 사용될 때마다 세션의 최근 접근 시간은 갱신된다.
        request.getSession().setMaxInactiveInterval(TIME);
//        request.getSession().setAttribute("isSession","yes");
//        log.info("login session 궁금하지?");
//        Enumeration e = request.getSession().getAttributeNames();
//        int i=0;
//        while( e.hasMoreElements()){
//            String t_name = e.nextElement().toString();
//            log.info("| "+ ++i + " |"+ t_name+":"+request.getSession().getAttribute(t_name));
//        }

        //로그인 한 날짜 기록
        updateLoginDate(auth);

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

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) return;
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    protected void updateLoginDate(Authentication auth){
        log.info("authToken & getPrincipal() : " + auth.getPrincipal()); /** auth.getName()은 auth의 Principal의 종류를 매칭한 후
                                                                                * (이 경우 CustomUserDetails)
                                                                                * 그 객체의 name정보를 가져오는 것 */
        String user_id = ((CustomUserDetails) auth.getPrincipal()).getId();
        log.info("authToken & cast to CustomUserDetials : " + user_id);
        Member member = memberRepository.findById(user_id).get();
        member.setLogindate(new Date());
        memberRepository.save(member);

    }
}
