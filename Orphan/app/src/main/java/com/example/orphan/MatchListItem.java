package com.example.orphan;

public class MatchListItem {

    private String matchtitleStr;
    private String matchtagStr;
    private String writerStr;
    private String writedateStr;
    private String writerContent;
    private Long boardId;

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getWriterContent() {
        return writerContent;
    }

    public void setWriterContent(String writerContent) {
        this.writerContent = writerContent;
    }

    public String getMatchtitleStr() {
        return matchtitleStr;
    }

    public void setMatchtitleStr(String matchtitleStr) {
        this.matchtitleStr = matchtitleStr;
    }

    public String getMatchtagStr() {
        return matchtagStr;
    }

    public void setMatchtagStr(String matchtagStr) {
        this.matchtagStr = matchtagStr;
    }

    public String getWriterStr() {
        return writerStr;
    }

    public void setWriterStr(String writerStr) {
        this.writerStr = writerStr;
    }

    public String getWritedateStr() {
        return writedateStr;
    }

    public void setWritedateStr(String writedateStr) {
        this.writedateStr = writedateStr;
    }



}
