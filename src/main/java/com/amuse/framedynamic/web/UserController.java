package com.amuse.framedynamic.web;

import com.amuse.framedynamic.dao.UserMapper;
import com.amuse.framedynamic.dao.UsersMapper;
import com.amuse.framedynamic.entity.User;
import com.amuse.framedynamic.entity.Users;
import com.amuse.framedynamic.service.UserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 刘培振
 * @Date 2022-11-11 17:40
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@RequestParam Integer id) {
        //return userMapper.selectById(id);
        return userService.getUser(id);
    }

    @DS("slave_3")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public Users getUsers(@RequestParam Integer id) {
        //return userMapper.selectById(id);
        return usersMapper.selectById(id);
    }

}
