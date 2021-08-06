package com.example.orphan.DTO.matching;

import java.time.LocalDateTime;

public class CreateBoardResponseDto {
    private String writer;// 작성자 닉네임
    private String title; // 제목
    private String content; // 글의 내용
    private LocalDateTime date; // 작성 날짜
    private int projectMembers; // 프로젝트 구성 인원
    private int hit; // 조회수
}
