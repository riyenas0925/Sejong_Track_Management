package kr.ac.sejong.web;

import kr.ac.sejong.service.SelectBoxService;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleResponseDto;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleSelectResponseDto;
import kr.ac.sejong.web.dto.degree.DegreeResponseDto;
import kr.ac.sejong.web.dto.track.TrackResponseDto;
import kr.ac.sejong.web.dto.univ.UnivResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/select/*")
public class ApiSelectBoxController {

    private final SelectBoxService selectBoxService;

    @GetMapping("univ")
    public List<UnivResponseDto> univSelectBox() {
        return selectBoxService.univ();
    }

    @GetMapping("track/{univId}")
    public List<TrackResponseDto> trackSelectBoxFindByUnivId(@PathVariable Long univId) {
        return selectBoxService.track(univId);
    }

    @GetMapping("degree/{trackId}")
    public List<DegreeResponseDto> degreeSelectBoxFindByTrackId(@PathVariable Long trackId) {
        return selectBoxService.degree(trackId);
    }

    @GetMapping("courseSchedule")
    public List<CourseScheduleSelectResponseDto> courseScheduleSelectBox() {
        return selectBoxService.courseSchedule();
    }
}
