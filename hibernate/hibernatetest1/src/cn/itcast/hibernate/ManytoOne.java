package cn.itcast.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.hibernate.domain.Department;
import cn.itcast.hibernate.domain.Employee;
import cn.itcast.hibernate.domain.User;

public class ManytoOne {
	
	public static void main(String[] args) {
		Department depart = add();
		Employee emp = query(1);
		
		System.out.println("depart name"+emp.getDepart().getName());
	}
	
	static Employee query(int empId) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateUtil.getSession();
			tx=s.beginTransaction();
			Employee emp = s.get(Employee.class, empId);
//			System.out.println("depart name"+emp.getDepart().getName());
			Hibernate.initialize(emp.getDepart());//��������Ǿ���������������Ҫ�������
			
			tx.commit();
			return emp;
		}finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	static Department add() {
		Session s = null;
		Transaction tx = null;
		
		try {
			Department depart = new Department();
			depart.setName("depart");
			
			Employee emp = new Employee();
			emp.setDepart(depart);  //������������Ĺ���
			emp.setName("emp name");
			s = HibernateUtil.getSession();
			tx=s.beginTransaction();
			s.save(emp);
			s.save(depart);
			tx.commit();
			return depart;
		}finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
