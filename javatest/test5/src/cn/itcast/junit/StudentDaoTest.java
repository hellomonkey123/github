package cn.itcast.junit;

import org.junit.Test;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;
import cn.itcast.exception.StudentNotExistException;

public class StudentDaoTest {

	@Test
	public void testAdd() {
		StudentDao dao = new StudentDao();
		Student s= new Student();
		s.setExamid("121");
		s.setGrade(89.00);
		s.setIdcard("134");
		s.setLocation("shenzhen");
		s.setName("xiaoqiang");
		dao.add(s);
	}
	
	@Test
	public void testFind() {
		StudentDao dao = new StudentDao();
		dao.find("222");    //can not find two object with same ID
	}
	@Test
	public void testDelete() throws StudentNotExistException {
		StudentDao dao = new StudentDao();
		dao.delete("ÕÅÈý");
	}
}
