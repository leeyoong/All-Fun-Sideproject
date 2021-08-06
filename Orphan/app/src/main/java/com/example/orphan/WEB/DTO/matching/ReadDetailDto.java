package com.example.orphan.WEB.DTO.matching;
import java.time.LocalDateTime;

public class ReadDetailDto {
    private String title;
    private String content;
    private String writer;
    private LocalDateTime date; //작성(수정) 날짜
    private int hope; // 프로젝트 구성 인원
    private int entry; // 참여 인원
    private int hit; // 조회수
}
