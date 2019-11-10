package kr.ac.sejong.controller;

import kr.ac.sejong.domain.Member;
import kr.ac.sejong.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MemberController {

    private static Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Inject
    MemberService memberService;

    @RequestMapping("/joinView")
    public void joinView(Model model) {

    }

    @RequestMapping("/loginView")
    public void loginView(Model model) {

    }

    @ResponseBody
    @RequestMapping("/memberExist")
    public String memberExist(Member member) {

        String res = memberService.IsMemberExist(member);
        logger.info("MemberExist - res : " + res);

        return res;
    }

    @ResponseBody
    @RequestMapping("/memberPwCorrect")
    public String memberPwCorrect(Member member){
        Optional<Member> m = memberService.findMember(member); //jsp단에서 멤버가 확실히 있음을 이미 체크.
        if(m.get().getPassword().equals(member.getPassword())){
            return "Yes";
        }
        else{
            return "No";
        }
    }

    @RequestMapping("/memberJoin")
    public String memberJoin(Member member, Model model) {
        int resInt = memberService.join(member);
        logger.info("resInt : " + resInt);
        if (resInt == 1)
            model.addAttribute("IsJoin", "Yes");
        else
            model.addAttribute("IsJoin", "No");

        return "joinResult";
    }



    @RequestMapping("/memberLogin") //세션 저장용
    public String memberLogin(Member member, HttpSession session){ //, @RequestParam(value = "rememberCheck") List<String> rCheck) {
        Optional<Member> m = memberService.findMember(member);  //return Optional한 멤버의 정보
        session.setAttribute("memberInfo", m.get());
        //logger.info("List<String> rCheck - "+ rCheck.get(0));
        //if(rCheck.get(0).equals("Yes")) {
        //   session.setMaxInactiveInterval(60 * 60 * 24 * 30); //체크햇으면 30일동안 기억
        //   logger.info("30days");

        // } else {
            session.setMaxInactiveInterval(60 * 60 * 2); //2시간(초단위)
            logger.info("2hours");
        // }
        return "redirect:/"; //home을 리턴하면 home.jsp는 찾아가지만 url은 안바뀐다! joinResult도 url안바뀌는 것처럼.

    }

    @RequestMapping("/memberLogout")
    public String memberLogout(HttpSession session) {
        session.removeAttribute("memberInfo");//세션 해제
        logger.info("session - 'memberInfo' :"+ session.getAttribute("memberInfo"));
        return "redirect:/";
    }
}
