package kr.ac.sejong.web;

import kr.ac.sejong.domain.degree.Degree;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.univ.Univ;
import kr.ac.sejong.service.SelectListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/select/*")
public class SelectRestController {

    @Inject
    private SelectListService selectListService;

    @GetMapping("/univ")
    public ResponseEntity<List<Univ>> univList(){

        ResponseEntity<List<Univ>> entity = null;

        try {
            entity = new ResponseEntity<>(selectListService.univList(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/track/{trackId}")
    public ResponseEntity<List<Track>> trackList(@PathVariable Long trackId){

        ResponseEntity<List<Track>> entity = null;

        try {
            entity = new ResponseEntity<>(selectListService.trackList(trackId), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/degree")
    public ResponseEntity<List<Degree>> degreeList(){

        ResponseEntity<List<Degree>> entity = null;

        try {
            entity = new ResponseEntity<>(selectListService.degreeList(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
