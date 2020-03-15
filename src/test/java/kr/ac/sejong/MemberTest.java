package kr.ac.sejong;

import kr.ac.sejong.config.auth.CustomAuthenticationProvider;
import kr.ac.sejong.config.auth.CustomUserDetailsService;
import kr.ac.sejong.domain.member.*;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
@Commit
public class MemberTest {

    @Inject
    MemberRepository repo;

    @Inject
    MemberRoleRepository rolerepo;

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    CustomAuthenticationProvider authProvier;

    @Inject
    CustomUserDetailsService customUserDetailsService;

    @Test
    public void memberJoin_findById_Hangeul() {
        Optional<Member> member = repo.findById("초가스");
    }

    @Before
    public void setUp() throws Exception {
        EntityManager em;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Test
    public void isPasswordEncoded() {
        String password = "IamPassword1234";
        String encPassword = passwordEncoder.encode(password);
        log.info("encPassword : " + encPassword);

        assertThat(passwordEncoder.matches(password, encPassword)).isTrue();
        assertThat(encPassword).contains("{bcrypt}");
    }

    @Test
    public void isCreateNewInstanceByBuilder() {
        Member member = new Member("tiger", "1234", "kim", "k@n");
        Member before = member;
        member = Member.builder()
                .id("tiger")
                .password("1234")
                .name("kim")
                .email("k@n")
                .build();
        Member after = member;

        Assert.assertNotSame(before, after); //결과 : 같지않음. 즉 builder가 새 인스턴스를 만든다는 의미.
    }

    @Test
    public void isMapped_Member_MemberRole() {
        Member m = Member.builder()
                .id("tiger")
                .password("1234")
                .name("kim")
                .email("k@n")
                .build();
        repo.save(m);
        MemberRole role1 = MemberRole.builder()
                .roleId(1L)
                .roleEnum(MemberRoleEnum.ROLE_STUDENT)
                .member(m)
                .build();
        rolerepo.save(role1);
        MemberRole role2 = MemberRole.builder()
                .roleId(2L)
                .roleEnum(MemberRoleEnum.ROLE_PRO)
                .member(m)
                .build();
        rolerepo.save(role2);
        m.getRoles().add(role1);
        m.getRoles().add(role2);
        repo.save(m);
        log.info("(Member m) Roles List  :");
        for (MemberRole v : m.getRoles()) {
            log.info(v.toString());
        }
    }

    @Test
    public void justAbout_ExceptionAndMethodLifecycle() {
        String v = "test";
        int u = 0;

        if (v.equals("testl")) {
            log.info("a");
            throw new NullPointerException(); // 메소드를 종료시켜버린다.
            //x
        }
        try {
            u = 1;
        } catch (Exception e) {

        }
        log.info("u: " + u); //u=1로 나옴.
    }

    @Test
    public void password_Decoding() {

    }

}
