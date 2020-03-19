package kr.ac.sejong.web.dto.member;

import kr.ac.sejong.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberModifyPwDto {

    private String userId;
    private String password;
    private String newPw;

    public Member toEntity() {
        return Member.builder()
                .userId(userId)
                .password(password)
                .build();
    }
}
