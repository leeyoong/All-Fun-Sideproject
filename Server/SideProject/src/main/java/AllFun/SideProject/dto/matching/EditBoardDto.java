package AllFun.SideProject.dto.matching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EditBoardDto {
    private String title; // 제목
    private String content; // 내용

    private int backend;
    private int frontend;
    private int pm;
    private int android;
    private int iOS;
    private int ai;
    private int bigData;
    private int blockChain;

    private LocalDateTime endDate;
}
