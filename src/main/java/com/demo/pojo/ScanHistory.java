package com.demo.pojo;

import lombok.Data;

@Data
public class ScanHistory {
    private String scanHistoryId;
    private String userId;
    private String articleOrAnswerId;
    private String createTime;//插入时用Timestamp类型
    private int status;
}
