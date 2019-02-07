package kr.ac.sejong.controller;

import kr.ac.sejong.domain.subjectVO;

import kr.ac.sejong.domain.trackSubjectVO;
import kr.ac.sejong.service.UploadResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@Controller
public class UploadResultController {

    private static final Logger logger = LoggerFactory.getLogger(UploadFormController.class);

    @Inject
    private UploadResultService service;

    @Resource(name = "uploadPath")
    private String uploadPath;

    @GetMapping("uploadResult")
    public void uploadResult(Integer trackNo, String savedName , Model model)throws Exception{
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

        List<trackSubjectVO> tracklist = service.readSub(trackNo);
        passSubject(list, tracklist, model);

        model.addAttribute("rule", service.readRule(trackNo));
    }

    private void passSubject(List<subjectVO> myList, List<trackSubjectVO> standList, Model model)throws Exception{
        List<trackSubjectVO> passSubjectList = new ArrayList<>();
        List<trackSubjectVO> nonPassSubjectList = new ArrayList<>();

        List<trackSubjectVO> passBasicList = new ArrayList<>();
        List<trackSubjectVO> passAppliedList = new ArrayList<>();
        List<trackSubjectVO> passIndustryList = new ArrayList<>();

        for(int i=0; i < standList.size(); i++){
            if(listContains(standList.get(i).getCourseTitle(), myList)){
                switch (standList.get(i).getSubType()){
                    case 1:
                        passBasicList.add(standList.get(i));
                        break;
                    case 2:
                        passAppliedList.add(standList.get(i));
                        break;
                    case 3:
                        passIndustryList.add(standList.get(i));
                        break;
                }
                passSubjectList.add(standList.get(i));
            }else{
                nonPassSubjectList.add(standList.get(i));
            }
        }

        logger.info(passBasicList.toString());
        logger.info(passAppliedList.toString());

        model.addAttribute("plist" , passSubjectList);
        model.addAttribute("nplist" , nonPassSubjectList);
        model.addAttribute("passCredit", calCredit(passSubjectList));

        model.addAttribute("pblist", passBasicList);
        model.addAttribute("palist",passAppliedList);
        model.addAttribute("pilist",passAppliedList);

        model.addAttribute("pbcredit", calCredit(passBasicList));
        model.addAttribute("pacredit", calCredit(passAppliedList));
        model.addAttribute("picredit", calCredit(passIndustryList));

    }

    private Boolean listContains(String standListTitle, List<subjectVO> myList){
        int cnt = 0;
        for(int i=0; i < myList.size(); i++){
            if(standListTitle.equals(myList.get(i).getCourseTitle())){
                cnt++;
                break;
            }
        }

        if(cnt == 0){ return false; }
        else{ return true; }
    }

    private int calCredit(List<trackSubjectVO> subjectList){
            int totalCredit = 0;

            for(int i=0; i < subjectList.size(); i++){
                totalCredit += subjectList.get(i).getCredit();
            }

        return totalCredit;
    }
}