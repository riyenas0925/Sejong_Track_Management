package kr.ac.sejong.web;

import kr.ac.sejong.service.SubjectService;
import kr.ac.sejong.web.dto.subject.SubjectResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/subject/*")
public class SubjectApiController {
    private final SubjectService subjectService;

    @DeleteMapping(path ="/delete/{id}")
    public void delete(Long id) {
        subjectService.delete(id);
    }

    @GetMapping(path = "/list")
    public List<SubjectResponseDto> findAll() {
        return subjectService.findAll();
    }
}
