package kr.ac.sejong.controller;

import kr.ac.sejong.service.UploadFormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
public class UploadFormController {
    private static final Logger logger = LoggerFactory.getLogger(UploadFormController.class);

    @Inject
    private UploadFormService uploadFormService;

    @GetMapping("/uploadForm")
    public void uploadForm(Model model, HttpSession httpSession) throws Exception{
        httpSession.removeAttribute("file");
    }
}