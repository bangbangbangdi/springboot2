package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_tbl")
public class User /*implements Serializable*/ {

    /*
    * 默认所有属性都应该在表中
    * */
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    // 以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
