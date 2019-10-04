package kr.ac.sejong.controller;

import kr.ac.sejong.domain.Member;
import kr.ac.sejong.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class MemberJoinController {

    @Inject
    MemberService memberService;

    @RequestMapping("/joinView")
    public String joinView(){

        return "joinView";
    }

    @RequestMapping("/memberJoin")
    public String memberJoin(Member member){

        memberService.join(member);
        return "joinResult";
    }
}
