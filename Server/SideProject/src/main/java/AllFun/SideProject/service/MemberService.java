package AllFun.SideProject.service;

import AllFun.SideProject.domain.Member;
import AllFun.SideProject.repository.SpringDataJpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final SpringDataJpaMemberRepository memberRepository;

    /**
     * check duplicated email
     * @param email
     * @return
     */
    public Member findByEmail(String email){
        return memberRepository.findByEmail(email)
                .orElse(null);
    }

    public Member findByNickname(String nickname){
        return memberRepository.findByNickname(nickname)
                .orElse(null);
    }
}

