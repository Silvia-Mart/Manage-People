package com.attornatus.managePeople.dto;

public class ErrorDto {
    private String message;
    private String statusName;
    private String field;

    public ErrorDto(String message, String status) {
        this.message = message;
        this.statusName = status;
    }

    public ErrorDto(String message, String status, String field) {
        this.message = message;
        this.statusName = status;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return statusName;
    }

    public String getField() {
        return field;
    }
}
