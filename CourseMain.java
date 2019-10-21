package com.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import xueshengxinxixitong.Course;

public class CourseMain {

	/**
	 * 
	 * @param args
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public void courseTest() {
		System.out.println("---------课程管理系统--------");
		System.out.println("1.查看所有课程信息");
		System.out.println("2.删除课程");
		System.out.println("3.修改课程");
		System.out.println("4.根据课程号查找信息");
		System.out.println("请输入序号选择相应的功能：");

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		HashSet hs = new HashSet();
		for (int i = 1; i < 5; i++) {
			hs.add(i);
		}
		if (!hs.contains(a)) {
			System.out.println("输入错误，请按照提示重新输入！");
		}
		SelectComm scm = new SelectComm();
		UpdateComm upm = new UpdateComm();

		try {
			switch (a) {
			// 1.查看所有课程信息
			case 1:
				String sql = "selcet cno,cname,type,credit,hours,tname from course";
				Object obj = 6;
				List<Course> list1 = com.util.SelectComm.getFrList(
						Course.class, sql, obj);
				for (Object e : list1) {
					System.out.println(e);
				}
				// 2.删除课程
			case 2:
				System.out.println("请输入要删除的课程号：");
				String b = sc.nextLine();
				String dsql = "DELETE FROM course WHERE cno=" + b;
				Object[] bobj = { dsql, 1 };
				com.util.UpdateComm.update(dsql, bobj);
				// 3.修改课程.
			case 3:
				System.out.println("请输入要修改的课程号：");
				String c1 = sc.nextLine();
				System.out.println("请输入要修改的课程名");
				String c2 = sc.nextLine();
				String csql = "UPDATE course SET cname=" + c1 + " WHERE cno="
						+ c2;
				Object[] cobj = { csql, 1 };
				com.util.UpdateComm.update(csql, cobj);

				// 4.根据课程号查找信息
			case 4:
				System.out.println("请输入要查询的课程号：");
				String d = sc.nextLine();
				Class clazz1 = Course.class;
				String ssql = "selcet cno,cname,type,credit,hours,tname from course where id="
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
		CourseMain cm = new CourseMain();
		cm.courseTest();

	}

}
