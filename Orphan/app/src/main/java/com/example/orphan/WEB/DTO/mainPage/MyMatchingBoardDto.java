package com.example.orphan.WEB.DTO.mainPage;

import java.time.LocalDateTime;

public class MyMatchingBoardDto {
    private Long boardId;
    private String title;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime endDate;

    private List<BoardRoleDto> expect;

    private BoardStatus status;

}
