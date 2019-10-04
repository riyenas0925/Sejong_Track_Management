package kr.ac.sejong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"kr.ac.sejong.controller"})
public class SejongtrackApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SejongtrackApplication.class, args);
    }
}
