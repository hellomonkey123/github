package cn.itcast.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.hibernate.domain.User;

public class QueryTest {
	
public static void main(String[] args) {
		
		User user = new User();
		user.setBirthday(new Date());
		user.setName("name");
		
		HibernateUtil.add(user); 
		query(user.getName());
		
	
	}
	
	
	static void query(String name) {
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			String hql = "from User user where user.name=name";
			
			s.createQuery(hql).setFirstResult(200);
			s.createQuery(hql).setMaxResults(10); //ͨ�����Կ��Ʒ�ҳ�����ݿ����еķ�ʽ
			
			List<User> list = s.createQuery(hql).list();
			
			User u = (User) s.createQuery(hql).uniqueResult();//��ѯֻ�ж��е�����
			for(User user:list) {
				System.out.println(user.getName());
			}
		} finally {
			// TODO: handle finally clause
			if (s != null) {
				s.close();
			}
		}
	}
	
	
}
