package kr.ac.sejong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class CourseScheduleController {

    @GetMapping(path = "/trackSubject")
    public String trackSubject() {
        return "trackSubject";
    }
}

