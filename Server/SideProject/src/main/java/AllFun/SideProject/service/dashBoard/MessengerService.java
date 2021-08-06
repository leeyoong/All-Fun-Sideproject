package AllFun.SideProject.service.dashBoard;

import AllFun.SideProject.dto.dashBoard.MessengerListDto;
import AllFun.SideProject.repository.dashBoard.MessengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessengerService {
    private final MessengerRepository messengerRepository;

    public List<MessengerListDto> getMessengerList(){
        return null;
    }
}
