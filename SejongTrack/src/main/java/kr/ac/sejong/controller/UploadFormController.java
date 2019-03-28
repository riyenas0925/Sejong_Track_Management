package kr.ac.sejong.controller;

import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackSubjectVO;
import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;
import kr.ac.sejong.persistence.UploadFormDAO;
import kr.ac.sejong.service.UploadFormService;
import kr.ac.sejong.service.UploadResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadFormController {
    private static final Logger logger = LoggerFactory.getLogger(UploadFormController.class);

    @Inject
    private UploadFormService uploadFormService;

    @GetMapping("/uploadForm")
    public void uploadForm(Model model) throws Exception{
       List<univVO> univList = uploadFormService.listUniv();
       model.addAttribute("univs", univList);
    }
}