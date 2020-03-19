package kr.ac.sejong.config.auth;

import lombok.extern.java.Log;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log
@Component("loginFailureHandler")
public class CustomLoginFailureHandler implements AuthenticationFailureHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response
            , AuthenticationException exception) throws IOException, ServletException {

        log.info("this is CustomLogin 'Failure' Handler.....");
        String loginErrorMsg = null; // 에러메시지를 세션에서 가져오는건 좋지않다.
        HttpSession session = request.getSession(false);

        if (exception instanceof BadCredentialsException) {
//            loginErrorMsg = MessageUtils.getMessage("error.BadCredentials");
            loginErrorMsg = "아이디나 비밀번호가 맞지 않습니다.";
        } else if (exception instanceof InternalAuthenticationServiceException) {
//            loginErrorMsg = MessageUtils.getMessage("error.InternalAuthenticationService");
            loginErrorMsg = "아이디나 비밀번호가 맞지 않습니다."; //보안을 위해 사용자에게 보여지는 에러메시지는 일부러 통일함.
        }

        log.info("loginErrorMsg = " + loginErrorMsg);
        session.setAttribute("loginErrorMsg", loginErrorMsg);
//        redirectStrategy.sendRedirect(request, response, "/loginView");
        response.sendRedirect("/loginView");
    }
}