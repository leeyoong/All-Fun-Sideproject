package com.example.orphan.WEB.DTO.dashBoard.todo;

import java.time.LocalDateTime;

public class GroupToDoDto {
    private Long todoId;
    private String startDateTime;
    private String endDateTime;
    private String title;

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GroupToDoDto(Long todoId, String startDateTime, String endDateTime, String title) {
        this.todoId = todoId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.title = title;
    }
}
