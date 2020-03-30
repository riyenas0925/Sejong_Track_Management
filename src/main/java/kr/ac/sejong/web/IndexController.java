package kr.ac.sejong.web;

import kr.ac.sejong.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Log
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final NoticeService service;

    /******************
        Student Page
    *******************/

    //Home Page
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    //Notice Page
    @GetMapping("/notice")
    public String NoticeListView() {
        return "notice";
    }

    @GetMapping("/notice/{id}")
    public ModelAndView NoticeView(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("notice/update");
        mav.addObject("noticeModel", service.findById(id));

        return mav;
    }

    //Track All Page
    @GetMapping("/trackAll")
    public String trackAll() throws Exception{
        return "trackAll";
    }

    //Profile Page
    @Value("${spring.profile.value}")
    private String profile;

    @GetMapping("/profile")
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    /******************
        Admin Page
     *******************/

    // CourseSchedule
    @GetMapping(path = "/courseSchedule")
    public String trackSubject() {
        return "courseSchedule";
    }

    //Track Rule Page
    @RequestMapping("/trackRule")
    public String trackRule(){
        return "trackRule";
    }

}
