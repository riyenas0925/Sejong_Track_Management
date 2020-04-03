package kr.ac.sejong.web.dto.uis;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UISLoginRequestDto {
    private String id;
    private String password;

    public UISLoginRequestDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
