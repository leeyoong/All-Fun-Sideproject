package AllFun.SideProject.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateBoardRequestDto {
    private String title; // 제목
    private String content; // 글의 내용
    private LocalDateTime date; // 작성 날짜
    private int projectMembers; // 프로젝트 구성 인원
}
