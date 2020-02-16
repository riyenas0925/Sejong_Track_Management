package kr.ac.sejong.service;

import kr.ac.sejong.domain.notice.Notice;
import kr.ac.sejong.domain.notice.NoticeRepository;
import kr.ac.sejong.web.dto.NoticeRequestDto;
import kr.ac.sejong.web.dto.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository repo;

    @Transactional
    public Long saveNotice(NoticeRequestDto nrDto) {
        log.info("service - save : " + nrDto.getTitle() + "/" + nrDto.getContent() + "/" + nrDto.getAuthor());
        Notice n = nrDto.toEntity();
        return repo.save(n).getId();
    }

    @Transactional
    public Long updateNotice(Long id, NoticeRequestDto nrDto) {

        Notice target = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find the Notice: " + id));

        target.update(nrDto.getTitle(), nrDto.getAuthor(), nrDto.getContent());
        log.info("update Target: " + target);
        return id;
    }

    @Transactional
    public Long deleteNotice(Long id) {
        Notice target = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find the Notice: " + id));

        repo.delete(target);

        return id;
    }

    @Transactional(readOnly = true)
    public NoticeResponseDto findById(Long id) {
        Notice target = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find the Notice: " + id));

        return new NoticeResponseDto(target);
    }

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> findAllDesc() {
        return repo.findAllDesc().stream()
                .map(NoticeResponseDto::new) // Stream < R > map(Function<? super T, ? extends R> mapper):  입력 T타입을 R타입 요소로 변환한 스트림 생성
                .collect(Collectors.toList());
    }
}
