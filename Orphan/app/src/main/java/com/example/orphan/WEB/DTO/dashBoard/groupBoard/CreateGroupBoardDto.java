package com.example.orphan.WEB.DTO.dashBoard.groupBoard;


import com.example.orphan.WEB.base.BoardKinds;

public class CreateGroupBoardDto {
    private String title;
    private String content;

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

    public BoardKinds getKinds() {
        return kinds;
    }

    public void setKinds(BoardKinds kinds) {
        this.kinds = kinds;
    }

    public CreateGroupBoardDto(String title, String content, BoardKinds kinds) {
        this.title = title;
        this.content = content;
        this.kinds = kinds;
    }

    private BoardKinds kinds;
}
