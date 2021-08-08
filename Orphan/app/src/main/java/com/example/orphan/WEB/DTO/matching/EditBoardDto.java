package com.example.orphan.WEB.DTO.matching;


import java.time.LocalDateTime;

public class EditBoardDto {
    private String title; // 제목
    private String content; // 내용

    private int backend;
    private int frontend;
    private int pm;
    private int android;
    private int iOS;
    private int ai;
    private int bigData;
    private int blockChain;

    private LocalDateTime endDate;

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

    public int getBackend() {
        return backend;
    }

    public void setBackend(int backend) {
        this.backend = backend;
    }

    public int getFrontend() {
        return frontend;
    }

    public void setFrontend(int frontend) {
        this.frontend = frontend;
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public int getAndroid() {
        return android;
    }

    public void setAndroid(int android) {
        this.android = android;
    }

    public int getiOS() {
        return iOS;
    }

    public void setiOS(int iOS) {
        this.iOS = iOS;
    }

    public int getAi() {
        return ai;
    }

    public void setAi(int ai) {
        this.ai = ai;
    }

    public int getBigData() {
        return bigData;
    }

    public void setBigData(int bigData) {
        this.bigData = bigData;
    }

    public int getBlockChain() {
        return blockChain;
    }

    public void setBlockChain(int blockChain) {
        this.blockChain = blockChain;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public EditBoardDto(String title, String content, int backend, int frontend, int pm, int android, int iOS, int ai, int bigData, int blockChain, LocalDateTime endDate) {
        this.title = title;
        this.content = content;
        this.backend = backend;
        this.frontend = frontend;
        this.pm = pm;
        this.android = android;
        this.iOS = iOS;
        this.ai = ai;
        this.bigData = bigData;
        this.blockChain = blockChain;
        this.endDate = endDate;
    }
}
