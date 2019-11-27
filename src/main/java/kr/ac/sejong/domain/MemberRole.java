package kr.ac.sejong.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_member_role")
@EqualsAndHashCode(of = "roleId")
@ToString

public class MemberRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name="role_enum" ,columnDefinition = "enum('ADMIN','PRO','STUDENT')") //관리자, 교수, 학생
    @Enumerated(EnumType.STRING)
    private MemberRoleEnum roleEnum ;

    @ManyToOne( fetch=FetchType.EAGER)
//    @JoinColumn(name = "memberId")
    private Member member;
    @Override
    public String getAuthority(){
        return this.getRoleEnum().toString();
    }
}
