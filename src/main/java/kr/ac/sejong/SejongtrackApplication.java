package kr.ac.sejong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SejongtrackApplication {
    public static void main(String[] args) {

        String profile = System.getProperty("spring.profiles.active");
        if(profile == null) {
            System.setProperty("spring.profiles.active", "develop-h2");
        }

        SpringApplication.run(SejongtrackApplication.class, args);
    }
}
