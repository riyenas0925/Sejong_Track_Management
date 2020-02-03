package kr.ac.sejong.web;

import kr.ac.sejong.web.dto.TrackAllViewDto;
import kr.ac.sejong.service.TrackAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/trackAll/*")
public class TrackAllRestController {

    @Inject
    private TrackAllService trackAllService;

    @GetMapping("/{univId}")
    public ResponseEntity<List<TrackAllViewDto>> list(@PathVariable Integer univId){

        ResponseEntity<List<TrackAllViewDto>> entity = null;

        try {
            entity = new ResponseEntity<>(trackAllService.trackAll(univId), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
