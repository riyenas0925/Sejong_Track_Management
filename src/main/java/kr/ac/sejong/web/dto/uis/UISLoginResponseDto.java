package kr.ac.sejong.web.dto.uis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UISLoginResponseDto {

    private String id;
    private String name;
    private String univ;
    private String major;

    @Builder
    public UISLoginResponseDto(String id, String name, String univ, String  major) {
        this.id = id;
        this.name = name;
        this.univ = univ;
        this.major = major;
    }

    public static UISLoginResponseDto of(UISUserInfoResponseDto uisUserInfoResponseDto){
        return UISLoginResponseDto.builder()
                .id(uisUserInfoResponseDto.getStudent_no())
                .name(uisUserInfoResponseDto.getNm())
                .univ(uisUserInfoResponseDto.getDept_l_alias())
                .major(uisUserInfoResponseDto.getDept_m_alias())
                .build();
    }
}
