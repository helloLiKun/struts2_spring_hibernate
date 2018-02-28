package com.ssh.cn.dao.impl;

import com.ssh.cn.dao.UserDao;
import com.ssh.cn.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
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
        List list=hibernateTemplate.findByNamedParam(hql, "idNum", idNum);
        return (User) list.get(0);

    }

    public List<User> findAll() {
        String hql="from User";
        List<User> list
                =hibernateTemplate.find(hql);
        return list;
    }

    @Override
    public List<User> findByPage(final String val,final int pageSize,final int pageNum) {
        return hibernateTemplate.executeFind(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = "from User where name=:val";
                Query query = session.createQuery(hql);
                /*
                 * 设置分页参数，注意在内层函数中调用外层函数的参数，
                 * 要求外层函数的参数必须是final的，因此需要将
                 * page、pageSize设置为final。
                 * */
                query.setFirstResult((pageNum-1)*pageSize);
                query.setMaxResults(pageSize);
                //设置查询限制参数值
                query.setParameter("val",val);
                return query.list();
            }
        });
    }

}
