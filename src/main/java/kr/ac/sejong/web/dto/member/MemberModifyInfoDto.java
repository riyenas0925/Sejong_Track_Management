package kr.ac.sejong.web.dto.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberModifyInfoDto {

    private String userId;
    private String password;
    private String email;
    private String name;
    private String major;
    private String univ;
}
