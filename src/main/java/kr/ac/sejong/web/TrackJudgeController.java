package kr.ac.sejong.web;

import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.service.TrackRuleService;
import kr.ac.sejong.web.dto.excel.ExcelDto;
import kr.ac.sejong.web.dto.excel.ExcelFileRequestDto;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Log
@Controller
public class TrackJudgeController {
    @GetMapping("/uploadForm")
    public String uploadForm(HttpSession httpSession) throws Exception{
        httpSession.removeAttribute("transcript");
        return "uploadForm";
    }

    @GetMapping("/trackJudge")
    public String trackJudge(@RequestParam("univId") Long univId,
                             @RequestParam("trackId") Long trackId,
                             @RequestParam("degreeId") Long degreeId)throws Exception{

        return "trackJudge";
    }

    @PostMapping("/trackJudge")
    public void trackJudge(@ModelAttribute @Valid ExcelFileRequestDto file, HttpSession httpSession)throws Exception{
        List<ReportCardExcelDto> transcriptSubjects = new ExcelDto(file.getMultipartFile()).toReportCardExcelDtos();
        httpSession.setAttribute("transcript", transcriptSubjects);
    }
}