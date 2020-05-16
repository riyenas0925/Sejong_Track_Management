package kr.ac.sejong;

import kr.ac.sejong.config.auth.CustomAuthenticationProvider;
import kr.ac.sejong.config.auth.CustomLoginSuccessHandler;
import kr.ac.sejong.config.auth.CustomUserDetailsService;
import kr.ac.sejong.domain.member.*;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
public class MemberTest {
    @Inject
    private MemberRepository repo;
    @Inject
    private MemberRoleRepository roleRepo;
    @Inject
    private PasswordEncoder passwordEncoder;
    @Inject
    private CustomUserDetailsService service;
    @Inject
    private CustomLoginSuccessHandler loginSuccessHandler;
    @Inject
    private CustomAuthenticationProvider authProvider;
    @Inject
    private CustomUserDetailsService customUserDetailsService;

    @Test
    public void 한글이름_추가_테스트() {
        Optional<Member> member = repo.findByUserId("김학생");
    }

    @Test
    public void 모든필드_회원가입() {
        Member member = Member.builder()
                .userId("17013222")
                .password("1234")
                .email("r@r")
                .univ("호호호대학")
                .major("안경학과")
                .name("김그릇")
                .build();
        service.join(member);
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
    public void 빌더_사용_테스트() {
        Member member = Member.builder()
                .userId("tiger")
                .password("1234")
                .name("kim")
                .email("k@n").build();
        Member before = member;
        member = Member.builder()
                .userId("tiger")
                .password("1234")
                .name("kim")
                .email("k@n")
                .build();
        Member after = member;

        Assert.assertNotSame(before, after); //결과 : 같지않음. 즉 builder가 새 인스턴스를 만든다는 의미.
    }

    @Test
    public void 멤버_멤버롤_매핑_테스트() {
        Member m = Member.builder()
                .userId("tiger")
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
        roleRepo.save(role1);
        MemberRole role2 = MemberRole.builder()
                .roleId(2L)
                .roleEnum(MemberRoleEnum.ROLE_PRO)
                .member(m)
                .build();
        roleRepo.save(role2);
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

//    @Test
//    public void resetNewAuthenticationAttributes_Test(){
//
//        HttpSession session = request.getSession(false);
//
//        if (session != null) {
//            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//        }
//
//        //유저 세션 설정
//        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) auth;
//        log.info("getName()비교.... Authentication: " + auth.getName() + ", authToken: " + authToken.getName());
//        CustomUserDetails user = (CustomUserDetails) customUserDetailsService.loadUserByUserId(authToken.getName());
//
//        session.setAttribute("userModel", user);
//    }

}
