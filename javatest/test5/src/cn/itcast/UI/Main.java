package cn.itcast.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;
import cn.itcast.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {

		try {
			System.out.println("���ѧ����a��     ɾ��ѧ����b��     ����ѧ����c��");
			System.out.println("������������ͣ� ");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String type = br.readLine();

			if ("a".equals(type)) {

				System.out.println("������ѧ�������� ");
				String name = br.readLine();

				System.out.println("������ѧ��׼��֤�ţ� ");
				String examid = br.readLine();

				System.out.println("������ѧ�����֤�� ");
				String idcard = br.readLine();

				System.out.println("������ѧ����ַ�� ");
				String location = br.readLine();

				System.out.println("������ѧ�������� ");
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

				System.out.println("������ѧ�������� ");
				String name = br.readLine();

				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
				} catch (StudentNotExistException e) {
					System.out.println("the data your wanting to delete do not exist!");
				}
				System.out.println("delete successfully");

			} else if ("c".equals(type)) {

				System.out.println("������ѧ�����ţ� ");
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
