package kr.ac.sejong.web.dto.uis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UISUserInfoResponseDto {
    private String student_no;
    private String nm;
    private String dept_l_alias;
    private String dept_m_alias;
}
