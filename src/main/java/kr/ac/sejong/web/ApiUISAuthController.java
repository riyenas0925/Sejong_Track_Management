package kr.ac.sejong.web;

import kr.ac.sejong.config.auth.UISAuthService;
import kr.ac.sejong.web.dto.uis.UISLoginRequestDto;
import kr.ac.sejong.web.dto.uis.UISLoginResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth/*")
public class ApiUISAuthController {

    private final UISAuthService uisAuthService;

    @PostMapping("/uis")
    public ResponseEntity<UISLoginResponseDto> auth(UISLoginRequestDto uisLoginRequestDto) throws IOException {
        ResponseEntity<UISLoginResponseDto> entity = null;

        try {
            UISLoginResponseDto uisLoginResponseDto = uisAuthService.auth(uisLoginRequestDto);
            entity = new ResponseEntity<>(uisLoginResponseDto, HttpStatus.OK);

        } catch (NullPointerException e) {
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
