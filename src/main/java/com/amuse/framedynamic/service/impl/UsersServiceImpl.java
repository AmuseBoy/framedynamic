package com.amuse.framedynamic.service.impl;

import com.amuse.framedynamic.dao.UsersMapper;
import com.amuse.framedynamic.entity.Users;
import com.amuse.framedynamic.service.UsersService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UsersServiceImpl
 * @Description TODO
 * @Author 刘培振
 * @Date 2022-11-21 14:14
 * @Version 1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @DS("slave_3")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Users getOracleUsers(Integer id) {
        return usersMapper.selectById(id);
    }
}
