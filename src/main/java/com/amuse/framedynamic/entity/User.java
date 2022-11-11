package com.amuse.framedynamic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "user")
public class User implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    //该注解用于接口类型互转
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private String email;

    private String password;

    private String job;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
