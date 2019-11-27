/* 스프링 시큐리티에 필요한 내용을 정의하는 configuration */

package kr.ac.sejong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    //    @Inject
    //    MemberServiceImpl memberServiceImpl;0
    //    private UserDetailsService customUserDetailsService;
    /* Password Encoder 등록 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

        /* 인증방식 */
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }
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
                .loginPage("/memberLogin") /* 내가 만든 로그인 페이지 */
                .usernameParameter("id")
                .passwordParameter("password").
                defaultSuccessUrl("/")
                .permitAll() /* 모두 오픈 ( 반대는 denyAll() ) */
            .and() //로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/memberLogout"))
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/"); /* 로그아웃 성공시 리다이렉트 url */
    }
}
