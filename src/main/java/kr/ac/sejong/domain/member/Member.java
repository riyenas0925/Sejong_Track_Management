package kr.ac.sejong.domain.member;

import kr.ac.sejong.domain.trackJudge.JudgeLog.JudgeLog;
import kr.ac.sejong.web.dto.member.MemberModifyInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String major;
    @Column(nullable = false)
    private String univ;

    @CreationTimestamp
    private LocalDateTime createdTime;

    private LocalDateTime modifiedTime;

    private LocalDateTime loginTime;

    private LocalDateTime logoutTime;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<JudgeLog> judgeLogs;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MemberRole> roles;

    public void updateInfo(MemberModifyInfoDto target) {
        this.userId = target.getUserId();
        this.name = target.getName();
        this.email = target.getEmail();
        this.major = target.getMajor();
        this.univ = target.getUniv();
    }

    public void updateModifiedTime() {
        this.modifiedTime = LocalDateTime.now();
    }

    public void updatePw(String password) {
        this.password = password;
    }

    public void updateLoginTime() {
        this.loginTime = LocalDateTime.now();
    }

    public void updateLogoutTime() {
        this.logoutTime = LocalDateTime.now();
    }


    @Builder
    public Member(String userId, String password, String name, String email,
                  String major, String univ) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.major = major;
        this.univ = univ;
    }
}