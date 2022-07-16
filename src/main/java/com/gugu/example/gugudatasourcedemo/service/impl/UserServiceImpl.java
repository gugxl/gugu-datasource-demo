package com.gugu.example.gugudatasourcedemo.service.impl;

import com.gugu.example.gugudatasourcedemo.annotation.Master;
import com.gugu.example.gugudatasourcedemo.mapper.UserMapper;
import com.gugu.example.gugudatasourcedemo.model.User;
import com.gugu.example.gugudatasourcedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gugu
 * @Classname MemberServiceImpl
 * @Description TODO
 * @Date 2022/7/16 20:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Transactional
    @Override
    public int insert(User userDO) {
        return userMapper.insert(userDO);
    }

    @Master
    @Override
    public int save(User userDO) {
        return userMapper.insert(userDO);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public String getToken(String userId) {
        //  有些读操作必须读主数据库
        User userDO = userMapper.selectByPrimaryKey(Long.valueOf(userId));
        if (userDO!= null){
            return userDO.getName();
        }
        return null;
    }
}
