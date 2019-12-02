package kr.ac.sejong.service;

import kr.ac.sejong.domain.CustomUserDetails;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * 로그인 인증용..
 * CustomUserDetailsService.class - loadUserByUserId() 에서 불러온 유저정보를 여기로 넘긴다.
 * 사용자가 입력한 아이디와 비밀번호를 확인하고 해당 권한을 부여
 */
@Log
@Component("authProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Inject
    CustomUserDetailsService customUserDetailsService;

    @Inject
    //@Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        /* Authentication을 상속받는 클래스. principal, credential, authorities 제공 */
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication; //유저가 입력한 정보를 이이디비번으로만든다.(로그인한 유저아이디비번정보를담는다)
        CustomUserDetails userInfo = null;

        /* 회원정보 로드, 패스워드 인증 로직 */
        try {
            userInfo = (CustomUserDetails) customUserDetailsService.loadUserByUserId(authToken.getName()); //UserDetailsService에서 유저정보를 불러온다.

            log.info("userInfo.getPassword() : " +userInfo.getPassword()); //bcrypt_pw
            log.info("authToken.getCredentials() : " + authToken.getCredentials()); //raw_pw
            log.info("AreTheyMatch? : "+ passwordEncoder.matches(authToken.getCredentials().toString(), userInfo.getPassword()));
            if (!passwordEncoder.matches(authToken.getCredentials().toString(),userInfo.getPassword())) {

                throw new BadCredentialsException("not matching userId or password");
            }

        } catch (UsernameNotFoundException e) {
            throw e;
        }
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) userInfo.getAuthorities();
        /* 인증처리 후 권한부여해서 로그인 마무리 */
        return new UsernamePasswordAuthenticationToken(userInfo, null, authorities);

    }

    /* 입력받은 class가 Authentication을 구현했는지 검사하는 메소드 */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
