package kr.ac.sejong.web;

import kr.ac.sejong.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class NoticeController {
    @Inject
    NoticeService service;

    @GetMapping("/noticeList")
    public String NoticeListView() {
        return "noticeList";
    }

    @GetMapping("/notice/details/{id}")
    public ModelAndView NoticeView(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("noticeDetails");
        mav.addObject("noticeModel", service.findById(id));

        return mav;
    }
}