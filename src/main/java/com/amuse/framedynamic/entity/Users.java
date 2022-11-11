package com.amuse.framedynamic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName Users
 * @Description oracle
 * @Author 刘培振
 * @Date 2022-11-11 18:59
 * @Version 1.0
 */
@Data
@TableName(value = "users")
public class Users {

    private Integer id;

    private String name;

    private String sex;

    //该注解用于接口类型互转
    private String birth;

    private String email;

    @TableField(value = "pass_word")
    private String password;

}
