package kr.ac.sejong.web;

import kr.ac.sejong.service.NoticeService;
import kr.ac.sejong.web.dto.NoticeRequestDto;
import kr.ac.sejong.web.dto.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RequiredArgsConstructor
@RequestMapping("/api/v1/*")
@RestController
public class NoticeApiController {

    private final NoticeService service;

    @PostMapping("/admin/notice/create")
    public Long create(@RequestBody NoticeRequestDto nrDto) {
        log.info("create()진입");
        return service.saveNotice(nrDto);
    }

    @GetMapping("/notice/list")
    public List<NoticeResponseDto> findAllDesc() {
        log.info("findAllDesc()진입");
        return service.findAllDesc();
    }

    @GetMapping("/notice/details/{id}")
    public NoticeResponseDto findById(@PathVariable Long id) {
        log.info("findById()진입");
        return service.findById(id);
    }

    @PostMapping("/admin/notice/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeRequestDto nrDto) {
        log.info("update()진입");

        return service.updateNotice(id, nrDto);
    }

    @PostMapping("/admin/notice/delete/{id}")
    public Long delete(@PathVariable Long id) {
        log.info("delete()진입");
        return service.deleteNotice(id);
    }

}
