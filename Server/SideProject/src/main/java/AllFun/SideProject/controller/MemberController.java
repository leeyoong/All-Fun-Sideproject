package AllFun.SideProject.controller;

import AllFun.SideProject.domain.Member;
import AllFun.SideProject.dto.member.CreateMemberDto;
import AllFun.SideProject.dto.member.FindMemberDto;
import AllFun.SideProject.dto.member.OneItemDto;
import AllFun.SideProject.dto.member.LoginDto;
import AllFun.SideProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    //private final PasswordEncoder passwordEncoder;
    /**
     * Check Duplicated Email
     * @param request
     * @return
     */
    @PostMapping("/emailChk")
    public ResponseEntity<?> emailChk(@RequestBody OneItemDto request){
        Member find = memberService.findByEmail(request.getItem());

        if (find != null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Duplicated Email");
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.ok(request);
        }
    }
    /**
     * Check Duplicated Nickname
     * @param request
     * @return
     */
    @PostMapping("/nicknameChk")
    public ResponseEntity<?> nicknameChk(@RequestBody OneItemDto request){
        Member find = memberService.findByNickname(request.getItem());

        if (find != null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Duplicated Nickname");
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.ok(request);
        }
    }

    /**
     * profile image enroll
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/profileEnroll")
    public ResponseEntity<?> profileEnroll(@RequestPart("profileImg")MultipartFile request) throws IOException {
        if (request.isEmpty()){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","No Image File");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        String profileImg = memberService.profileEnroll(request);
        return ResponseEntity.ok(profileImg);
    }

    /**
     * Email Authentication
     * @param request
     * @return
     */
    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody OneItemDto request){
        return ResponseEntity.ok(memberService.sendMail(request.getItem()));
    }

    /**
     * Create Member (Sign Up) / application create version (Not social)
     * @param request
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateMemberDto request){
        CreateMemberDto response = null;
        Member newMember = Member.createMember(
                request.getEmail(),
                request.getPasswd(),
                //passwordEncoder.encode(request.getPasswd()),
                request.getBirth(),
                request.getName(),
                request.getPhone(),
                request.getNickname(),
                request.getProfileImg(),
                request.getCreateDate(),
                request.getGender());
        response = memberService.save(newMember);
        return ResponseEntity.ok(response);
    }

    /**
     * Log-In(Sign in) / application login version (Not social)
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto request){
        // Find valid email
        Member find = memberService.findByEmail(request.getEmail());
        if (find == null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Email_Error","존재하지 않는 아이디 입니다.");
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }

        // Check correct password
        if (find.getPasswd() != request.getPasswd()){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("PW_Error","유효하지 않은 비밀번호 입니다.");
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(request);
    }

    /**
     * find user email
     * @param request
     * @return
     */
    @PostMapping("/findId")
    public ResponseEntity<?> findId(@RequestBody FindMemberDto request){
        Member find = memberService.findByNameAndBirthAndPhoneAndGender(
                request.getName(),request.getBirth(),request.getPhone(),request.getGender());

        if (find == null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Wrong Value");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }else{
            OneItemDto email = new OneItemDto(find.getEmail());
            return ResponseEntity.ok(email);
        }
    }
    /**
     * find user password
     * @param request
     * @return
     */
    @PostMapping("/findPw")
    public ResponseEntity<?> findPw(@RequestBody FindMemberDto request){
        Member find = memberService.findByNameAndBirthAndPhoneAndGenderAndEmail
                (request.getName(), request.getBirth(), request.getPhone(), request.getGender(), request.getEmail());
        if (find == null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Wrong Value");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }else{
            OneItemDto passwd = new OneItemDto(find.getPasswd());
            return ResponseEntity.ok(passwd);
        }
    }
}
