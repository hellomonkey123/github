package cn.itcast.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.hibernate.domain.Department;
import cn.itcast.hibernate.domain.Employee;

public class One2Many {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Department depart = add();
		queryDepart(depart.getId());
		
		System.out.println("depart name"+depart.getId());
	}
	
	static Department queryDepart(int departId) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateUtil.getSession();
			tx=s.beginTransaction();
			Department depart = s.get(Department.class, departId);
//			System.out.println("depart name"+emp.getDepart().getName());
			Hibernate.initialize(depart.getEmps());//��������Ǿ���������������Ҫ�������
			
			tx.commit();
			return depart;
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
			
			Employee emp1 = new Employee();
			emp1.setDepart(depart);  //������������Ĺ���
			emp1.setName("emp1 name");
			
			Employee emp2 = new Employee();
			emp2.setDepart(depart);  //������������Ĺ���
			emp2.setName("emp2 name");
			
			s = HibernateUtil.getSession();
			tx=s.beginTransaction();
//			s.save(depart);//���save depart����ǰ������Ȳ���departmentȻ�����β�������Ա��
			s.save(emp1);
			s.save(emp2);
			s.save(depart);//������ں��棬�����β���Ա���������department�����һ��������Ա�����и���
			tx.commit();
			return depart;
		}finally {
			if (s != null) {
				s.close();
			}
		}
	}
}

