package kr.ac.sejong;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.sejong.config.auth.UISAuthService;
import kr.ac.sejong.web.dto.uis.UISLoginResponseDto;
import kr.ac.sejong.web.dto.uis.UISUserInfoResponseDto;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Log
public class UISAuthTest {

    @Autowired
    private UISAuthService uisAuthService;

    @Test
    public void UISAuthTest() throws IOException {

        String id = "Your ID";
        String password = "Your Password";

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

        Map<String, String> data2 = new HashMap<>();
        data2.put("pgauth_sys_id", "SELF_STUD");
        data2.put("pgauth_sub_id", "SELF_SUB_20");
        data2.put("pgauth_menu_id", "SELF_MENU_10");
        data2.put("pgauth_pg_id", "SudMasterBodyE");
        data2.put("pgauth_self_yn","Y");
        data2.put("pgauth_orgn_clsf_map_cd","MAP-001");
        data2.put("pgauth_orgn_clsf_ctrl_yn","Y");
        data2.put("pgauth_auth_depth_cd","9");
        data2.put("pgauth_upd_posb_yn","Y");
        data2.put("pgauth_dwn_posb_yn","Y");
        data2.put("pguser_member_no",id);
        data2.put("param_member_no",id);
        data2.put("strCommand","Student");
        data2.put("keyOrgnClsfCd","");
        data2.put("keyStudentNo",id);

        String userInfoJson = Jsoup.connect("http://uis.sejong.ac.kr/app/modules/sch_sud/sch.SchStudentBaseInfo.do")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "en-US,en;q=0.9,ko;q=0.8")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("eXria-Version", "eXria.1.0")
                .header("Referer", "http://uis.sejong.ac.kr/app/modules/sch_sud/SudMasterBodyE.xrf")
                .header("req-charset", "UTF-8")
                .header("req-protocol", "urlencoded")
                .header("res-charset", "utf-8")
                .header("res-protocol", "json")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36")
                .timeout(3000)
                .cookies(UISResponsePage.cookies())
                .data(data2)
                .method(Connection.Method.POST)
                .execute()
                .body();

        userInfoJson = userInfoJson.replace("{\n" + "root:{\n" + "listMain:{\n" + "list:[\n" + "{ ","{");
        userInfoJson = userInfoJson.replace("}\n" + "]\n" + "}\n" + "}\n" + "}", "}");

        log.info(userInfoJson);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        UISUserInfoResponseDto uisUserInfoResponseDto = objectMapper.readValue(userInfoJson, UISUserInfoResponseDto.class);

        long end = System.currentTimeMillis();
        double time = (end - start) / 1000.0;

        log.info(UISLoginResponseDto.of(uisUserInfoResponseDto).toString());
    }
}
