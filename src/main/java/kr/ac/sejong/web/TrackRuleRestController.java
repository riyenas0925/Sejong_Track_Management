package kr.ac.sejong.web;

import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.web.dto.UnivTrackRuleDegreeJoinDto;
import kr.ac.sejong.service.TrackRuleService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@Log
@RequestMapping("/rule/*")
public class TrackRuleRestController {

    @Inject
    private TrackRuleService trackRuleService;

    @PostMapping("/create")
    public ResponseEntity<String> register(@RequestBody Rule rule) {

        ResponseEntity<String> entity = null;

        try {
            log.info(rule.toString() + rule.getTrack().toString());
            trackRuleService.save(rule);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/list")
    public ResponseEntity<List<UnivTrackRuleDegreeJoinDto>> list(){

        ResponseEntity<List<UnivTrackRuleDegreeJoinDto>> entity = null;

        try {
            entity = new ResponseEntity<>(trackRuleService.findRules(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/list/{univId}")
    public ResponseEntity<List<UnivTrackRuleDegreeJoinDto>> listSearch(@PathVariable Long univId){

        ResponseEntity<List<UnivTrackRuleDegreeJoinDto>> entity = null;

        try {
            entity = new ResponseEntity<>(trackRuleService.findByUnivId(univId), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @DeleteMapping("/delete/{ruleId}")
    public ResponseEntity<String> remove(@PathVariable("ruleId") Long ruleId){

        ResponseEntity<String> entity = null;

        try{
            trackRuleService.delete(ruleId);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
