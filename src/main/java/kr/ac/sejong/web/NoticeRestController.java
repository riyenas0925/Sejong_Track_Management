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
@RequestMapping("/notice")
public class NoticeRestController {

    @Inject
    NoticeService service;

    @PostMapping("/create")
    public Long create(@RequestBody NoticeRequestDto nrDto) {
        log.info("create()진입");
        return service.saveNotice(nrDto);
    }

//    @GetMapping("/{id}")
//    public NoticeResponseDto findById(@PathVariable Long id) {
//        NoticeResponseDto dto = service.findById(id);
//        log.info("findById()진입: " + dto);
//        return service.findById(id);
//    } 안씀. NoticeController에서 작업.

    @GetMapping("/list")
    public List<NoticeResponseDto> findAllDesc() {
        log.info("findAllDesc()진입");
        return service.findAllDesc();
    }

    @PostMapping("/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeRequestDto nrDto) {
        log.info("update()진입");

        return service.updateNotice(id, nrDto);
    }

    @PostMapping("/delete/{id}")
    public Long delete(@PathVariable Long id) {
        log.info("delete()진입");
        return service.deleteNotice(id);
    }

}
