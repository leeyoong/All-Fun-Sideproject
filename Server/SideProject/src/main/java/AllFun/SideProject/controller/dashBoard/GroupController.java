package AllFun.SideProject.controller.dashBoard;

import AllFun.SideProject.dto.dashBoard.group.MyGroupListDto;
import AllFun.SideProject.service.dashBoard.DashGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class GroupController {
    private final DashGroupService dashGroupService;
    /**
     * get dashboard main page (show group)
     * @return
     */
    @GetMapping("/group/member/{memberId}")
    public ResponseEntity<?> myGroup(@PathVariable("memberId")Long memberId){
        List<MyGroupListDto> response = dashGroupService.getMyGroups(memberId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/group/member/{memberId}")
    public ResponseEntity<?> createGroup(@PathVariable("memberId") Long memberId,
                                         @RequestBody String groupName){
        dashGroupService.createGroup(memberId, groupName);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 그룹 삭제
     * @param groupId
     * @return
     */
    @DeleteMapping("/group/{groupId}")
    public ResponseEntity<?> deleteGroup(@PathVariable("groupId")Long groupId){
        dashGroupService.deleteGroup(groupId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 그룹 탈퇴
     * @param groupId
     * @param memberId
     * @return
     */
    @DeleteMapping("group/{groupId}/member/{memberId}")
    public ResponseEntity<?> secessionGroup(@PathVariable("groupId")Long groupId,
                                            @PathVariable("memberId")Long memberId){
        dashGroupService.secessionGroup(groupId, memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
