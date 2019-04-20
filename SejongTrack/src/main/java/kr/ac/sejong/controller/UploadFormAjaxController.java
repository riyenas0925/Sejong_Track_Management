package kr.ac.sejong.controller;

import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;
import kr.ac.sejong.service.UploadFormService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/uploadAjax/*")
public class UploadFormAjaxController {

    @Inject
    private UploadFormService uploadFormService;

    @GetMapping("/selectUniv/{univNo}")
    public ResponseEntity<List<trackVO>> list(@PathVariable Integer univNo) {

        ResponseEntity<List<trackVO>> entity = null;

        try {
            entity = new ResponseEntity<>(uploadFormService.listTrack(univNo), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/univList")
    public ResponseEntity<List<univVO>> list() {
        ResponseEntity<List<univVO>> entity = null;
        try {
            entity = new ResponseEntity<>(uploadFormService.listUniv(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;

    }
}