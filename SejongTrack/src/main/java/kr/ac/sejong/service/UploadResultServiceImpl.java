package kr.ac.sejong.service;

import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackSubjectVO;
import kr.ac.sejong.persistence.UploadResultDAO;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UploadResultServiceImpl implements UploadResultService{

    @Inject
    private UploadResultDAO dao;

    @Resource(name = "uploadPath")
    private String uploadPath;

    @Override
    public ruleVO readRule(Integer ruleNo) throws Exception{
        return dao.readRule(ruleNo);
    }

    @Override
    public List<trackSubjectVO> readSub(Integer subType) throws Exception{
        return dao.readSub(subType);
    }

    @Override
    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception{
        return dao.readTypeSub(trackNo, subType);
    }

    @Override
    public List<subjectVO> readMySub(String savedName) throws Exception{

        List<subjectVO> mySubList = new ArrayList<subjectVO>();
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

                mySubList.add(vo);
            }
        }

        return mySubList;
    }

    @Override
    public HashMap<String, List<trackSubjectVO>> resultListSub(List<subjectVO> myList, List<trackSubjectVO> standList) throws Exception{
        HashMap<String, List<trackSubjectVO>> passListSubMap = new HashMap<>();

        List<trackSubjectVO> passBasicList = new ArrayList<>();
        List<trackSubjectVO> passAppliedList = new ArrayList<>();
        List<trackSubjectVO> passIndustryList = new ArrayList<>();

        List<trackSubjectVO> nonPassBasicList = new ArrayList<>();
        List<trackSubjectVO> nonPassAppliedList = new ArrayList<>();
        List<trackSubjectVO> nonPassIndustryList = new ArrayList<>();

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
            }else{
                switch (standList.get(i).getSubType()){
                    case 1:
                        nonPassBasicList.add(standList.get(i));
                        break;
                    case 2:
                        nonPassAppliedList.add(standList.get(i));
                        break;
                    case 3:
                        nonPassIndustryList.add(standList.get(i));
                        break;
                }
            }
        }

        passListSubMap.put("passBasicList", passBasicList);
        passListSubMap.put("passAppliedList", passAppliedList);
        passListSubMap.put("passIndustryList",passIndustryList);

        passListSubMap.put("nonPassBasicList",nonPassBasicList);
        passListSubMap.put("nonPassAppliedList",nonPassAppliedList);
        passListSubMap.put("nonPassIndustryList",nonPassIndustryList);

        return passListSubMap;
    }

    private Boolean listContains(String standListTitle, List<subjectVO> myList){
        int cnt = 0;
        for(int i=0; i < myList.size(); i++){
            if(standListTitle.equals(myList.get(i).getCourseTitle())) {
                cnt++;
                break;
            }
        }

        if (cnt == 0) {
            return false;
        } else {
            return true;
        }
    }
}
