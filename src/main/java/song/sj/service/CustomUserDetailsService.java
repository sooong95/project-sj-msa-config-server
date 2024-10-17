package song.sj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import song.sj.dto.CustomUserDetails;
import song.sj.entity.Member;
import song.sj.entity.Shop;
import song.sj.repository.MemberRepository;
import song.sj.repository.ShopRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // DB 조회
        Member findMember = memberRepository.findByEmail(email);

        if (findMember != null) {

            return new CustomUserDetails(findMember);
        }

        return null;
    }
}
