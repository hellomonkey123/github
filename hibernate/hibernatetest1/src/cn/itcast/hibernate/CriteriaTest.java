package cn.itcast.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import cn.itcast.hibernate.domain.User;

public class CriteriaTest {

public static void main(String[] args) {
		
		cri("name");

	}
	
	
	static void cri(String name) {
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(User.class);
			c.add(Restrictions.eq(name, "name"));
			c.add(Restrictions.le("birthday",new Date()));
			
			List<User> list = c.list();
			User u = (User) c.uniqueResult();
			System.out.println(u);
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
