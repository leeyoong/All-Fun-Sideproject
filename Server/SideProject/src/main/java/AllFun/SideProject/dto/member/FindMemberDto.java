package AllFun.SideProject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FindMemberDto {
    @NonNull private String name;
    @NonNull private String birth;
    @NonNull private String phone;
    private String email;
}
