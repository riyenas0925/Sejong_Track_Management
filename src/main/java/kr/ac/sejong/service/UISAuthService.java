package kr.ac.sejong.service;

import kr.ac.sejong.web.dto.uis.UISLoginRequestDto;
import kr.ac.sejong.web.dto.uis.UISLoginResponseDto;
import lombok.ToString;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@ToString
public class UISAuthService {

    private static final String UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36";
    private static final String Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9";
    private static final String Origin = "https://portal.sejong.ac.kr";
    private static final String Referer = "https://portal.sejong.ac.kr/jsp/login/uisloginSSL.jsp?rtUrl=uis.sejong.ac.kr/app/sys.Login.servj?strCommand=SSOLOGIN";

    public UISLoginResponseDto auth(UISLoginRequestDto uisLoginRequestDto) throws IOException {

        Map<String, String> data = new HashMap<>();
        data.put("rtUrl", "uis.sejong.ac.kr/app/sys.Login.servj?strCommand=SSOLOGIN");
        data.put("loginUrl", "uisloginSSL.jsp");
        data.put("id", uisLoginRequestDto.getId());
        data.put("password", uisLoginRequestDto.getPassword());

        Connection.Response loginResponse = Jsoup.connect("https://portal.sejong.ac.kr/jsp/login/login_action.jsp")
                .header("Accept", Accept)
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Cache-Control", "max-age=0")
                .header("Connection", "keep-alive")
                .header("Content-Length", "125")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Host", "portal.sejong.ac.kr")
                .header("Origin", Origin)
                .header("Referer", Referer)
                .header("Sec-Fetch-Dest", "document")
                .header("Sec-Fetch-Mode", "navigate")
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Fetch-User", "?1")
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", UserAgent)
                .timeout(3000)
                .data(data)
                .method(Connection.Method.POST)
                .execute();

        Connection.Response UISResponsePage = Jsoup.connect("http://uis.sejong.ac.kr/app/sys.Login.servj")
                .timeout(3000)
                .header("Accept", Accept)
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", UserAgent)
                .cookies(loginResponse.cookies())
                .method(Connection.Method.GET)
                .execute();

        Document UISMenuResponsPage = Jsoup.connect("http://uis.sejong.ac.kr/app/menu/sys.MenuSys.doj")
                .timeout(3000)
                .header("Accept", Accept)
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", UserAgent)
                .cookies(UISResponsePage.cookies())
                .method(Connection.Method.GET)
                .get();

        Element memberName = UISMenuResponsPage.selectFirst("body > form:nth-child(3) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > strong:nth-child(1)");

        return UISLoginResponseDto.builder()
                .id(uisLoginRequestDto.getId())
                .name(memberName.text())
                .build();
    }
}
