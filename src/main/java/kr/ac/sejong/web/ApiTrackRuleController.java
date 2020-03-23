package kr.ac.sejong.web;

import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.service.TrackRuleService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@Log
@RequestMapping("api/v1/admin/rule/*")
public class ApiTrackRuleController {

}
