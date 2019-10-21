package com.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import xueshengxinxixitong.Course;
import xueshengxinxixitong.Student;

public class StudentMain {

	/**
	 * 
	 * @param args
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public void studentTest() {
		System.out.println("---------学生管理系统--------");
		System.out.println("1.查看所有学生信息");
		System.out.println("2.删除学生");
		System.out.println("3.修改学生");
		System.out.println("4.根据学号查找信息");
		System.out.println("请输入序号选择相应的功能：");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		SelectComm scm = new SelectComm();
		UpdateComm upm = new UpdateComm();

		try {
			switch (a) {
			// 1.查看所有学生信息
			case 1:
				String sql = "selcet sno,sname,gender,id,birth,college from student";
				Object obj = 6;
				List<Course> list1 = com.util.SelectComm.getFrList(
						Course.class, sql, obj);
				for (Object e : list1) {
					System.out.println(e);
				}

				// 2.删除学生
			case 2:
				System.out.println("请输入要删除的学号：");
				String b = sc.nextLine();
				String dsql = "DELETE FROM student WHERE sno=" + b;
				Object[] bobj = { dsql, 1 };
				com.util.UpdateComm.update(dsql, bobj);

				// 3.修改学生
			case 3:
				System.out.println("请输入要修改的学号：");
				String c1 = sc.nextLine();
				System.out.println("请输入要修改的姓名");
				String c2 = sc.nextLine();
				String csql = "UPDATE student SET sname=" + c1 + " WHERE sno="
						+ c2;
				Object[] cobj = { csql, 1 };
				com.util.UpdateComm.update(csql, cobj);

				// 4.根据学号查找信息
			case 4:
				System.out.println("请输入要查询的课程号：");
				String d = sc.nextLine();
				Class clazz1 = Student.class;
				String ssql = "selcet sno,sname,gender,id,birth,college  from course where id="
						+ d;
				Object sobj = 6;
				List list2 = com.util.SelectComm.getFrList(clazz1, ssql, sobj);
				for (Object e : list2) {
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentMain sm = new StudentMain();
		sm.studentTest();
	}

}
