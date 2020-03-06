/*
 * 기본적인 오버라이딩 메소드들은 오버라이딩하고,
 * 다른 추가적인 회원 정보 컬럼이 있다면 멤버변수로 추가하고 getter, setter을 추가해주면 된다.
 */

package kr.ac.sejong.domain;

import kr.ac.sejong.domain.member.MemberRoleEnum;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * loadUserByUserId 가 하는 역할은 입력한 아이디 값을 통해서 데이터베이스에서 값을 읽어오는데,
 * 스프링 시큐리티가 인식할수있는 dto로 바꿔줘야 하기 때문에
 * 로그인 한 유저의 정보는 UserDetails인터페이스를 구현한 CustomUserDetails 객체에 저장 되게끔 다시 저장.
 *
 * 그렇게 되면 스프링 시큐리티는
 * 유저가 입력한 아이디를 통해 디비에서 읽어온 비밀번호 (이미 회원가입할때 암호화 되어있음)와
 * 유저가 입력한 비밀번호를 암호화한 비밀번호를 비교해서 로그인 인증을 처리해줄지 안할지를 결정하게 되는것입니다.
 * */

@EqualsAndHashCode(of = "id")
public class CustomUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L; //serial 상속받은 클래스는 serialVersionUID 꼭 선언하는것 권유

    private String id;
    private String password;
    private String name;
    private String email;
    private List<GrantedAuthority> authorities; //세션을 위한 객제인듯.

    public CustomUserDetails(String id, String password, String name, String email,
                             List<GrantedAuthority> authorities) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    /**
     * db에서 꺼내와서 이 유저가 가질 권한 add해줘서 customUserDetails리턴
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();  //원래코드

        if (this.id.equals("admin")) {
            authorities.add(new SimpleGrantedAuthority(MemberRoleEnum.ROLE_ADMIN.toString()));
        } else if (this.id.equals("student")) {
            authorities.add(new SimpleGrantedAuthority(MemberRoleEnum.ROLE_STUDENT.toString()));
        } else if (this.id.equals("pro")) {
            authorities.add(new SimpleGrantedAuthority(MemberRoleEnum.ROLE_PRO.toString()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
