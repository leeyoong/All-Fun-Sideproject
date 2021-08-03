package AllFun.SideProject.controller;

import AllFun.SideProject.Exception.ErrorHeader;
import AllFun.SideProject.dto.member.EditMemberInfoDto;
import AllFun.SideProject.dto.member.MemberInfoDto;
import AllFun.SideProject.dto.member.MyInfoDto;
import AllFun.SideProject.dto.member.OneItemDto;
import AllFun.SideProject.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    /**
     * modify password
     * @param memberId
     * @param request
     * @return
     */
    @PostMapping("/{memberId}/password")
    public ResponseEntity<?> modifyPassword(@PathVariable("memberId")Long memberId, @RequestBody OneItemDto request){
        return ResponseEntity.ok(memberService.modifyPassword(memberId,request));
    }

    /**
     * profile image enroll
     * @param memberId
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/{memberId}/profile")
    public ResponseEntity<?> profileEnroll(@PathVariable("memberId") Long memberId,@RequestPart("profileImg") MultipartFile request) throws IOException {
        if (request.isEmpty()){
            return ErrorHeader.errorMessage("request error", HttpStatus.BAD_REQUEST);
        }
        //String profileImg = memberService.profileEnroll(request);
        return ResponseEntity.ok(null);
    }

    /**
     * get my info
     *
     * @return
     */
    @GetMapping("/my/{memberId}")
    public ResponseEntity<?> myInfo(@PathVariable("memberId")Long memberId){
        MyInfoDto response = memberService.getMyInfo(memberId);
        if (response==null){
            return ErrorHeader.errorMessage("error",HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(response);
    }

    /**
     * get my info
     *
     * @return
     */
    @GetMapping("/member/{memberId}")
    public ResponseEntity<?> memberInfo(@PathVariable("memberId")Long memberId){
        MemberInfoDto response = memberService.getMemberInfo(memberId);
        if (response==null){
            return ErrorHeader.errorMessage("error",HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(response);
    }

    /**
     * my page get edit data
     * @param memberId
     * @return
     */
    @GetMapping("/{memberId}/edit")
    public ResponseEntity<?> editMyPageGet(@PathVariable("memberId")Long memberId){
        return ResponseEntity.ok(memberService.getMemberInfo(memberId));
    }

    /**
     * my page edit
     * @param memberId
     * @param request
     * @return
     */
    @PutMapping("/{memberId}/edit")
    public ResponseEntity<?> editMyPage(@PathVariable("memberId")Long memberId, @RequestBody EditMemberInfoDto request){
        String response = memberService.putMemberInfo(memberId,request);
        if (response == null){
            return ErrorHeader.errorMessage("error",HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }

}
