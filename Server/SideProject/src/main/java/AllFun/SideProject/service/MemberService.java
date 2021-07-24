package AllFun.SideProject.service;

import AllFun.SideProject.domain.Member;
import AllFun.SideProject.dto.member.CreateMemberDto;
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
    /**
     * check duplicated nickname
     * @param nickname
     * @return
     */
    public Member findByNickname(String nickname){
        return memberRepository.findByNickname(nickname)
                .orElse(null);
    }

    /**
     * Create Member (Sign Up)
     * @param member
     * @return
     */
    public CreateMemberDto save(Member member){
        memberRepository.save(member);
        return new CreateMemberDto(member.getEmail(), member.getPasswd(),member.getBirth(),member.getName(),
                        member.getNickname(),member.getProfileImg(),member.getCreateDate(),member.getGender());
    }
}

