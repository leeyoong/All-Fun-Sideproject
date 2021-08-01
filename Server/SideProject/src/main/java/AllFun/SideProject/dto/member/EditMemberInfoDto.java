package AllFun.SideProject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EditMemberInfoDto {
    private String phone; //phone number
    private String nickname; // nickname (변동 가능)
    private String introduce; //자기소개
}
