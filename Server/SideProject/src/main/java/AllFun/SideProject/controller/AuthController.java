package AllFun.SideProject.controller;

import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.dto.ErrorHeader;
import AllFun.SideProject.dto.member.*;
import AllFun.SideProject.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    /**
     * Check Duplicated Email
     * @param request
     * @return
     */
    @PostMapping("/check/email")
    public ResponseEntity<?> emailChk(@RequestBody OneItemDto request){
        System.out.println(request);
        Member find = memberService.findByEmail(request.getItem());
        if (find != null){
            return ErrorHeader.errorMessage("duplicated email",HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.ok(null);
        }
    }
    /**
     * Check Duplicated Nickname
     * @param request
     * @return
     */
    @PostMapping("/check/nickname")
    public ResponseEntity<?> nicknameChk(@RequestBody OneItemDto request){
        Member find = memberService.findByNickname(request.getItem());

        if (find != null){
            return ErrorHeader.errorMessage("duplicated nickname",HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.ok(null);
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
            return ErrorHeader.errorMessage("request error",HttpStatus.BAD_REQUEST);
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
        Member newMember = Member.createMember(
                request.getEmail(),
                request.getPasswd(),
                request.getBirth(),
                request.getName(),
                request.getPhone(),
                request.getNickname(),
                request.getGender());
        memberService.save(newMember);
        return ResponseEntity.ok(null);
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
            return ErrorHeader.errorMessage("wrong email",HttpStatus.CONFLICT);
        }

        // Check correct password
        if (find.getPasswd() != request.getPasswd()){
            return ErrorHeader.errorMessage("wrong password",HttpStatus.CONFLICT);
        }

        MemberDataDto response = new MemberDataDto(
                find.getId(),
                find.getEmail(),
                find.getPasswd(),
                find.getBirth(),
                find.getName(),
                find.getPhone(),
                find.getNickname(),
                find.getCreatedDate(),
                find.getGender()
        );
        return ResponseEntity.ok(response);
    }

    /**
     * find user email
     * @param request
     * @return {email}
     */
    @GetMapping("/findId")
    public ResponseEntity<?> findId(@RequestBody FindEmailDto request){
        Member find = memberService.findByNameAndBirthAndPhoneAndGender(
                request.getName(),request.getBirth(),request.getPhone());

        if (find == null){
            return ErrorHeader.errorMessage("wrong email",HttpStatus.CONFLICT);
        }else{
            OneItemDto email = new OneItemDto(find.getEmail());
            return ResponseEntity.ok(email);
        }
    }

    /**
     * change user password (if user forgot pw)
     * @param request
     * @return
     */
    @GetMapping("/findPw")
    public ResponseEntity<?> findPw(@RequestBody FindPasswordDto request){
        Member find = memberService.findByNameAndBirthAndPhoneAndGenderAndEmail
                (request.getName(), request.getBirth(), request.getPhone(), request.getEmail());
        if (find == null){
            return ErrorHeader.errorMessage("wrong value",HttpStatus.CONFLICT);
        }else{
            // 임시 비밀번호 메일로 전송
            String res = memberService.sendMailPw(find.getEmail());
            if(res == "Fail"){
                return ErrorHeader.errorMessage("email send fail",HttpStatus.CONFLICT);
            }
            else{
                return ResponseEntity.ok(null);
            }
        }
    }

    /**
     * 회원 탈퇴
     * @return
     */
    @PostMapping("/secession")
    public ResponseEntity<?> secession(){
        return null;
    }
}
