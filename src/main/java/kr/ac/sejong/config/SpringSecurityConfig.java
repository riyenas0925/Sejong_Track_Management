/* 스프링 시큐리티에 필요한 내용을 정의하는 configuration */

package kr.ac.sejong.config;

import kr.ac.sejong.web.handler.CustomLoginSuccessHandler;
import kr.ac.sejong.web.handler.CustomLogoutSuccessHandler;
import kr.ac.sejong.service.CustomAuthenticationProvider;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.inject.Inject;

@Configuration
@EnableWebSecurity
@Log
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Inject
    CustomAuthenticationProvider authProvider;

    @Inject
    CustomLoginSuccessHandler loginSuccessHandler;

    @Inject
    CustomLogoutSuccessHandler logoutSuccessHandler;

    /* Password Encoder 등록 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /* Security 제외 패턴 */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("./**");/* 리소스 제한 허용 */
    }

    /* 각종 시큐어 패턴등록 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*페이지 권한 설정*/
                .antMatchers("/visitor/**", "/student/**", "/uploadForm/**",
                        "/trackJudge/**", "/modifyView/**", "/memberModify/**").authenticated()
                .antMatchers("/trackSubject/**", "/trackRule/**").hasAnyRole("ADMIN", "PRO")
                .antMatchers("/rule/**","/notice/create", "/notice/update/**", "/notice/delete/**").hasRole("ADMIN")

                .antMatchers("/**").permitAll()

                .and() //로그인 설정
                .formLogin() /* 로그인 폼 나오도록 */
                .loginPage("/loginView") /* 내가 만든 로그인 페이지 */
                .loginProcessingUrl("/memberLogin")
                .usernameParameter("id")
                .passwordParameter("password")
                .successHandler(loginSuccessHandler) /* 로그인 성공시 핸들러 */
                .failureUrl("/loginView") /*로그인 실패시 뷰*/
                .permitAll() /* 모두 오픈 */

                .and() //로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/memberLogout"))
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)


                .and()
                .exceptionHandling() /*예외처리*/
                .accessDeniedPage("/memberDenied") // 접근 권한 예외 페이지로 이동

                .and()
                .authenticationProvider(authProvider); /*로그인 검증*/

        http.sessionManagement()
                .maximumSessions(1)/*최대 허용 가능 중복 세션 수*/
                .maxSessionsPreventsLogin(false) /*true: 로그인이 이미 되어있는 경우 중복 로그인이 안된다,false면 두번째 로그인 되고, 첫번째가 세션만료된다*/
                .expiredUrl("/memberExpired")/*
                                             *중복 로그인이 일어낫을 경우 선 로그인 유저가 이동할 페이지
                                             *invalidSessionUrl : 세션만료됐을 경우 로그아웃시키는 url페이지. (우선순위)
                                             *expiredUrl : 강제로그아웃되고, url로 이동.
                                             */

                .and()
                .sessionFixation().newSession(); /* 사용자 로그인 때마다 새로운 세션을 생성한다 */

                /**
                 * 위와 같이 설정하면 한 명이 로그인하고, 다른 곳에서 동일한 아이디로 로그인 하게 되면
                 * 먼저 로그인한 사람의 세션이 끊김.
                 * 먼저 로그인한 사람이 링크를 클릭하여 사이트내의 페이지를 이동하면 expiredUrl 로
                 * 지정된 곳으로 보내진다.
                 **/
    }

}