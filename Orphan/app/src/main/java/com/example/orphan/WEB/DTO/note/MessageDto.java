package com.example.orphan.WEB.DTO.note;

public class MessageDto {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageDto(String message) {
        this.message = message;
    }

    private String message;
}
