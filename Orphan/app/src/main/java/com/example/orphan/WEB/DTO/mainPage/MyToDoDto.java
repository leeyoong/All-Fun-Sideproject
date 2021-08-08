package com.example.orphan.WEB.DTO.mainPage;


import java.time.LocalDateTime;

public class MyToDoDto {
    private String startDateTime;
    private String endDateTime;
    private String groupName;
    private String title;

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
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

    public MyToDoDto(String startDateTime, String endDateTime, String groupName, String title) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.groupName = groupName;
        this.title = title;
    }
}
