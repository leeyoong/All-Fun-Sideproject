package AllFun.SideProject.dto.matching;

import AllFun.SideProject.domain.base.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardRoleDto {
    private RoleType role;
    private int hope;
    private int entry;
}
