package kr.ac.sejong.handler;

import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log
@Component("logoutSuccessHandler")
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        try {
            log.info("onLogoutSuccess"); /*로그아웃 하는*/

            if (authentication != null && authentication.getDetails() != null) {
                try {
                    request.getSession().invalidate();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("/");
        } catch (NullPointerException e) {
            e.printStackTrace();
            session.setAttribute("sessionState", "timeout");
        }
    }
}