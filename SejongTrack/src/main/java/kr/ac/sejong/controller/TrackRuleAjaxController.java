package kr.ac.sejong.controller;

import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.service.TrackRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/ruleAjax/*")
public class TrackRuleAjaxController {
    private static final Logger logger = LoggerFactory.getLogger(TrackRuleAjaxController.class);

    @Inject
    private TrackRuleService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ruleVO vo) {

        ResponseEntity<String> entity = null;

        try {
            service.regist(vo);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ruleVO>> list(){

        ResponseEntity<List<ruleVO>> entity = null;

        try {
            entity = new ResponseEntity<>(service.listAll(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/list/{univNo}")
    public ResponseEntity<List<ruleVO>> listSearch(@PathVariable Integer univNo){

        ResponseEntity<List<ruleVO>> entity = null;

        try {
            entity = new ResponseEntity<>(service.listSearch(univNo), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @PutMapping("/update/{ruleNo}")
    public ResponseEntity<String> update(@PathVariable("ruleNo") Integer ruleNo, @RequestBody ruleVO vo){
        ResponseEntity<String> entity = null;

        try{
            vo.setRuleNo(ruleNo);
            service.update(vo);
            entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @DeleteMapping("/remove/{ruleNo}")
    public ResponseEntity<String> remove(@PathVariable("ruleNo") Integer ruleNo){

        ResponseEntity<String> entity = null;

        try{
            service.remove(ruleNo);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
