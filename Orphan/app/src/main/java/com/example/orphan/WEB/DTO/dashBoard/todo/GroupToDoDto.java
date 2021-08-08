package com.example.orphan.WEB.DTO.dashBoard.todo;

import java.time.LocalDateTime;

public class GroupToDoDto {
    private Long todoId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String title;

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GroupToDoDto(Long todoId, LocalDateTime startDateTime, LocalDateTime endDateTime, String title) {
        this.todoId = todoId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.title = title;
    }
}
