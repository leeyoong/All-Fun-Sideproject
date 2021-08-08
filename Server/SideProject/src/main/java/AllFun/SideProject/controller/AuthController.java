package AllFun.SideProject.controller;

import AllFun.SideProject.domain.member.Member;
import AllFun.SideProject.Exception.ErrorHeader;
import AllFun.SideProject.dto.member.*;
import AllFun.SideProject.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    /**
     * Check Duplicated Email
     * @param email
     * @return
     */
    @GetMapping("/check/email/{email}")
    public ResponseEntity<?> emailChk(@PathVariable("email")String email){

        Member find = memberService.findByEmail(email);
        if (find != null){

            return ErrorHeader.errorMessage("duplicated email",HttpStatus.CONFLICT);
        }else{
            OneItemDto oneItemDto = new OneItemDto(memberService.generatedKey());
            try{
                System.out.println("여기임 씨발");
                System.out.println(oneItemDto.getItem());
                return ResponseEntity.ok(oneItemDto);
            }finally{
                memberService.sendMail(oneItemDto.getItem(),email);
                System.out.println("이메일 전송 완료");
            }

        }

    }

    /**
     * Check Duplicated Nickname
     * @param nickname
     * @return
     */
    @GetMapping("/check/nickname/{nickname}")
    public ResponseEntity<?> nicknameChk(@PathVariable("nickname") String nickname){
        Member find = memberService.findByNickname(nickname);
        if (find != null){
            return ErrorHeader.errorMessage("duplicated nickname",HttpStatus.CONFLICT);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Email Authentication
     * @param email
     * @return
     */
/*
    @GetMapping("/send/email/{email}")
    public ResponseEntity<?> sendMail(@PathVariable("email")String email){
        OneItemDto oneItemDto = new OneItemDto(memberService.sendMail(email));
        return ResponseEntity.ok(oneItemDto);
    }

 */

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
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    /**
     * Log-In(Sign in) / application login version (Not social)
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto request){
        // Find valid email
        System.out.println(request.getPasswd());
        Member find = memberService.findByEmail(request.getEmail());
        if (find == null){
            return ErrorHeader.errorMessage("wrong email",HttpStatus.CONFLICT);
        }

        // Check correct password
        if (!find.getPasswd().equals(request.getPasswd())){
            return ErrorHeader.errorMessage("wrong password",HttpStatus.CONFLICT);
        }

        MemberLoginDto response = new MemberLoginDto(
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
     * @param name
     * @param birth
     * @param phone
     * @return
     */
    @GetMapping("/find/email/name/{name}/birth/{birth}/phone/{phone}")
    public ResponseEntity<?> findEmail(@PathVariable("name") String name, @PathVariable("birth") String birth,
                                       @PathVariable("phone") String phone){
        Member find = memberService.findByNameAndBirthAndPhoneAndGender(name,birth,phone);

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
    @PatchMapping("/find/password")
    public ResponseEntity<?> findPassword(@RequestBody FindPasswordDto request){
        System.out.println(request);
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
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }

    /**
     * 회원 탈퇴
     * @param member_id
     * @return
     */
    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> secession(@PathVariable("memberId")Long member_id){
        Member find = memberService.findById(member_id);
        if (find == null){
            return ErrorHeader.errorMessage("wrong_member",HttpStatus.BAD_REQUEST);

        }memberService.deleteMember(find);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
