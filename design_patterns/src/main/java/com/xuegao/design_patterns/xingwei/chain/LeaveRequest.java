package com.xuegao.design_patterns.xingwei.chain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaveRequest {
    private String name;    // 请假人姓名
    private int numOfDays;  // 请假天数
}
