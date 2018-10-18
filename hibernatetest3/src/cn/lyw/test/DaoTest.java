package cn.lyw.test;

import java.util.Date;

import cn.lyw.dao.UserDao;
import cn.lyw.dao.impl.UserDaoHibernateImpl;
import cn.lyw.domain.User;

public class DaoTest {

	public static void main(String[] args) {

		UserDao dao = new UserDaoHibernateImpl();
		User user = new User();
		user.setName("name");
		user.setBirthday(new Date());
		System.out.println("-----------------");
		dao.saveUser(user);
		
		user.setName("new name");
		System.out.println("-----------------");
		dao.updateUser(user);
		
		User u = dao.findUserByName(user.getName());
		
		System.out.println("------------------");
		dao.remove(u);
	}

}
