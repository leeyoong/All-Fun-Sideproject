package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.domain.dashBoard.DashGroup;
import AllFun.SideProject.dto.mainPage.MyGroupDto;
import AllFun.SideProject.repository.dashBoard.DashGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DashGroupService {
    private final DashGroupRepository dashGroupRepository;

}
