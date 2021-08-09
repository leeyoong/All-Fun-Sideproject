package com.example.orphan.WEB.DTO.matching;

import java.time.LocalDateTime;

public class CreateBoardResponseDto {
    private String writer;// 작성자 닉네임
    private String title; // 제목
    private String content; // 글의 내용
    private LocalDateTime date; // 작성 날짜
    private int projectMembers; // 프로젝트 구성 인원
    private int hit; // 조회수

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(int projectMembers) {
        this.projectMembers = projectMembers;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public CreateBoardResponseDto(String writer, String title, String content, LocalDateTime date, int projectMembers, int hit) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.date = date;
        this.projectMembers = projectMembers;
        this.hit = hit;
    }
}
