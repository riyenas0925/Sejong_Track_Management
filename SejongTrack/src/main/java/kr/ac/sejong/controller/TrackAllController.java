package kr.ac.sejong.controller;

import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackAllVO;
import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;
import kr.ac.sejong.service.TrackAllService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.inject.Inject;
import java.util.List;

@Controller
public class TrackAllController {
    private static final Logger logger = LoggerFactory.getLogger(TrackAllController.class);

    @Inject
    private TrackAllService trackAllService;

    @GetMapping("/trackAll")
    public void trackAll(Model model) throws Exception{

        List<trackAllVO> basicList = trackAllService.basicTrack(1);
        List<trackAllVO> appliedList = trackAllService.appliedTrack(1);
        List<univVO> univName = trackAllService.univName();
        List<trackVO> trackName = trackAllService.trackName(1);

        //....? jsp에서 uniNo를 검색하게할 수 있음?

        model.addAttribute("basicList", basicList);
        model.addAttribute("appliedList", appliedList);
        model.addAttribute("univName",univName);
        model.addAttribute("trackName",trackName);
    }
}
