package com.example.orphan;

public class BoardListItem {

    private String boardtitleStr;
    private String boardtextStr;
    private String boardwriterStr;
    private String boarddateStr;

    private Long groupBoardId;
    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getGroupBoardId() {
        return groupBoardId;
    }

    public void setGroupBoardId(Long groupBoardId) {
        this.groupBoardId = groupBoardId;
    }

    public String getBoardtitleStr() {
        return boardtitleStr;
    }

    public void setBoardtitleStr(String boardtitleStr) {
        this.boardtitleStr = boardtitleStr;
    }

    public String getBoardtextStr() {
        return boardtextStr;
    }

    public void setBoardtextStr(String boardtextStr) {
        this.boardtextStr = boardtextStr;
    }

    public String getBoardwriterStr() {
        return boardwriterStr;
    }

    public void setBoardwriterStr(String boardwriterStr) {
        this.boardwriterStr = boardwriterStr;
    }

    public String getBoarddateStr() {
        return boarddateStr;
    }

    public void setBoarddateStr(String boarddateStr) {
        this.boarddateStr = boarddateStr;
    }


 /*   private int dashfixDrawable;
    private int dashassDrawable;
    private int dashalarmDrawable; */



   /* public int getDashfixDrawable() {
        return dashfixDrawable;
    }

    public void setDashfixDrawable(int dashfixDrawable) {
        this.dashfixDrawable = dashfixDrawable;
    }

    public int getDashassDrawable() {
        return dashassDrawable;
    }

    public void setDashassDrawable(int dashassDrawable) {
        this.dashassDrawable = dashassDrawable;
    }

    public int getDashalarmDrawable() {
        return dashalarmDrawable;
    }

    public void setDashalarmDrawable(int dashalarmDrawable) {
        this.dashalarmDrawable = dashalarmDrawable;
    }

*/

}
