package com.atguigu.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fruit {

    private Integer fid;
    private String fname;
    private Integer price;
    private Integer fcount;
    private String remark;

}
