package AllFun.SideProject.dto.matching;

import AllFun.SideProject.domain.base.MatchingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EntryPoolResponseDto {

    //사용자 Id
    private Long memberId;
    private String memberNickname;
    private String img;// 임시로 string 처리
    //매칭 결과 (~중 / 탈락 / 합격)
    private MatchingStatus status;
}
