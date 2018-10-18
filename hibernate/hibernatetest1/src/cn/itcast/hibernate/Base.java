package cn.itcast.hibernate;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;



import cn.itcast.hibernate.domain.User;

public class Base {
	
	public static void main(String[] args) {
		
		User user = new User();
		user.setBirthday(new Date());
		user.setName("name");
		
		addUser(user); //�����й�״̬��session�Ѿ��ر���
		System.out.println("id:"+user.getId());
		
		
		User u = getUser(user.getId());
		System.out.println("name"+u.getName());
		
	
	}
	
	static User  getUser(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Class userClass = User.class;
			User user = (User) session.get(userClass, id);
			//User user = (User) session.load(userClass, id);  //load������Ϊ��
			
			return user;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	static void  addUser(User user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(user);
			
			user.setName("new name");
//			session.persist(user); //�������ݣ��������ⲻ����insert��䣬�õıȽ���
			transaction.commit();
		} catch (HibernateException e) {
			
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	static void  addUser1(User user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
}
