package com.ssh.cn.dao;

import com.ssh.cn.entity.User;

import java.util.List;

/**
 * Created by likun on 2018/2/28 0028.
 */
public interface UserDao {
    void save(User user);
    void delete(User user);
    void update(User user);
    User findById(String id);
    User findByIdNum(String idNum);
    List<User> findAll();
}
