package com.amuse.framedynamic.service.impl;

import com.amuse.framedynamic.dao.UserMapper;
import com.amuse.framedynamic.entity.User;
import com.amuse.framedynamic.service.UserService;
import com.amuse.framedynamic.service.UsersService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UsersService usersService;


    @DS("slave_1")
    @Transactional
    public User getUser(Integer id) {
        //测试@DS和spring事务之间的关系
        usersService.getOracleUsers(0);
        return userMapper.selectById(id);
    }


}
