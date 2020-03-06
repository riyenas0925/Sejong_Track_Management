package kr.ac.sejong.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrackRuleController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/trackRule")
    public String user(){

        return "trackRule";
    }
}