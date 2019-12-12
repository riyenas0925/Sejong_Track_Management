/* 스프링 시큐리티에 필요한 내용을 정의하는 configuration */

package kr.ac.sejong.config;

import kr.ac.sejong.handler.CustomLoginFailureHandler;
import kr.ac.sejong.handler.CustomLoginSuccessHandler;
import kr.ac.sejong.service.CustomAuthenticationProvider;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
    CustomLoginSuccessHandler successHandler;

    @Inject
    CustomLoginFailureHandler failureHandler;

    /* Password Encoder 등록 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        log.info("build Auth global.......");

        //auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

        auth.inMemoryAuthentication()
                .withUser("manager")
                .password("{noop}1111")
                .roles("MANAGER");
    }
    /* Security 제외 패턴 */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**");
    }

    /* 각종 시큐어 패턴등록 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*페이지 권한 설정*/
//                .antMatchers("/trackAll/**").hasRole("MEMBER") /* /access 패턴은 ADMIN 유저만 접근 */
                .antMatchers("/**").permitAll()
            .and() //로그인 설정
                .formLogin() /* 로그인 폼 나오도록 */
                .loginPage("/loginView") /* 내가 만든 로그인 페이지 */
                .loginProcessingUrl("/memberLogin")
                .usernameParameter("id")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/loginView")
//                .successHandler(successHandler) /* 로그인 성공시 세션 생성할 수 있을 듯 */
//                .failureHandler(failureHandler)
                .permitAll() /* 모두 오픈 ( 반대는 denyAll() ) */
            .and() //로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/memberLogout"))
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/") /* 로그아웃 성공시 리다이렉트 url */
            .and()
                .exceptionHandling() /*예외처리*/
                .accessDeniedPage("/exception") //예외발생 페이지로 이동
            .and()
                .authenticationProvider(authProvider); /*로그인 검증*/
    }
}
