package kr.ac.sejong.controller;

import kr.ac.sejong.domain.degreeVO;
import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.dto.UnivTrackRuleDegreeJoinDto;
import kr.ac.sejong.service.TrackRuleService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@Log
@RequestMapping("/ruleAjax/*")
public class TrackRuleRestController {

    @Inject
    private TrackRuleService trackRuleService;

    /*
    @PostMapping("/create")
    public ResponseEntity<String> register(@RequestBody ruleVO vo) {

        ResponseEntity<String> entity = null;

        try {
            trackRuleService.regist(vo);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
    */

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

    /*
    @PutMapping("/update/{ruleNo}")
    public ResponseEntity<String> update(@PathVariable("ruleNo") Integer ruleNo, @RequestBody ruleVO vo){
        ResponseEntity<String> entity = null;

        try{
            vo.setRuleNo(ruleNo);
            trackRuleService.update(vo);
            entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
    */

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
