package com.example.orphan.WEB.DTO.mainPage;


import java.time.LocalDateTime;

public class MyNoHitBoardDto {
    private Long groupId;
    private Long groupBoardId;

    private String title;
    private String content;
    private LocalDateTime createdDate;

    private Long memberId;
    private String memberNickname;

    private String groupName;

    private BoardKinds kinds;
}
