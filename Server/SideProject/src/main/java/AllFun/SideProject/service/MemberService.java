package AllFun.SideProject.service;

import AllFun.SideProject.domain.Member;
import AllFun.SideProject.dto.member.CreateMemberDto;
import AllFun.SideProject.repository.SpringDataJpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final SpringDataJpaMemberRepository memberRepository;
    private final JavaMailSender javaMailSender;

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
                member.getPhone(), member.getNickname(),member.getProfileImg(),member.getCreateDate(),member.getGender());
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
        return "ok";
    }

    /**
     * find user email
     * @param name
     * @param birth
     * @param phone
     * @param gender
     * @return
     */
    public Member findByNameAndBirthAndPhoneAndGender(String name, String birth, String phone, String gender){
        return memberRepository.findByNameAndBirthAndPhoneAndGender(name, birth, phone, gender)
                .orElse(null);
    }

    /**
     * find user password
     * @param name
     * @param birth
     * @param phone
     * @param gender
     * @param email
     * @return
     */
    public Member findByNameAndBirthAndPhoneAndGenderAndEmail
                (String name, String birth, String phone, String gender, String email){
        return memberRepository.findByNameAndBirthAndPhoneAndGenderAndEmail(name, birth, phone, gender,email)
                .orElse(null);
    }
}

