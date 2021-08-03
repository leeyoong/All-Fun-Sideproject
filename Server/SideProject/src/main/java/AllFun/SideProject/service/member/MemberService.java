package AllFun.SideProject.service.member;

import AllFun.SideProject.domain.matching.Board;
import AllFun.SideProject.domain.matching.EntryPool;
import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.dto.mainPage.MyMatchingBoardDto;
import AllFun.SideProject.dto.mainPage.MyMatchingStatusDto;
import AllFun.SideProject.dto.member.EditMemberInfoDto;
import AllFun.SideProject.dto.member.MemberInfoDto;
import AllFun.SideProject.dto.member.OneItemDto;
import AllFun.SideProject.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final JavaMailSender javaMailSender;

    /**
     * Find By Id
     * @param id
     * @return
     */
    public Member findById(Long id){
        return memberRepository.findById(id)
                .orElse(null);
    }

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
    @Transactional
    public void save(Member member){
        memberRepository.save(member);

    }

    /**
     * Enroll Profile
     * @param file
     * @return
     * @throws IOException
     */
    public String profileEnroll(MultipartFile file) throws IOException{
        UUID uuid = UUID.randomUUID();
        String ogFileName = file.getOriginalFilename();
        String fileName = uuid.toString()+ogFileName.substring(ogFileName.lastIndexOf("."));
        String relativePath = "/profileImage";

        String path = new ClassPathResource(relativePath).getFile().getAbsolutePath();
        File pathFile = new File(path);
        Files.copy(file.getInputStream(),pathFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return (relativePath+"/"+fileName).toString();
    }

    /**
     * Email Authentication
     * @param email
     * @return
     */
    public String sendMail(String email){
        Random random = new Random();
        String key = "";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(25) + 65;
            key += (char)index;
        }
        int numIndex = random.nextInt(9999)+1000;
        key += numIndex;
        message.setSubject("인증번호 입력을 위한 메일입니다.");
        message.setText("인증번호 : " + key);
        javaMailSender.send(message);
        return null;
    }

    /**
     * Email Authentication
     * @param email
     * @return
     */
    @Transactional
    public String sendMailPw(String email){
        Random random = new Random();
        String key = "";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 10; i++) {
            int idx = random.nextInt(source.length());
            key += source.charAt(idx);
        }
        Optional<Member> member = Optional.ofNullable(memberRepository.findByEmail(email).orElse(null));
        if (member != null){
            String finalKey = key;
            member.ifPresent(selectMember->{
                selectMember.setPasswd(finalKey);
                memberRepository.save(selectMember);
            });
            message.setSubject("임시 비밀번호 입니다.");
            message.setText("임시 비밀번호 : " + key);
            javaMailSender.send(message);
            return "Ok";
        } else{
            return "Fail";
        }
    }

    /**
     * find user email
     * @param name
     * @param birth
     * @param phone
     * @return
     */
    public Member findByNameAndBirthAndPhoneAndGender(String name, String birth, String phone){
        return memberRepository.findByNameAndBirthAndPhone(name, birth, phone)
                .orElse(null);
    }

    /**
     * find user password
     * @param name
     * @param birth
     * @param phone
     * @param email
     * @return
     */
    public Member findByNameAndBirthAndPhoneAndGenderAndEmail
                (String name, String birth, String phone, String email){
        return memberRepository.findByNameAndBirthAndPhoneAndEmail(name, birth, phone,email)
                .orElse(null);
    }

    /**
     * 회원 탈퇴
     * @param member
     * @return
     */
    @Transactional
    public String deleteMember(Member member){
        memberRepository.delete(member);
        return null;
    }

    /**
     * modify password
     * @param memberId
     * @param request
     * @return
     */
    @Transactional
    public String modifyPassword(Long memberId, OneItemDto request){
        Optional<Member> editData = Optional.ofNullable(memberRepository.findById(memberId).orElse(null));
        editData.ifPresent(selectMember->{
            selectMember.setPasswd(request.getItem());
            memberRepository.save(selectMember);
        });
        return null;
    }

    /**
     * get member information
     * @param memberId
     * @return
     */
    public MemberInfoDto getMemberInfo(Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        MemberInfoDto response = new MemberInfoDto(
                                member.getEmail(),
                                member.getBirth(),
                                member.getName(),
                                member.getPhone(),
                                member.getNickname(),
                                member.getGender(),
                                member.getIntroduce()
                                );
        return response;
    }

    /**
     * edit my info
     * @param memberId
     * @param request
     * @return
     */
    @Transactional
    public String putMemberInfo(Long memberId, EditMemberInfoDto request){
        Optional<Member> editData = Optional.ofNullable(memberRepository.findById(memberId).orElse(null));
        final String[] res = {null};
        editData.ifPresent(selectMember->{
            selectMember.setPhone(request.getPhone());
            selectMember.setNickname(request.getNickname());
            selectMember.setIntroduce(request.getIntroduce());
            memberRepository.save(selectMember);
            res[0] = "ok";
        });
        return res[0];
    }

    /**
     * get my matching board
     * @param memberId
     * @return
     */
    public List<MyMatchingBoardDto> getMyMatchingBoard(Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        List<Board> boards = member.getBoards();
        List<MyMatchingBoardDto> response = new ArrayList<>();
        for (Board board : boards) {
            MyMatchingBoardDto myMatchingBoardDto = new MyMatchingBoardDto(
                    board.getId(),
                    board.getTitle(),
                    board.getProjectMembers(),
                    board.getEntryMembers()
            );
            response.add(myMatchingBoardDto);
        }
        return response;
    }

    /**
     * get my matching status
     * @param memberId
     * @return
     */
    public List<MyMatchingStatusDto> getMyMatchingStatus(Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        List<EntryPool> entryPools = member.getEntryPools();
        List<MyMatchingStatusDto> response = new ArrayList<>();
        for (EntryPool entryPool : entryPools) {
            MyMatchingStatusDto myMatchingStatusDto = new MyMatchingStatusDto(
                    entryPool.getBoard().getId(),
                    entryPool.getRole(),
                    entryPool.getStatus()
            );
            response.add(myMatchingStatusDto);
        }
        return response;
    }
}

