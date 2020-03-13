package kr.ac.sejong.web;

import kr.ac.sejong.service.NoticeService;
import kr.ac.sejong.web.dto.NoticeRequestDto;
import kr.ac.sejong.web.dto.NoticeResponseDto;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Log
@RestController
public class NoticeRestController {
    @Inject
    private NoticeService service;

    @PostMapping("/api/v1/admin/notice/create")
    public Long create(@RequestBody NoticeRequestDto nrDto) {
        log.info("create()진입");
        return service.saveNotice(nrDto);
    }

    @GetMapping("/notice/list")
    public List<NoticeResponseDto> findAllDesc() {
        log.info("findAllDesc()진입");
        return service.findAllDesc();
    }

    @PostMapping("/api/v1/admin/notice/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeRequestDto nrDto) {
        log.info("update()진입");

        return service.updateNotice(id, nrDto);
    }

    @PostMapping("/api/v1/admin/notice/delete/{id}")
    public Long delete(@PathVariable Long id) {
        log.info("delete()진입");
        return service.deleteNotice(id);
    }

}
