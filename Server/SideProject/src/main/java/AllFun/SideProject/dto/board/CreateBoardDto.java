package AllFun.SideProject.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBoardDto {
    private String nickname; // member - nickname
    private String title; // 제목
    private String content; // 글의 내용
    private String createDate; //작성날짜
    private int projectMembers; // 프로젝트 구성 인원
    private int hit; // 조회수
}
