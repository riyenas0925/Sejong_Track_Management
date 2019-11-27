package kr.ac.sejong.service;

import kr.ac.sejong.domain.Member;
import kr.ac.sejong.domain.MemberRoleEnum;
import kr.ac.sejong.persistence.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService_security implements UserDetailsService {

    @Inject
    private MemberRepository repo;

    @Transactional
    public String joinUser(Member member) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        return repo.save(member).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Member> userEntityWrapper = repo.findById(id); /*엔티티*/
        Member member = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>(); /*권한*/

        if (("admin").equals(id)) {
            authorities.add(new SimpleGrantedAuthority(MemberRoleEnum.ADMIN.toString()));
        } else {
            authorities.add(new SimpleGrantedAuthority(MemberRoleEnum.STUDENT.toString()));
        }

        return new User(member.getId(), member.getPassword(), authorities);
    }
}