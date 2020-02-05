package kr.ac.sejong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String user(){
        logger.info("home called.........");
        return "home";
    }

    @RequestMapping("/bootstrap")
    public String ex1(){
        return "index";
    }

    @RequestMapping("/default")
    public String ex2(){
        return "default";
    }

}