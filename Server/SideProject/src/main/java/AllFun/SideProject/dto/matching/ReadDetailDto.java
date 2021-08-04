package AllFun.SideProject.dto.matching;

import AllFun.SideProject.domain.base.BoardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ReadDetailDto {
    private String title;
    private String content;
    private String writer;

    private LocalDateTime date; //작성(수정) 날짜

    private LocalDateTime endDate;

    private List<BoardRoleDto> roles;

    private int hit; // 조회수

    private Long memberId; // 사용자 id

    private BoardStatus status;
}

