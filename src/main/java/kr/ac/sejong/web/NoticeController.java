package kr.ac.sejong.web;

import kr.ac.sejong.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService service;

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
}