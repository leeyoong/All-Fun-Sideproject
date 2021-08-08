package com.example.orphan.WEB.DTO.matching;


import java.time.LocalDateTime;
import java.util.List;

public class ReadDetailDto {
    private String title;
    private String content;
    private String writer;

    private LocalDateTime createdDate; //작성(수정) 날짜

    private LocalDateTime endDate;

    private List<BoardRoleDto> expect; // ex> backend 0(entry) / 1(expect)

    private int hit; // 조회수

    private Long memberId; // 사용자 id

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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<BoardRoleDto> getExpect() {
        return expect;
    }

    public void setExpect(List<BoardRoleDto> expect) {
        this.expect = expect;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public ReadDetailDto(String title, String content, String writer, LocalDateTime createdDate, LocalDateTime endDate, List<BoardRoleDto> expect, int hit, Long memberId) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.expect = expect;
        this.hit = hit;
        this.memberId = memberId;
    }
}
