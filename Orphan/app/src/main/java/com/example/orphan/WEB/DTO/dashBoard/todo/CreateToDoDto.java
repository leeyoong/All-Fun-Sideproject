package com.example.orphan.WEB.DTO.dashBoard.todo;


import java.time.LocalDateTime;

public class CreateToDoDto {
    private String startTime;
    private String endTime;
    private String title;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CreateToDoDto(String startTime, String endTime, String title) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
    }
}
