package kr.ac.sejong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.UUID;

@Controller
public class UploadFormController {
    private static final Logger logger = LoggerFactory.getLogger(UploadFormController.class);

    @Resource(name = "uploadPath")
    private String uploadPath;

    @GetMapping("/uploadForm")
    public void uploadForm() throws Exception{

    }

    @PostMapping("/uploadForm")
    public String uploadForm(MultipartFile file, Model model) throws Exception{
        logger.info(uploadPath);
        logger.info("originalName : " + file.getOriginalFilename());
        logger.info("size : " + file.getSize());
        logger.info("contentType : " + file.getContentType());

        String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());

        Integer trackNo = 1;

        model.addAttribute("savedName", savedName);
        model.addAttribute("trackNo", trackNo);

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