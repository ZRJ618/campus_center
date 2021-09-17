package com.demo.pojo;

import lombok.Data;

@Data
public class Logger {
    private String userId;
    private String method;
    private String param;
    private String executionTime;
    private String result;
}
