package AllFun.SideProject.dto.matching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateBoardRequestDto {
    private String title; // 제목
    private String content; // 글의 내용

    private int backend;
    private int frontend;
    private int pm;
    private int android;
    private int iOS;
    private int ai;
    private int bigData;
    private int blockChain;

    private  String endDate;

}
