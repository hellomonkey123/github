package cn.itcast.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.hibernate.domain.Department;
import cn.itcast.hibernate.domain.Employee;
import cn.itcast.hibernate.domain.IdCard;
import cn.itcast.hibernate.domain.Person;
import cn.itcast.hibernate.domain.Teacher;

public class Many2Many {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add();
	}
	

	static void add() {
		Session s = null;
		Transaction tx = null;
		
		try {
			
			Teacher t1 = new Teacher();
			idCard.setName("idcard");
			
			Person p = new Person();
			p.setName("person");
			p.setIdCard(idCard);
			
			idCard.setPerson(p);
			
			s = HibernateUtil.getSession();
			tx=s.beginTransaction();	
			s.save(p);
			s.save(idCard);//������ں��棬�����β���Ա���������department�����һ��������Ա�����и���
			tx.commit();
			return p;
		}finally {
			if (s != null) {
				s.close();
			}
		}
	}

}
