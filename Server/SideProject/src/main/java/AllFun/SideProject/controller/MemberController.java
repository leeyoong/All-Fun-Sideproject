package AllFun.SideProject.controller;

import AllFun.SideProject.domain.Member;
import AllFun.SideProject.dto.member.EmailCheckDto;
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
        HashMap<String, String> result = new HashMap<String,String>();

        if (find != null){
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
    @PostMapping("/emailChk")
    public ResponseEntity<?> nicknameChk(@RequestBody NicknameCheckDto request){
        Member find = memberService.findByEmail(request.getNickname());
        HashMap<String, String> result = new HashMap<String,String>();

        if (find != null){
            result.put("Error","Duplicated Nickname");
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.ok(request);
        }
    }

}
