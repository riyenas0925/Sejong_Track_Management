package kr.ac.sejong.web;

import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * uis 로그인 -> 200이면
 * 회원가입 아이디 부분 자동으로 채워지고 수정못하게 막는다.
 **/
@Log
@RestController
public class AutoLoginController {

    private final String LOGIN_URL = "https://portal.sejong.ac.kr/jsp/login/uisloginSSL.jsp";
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36";

    private String token_rtUrl = null;
    private String token_loginUrl = null;
    private Map<String, String> loginTryCookie;
    private Map<String, String> loginCookie;

    @PostMapping("/remoteLogin")
    public ResponseEntity<String> remoteLogin(@RequestParam String targetId, @RequestParam String targetPw) throws IOException {
        //RequestBody같은걸로 바꾸기. Requestparam은 url에 노출됨.
        log.info("autoLogin 진입..... targetId:" + targetId + ", targetPw:" + targetPw);

        getTokenByConnection();

        log.info("token_rtUrl: " + token_rtUrl);
        log.info("token_loginUrl: " + token_loginUrl);
        log.info("loginTryCookie: " + loginTryCookie);

        Map<String, String> data = new HashMap<>();
        data.put("id", targetId);
        data.put("password", targetPw);
        data.put("rtUrl", token_rtUrl);//로그인페이지에서 얻은 토큰들
        data.put("loginUrl", token_loginUrl);

        ResponseEntity<String> res = remoteLogin(data);
//        String name = getNameAfterLogin();

        return res;
    }

//    public String getNameAfterLogin() throws IOException {
//        Document my = Jsoup.connect("http://uis.sejong.ac.kr/app/sys.Login.servj")
////                .userAgent(userAgent)
//                .header("Referer", "http://www.tistory.com/")
//                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .header("Accept-Encoding", "gzip, deflate, sdch")
//                .header("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4")
//                .cookies(loginCookie) // 위에서 얻은 '로그인 된' 쿠키
//                .get();
//
//        String name = my.select("tbody>tr>td>strong").val();
//        log.info("name: " + name);
//        return name;
//    }

    public ResponseEntity<String> remoteLogin(Map<String, String> data) throws IOException {
        ResponseEntity<String> entity = null;
        try {
            Connection.Response response = Jsoup.connect(LOGIN_URL)  //로그인 실패해도 200뜸. 가려낼게 필요함.
//                    .userAgent(USER_AGENT)
                    .timeout(5000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                    .cookies(loginTryCookie)
                    .data(data)
                    .method(Connection.Method.POST)
                    .execute();

//            if (response.statusCode() == 200) {
            loginCookie = response.cookies();  // --> 로그인 된 쿠키
            log.info("loginCookie : " + loginCookie);
            entity = new ResponseEntity<>("success", HttpStatus.OK);
//            }
//            } else {
//                log.info("this is for bad response.....");
//                entity = new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
//            }
        } catch (Exception e) {
            log.warning(e.getMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }


    public void getTokenByConnection() throws IOException {
        // 로그인 페이지 접속
        Connection.Response loginPageResponse = Jsoup.connect(LOGIN_URL)
                .userAgent(USER_AGENT)
                .timeout(5000)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Sec-Fetch-Dest", "document")
                .method(Connection.Method.GET)
                .execute();// Document보다 상위 객체인 Response 객체를 얻어옴.(get(), post()메소드도 있음, execute()는 그 전에 쿠키 얻어오려고)

        // 로그인 페이지에서 얻은 쿠키
        loginTryCookie = loginPageResponse.cookies();

        // 로그인 페이지에서 로그인에 함께 전송하는 토큰 얻어내기
        Document loginPageDocument = loginPageResponse.parse();
        token_rtUrl = loginPageDocument.select("input[name=rtUrl]").val();
        token_loginUrl = loginPageDocument.select("input[name=loginUrl]").val();
    }
}