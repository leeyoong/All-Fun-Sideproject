package AllFun.SideProject.controller;

import AllFun.SideProject.dto.ErrorHeader;
import AllFun.SideProject.dto.member.EditMemberInfoDto;
import AllFun.SideProject.dto.member.MemberInfoDto;
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
    @PostMapping("/{member_id}/password")
    public ResponseEntity<?> modifyPassword(@PathVariable("member_id")Long memberId, @RequestBody OneItemDto request){
        return ResponseEntity.ok(memberService.modifyPassword(memberId,request));
    }

    /**
     * profile image enroll
     * @param memberId
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/{member_id}/profile")
    public ResponseEntity<?> profileEnroll(@PathVariable("member_id") Long memberId,@RequestPart("profileImg") MultipartFile request) throws IOException {
        if (request.isEmpty()){
            return ErrorHeader.errorMessage("request error", HttpStatus.BAD_REQUEST);
        }
        //String profileImg = memberService.profileEnroll(request);
        return ResponseEntity.ok(null);
    }

    /**
     * get member info
     *
     * @return
     */
    @GetMapping("/{member_id}")
    public ResponseEntity<?> memberInfo(@PathVariable("member_id")Long memberId){
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
    @GetMapping("/{member_id}/edit")
    public ResponseEntity<?> editMyPageGet(@PathVariable("member_id")Long memberId){
        return ResponseEntity.ok(memberService.getMemberInfo(memberId));
    }

    /**
     * my page edit 
     * @param memberId
     * @param request
     * @return
     */
    @PutMapping("/{member_id}/edit")
    public ResponseEntity<?> editMyPage(@PathVariable("member_id")Long memberId, @RequestBody EditMemberInfoDto request){
        String response = memberService.putMemberInfo(memberId,request);
        if (response == null){
            return ErrorHeader.errorMessage("error",HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }

}
