package com.example.orphan.WEB.DTO.dashBoard.todo;


import java.time.LocalDateTime;

public class CreateToDoDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String title;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CreateToDoDto(LocalDateTime startTime, LocalDateTime endTime, String title) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
    }
}
