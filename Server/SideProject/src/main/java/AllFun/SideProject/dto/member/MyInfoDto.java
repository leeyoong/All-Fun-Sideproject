package AllFun.SideProject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyInfoDto {
    private String email; // Log-In Id (이메일 변동 불가)
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname (변동 가능)
    private String gender; // gender(MALE / FEMALE)
    private String introduce; //자기소개

    private int myGroups;
    private int myEntryPool;

}
