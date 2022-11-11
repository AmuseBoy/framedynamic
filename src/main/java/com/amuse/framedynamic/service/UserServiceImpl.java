package com.amuse.framedynamic.service;

import com.amuse.framedynamic.dao.UserMapper;
import com.amuse.framedynamic.entity.User;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 刘培振
 * @Date 2022-11-11 18:09
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @DS("slave_1")
    public User getUser(Integer id) {
        return userMapper.selectById(id);
    }


}
