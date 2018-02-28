package com.ssh.cn.dao.impl;

import com.ssh.cn.dao.UserDao;
import com.ssh.cn.entity.User;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by likun on 2018/2/28 0028.
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
    @Resource
    private HibernateTemplate hibernateTemplate;
    public void save(User user) {
        hibernateTemplate.save(user);
    }

    public void delete(User user) {
        hibernateTemplate.delete(user);
    }

    public void update(User user) {
        hibernateTemplate.update(user);
    }

    public User findById(String id) {
        String hql="from User where id=?";
        User user=(User) hibernateTemplate.find(hql, id);
        return user;
    }

    public User findByIdNum(String idNum) {
        String hql="from User where idNum=:idNum";
        List list
                =hibernateTemplate.findByNamedParam(hql, "idNum", idNum);
        return (User) list.get(0);
    }

    public List<User> findAll() {
        String hql="from User";
        List<User> list
                =hibernateTemplate.find(hql);
        return list;
    }

}
