package com.TcgTask.weather.ErrorHandling;

public class ApiError {
    private String message;
    private String timestamp;

    public ApiError(String message) {
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

