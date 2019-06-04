package kr.ac.sejong.controller;

import kr.ac.sejong.domain.graphVO;
import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.domain.visitorVO;
import kr.ac.sejong.persistence.TrackRuleDAO;
import kr.ac.sejong.persistence.VisitCountDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/statusAjax/*")
public class TrackStatusAjaxController {

    @Inject
    //@Qualifier("VisitCountDAO")
    private VisitCountDAO dao;

    @GetMapping("/list")
    public ResponseEntity<List<visitorVO>> listSearch() {

        ResponseEntity<List<visitorVO>> entity = null;

        try {
            entity = new ResponseEntity<>(dao.list(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/count")
    public ResponseEntity<List<Integer>> count() {
        ResponseEntity<List<Integer>> entity = null;

        try {
            List<Integer> countList = new ArrayList<>();

            Integer todayCount = dao.todayCount();
            Integer totalCount = dao.totalCount();
            Integer dummyData1 = 9999;
            Integer dummyData2 = 9999;

            countList.add(todayCount);
            countList.add(totalCount);
            countList.add(dummyData1);
            countList.add(dummyData2);

            entity = new ResponseEntity<>(countList, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/device")
    public ResponseEntity<List<graphVO>> deviceGraph() {

        ResponseEntity<List<graphVO>> entity = null;

        try {
            entity = new ResponseEntity<>(dao.deviceGraph(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/browser")
    public ResponseEntity<List<graphVO>> browserGraph() {

        ResponseEntity<List<graphVO>> entity = null;

        try {
            entity = new ResponseEntity<>(dao.browserGraph(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}