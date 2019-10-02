package kr.ac.sejong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private static final String PATH = "/error"; // configure 에서 Redirect 될 path

    @RequestMapping(value = PATH)
    public String error(HttpServletRequest request) {

        logger.info("error page called.........");
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (String.valueOf(status).equalsIgnoreCase(HttpStatus.NOT_FOUND.toString())) {
            return "errors/404"; // /WEB-INF/errors/404.jsp
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}