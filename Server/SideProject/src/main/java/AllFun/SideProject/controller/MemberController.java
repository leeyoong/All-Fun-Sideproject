package AllFun.SideProject.controller;

import AllFun.SideProject.domain.Member;
import AllFun.SideProject.dto.member.CreateMemberDto;
import AllFun.SideProject.dto.member.EmailCheckDto;
import AllFun.SideProject.dto.member.LoginDto;
import AllFun.SideProject.dto.member.NicknameCheckDto;
import AllFun.SideProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * Check Duplicated Email
     * @param request
     * @return
     */
    @PostMapping("/emailChk")
    public ResponseEntity<?> emailChk(@RequestBody EmailCheckDto request){
        Member find = memberService.findByEmail(request.getEmail());

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
    public ResponseEntity<?> nicknameChk(@RequestBody NicknameCheckDto request){
        Member find = memberService.findByNickname(request.getNickname());

        if (find != null){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","Duplicated Nickname");
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.ok(request);
        }
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
                request.getBirth(),
                request.getName(),
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
            result.put("Error","존재하지 않는 아이디 입니다.");
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }

        // Check correct password
        if (find.getPasswd() != request.getPasswd()){
            HashMap<String, String> result = new HashMap<String,String>();
            result.put("Error","유효하지 않은 비밀번호 입니다.");
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(request);
    }
}
