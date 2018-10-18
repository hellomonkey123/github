package cn.lyw.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.lyw.dao.HibernateUtil;
import cn.lyw.dao.UserDao;
import cn.lyw.domain.User;

public class UserDaoHibernateImpl implements UserDao {

	@Override
	public void saveUser(User user) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.save(user);
			tx.commit();
		} finally {
			if(s != null)
				s.close();
		}

	}

	@Override
	public User findUserByName(String name) {
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(User.class); //还可以用hql查询方式
			c.add(Restrictions.eq("name", name));
			User user = (User) c.uniqueResult();
			return user;
		} finally {
			if(s != null)
				s.close();
		}
	}

	@Override
	public User findUserById(int id) {

		Session s = null;
		try {
			s = HibernateUtil.getSession();
			User user = s.get(User.class, id);
			return user;
		} finally {
			if(s != null)
				s.close();
		}
		
	}

	@Override
	public void updateUser(User user) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.update(user);
			tx.commit();
		} finally {
			if(s != null)
				s.close();
		}

	}

	@Override
	public void remove(User user) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
		} finally {
			if(s != null)
				s.close();
		}

	}

	

}
