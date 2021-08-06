package com.example.orphan.DTO.matching;


import java.time.LocalDateTime;
import java.util.List;

public class CreateBoardRequestDto {
    private String title; // 제목
    private String content; // 글의 내용
    private List<Integer> hope;
    private LocalDateTime endDate;

}
