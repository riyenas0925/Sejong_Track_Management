package kr.ac.sejong.controller;

import kr.ac.sejong.domain.Member;
import kr.ac.sejong.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class MemberJoinController {

    private static Logger logger = LoggerFactory.getLogger(MemberJoinController.class);

    @Inject
    MemberService memberService;

    @RequestMapping("/joinView")
    public String joinView(){
        return "joinView";
    }

    @RequestMapping("/memberJoin")
    public String memberJoin(Member member, Model model){
        int resInt = memberService.join(member);
        logger.info("resInt : "+resInt);
        if( resInt == 1)
        {
            model.addAttribute("IsJoin", "Yes");
        }
        else{
            //실패
            model.addAttribute("IsJoin", "No");
        }
        return "joinResult";
    }
}
