package kr.ac.sejong.domain.member;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "tbl_member")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString
public class Member {
    @Id
    @Column(name = "memberId")
    private String id;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

    @CreationTimestamp
    private Date regdate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifydate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date logindate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutdate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MemberRole> roles;

    public void update(String name, String email){
        this.email = email;
        this.name = name;
    }

    public void updatePw(String password){
        this.password = password;
    }

    public void updateLogindate(Date logindate){
        this.logindate = logindate;
    }

    public void updateLogoutdate(Date logoutdate){
        this.logoutdate = logoutdate;
    }
    @Builder
    public Member(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }


}