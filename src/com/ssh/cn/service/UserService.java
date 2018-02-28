package com.ssh.cn.service;

import com.ssh.cn.entity.User;

import java.util.List;

/**
 * Created by likun on 2018/2/28 0028.
 */
public interface UserService {
    User login(String username, String password);
    List<User> getUsers();
    List<User> getUsersByNameAndPage(String val,int pageIndex,int pageSize);
}
