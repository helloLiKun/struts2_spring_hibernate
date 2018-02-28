package com.ssh.cn.service.impl;

import com.ssh.cn.dao.UserDao;
import com.ssh.cn.entity.User;
import com.ssh.cn.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by likun on 2018/2/28 0028.
 */
@Service("userService")
@Transactional
public class UserServiceImpl  implements UserService{
    @Resource
    private UserDao userDao;
    public User login(String idNum, String password) {
        User user
                =userDao.findByIdNum(idNum);
        if((user!=null)&&
                user.getPwd().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }
}
