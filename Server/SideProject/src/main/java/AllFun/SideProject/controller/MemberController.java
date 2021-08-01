package AllFun.SideProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MemberController {

    /**
     * modify password
     * @return
     */
    @PostMapping("/change/password")
    public ResponseEntity<?> modifyPassword(){
        return null;
    }

    /**
     * 프로필 사진 등록(변경)
     * @return
     */
    @PostMapping("/enroll/profile")
    public ResponseEntity<?> enrollProfile(){
        return null;
    }

    /**
     * my page 정보 불러오기
     * @return
     */
    @GetMapping("/list/profile")
    public ResponseEntity<?> listProfile(){
        return null;
    }

    /**
     * my page 정보 수정
     * @return
     */
    @PostMapping("/edit")
    public ResponseEntity<?> editMyPage(){
        return null;
    }

}
