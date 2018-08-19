package cn.itcast.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;
import cn.itcast.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {

		try {
			System.out.println("添加学生（a）     删除学生（b）     查找学生（c）");
			System.out.println("请输入操作类型： ");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String type = br.readLine();

			if ("a".equals(type)) {

				System.out.println("请输入学生姓名： ");
				String name = br.readLine();

				System.out.println("请输入学生准考证号： ");
				String examid = br.readLine();

				System.out.println("请输入学生身份证： ");
				String idcard = br.readLine();

				System.out.println("请输入学生地址： ");
				String location = br.readLine();

				System.out.println("请输入学生分数： ");
				String grade = br.readLine();

				Student s = new Student();
				s.setName(name);
				s.setExamid(examid);
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setGrade(Double.parseDouble(grade));

				StudentDao dao = new StudentDao();
				dao.add(s);

				System.out.println("add successfully");

			} else if ("b".equals(type)) {

				System.out.println("请输入学生姓名： ");
				String name = br.readLine();

				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
				} catch (StudentNotExistException e) {
					System.out.println("the data your wanting to delete do not exist!");
				}
				System.out.println("delete successfully");

			} else if ("c".equals(type)) {

				System.out.println("请输入学生考号： ");
				String examid = br.readLine();

				Student s = new Student();
				

				StudentDao dao = new StudentDao();
				dao.find(examid);

				System.out.println("find successfully");
//				System.out.println(s.getTextContent());
			} else {
				System.out.println("out of your operation");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sorry, something wrong with here");
		}
	}

}
