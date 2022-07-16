package com.gugu.example.gugudatasourcedemo.service;

import com.gugu.example.gugudatasourcedemo.model.User;

import java.util.List;

/**
 * @author gugu
 * @Classname MemberService
 * @Description TODO
 * @Date 2022/7/16 20:33
 */
public interface UserService {

    int insert(User userDO);

    int save(User userDO);

    List<User> selectAll();

    String getToken(String userId);
}
