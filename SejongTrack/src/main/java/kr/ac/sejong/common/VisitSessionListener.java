package kr.ac.sejong.common;

import kr.ac.sejong.domain.visitorVO;
import kr.ac.sejong.persistence.VisitCountDAO;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class VisitSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        try {

            HttpSession session = arg0.getSession();
            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
            VisitCountDAO visitCountDAO = (VisitCountDAO)wac.getBean("visitCountDAO");

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

            String ip = getIp(request);
            String device = getDevice(DeviceUtils.getCurrentDevice(request));
            String agent = getBrowser(request);
            String os = getOS(request);

            visitorVO vo = new visitorVO(ip, device, agent, os);
            System.out.println(vo.toString());
            visitCountDAO.visitorCreate(vo);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getIp(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    private String getDevice(Device device){

        String deviceType = "unknown";

        if (device.isNormal()) {
            deviceType = "nomal";
        }
        else if (device.isMobile()) {
            deviceType = "mobile";
        }
        else if (device.isTablet()) {
            deviceType = "tablet";
        }

        return deviceType;
    }

    private String getBrowser(HttpServletRequest request){
        String agent = request.getHeader("User-Agent");
        String browser = "unknown";

        if (agent != null) {
            if (agent.indexOf("Trident") > -1) {
                browser = "MSIE";
            } else if (agent.indexOf("Chrome") > -1) {
                browser = "Chrome";
            } else if (agent.indexOf("Opera") > -1) {
                browser = "Opera";
            } else if (agent.indexOf("iPhone") > -1 && agent.indexOf("Mobile") > -1) {
                browser = "iPhone";
            } else if (agent.indexOf("Android") > -1 && agent.indexOf("Mobile") > -1) {
                browser = "Android";
            }
        }

        return browser;
    }

    private String getOS(HttpServletRequest request){
        String agent = request.getHeader("User-Agent");
        String os = "unknown";

        if(agent.indexOf("Windows") != -1) {
            os = "Windows";
        }
        else if(agent.indexOf("Linux") != -1) {
            os = "Linux";
        }
        else if(agent.indexOf("Macintosh") != -1) {
            os = "Macintosh";
        }

        return os;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
}
