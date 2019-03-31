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

    }
}
