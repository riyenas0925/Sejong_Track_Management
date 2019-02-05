package kr.ac.sejong.controller;

import kr.ac.sejong.domain.subjectVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class UploadResultController {

    private static final Logger logger = LoggerFactory.getLogger(UploadFormController.class);

    @Resource(name = "uploadPath")
    private String uploadPath;

    @GetMapping("uploadResult")
    public void uploadResult(String savedName , Model model)throws Exception{
        List<subjectVO> list =new ArrayList<subjectVO>();
        FileInputStream file = new FileInputStream(uploadPath + "\\" + savedName);

        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);

        for(int rowindex = 0; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++){
            if(rowindex != 0){
                HSSFRow row = sheet.getRow(rowindex);
                subjectVO vo = new subjectVO();

                vo.setCourseNum(row.getCell(2).getStringCellValue());
                vo.setCourseTitle(row.getCell(3).getStringCellValue());
                vo.setCompletionType(row.getCell(4).getStringCellValue());

                list.add(vo);
            }
        }

        model.addAttribute("list", list);

        logger.info(Arrays.toString(list.toArray()));
    }
}