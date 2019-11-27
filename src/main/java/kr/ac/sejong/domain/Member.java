package kr.ac.sejong.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_member")
@EqualsAndHashCode(of = "id")
@ToString

public class Member {

    @Id
    @Column(name="memberId")
    private String id;

    private String password;
    private String name;
    private String email;

    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;

    @OneToMany(mappedBy="member", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinColumn(name = "member")
    private List<MemberRole> roles;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }
    @Builder
    public Member(String id,String password,String name,String email){
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}