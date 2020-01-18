package kr.ac.sejong.handler;

import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Log
@Component("logoutSuccessHandler")
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {

        log.info("onLogoutSuccess - authentication : "+ authentication.toString()); /*로그아웃 하는*/

        if (authentication != null && authentication.getDetails() != null) {
            try {
                request.getSession().invalidate();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/");
    }
}