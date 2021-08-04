package com.example.test.DTO.matching;


import java.time.LocalDateTime;

public class SearchResponseDto {
    private Long boardId;
    private String title;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime endDate;
    private int projMember;
    private int entryMember;
}
