package AllFun.SideProject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MemberDataDto {
    private Long id; // member id (pk)
    private String email; // Log-In Id
    private String passwd; // password
    private String birth; // yyyy-mm-dd
    private String name; // user korean name
    private String phone; //phone number
    private String nickname; // nickname
    private LocalDateTime createDate; // create member time (yyyy-mm-dd hh:mm:ss)
    private String gender; // gender(M / F)
}
