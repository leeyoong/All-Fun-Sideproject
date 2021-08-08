package com.example.orphan.WEB.DTO.mainPage;


import java.time.LocalDateTime;

public class MyToDoDto {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String groupName;
    private String title;

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MyToDoDto(LocalDateTime startDateTime, LocalDateTime endDateTime, String groupName, String title) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.groupName = groupName;
        this.title = title;
    }
}
