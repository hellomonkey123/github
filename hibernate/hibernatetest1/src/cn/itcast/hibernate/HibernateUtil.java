package cn.itcast.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import cn.itcast.hibernate.domain.User;

public final class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static Configuration configuration = null;
	private static StandardServiceRegistry serviceRegistry = null;

	private HibernateUtil() {
		
	}
	
	static {
		
//		configuration = new Configuration().configure();
//			SessionFactory sf = configuration.buildSessionFactory();
		
//		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		sessionFactory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
		
	}
	
	public static Session getSession() {
		return  sessionFactory.openSession();
		
		
	}

	public static void  add(Object entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public static void  upd(Object entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public static void  del(Object entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
