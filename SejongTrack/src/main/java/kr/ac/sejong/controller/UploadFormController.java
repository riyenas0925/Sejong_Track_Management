package kr.ac.sejong.controller;

import kr.ac.sejong.domain.trackSubjectVO;
import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;
import kr.ac.sejong.persistence.UploadFormDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadFormController {
    private static final Logger logger = LoggerFactory.getLogger(UploadFormController.class);

    @Inject
    private UploadFormDAO dao;

    @Resource(name = "uploadPath")
    private String uploadPath;

    @GetMapping("/uploadForm")
    public void uploadForm(Model model) throws Exception{
        List<univVO> univList = dao.listUniv();
        model.addAttribute("univs", univList);
    }

    @PostMapping("/uploadForm")
    public String uploadForm(MultipartFile file, Model model) throws Exception{
        logger.info(uploadPath);
        logger.info("originalName : " + file.getOriginalFilename());
        logger.info("size : " + file.getSize());
        logger.info("contentType : " + file.getContentType());

        String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());

        model.addAttribute("savedName", savedName);
        return "redirect:/uploadResult";
    }

    private String uploadFile(String originalName, byte[] fileData)throws Exception{
        UUID uid = UUID.randomUUID();
        String savedName = uid.toString() + "_"+ originalName;
        File target = new File(uploadPath,savedName);
        FileCopyUtils.copy(fileData, target);
        return savedName;
    }
}