package kr.ac.sejong.service;

import kr.ac.sejong.domain.subject.Subject;
import kr.ac.sejong.domain.subject.SubjectRepository;
import kr.ac.sejong.web.dto.subject.SubjectRequestDto;
import kr.ac.sejong.web.dto.subject.SubjectResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Transactional
    public Long save(SubjectRequestDto requestDto) {
        return subjectRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exception id = " +id));

        subjectRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<SubjectResponseDto> findAll() {
        return subjectRepository.findAll().stream()
                .map(SubjectResponseDto::new)
                .collect(Collectors.toList());
    }

}
