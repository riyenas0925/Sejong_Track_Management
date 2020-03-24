package kr.ac.sejong.web;

import kr.ac.sejong.service.TrackAllService;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/trackAll/*")
public class ApiTrackAllController {

    private final TrackAllService trackAllService;

    @GetMapping("/{univId}")
    public Map<String, Map<String, List<CourseResponseDto>>> list(@PathVariable Long univId) {
        return trackAllService.trackAllStatistic(univId);
    }
}
