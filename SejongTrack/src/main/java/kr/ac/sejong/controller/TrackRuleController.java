package kr.ac.sejong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrackRuleController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/trackrule")
    public String user(){

        return "trackrule";
    }
}