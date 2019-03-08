package kr.ac.sejong.controller;

import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.persistence.UploadFormDAO;
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
    private UploadFormDAO uploadFormDAO;

    @GetMapping("/selectUniv/{univNo}")
    public ResponseEntity<List<trackVO>> list(@PathVariable Integer univNo){

        ResponseEntity<List<trackVO>> entity = null;

        try {
            entity = new ResponseEntity<>(uploadFormDAO.listTrack(univNo), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
