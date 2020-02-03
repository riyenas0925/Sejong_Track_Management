package kr.ac.sejong.service;

import kr.ac.sejong.domain.CustomUserDetails;
import kr.ac.sejong.domain.Member;
import kr.ac.sejong.domain.MemberRoleEnum;
import kr.ac.sejong.persistence.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log
public class CustomUserDetailsService implements UserDetailsService {

    @Inject
    private MemberRepository repo;
    @Inject
    private PasswordEncoder passwordEncoder;

    @Transactional
    public String joinMember(Member m) {
        Member member = Member.builder()
                .id(m.getId())
                .password(passwordEncoder.encode(m.getPassword())) /*비밀번호 암호화*/
                .name(m.getName())
                .email(m.getEmail())
                .build();

        return repo.save(member).getId();
    }

    @Transactional
    public void modifyMember(String targetId, String targetPw, Member result) throws BadCredentialsException {
        Optional<Member> targetWrapper = repo.findById(targetId);
        Member target = targetWrapper.get();

        if (!passwordEncoder.matches(targetPw, target.getPassword())) { //raw, bcrypt
            throw new BadCredentialsException("not matching userId or password");
        } else {
            target.setName(result.getName());
            target.setEmail(result.getEmail());
        }

        repo.save(target);
    }

    @Transactional
    public void modifyPw(String targetId, String targetPw, String resultPw) {
        Optional<Member> targetWrapper = repo.findById(targetId);
        Member target = targetWrapper.get();

        if (!passwordEncoder.matches(targetPw, target.getPassword())) { //raw, bcrypt
            throw new BadCredentialsException("not matching userId or password");
        } else {
            target.setPassword(passwordEncoder.encode(resultPw));
        }

        repo.save(target);
    }

    public UserDetails loadUserByUserId(String id) throws UsernameNotFoundException {
        /*id 일치하는 멤버 조회*/
        Optional<Member> memberEntityWrapper = repo.findById(id);

        /*만약 id가 없으면 에러 던지고 아니면 member에 담는다.*/
        Member member = memberEntityWrapper.orElseThrow(() -> new UsernameNotFoundException(id));

        List<GrantedAuthority> authorities = new ArrayList<>(); /*권한*/

        if (("admin").equals(id)) {
            authorities.add(new SimpleGrantedAuthority(MemberRoleEnum.ADMIN.toString()));
        } else if (("student").equals(id)) {
            authorities.add(new SimpleGrantedAuthority(MemberRoleEnum.STUDENT.toString()));
        } else if (("pro").equals(id)) {
            authorities.add(new SimpleGrantedAuthority(MemberRoleEnum.PRO.toString()));
        }

        return new CustomUserDetails(member.getId(), member.getPassword(), member.getName(),
                member.getEmail(), authorities);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}