package kr.ac.sejong;

import kr.ac.sejong.config.auth.UISAuthService;
import kr.ac.sejong.web.dto.uis.UISLoginRequestDto;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
public class UISAuthTest {

    @Autowired
    private UISAuthService uisAuthService;

    @Test
    public void UISAuthTest() throws IOException {

        String id = "Member ID";
        String password = "Member Password";

        long start = System.currentTimeMillis();

        Map<String, String> data = new HashMap<>();
        data.put("rtUrl", "uis.sejong.ac.kr/app/sys.Login.servj?strCommand=SSOLOGIN");
        data.put("loginUrl", "uisloginSSL.jsp");
        data.put("id", id);
        data.put("password", password);

        Connection.Response loginResponse = Jsoup.connect("https://portal.sejong.ac.kr/jsp/login/login_action.jsp")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Cache-Control", "max-age=0")
                .header("Connection", "keep-alive")
                .header("Content-Length", "125")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Host", "portal.sejong.ac.kr")
                .header("Origin", "https://portal.sejong.ac.kr")
                .header("Referer", "https://portal.sejong.ac.kr/jsp/login/uisloginSSL.jsp?rtUrl=uis.sejong.ac.kr/app/sys.Login.servj?strCommand=SSOLOGIN")
                .header("Sec-Fetch-Dest", "document")
                .header("Sec-Fetch-Mode", "navigate")
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Fetch-User", "?1")
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36")
                .timeout(3000)
                .data(data)
                .method(Connection.Method.POST)
                .execute();

        Connection.Response UISResponsePage = Jsoup.connect("http://uis.sejong.ac.kr/app/sys.Login.servj")
                .timeout(3000)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36")
                .cookies(loginResponse.cookies())
                .method(Connection.Method.GET)
                .execute();

        Document UISMenuResponsPage = Jsoup.connect("http://uis.sejong.ac.kr/app/menu/sys.MenuSys.doj")
                .timeout(3000)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36")
                .cookies(UISResponsePage.cookies())
                .method(Connection.Method.GET)
                .get();

        Element MemberName = UISMenuResponsPage.selectFirst("body > form:nth-child(3) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > strong:nth-child(1)");

        long end = System.currentTimeMillis();
        double time = (end - start) / 1000.0;

        log.info("Time : " + time + "s, " + "Member Name : " + MemberName.text());
    }

    @Test
    public void test() throws IOException {
        String id = "Member ID";
        String password = "Member Password";

        UISLoginRequestDto request = new UISLoginRequestDto(id, password);

        log.info(uisAuthService.auth(request).toString());
    }
}
