package com.xm.web.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
import com.xm.web.entity.User;
 
public class TestAddUser {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
        Session s = sf.openSession();
        s.beginTransaction();
        
        User user = new User();
        user.setId(999999);
        user.setUserid("888888");
        user.setUsername("cb");
        user.setPassword("cb");
        user.setPhone("13099999999");
        user.setSex("0");
        user.setAge(99);
        user.setWeight(99);
        user.setHeight(199);
        // 持久化用户信息
        s.save(user);
        
        // 查询用户信息并打印
        List<User> list = s.createQuery("from User").list();
        for(User u : list){
        	System.out.println(u.getId() + " : " + u.getUserid() + " : " + u.getUsername());
        }
        
        s.getTransaction().commit();
        s.close();
        sf.close();
	}
}
