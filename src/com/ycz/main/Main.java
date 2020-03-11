package com.ycz.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ycz.pojo.Student;
import com.ycz.pojo.Teacher;
import com.ycz.util.MethodsManager;

public class Main {

	// 通用路径
	private static String DIC = "F:/workspace-for-homework/FinalTest/src/com/ycz/files";
	// 管理员账号密码文件路径
	private static String FILENAME_0 = DIC + "/Admin.txt";
	// 老师账号密码文件路径
	private static String FILENAME_2 = DIC + "/Teachers.txt";
	// 班级信息保存路径
	private static String FILENAME_3 = DIC + "/className.txt";
	// 课程信息保存路径
	private static String FILENAME_4 = DIC + "/Course.txt";
	// 存放对象的目录
	private static String FILENAME_5 = DIC + "/老师";
	// 学生账号密码文件路径
	private static String FILENAME_6 = DIC + "/Students.txt";
	// 存放对象的目录
	private static String FILENAME_7 = DIC + "/学生";

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Boolean b0 = false;
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("★     欢迎来到城市学院教学管理系统         ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
		do {
			System.out.println("1、我是管理员");
			System.out.println("2、我是老师");
			System.out.println("3、我是学生");
			System.out.println("4、常用工具");
			System.out.println("------------------------------");
			System.out.println("请选择相应的选项：");
			String res = in.next();
			System.out.println("------------------------------");
			switch (res) {
			case "1":
				// 在输入用户名之前，先从本地将保存用户名和密码的文件读取出来，以便接下来验证
				String res0 = MethodsManager.readMsg(FILENAME_0);
				// 这个map集合只存放一对键值，键为用户名，值为密码
				Map<String, String> map = MethodsManager.getMap(res0);
				boolean b2 = false;
				Label: do {
					System.out.println("请输入用户名：");
					String username = in.next();
					// 先进行用户名验证
					if (map.containsKey(username)) {
						b2 = false;
						Boolean b3 = false;
						do {
							System.out.println("请输入密码：");
							String pwd0 = in.next();
							System.out.println("------------------------------");
							if (pwd0.equals(map.get(username))) {
								b3 = false;
								System.out.println("登录成功！");
								System.out.println("------------------------------");
								Boolean b6 = false;
								do {
									System.out.println("1、查看所有学生");
									System.out.println("2、查看所有老师");
									System.out.println("3、分类查看");
									System.out.println("4、添加班级");
									System.out.println("5、添加课程");
									System.out.println("6、返回上一级");
									System.out.println("7、返回最顶层");
									System.out.println("请进行选择：");
									String res2 = in.next();
									System.out.println(
											"------------------------------------------------------------------------------------------------------");
									switch (res2) {
									case "1":
										File file2 = new File(FILENAME_7);
										if (!file2.exists()) {// 如果文件夹不存在则创建
											file2.mkdirs();
										}
										if (file2.listFiles().length == 0) {// 如果学生暂未注册
											System.out.println("尚未注册，暂无学生信息！");
											Boolean b8 = false;
											do {
												System.out.println("1、返回上级");
												System.out.println("2、返回顶层");
												System.out.println("请选择：");
												String s0 = in.next();
												System.out.println("------------------------------");
												switch (s0) {
												case "1":
													b6 = true;
													break;
												case "2":
													b8 = false;
													b6 = false;
													b0 = true;
													break;
												default:
													System.out.println("请选择有效数字：");
													System.out.println("------------------------------");
													b8 = true;
												}
											} while (b8);
										} else {
											System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t班级   \t专业\t 课程\t   成绩");
											// 调用方法获取所有对象
											Set<Student> set = MethodsManager.getAllObj2(FILENAME_7);
											for (Student s : set) {
												System.out.println(s.toString());
											}
											System.out.println(
													"------------------------------------------------------------------------------------------------------");
											Boolean b7 = false;
											do {
												System.out.println("1、返回上级");
												System.out.println("2、返回顶层");
												System.out.println("请选择：");
												String s0 = in.next();
												System.out.println("------------------------------");
												switch (s0) {
												case "1":
													b7 = false;
													b6 = true;
													break;
												case "2":
													b7 = false;
													b6 = false;
													b0 = true;
													break;
												default:
													System.out.println("请选择有效数字：");
													System.out.println("------------------------------");
													b7 = true;
												}
											} while (b7);
										}
										break;
									case "2":
										File file = new File(FILENAME_5);
										if (!file.exists()) {// 如果文件夹不存在则创建
											file.mkdirs();
										}
										if (file.listFiles().length == 0) {// 如果老师暂未注册
											System.out.println("尚未注册，暂无老师信息！");
											Boolean b8 = false;
											do {
												System.out.println("1、返回上级");
												System.out.println("2、返回顶层");
												System.out.println("请选择：");
												String s0 = in.next();
												System.out.println("------------------------------");
												switch (s0) {
												case "1":
													b6 = true;
													break;
												case "2":
													b8 = false;
													b6 = false;
													b0 = true;
													break;
												default:
													System.out.println("请选择有效数字：");
													System.out.println("------------------------------");
													b8 = true;
												}
											} while (b8);

										} else {
											System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t课程\t班级");
											// 调用方法获取所有对象
											Set<Teacher> set = MethodsManager.getAllObj(FILENAME_5);
											for (Teacher t : set) {
												System.out.println(t.toString());
											}
											System.out.println(
													"----------------------------------------------------------------");
											Boolean b7 = false;
											do {
												System.out.println("1、返回上级");
												System.out.println("2、返回顶层");
												System.out.println("请选择：");
												String s0 = in.next();
												System.out.println("------------------------------");
												switch (s0) {
												case "1":
													b6 = true;
													break;
												case "2":
													b7 = false;
													b6 = false;
													b0 = true;
													break;
												default:
													System.out.println("请选择有效数字：");
													System.out.println("------------------------------");
													b7 = true;
												}
											} while (b7);
										}
										break;
									case "3":
										boolean b42 = false;
										do {
											System.out.println("1、按性别查看");
											System.out.println("2、按班级查看");
											System.out.println("3、查看成绩大于80分的学生");
											System.out.println("4、查看成绩等于80分的学生");
											System.out.println("5、查看成绩小于80分的学生");
											System.out.println("6、查看具体学生的信息");
											System.out.println("7、查看学生的平均成绩");
											System.out.println("8、按成绩降序查看所有学生");
											System.out.println("9、按成绩升序查看所有学生");
											System.out.println("10、查看当前学生和老师的总数");
											System.out.println("11、显示成绩综合信息");
											System.out.println("12、返回上一页");
											System.out.println("13、返回首页");
											System.out.println("请选择：");
											String num = in.next();
											System.out.println("------------------------------");
											switch (num) {
											case "1":
												boolean b50 = false;
												do {
													System.out.println("1、查看男");
													System.out.println("2、查看女");
													System.out.println("3、返回上一级");
													System.out.println("请选择：");
													String cho4 = in.next();
													System.out.println("------------------------------");
													switch (cho4) {
													case "1":
														boolean b51 = false;
														do {
															System.out.println("1、查看男老师");
															System.out.println("2、查看男学生");
															System.out.println("3、返回上一级");
															System.out.println("请选择：");
															String cho5 = in.next();
															System.out.println("------------------------------");
															switch (cho5) {
															case "1":
																System.out.println("所有男老师信息如下：");
																System.out.println(
																		"----------------------------------------------------------------");
																System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t课程\t班级");
																Set<Teacher> set8 = MethodsManager
																		.getAllObj(FILENAME_5);
																for (Teacher t : set8) {
																	if (t.getSex().equals("男")) {
																		System.out.println(t.toString());
																	}
																}
																System.out.println(
																		"----------------------------------------------------------------");
																System.out.println("请输入任意字符返回上一页：");
																int any9 = in.nextInt();
																b51 = true;
																break;
															case "2":
																System.out.println("所有男学生信息如下：");
																System.out.println(
																		"--------------------------------------------------------------------------------");
																System.out.println(
																		"ID\t 姓名\t    密码\t\t性别\t年龄\t班级   \t专业\t 课程\t   成绩");
																Set<Student> set9 = MethodsManager
																		.getAllObj2(FILENAME_7);
																for (Student s : set9) {
																	if (s.getSex().equals("男")) {
																		System.out.println(s.toString());
																	}
																}
																System.out.println(
																		"---------------------------------------------------------------------------------");
																System.out.println("请输入任意字符返回上一页：");
																int any10 = in.nextInt();
																b51 = true;
																break;
															case "3":
																b51 = false;
																b50 = true;
																break;
															default:
																System.out.println("输入无效！请重新输入：");
																b51 = true;
																break;
															}
														} while (b51);
														break;
													case "2":
														boolean b52 = false;
														do {
															System.out.println("1、查看女老师");
															System.out.println("2、查看女学生");
															System.out.println("3、返回上一级");
															System.out.println("请选择：");
															String cho5 = in.next();
															System.out.println("------------------------------");
															switch (cho5) {
															case "1":
																System.out.println("所有女老师信息如下：");
																System.out.println(
																		"----------------------------------------------------------------");
																System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t课程\t班级");
																Set<Teacher> set8 = MethodsManager
																		.getAllObj(FILENAME_5);
																for (Teacher t : set8) {
																	if (t.getSex().equals("女")) {
																		System.out.println(t.toString());
																	}
																}
																System.out.println(
																		"----------------------------------------------------------------");
																System.out.println("请输入任意字符返回上一页：");
																int any9 = in.nextInt();
																b52 = true;
																break;
															case "2":
																System.out.println("所有女学生信息如下：");
																System.out.println(
																		"--------------------------------------------------------------------------------");
																System.out.println(
																		"ID\t 姓名\t    密码\t\t性别\t年龄\t班级   \t专业\t 课程\t   成绩");
																Set<Student> set9 = MethodsManager
																		.getAllObj2(FILENAME_7);
																for (Student s : set9) {
																	if (s.getSex().equals("女")) {
																		System.out.println(s.toString());
																	}
																}
																System.out.println(
																		"---------------------------------------------------------------------------------");
																System.out.println("请输入任意字符返回上一页：");
																int any10 = in.nextInt();
																b52 = true;
																break;
															case "3":
																b52 = false;
																b50 = true;
																break;
															default:
																System.out.println("输入无效！请重新输入：");
																b52 = true;
																break;
															}
														} while (b52);
														break;
													case "3":
														b50 = false;
														b42 = true;
														break;
													default:
														b50 = true;
														System.out.println("输入无效！请重新输入：");
														break;
													}
												} while (b50);
												break;
											case "2":
												boolean b48 = false;
												do {
													System.out.println("1、按班级查看老师");
													System.out.println("2、按班级查看学生");
													System.out.println("3、返回上一页");
													System.out.println("请选择：");
													String cho2 = in.next();
													System.out.println("------------------------------");
													switch (cho2) {
													case "1":
														System.out.println("请输入班级名称：");
														String cName = in.next();
														System.out.println("------------------------------");
														Set<Teacher> set6 = MethodsManager.getAllObj(FILENAME_5);
														if (MethodsManager.readMsg(FILENAME_3).contains(cName)) {
															System.out.println(cName + "所有老师信息如下：");
															System.out.println(
																	"----------------------------------------------------------------");
															System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t课程\t班级");
															for (Teacher t : set6) {
																if (cName.equals(t.getClassName())) {
																	System.out.println(t.toString());
																}
															}
														} else {
															System.out.println("此班级不存在！请查证后重新输入：");
														}
														System.out.println(
																"----------------------------------------------------------------");
														System.out.println("请输入任意信息返回上一页：");
														String any7 = in.next();
														System.out.println("------------------------------");
														b48 = true;
														break;
													case "2":
														System.out.println("请输入班级名称：");
														String cName2 = in.next();
														System.out.println("------------------------------");
														Set<Student> set7 = MethodsManager.getAllObj2(FILENAME_7);
														if (MethodsManager.readMsg(FILENAME_3).contains(cName2)) {
															System.out.println(cName2 + "所有学生信息如下：");
															System.out.println(
																	"--------------------------------------------------------------------------");
															System.out.println(
																	"ID\t 姓名\t    密码\t\t性别\t年龄\t班级   \t专业\t 课程\t   成绩");
															for (Student s : set7) {
																if (cName2.equals(s.getClassName())) {
																	System.out.println(s.toString());
																}
															}
														} else {
															System.out.println("此班级不存在！请查证后重新输入：");
														}
														System.out.println(
																"---------------------------------------------------------------------------");
														System.out.println("请输入任意信息返回上一页：");
														String any8 = in.next();
														System.out.println("------------------------------");
														b48 = true;
														break;
													case "3":
														b48 = false;
														b42 = true;
														break;
													default:
														System.out.println("输入无效！请重新输入：");
														b48 = true;
														break;
													}
												} while (b48);
												break;
											case "3":
												System.out.println("大于80分的学生信息如下：");
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t班级   \t专业\t 课程\t   成绩");
												Set<Student> set6 = MethodsManager.getAllObj2(FILENAME_7);
												for (Student s : set6) {
													if (s.getScore() > 80) {
														System.out.println(s.toString());
													}
												}
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("请输入任意键返回上一页：");
												String any = in.next();
												System.out.println("------------------------------");
												b42 = true;
												break;
											case "4":
												System.out.println("等于80分的学生信息如下：");
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t班级   \t专业\t 课程\t   成绩");
												Set<Student> set5 = MethodsManager.getAllObj2(FILENAME_7);
												for (Student s : set5) {
													if (s.getScore() == 80) {
														System.out.println(s.toString());
													}
												}
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("请输入任意键返回上一页：");
												String any2 = in.next();
												System.out.println("------------------------------");
												b42 = true;
												break;
											case "5":
												System.out.println("小于80分的学生信息如下：");
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t班级   \t专业\t 课程\t   成绩");
												Set<Student> set4 = MethodsManager.getAllObj2(FILENAME_7);
												for (Student s : set4) {
													if (s.getScore() < 80) {
														System.out.println(s.toString());
													}
												}
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("请输入任意键返回上一页：");
												String any4 = in.next();
												System.out.println("------------------------------");
												b42 = true;
												break;
											case "6":
												System.out.println("请输入学生ID：");
												String id = in.next();
												System.out.println("请输入学生姓名：");
												String name = in.next();
												System.out.println("------------------------------");
												System.out.println("该学生具体信息如下：");
												System.out.println(
														"-------------------------------------------------------------------------------");
												if (!MethodsManager.getStuName(FILENAME_7).contains(name)) {
													System.out.println("无此人信息！");
												} else {
													Student stu = (Student) MethodsManager
															.readObj(FILENAME_7 + "/" + name + ".txt");
													if (id.equals(Integer.toString(stu.getId()))
															&& name.equals(stu.getUsername())) {
														System.out.println(stu.toString());
													} else {
														System.out.println("输入有误！请核对后重新输入：");
													}
												}
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("请输入任意键返回上一页：");
												String any3 = in.next();
												System.out.println("------------------------------");
												b42 = true;
												break;
											case "7":
												boolean b46 = false;
												do {
													MethodsManager.seeAvg(MethodsManager.readMsg(FILENAME_4));// 用于展示列表询问用户
													System.out.println("4、返回上一页");
													System.out.println("请选择：");
													String res10 = in.next();
													System.out.println("------------------------------");
													switch (res10) {
													case "1":
														System.out.println("平均成绩为："
																+ MethodsManager.getAvgScore("语文", FILENAME_7));
														System.out.println("------------------------------");
														System.out.println("请输入任意键返回上一页：");
														String res11 = in.next();
														b46 = true;
														System.out.println("------------------------------");
														break;
													case "2":
														System.out.println("平均成绩为："
																+ MethodsManager.getAvgScore("数学", FILENAME_7));
														System.out.println("------------------------------");
														System.out.println("请输入任意键返回上一页：");
														String res12 = in.next();
														b46 = true;
														System.out.println("------------------------------");
														break;
													case "3":
														System.out.println("平均成绩为："
																+ MethodsManager.getAvgScore("外语", FILENAME_7));
														System.out.println("------------------------------");
														System.out.println("请输入任意键返回上一页：");
														String res13 = in.next();
														b46 = true;
														System.out.println("------------------------------");
														break;
													case "4":
														b46 = false;
														b42 = true;
														break;
													default:
														System.out.println("输入无效，请重新输入：");
														b46 = true;
														break;
													}
												} while (b46);
												break;
											case "8":
												System.out.println("所有学生信息如下：");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t班级   \t专业\t 课程\t   成绩");
												Set<Student> set = MethodsManager.getStu2(FILENAME_7);
												for (Student s : set) {
													System.out.println(s.toString());
												}
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												boolean b45 = false;
												do {
													System.out.println("请输入0确认返回上一页：");
													String res9 = in.next();
													System.out.println("------------------------------");
													if (res9.equals("0")) {
														b45 = false;
														b42 = true;
													} else {
														System.out.println("输入无效，请重新输入：");
														b45 = true;
													}
												} while (b45);
												break;
											case "9":
												System.out.println("所有学生信息如下：");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t 姓名\t    密码\t\t性别\t年龄\t班级   \t专业\t 课程\t   成绩");
												Set<Student> set2 = MethodsManager.getStu(FILENAME_7);
												for (Student s : set2) {
													System.out.println(s.toString());
												}
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												boolean b44 = false;
												do {
													System.out.println("请输入0确认返回上一页：");
													String res9 = in.next();
													System.out.println("------------------------------");
													if (res9.equals("0")) {
														b44 = false;
														b42 = true;
													} else {
														System.out.println("输入无效，请重新输入：");
														b44 = true;
													}
												} while (b44);
												break;
											case "10":
												Set<Teacher> tSet = MethodsManager.getAllObj(FILENAME_5);
												Set<Student> sSet = MethodsManager.getStuObj(FILENAME_7);
												System.out.println("当前一共有老师：" + tSet.size() + "人");
												System.out.println("当前一共有学生：" + sSet.size() + "人");
												System.out.println("当前老师和学生总人数为：" + (tSet.size() + sSet.size()) + "人");
												boolean b43 = false;
												do {
													System.out.println("请输入0确认返回上一页：");
													String res9 = in.next();
													System.out.println("------------------------------");
													if (res9.equals("0")) {
														b43 = false;
														b42 = true;
													} else {
														System.out.println("输入无效！请重新输入：");
														b43 = true;
													}
												} while (b43);
												break;
											case "11":
												boolean b53 = false;
												do {
													MethodsManager.seeAvg(MethodsManager.readMsg(FILENAME_4));
													System.out.println("4、返回上一级");
													System.out.println("请选择：");
													String cho6 = in.next();
													System.out.println(
															"------------------------------------------------");
													switch (cho6) {
													case "1":
														System.out.println("语文综合成绩如下：");
														System.out.println("总成绩\t平均成绩\t及格百分比\t   未及格百分比");
														System.out.println(MethodsManager.getSumScore("语文", FILENAME_7)
																+ "  \t  "
																+ MethodsManager.getAvgScore("语文", FILENAME_7) + "\t  "
																+ MethodsManager.getPassPer("语文", FILENAME_7) + "%"
																+ "\t   "
																+ (100 - MethodsManager.getPassPer("语文", FILENAME_7))
																+ "%");
														System.out.println(
																"------------------------------------------------");
														System.out.println("请输入任意字符返回上一页：");
														String any10 = in.next();
														b53 = true;
														System.out.println("------------------------------");
														break;
													case "2":
														System.out.println("数学综合成绩如下：");
														System.out.println("总成绩\t平均成绩\t及格百分比\t   未及格百分比");
														System.out.println(MethodsManager.getSumScore("数学", FILENAME_7)
																+ "  \t  "
																+ MethodsManager.getAvgScore("数学", FILENAME_7) + "\t  "
																+ MethodsManager.getPassPer("数学", FILENAME_7) + "%"
																+ "\t   "
																+ (100 - MethodsManager.getPassPer("数学", FILENAME_7))
																+ "%");
														System.out.println(
																"------------------------------------------------");
														System.out.println("请输入任意字符返回上一页：");
														String any11 = in.next();
														b53 = true;
														System.out.println("------------------------------");
														break;
													case "3":
														System.out.println("英语综合成绩如下：");
														System.out.println("总成绩\t平均成绩\t及格百分比\t   未及格百分比");
														System.out.println(MethodsManager.getSumScore("外语", FILENAME_7)
																+ "  \t  "
																+ MethodsManager.getAvgScore("外语", FILENAME_7) + "\t  "
																+ MethodsManager.getPassPer("外语", FILENAME_7) + "%"
																+ "\t   "
																+ (100 - MethodsManager.getPassPer("外语", FILENAME_7))
																+ "%");
														System.out.println(
																"------------------------------------------------");
														System.out.println("请输入任意字符返回上一页：");
														String any12 = in.next();
														b53 = true;
														System.out.println("------------------------------");
														break;
													case "4":
														b53 = false;
														b42 = true;
														break;
													default:
														System.out.println("输入无效，请重新输入：");
														b53 = true;
														break;
													}
												} while (b53);
												break;
											case "12":
												b42 = false;
												b6 = true;
												break;
											case "13":
												b42 = false;
												b6 = false;
												b0 = true;
												break;
											default:
												break;
											}
										} while (b42);
										break;
									case "4":
										File file3 = new File(FILENAME_3);
										if (!file3.exists()) {// 文件不存在，则创建文件
											try {
												file3.createNewFile();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										System.out.println("请输入班级名称：");
										StringBuilder sb = new StringBuilder("");
										String cName = in.next();
										sb.append(cName).append(",");
										if (file3.length() == 0) {
											MethodsManager.writeMsg(FILENAME_3, sb.toString());
											System.out.println("添加成功！");
											System.out.println("------------------------------");
										} else {
											String str = MethodsManager.readMsg(FILENAME_3);
											if (str.contains(cName)) {
												System.out.println("此班级已存在！");
												System.out.println("------------------------------");
											} else {
												MethodsManager.writeMsg(FILENAME_3, sb.toString());
												System.out.println("添加成功！");
												System.out.println("------------------------------");
											}
										}
										b6 = true;
										break;
									case "5":
										File file4 = new File(FILENAME_4);
										if (!file4.exists()) {// 文件不存在，则创建文件
											try {
												file4.createNewFile();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										System.out.println("请输入课程名称：");
										StringBuilder sb2 = new StringBuilder("");
										String couName = in.next();
										sb2.append(couName).append(",");
										if (file4.length() == 0) {
											MethodsManager.writeMsg(FILENAME_4, sb2.toString());
											System.out.println("添加成功！");
											System.out.println("------------------------------");
										} else {
											String str = MethodsManager.readMsg(FILENAME_4);
											if (str.contains(couName)) {
												System.out.println("此课程已存在！");
												System.out.println("------------------------------");
											} else {
												MethodsManager.writeMsg(FILENAME_4, sb2.toString());
												System.out.println("添加成功！");
												System.out.println("------------------------------");
											}
										}
										b6 = true;
										break;
									case "6":
										b0 = true;
										break Label;
									case "7":
										b0 = true;
										break Label;
									default:
										b6 = true;
										System.out.println("请选择有效数字：");
										break;
									}
								} while (b6);
							} else {
								b3 = true;
								System.out.println("密码错误！请重新输入：");
							}
						} while (b3);
					} else {
						System.out.println("用户名不存在，请重新输入：");
						b2 = true;
					}
				} while (b2);
				break;
			case "2":// 老师选项
				String tecName;
				String tecPwd;
				Boolean b4 = false;
				Label2: do {
					String res2 = MethodsManager.readMsg(FILENAME_2);
					Map<String, String> map2 = MethodsManager.getMap2(res2);
					System.out.println("请输入用户名：");
					String username2 = in.next();
					tecName = username2;
					if (map2.containsKey(username2)) {
						b4 = false;
						if (username2.equals("t1")) {
							StringBuilder sb = new StringBuilder("");
							System.out.println("注册老师账号：");
							System.out.println("------------------------------");
							System.out.println("请设置账号：");
							String tName = in.next();
							System.out.println("请设置密码：");
							String tPass = in.next();
							sb.append(tName).append(":").append(tPass).append(",");
							// 保存用户输入的信息
							MethodsManager.writeMsg(FILENAME_2, sb.toString());
							System.out.println("注册成功！");
							System.out.println("请重新登录！");
							System.out.println("------------------------------");
							b4 = true;
						} else {
							Boolean b5 = false;
							do {
								System.out.println("请输入密码：");
								String pwd2 = in.next();
								tecPwd = pwd2;
								if (pwd2.equals(map2.get(username2))) {
									b5 = false;
									System.out.println("登录成功！");
									System.out.println("------------------------------");
									Boolean b6 = false;
									do {
										System.out.println("1、查看所有学生");
										System.out.println("2、按性别查看学生");
										System.out.println("3、查看成绩大于60分的学生");
										System.out.println("4、查看成绩等于60分的学生");
										System.out.println("5、查看成绩小于60分的学生");
										System.out.println("6、查看具体学生信息");
										System.out.println("7、查看学生平均成绩");
										System.out.println("8、按成绩升序查看所有学生");
										System.out.println("9、按成绩降序查看所有学生");
										System.out.println("10、显示成绩综合信息");
										System.out.println("11、注册老师账号");
										System.out.println("12、修改老师信息");
										System.out.println("13、返回上一级");
										System.out.println("14、返回顶层");
										System.out.println("请进行选择：");
										String res3 = in.next();
										System.out.println("------------------------------");
										boolean b13 = false;
										Label3: do {
											String claName = MethodsManager.getStuClassName(FILENAME_5, tecName);// 获取老师所在班级
											String couName = MethodsManager.getCourse(FILENAME_5, tecName);// 获取老师所教授的课程
											switch (res3) {
											case "1":
												System.out.println("所有学生的信息如下：");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
												Set<Student> set2 = MethodsManager.getStuObj(FILENAME_7);
												for (Student s : set2) {
													if (s.getClassName().equals(claName)
															&& s.getCourse().equals(couName)) {
														System.out.println(s.toString2());
													}
												}
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("请输入任意键返回上一页：");
												String any11 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "2":
												boolean b55 = false;
												do {
													System.out.println("1、查看男");
													System.out.println("2、查看女");
													System.out.println("3、返回上一页");
													System.out.println("请选择：");
													String cho6 = in.next();
													System.out.println("------------------------------");
													switch (cho6) {
													case "1":
														System.out.println("所有男学生信息如下：");
														System.out.println(
																"------------------------------------------------------------------------------------------------------");
														System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
														Set<Student> set3 = MethodsManager.getStuObj(FILENAME_7);
														for (Student s : set3) {
															if (s.getClassName().equals(claName)
																	&& s.getCourse().equals(couName)) {
																if (s.getSex().equals("男")) {
																	System.out.println(s.toString2());
																}
															}
														}
														System.out.println(
																"------------------------------------------------------------------------------------------------------");
														System.out.println("请输入任意键返回上一页：");
														String any12 = in.next();
														System.out.println("------------------------------");
														b6 = true;
														break;
													case "2":
														System.out.println("所有女学生信息如下：");
														System.out.println(
																"------------------------------------------------------------------------------------------------------");
														System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
														Set<Student> set4 = MethodsManager.getStuObj(FILENAME_7);
														for (Student s : set4) {
															if (s.getClassName().equals(claName)
																	&& s.getCourse().equals(couName)) {
																if (s.getSex().equals("女")) {
																	System.out.println(s.toString2());
																}
															}
														}
														System.out.println(
																"------------------------------------------------------------------------------------------------------");
														System.out.println("请输入任意键返回上一页：");
														String any13 = in.next();
														System.out.println("------------------------------");
														b6 = true;
														break;
													case "3":
														b6 = true;
														break Label3;
													default:
														System.out.println("输入无效，请重新输入：");
														System.out.println("------------------------------");
														b55 = true;
														break;
													}
												} while (b55);
												break;
											case "3":
												System.out.println("大于60分的所有学生信息如下：");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
												Set<Student> set4 = MethodsManager.getStuObj(FILENAME_7);
												for (Student s : set4) {
													if (s.getClassName().equals(claName)
															&& s.getCourse().equals(couName)) {
														if (s.getScore() > 60) {
															System.out.println(s.toString2());
														}
													}
												}
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("请输入任意键返回上一页：");
												String any13 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "4":
												System.out.println("等于60分的所有学生信息如下：");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
												Set<Student> set5 = MethodsManager.getStuObj(FILENAME_7);
												for (Student s : set5) {
													if (s.getClassName().equals(claName)
															&& s.getCourse().equals(couName)) {
														if (s.getScore() == 60) {
															System.out.println(s.toString2());
														}
													}
												}
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("请输入任意键返回上一页：");
												String any14 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "5":
												System.out.println("小于60分的所有学生信息如下：");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
												Set<Student> set6 = MethodsManager.getStuObj(FILENAME_7);
												for (Student s : set6) {
													if (s.getClassName().equals(claName)
															&& s.getCourse().equals(couName)) {
														if (s.getScore() < 60) {
															System.out.println(s.toString2());
														}
													}
												}
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("请输入任意键返回上一页：");
												String any15 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "6":
												Set<Student> set7 = MethodsManager.getSureStu(FILENAME_7, FILENAME_5,
														tecName);
												System.out.println("请输入学生ID");
												int sID = in.nextInt();
												System.out.println("请输入学生姓名：");
												String sName = in.next();
												System.out.println("------------------------------");
												System.out.println("该学生信息如下：");
												System.out.println(
														"------------------------------------------------------------");
												System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
												if (!MethodsManager.getStuName(FILENAME_7).contains(sName)) {
													System.out.println("无此人信息！");
												} else {
													Student stu = (Student) MethodsManager
															.readObj(FILENAME_7 + "/" + sName + ".txt");
													if (sID == stu.getId() && sName.equals(stu.getUsername())) {
														if (MethodsManager
																.getSureStuName(FILENAME_7, FILENAME_5, tecName)
																.contains(sName)) {
															System.out.println(stu.toString2());
														} else {
															System.out.println("输入有误！请核对后重新输入：");
														}
													} else {
														System.out.println("输入有误！请核对后重新输入：");
													}
												}
												System.out.println(
														"------------------------------------------------------------");
												System.out.println("请按任意键返回上一页：");
												String any12 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "7":
												System.out.println(claName + couName + "平均成绩为："
														+ MethodsManager.getSureAvg(FILENAME_7, FILENAME_5, tecName));
												System.out.println("------------------------------");
												System.out.println("请按任意键返回上一页：");
												String any16 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "8":
												Set<Student> set = MethodsManager.sortSureScore(FILENAME_7, FILENAME_5,
														tecName);
												System.out.println("所有学生成绩如下：");
												System.out.println("----------------------------------------------");
												System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
												for (Student s : set) {
													System.out.println(s.toString2());
												}
												System.out.println("----------------------------------------------");
												System.out.println("请按任意键返回上一页：");
												String any17 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "9":
												Set<Student> set3 = MethodsManager.sortSureScore2(FILENAME_7,
														FILENAME_5, tecName);
												System.out.println("所有学生成绩如下：");
												System.out.println("----------------------------------------------");
												System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
												for (Student s : set3) {
													System.out.println(s.toString2());
												}
												System.out.println("----------------------------------------------");
												System.out.println("请按任意键返回上一页：");
												String any18 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "10":
												System.out.println(claName + "的综合成绩信息如下：");
												System.out.println("----------------------------------------------");
												String ch = MethodsManager.getZongHe(FILENAME_7, FILENAME_5, tecName,
														"语文");
												String math = MethodsManager.getZongHe(FILENAME_7, FILENAME_5, tecName,
														"数学");
												String eng = MethodsManager.getZongHe(FILENAME_7, FILENAME_5, tecName,
														"外语");
												StringBuilder sb = new StringBuilder("");
												sb.append("课程\t总分\t平均分\t及格率\t不及格率").append("\n").append(ch).append("\n")
														.append(math).append("\n").append(eng);
												System.out.println(sb.toString());
												System.out.println("----------------------------------------------");
												boolean b56 = false;
												do {
													System.out.println("1、导出数据");
													System.out.println("2、返回上一页");
													System.out.println("请选择：");
													String ch10 = in.next();
													System.out.println("------------------------------");
													switch (ch10) {
													case "1":
														String filePath = "F:/workspace-for-homework/FinalTest/src/com/ycz/files/"
																+ claName + "综合成绩信息.txt";
														File file = new File(filePath);
														if (!file.exists()) {
															try {
																file.createNewFile();
															} catch (IOException e) {
																e.printStackTrace();
															}
														}
														// 导出数据
														MethodsManager.writeMsg2(filePath, sb.toString());
														System.out.println("已导出！");
														System.out.println("------------------------------");
														System.out.println("请按任何键返回上一页：");
														String any19 = in.next();
														System.out.println("------------------------------");
														b56 = false;
														b6 = true;
														break;
													case "2":
														b56 = false;
														b6 = true;
														break;
													default:
														System.out.println("输入无效！请重新输入：");
														b56 = true;
														break;
													}
												} while (b56);
												break;
											case "11":
												// 如果存在，则利用其文件个数设置教师ID
												// length方法返回的是long类型，需要转换
												int len = new File(FILENAME_5).listFiles().length;
												Teacher t = new Teacher();
												if (MethodsManager.getIdMax(FILENAME_5) == len)// 考虑到删除学生之后再增加ID值可能重复的情况处理方式
												{
													t.setId(len + 1);
												} else {
													TreeSet<Integer> tSet = MethodsManager.getIdSet(FILENAME_5);
													for (Integer i : tSet) {
														t.setId(i);
														break;
													}
												}
												Boolean b9 = false;
												do {
													System.out.println("请输入姓名：");
													String tName = in.next();
													boolean b11 = MethodsManager.validateRrgis(FILENAME_5, tName);
													if (b11 == false) {
														if (!tName.equals(tecName)) {
															System.out.println("本账号无法注册其他老师，请重新输入：");
															b9 = true;
														} else {
															t.setUsername(tName);
															b9 = false;
														}
													} else {
														System.out.println("此用户已注册，无法重复注册！");
														System.out.println("------------------------------");
														boolean b12 = false;
														do {
															System.out.println("请输入0确认返回上一页：");
															String s2 = in.next();
															System.out.println("------------------------------");
															if (s2.equals("0")) {
																b6 = true;
																break Label3;
															} else {
																System.out.println("输入无效，请输入0！");
																b12 = true;
															}
														} while (b12);
													}
												} while (b9);
												Boolean b10 = false;
												do {
													System.out.println("请输入密码：");
													String tPass = in.next();
													if (!tPass.equals(tecPwd)) {
														b10 = true;
														System.out.println("与登录密码不一致，请重新输入：");
													} else {
														t.setPassword(tPass);
														b10 = false;
													}
												} while (b10);
												System.out.println("请输入性别：");
												String tSex = in.next();
												t.setSex(tSex);
												System.out.println("请输入年龄：");
												int tAge = in.nextInt();
												t.setAge(tAge);
												System.out.println("------------------------------");
												Boolean b7 = false;
												do {
													System.out.println("所有课程如下：");
													MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_4));// 展示课程列表
													System.out.println("请选择添加以上课程：");
													String course = in.next();
													if (MethodsManager.readMsg(FILENAME_4).contains(course)) {
														t.setCourse(course);
														System.out.println("添加成功！");
														System.out.println("------------------------------");
														b7 = false;
													} else {
														System.out.println("课程无效，请重新添加：");
														System.out.println("------------------------------");
														b7 = true;
													}
												} while (b7);
												Boolean b8 = false;
												do {
													System.out.println("所有班级如下：");
													MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_3));// 展示班级列表
													System.out.println("请选择添加以上班级：");
													String cName = in.next();
													if (MethodsManager.readMsg(FILENAME_3).contains(cName)) {
														t.setClassName(cName);
														System.out.println("添加成功！");
														System.out.println("账号注册成功！");
														System.out.println("------------------------------");
														b8 = false;
													} else {
														System.out.println("班级无效，请重新添加：");
														System.out.println("------------------------------");
														b8 = true;
													}
												} while (b8);
												// 开始写入对象到文件
												String fileName3 = FILENAME_5 + "/" + tecName + ".txt";
												File file4 = new File(fileName3);
												if (!file4.exists()) {
													try {
														file4.createNewFile();
													} catch (IOException e) {
														e.printStackTrace();
													}
												}
												MethodsManager.writeObj(fileName3, t);// 保存对象
												b6 = true;
												break;
											case "12":
												b0 = false;
												boolean b14 = false;
												do {
													System.out.println("1、修改性别");
													System.out.println("2、修改年龄");
													System.out.println("3、修改密码");
													System.out.println("4、返回上一级");
													System.out.println("5、返回首页");
													System.out.println("请进行选择：");
													String res5 = in.next();
													System.out.println("------------------------------");
													Teacher tec = (Teacher) MethodsManager
															.readObj(FILENAME_5 + "/" + tecName + ".txt");
													switch (res5) {
													case "1":
														System.out.println("请输入新的性别：");
														String nSex = in.next();
														tec.setId(tec.getId());
														tec.setUsername(tec.getUsername());
														tec.setAge(tec.getAge());
														tec.setClassName(tec.getClassName());
														tec.setCourse(tec.getCourse());
														tec.setPassword(tec.getPassword());
														tec.setSex(nSex);// 修改性别，其他的不变
														// 修改完成后覆盖原文件写进去
														MethodsManager.writeObj2(FILENAME_5 + "/" + tecName + ".txt",
																tec);
														System.out.println("修改成功！");
														boolean b15 = false;
														do {
															System.out.println("请输入0确认返回上页：");
															String res6 = in.next();
															if (res6.equals("0")) {
																b14 = true;
																b15 = false;
															} else {
																System.out.println("输入无效，请重新输入！");
																b15 = true;
															}
														} while (b15);
														break;
													case "2":
														System.out.println("请输入新的年龄：");
														int nAge = in.nextInt();
														tec.setId(tec.getId());
														tec.setUsername(tec.getUsername());
														tec.setAge(nAge);
														tec.setClassName(tec.getClassName());
														tec.setCourse(tec.getCourse());
														tec.setPassword(tec.getPassword());
														tec.setSex(tec.getSex());// 修改年龄，其他的不变
														// 修改完成后覆盖原文件写进去
														MethodsManager.writeObj2(FILENAME_5 + "/" + tecName + ".txt",
																tec);
														System.out.println("修改成功！");
														boolean b16 = false;
														do {
															System.out.println("请输入0确认返回上页：");
															String res6 = in.next();
															if (res6.equals("0")) {
																b14 = true;
																b16 = false;
															} else {
																System.out.println("输入无效，请重新输入！");
																b16 = true;
															}
														} while (b16);
														break;
													case "3":
														boolean b18 = false;
														do {
															System.out.println("请输入原密码：");
															String oPwd = in.next();
															if (!oPwd.equals(tecPwd)) {
																System.out.println("密码错误！请重新输入：");
																b18 = true;
															} else {
																b18 = false;
															}
														} while (b18);
														boolean b19 = false;
														do {
															System.out.println("请输入新的密码：");
															String nPwd = in.next();
															System.out.println("请确认新密码：");
															String nPwd2 = in.next();
															if (!nPwd.equals(nPwd2)) {
																System.out.println("两次密码输入不一致，请重新输入！");
																b19 = true;
															} else {
																b19 = false;
																tec.setPassword(nPwd);
																// 修改存用户密码的文件
																String oMes = MethodsManager.readMsg(FILENAME_2);// 先读出原文件
																// 再替换密码
																MethodsManager.writeMsg2(FILENAME_2,
																		oMes.replace(tecPwd, nPwd));
															}
														} while (b19);
														tec.setId(tec.getId());
														tec.setUsername(tec.getUsername());
														tec.setAge(tec.getAge());
														tec.setClassName(tec.getClassName());
														tec.setCourse(tec.getCourse());
														tec.setSex(tec.getSex());// 修改密码，其他的不变
														// 修改完成后覆盖原文件写进去
														MethodsManager.writeObj2(FILENAME_5 + "/" + tecName + ".txt",
																tec);
														System.out.println("修改成功！");
														boolean b17 = false;
														do {
															System.out.println("请输入0确认返回上页：");
															String res6 = in.next();
															if (res6.equals("0")) {
																b14 = true;
																b17 = false;
															} else {
																System.out.println("输入无效，请重新输入！");
																b17 = true;
															}
														} while (b17);
														break;
													case "4":
														b6 = true;
														b14 = false;
														break;
													case "5":
														b6 = false;
														b14 = false;
														b0 = true;
														break;
													default:
														break;
													}
												} while (b14);
												break;
											case "13":
												b0 = true;
												break Label2;
											case "14":
												b0 = true;
												break Label2;
											default:
												b6 = true;
												System.out.println("请选择有效数字：");
												System.out.println("------------------------------");
												break;
											}
										} while (b13);
									} while (b6);
								} else {
									b5 = true;
									System.out.println("密码错误！请重新输入：");
								}
							} while (b5);
						}
					} else {
						b4 = true;
						System.out.println("用户名不存在，请重新输入或使用t1账号进行注册：");
					}
				} while (b4);
				break;
			case "3":
				// 学生选项
				String stuName;
				String stuPwd;
				Boolean b18 = false;
				Label2: do {
					String res2 = MethodsManager.readMsg(FILENAME_6);
					Map<String, String> map2 = MethodsManager.getMap2(res2);
					System.out.println("请输入用户名：");
					String username2 = in.next();
					stuName = username2;
					if (map2.containsKey(username2)) {
						b18 = false;
						if (username2.equals("s1")) {
							StringBuilder sb = new StringBuilder("");
							System.out.println("注册学生账号：");
							System.out.println("------------------------------");
							System.out.println("请设置账号：");
							String sName = in.next();
							System.out.println("请设置密码：");
							String sPass = in.next();
							sb.append(sName).append(":").append(sPass).append(",");
							// 保存用户输入的信息
							MethodsManager.writeMsg(FILENAME_6, sb.toString());
							System.out.println("注册成功！");
							System.out.println("请重新登录！");
							System.out.println("------------------------------");
							b18 = true;
						} else {
							Boolean b19 = false;
							do {
								System.out.println("请输入密码：");
								String pwd2 = in.next();
								stuPwd = pwd2;
								if (pwd2.equals(map2.get(username2))) {
									b19 = false;
									System.out.println("登录成功！");
									System.out.println("------------------------------");
									boolean b31 = false;
									do {
										System.out.println("1、查看本班所有学生");
										System.out.println("2、按性别查看本班学生");
										System.out.println("3、查找本班学生");
										System.out.println("4、按课程查看");
										System.out.println("5、查看所在班的老师信息");
										System.out.println("6、注册/修改学生账号");
										System.out.println("7、注销账号");
										System.out.println("8、查看本班成绩");
										System.out.println("9、返回上一页");
										System.out.println("10、返回首页");
										System.out.println("请进行选择：");
										String res6 = in.next();
										System.out.println("------------------------------");
										switch (res6) {
										case "1":
											String cName = MethodsManager.getclaName(FILENAME_7, stuName);
											File file = new File(FILENAME_7);
											if (!file.exists()) {
												file.mkdirs();
											}
											boolean b30 = MethodsManager.validateRrgis(FILENAME_7, stuName);
											if (b30 == false) {
												System.out.println("您还未注册，无法查看！");
												boolean b32 = false;
												do {
													System.out.println("输入0返回上一页注册：");
													String res7 = in.next();
													System.out.println("------------------------------");
													if (res7.equals("0")) {
														b31 = true;
														b32 = false;
													} else {
														System.out.println("输入无效！请输入0确认返回上一页：");
														b32 = true;
													}
												} while (b32);
											} else {
												System.out.println(cName + "所有学生信息如下：");
												System.out.println(
														"--------------------------------------------------------------------------------------");
												System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
												Set<Student> set = MethodsManager.getclaStu(FILENAME_7, cName);
												for (Student s : set) {
													System.out.println(s.toString2());
												}
												System.out.println(
														"--------------------------------------------------------------------------------------");
												System.out.println("请按任意键返回上一页：");
												String any = in.next();
												System.out.println("------------------------------");
												b31 = true;
											}
											break;
										case "2":
											boolean b56 = false;
											String cName2 = MethodsManager.getclaName(FILENAME_7, stuName);
											do {
												System.out.println("1、查看男");
												System.out.println("2、查看女");
												System.out.println("3、返回上一页");
												System.out.println("请选择：");
												String cho = in.next();
												System.out.println("------------------------------");
												switch (cho) {
												case "1":
													System.out.println(cName2 + "所有男学生信息如下：");
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
													Set<Student> set = MethodsManager.getclaStu(FILENAME_7, cName2);
													for (Student s : set) {
														if (s.getSex().equals("男")) {
															System.out.println(s.toString2());
														}
													}
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("请按任意键返回上一页：");
													String any2 = in.next();
													System.out.println("------------------------------");
													b31 = true;
													break;
												case "2":
													System.out.println(cName2 + "所有女学生信息如下：");
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
													Set<Student> set2 = MethodsManager.getclaStu(FILENAME_7, cName2);
													for (Student s : set2) {
														if (s.getSex().equals("女")) {
															System.out.println(s.toString2());
														}
													}
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("请按任意键返回上一页：");
													String any3 = in.next();
													System.out.println("------------------------------");
													b31 = true;
													break;
												case "3":
													b56 = false;
													b31 = true;
													break;
												default:
													System.out.println("输入无效，请重新输入！");
													System.out.println("------------------------------");
													b56 = true;
													break;
												}
											} while (b56);
											break;
										case "3":
											String cName3 = MethodsManager.getclaName(FILENAME_7, stuName);
											System.out.println("请输入要查找的学生姓名：");
											String name = in.next();
											System.out.println("------------------------------");
											if (MethodsManager.getsName(FILENAME_7, cName3).contains(name)) {
												Student stu = (Student) MethodsManager
														.readObj(FILENAME_7 + "/" + name + ".txt");
												System.out.println("查找的信息如下：");
												System.out.println(
														"--------------------------------------------------------------------------------------");
												System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
												System.out.println(stu.toString2());
												System.out.println(
														"--------------------------------------------------------------------------------------");
												System.out.println("请按任意键返回上一页：");
												String any2 = in.next();
												System.out.println("------------------------------");
												b31 = true;
											} else {
												System.out.println("本班无此学生！");
												System.out.println("------------------------------");
												b31 = true;
											}
											break;
										case "4":
											String cName4 = MethodsManager.getclaName(FILENAME_7, stuName);
											boolean b57 = false;
											do {
												MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_4));
												System.out.println("按0返回上一页：");
												System.out.println("请选择查看的课程：");
												System.out.println("------------------------------");
												String couName = in.next();
												if (MethodsManager.readMsg(FILENAME_4).contains(couName)) {
													System.out.println("选择" + couName + "的所有学生信息如下：");
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("ID\t姓名\t性别\t班级\t课程\t  成绩");
													Set<Student> set = MethodsManager.getclaStu(FILENAME_7, cName4);
													for (Student s : set) {
														if (s.getCourse().equals(couName)) {
															System.out.println(s.toString2());
														}
													}
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("请按任意键返回上一页：");
													String any = in.next();
													System.out.println("------------------------------");
													b57 = true;
												} else {
													if (couName.equals("0")) {
														b57 = false;
														b31 = true;
													} else {
														System.out.println("无此课程！");
														System.out.println("------------------------------");
														b57 = true;
													}
												}
											} while (b57);
											break;
										case "5":
											String cName5 = MethodsManager.getclaName(FILENAME_7, stuName);
											System.out.println("本班所有老师信息如下：");
											System.out.println("-------------------------------------------------");
											System.out.println("姓名\t性别\t年龄\t所在班级\t所授课程");
											Set<Teacher> set = MethodsManager.getTecObj(FILENAME_5, cName5);
											for (Teacher t : set) {
												System.out.println(t.toString2());
											}
											System.out.println("-------------------------------------------------");
											System.out.println("请按任意键返回上一页：");
											String any2 = in.next();
											System.out.println("------------------------------");
											b31 = true;
											break;
										case "6":
											boolean b33 = false;
											do {
												System.out.println("1、注册学生账号");
												System.out.println("2、修改学生账号");
												System.out.println("3、返回上一级");
												System.out.println("4、返回首页");
												System.out.println("请选择：");
												String res7 = in.next();
												System.out.println("------------------------------");
												switch (res7) {
												case "1":
													b33 = false;
													int len = new File(FILENAME_7).listFiles().length;
													Student stu = new Student();
													if (MethodsManager.getIdMax(FILENAME_7) == len)// 考虑到删除学生之后再增加ID值可能重复的情况处理方式
													{
														stu.setId(len + 1);
													} else {
														TreeSet<Integer> tSet = MethodsManager.getIdSet(FILENAME_7);
														for (Integer i : tSet) {
															stu.setId(i);
															break;
														}
													}
													boolean b34 = false;
													do {
														System.out.println("请输入姓名：");
														String sName = in.next();
														boolean b11 = MethodsManager.validateRrgis(FILENAME_5, sName);
														if (b11 == false) {
															if (!sName.equals(stuName)) {
																System.out.println("本账号无法注册其他学员，请重新输入：");
																b34 = true;
															} else {
																stu.setUsername(stuName);
																b34 = false;
															}
														} else {
															System.out.println("此用户已注册，无法重复注册！");
															System.out.println("------------------------------");
															boolean b35 = false;
															do {
																System.out.println("请输入0确认返回上一页：");
																String s2 = in.next();
																System.out.println("------------------------------");
																if (s2.equals("0")) {
																	b35 = false;
																	b33 = true;
																} else {
																	System.out.println("输入无效，请输入0！");
																	b35 = true;
																}
															} while (b35);
														}
													} while (b34);
													Boolean b36 = false;
													do {
														System.out.println("请输入密码：");
														String sPass = in.next();
														if (!sPass.equals(stuPwd)) {
															b36 = true;
															System.out.println("与登录密码不一致，请重新输入：");
														} else {
															stu.setPassword(sPass);
															b36 = false;
														}
													} while (b36);
													System.out.println("请输入性别：");
													String sSex = in.next();
													stu.setSex(sSex);
													System.out.println("请输入年龄：");
													int sAge = in.nextInt();
													stu.setAge(sAge);
													System.out.println("请输入专业：");
													String major = in.next();
													stu.setMajor(major);
													System.out.println("------------------------------");
													Boolean b37 = false;
													do {
														System.out.println("所有课程如下：");
														MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_4));// 展示课程列表
														System.out.println("请选择添加以上课程：");
														String course = in.next();
														if (MethodsManager.readMsg(FILENAME_4).contains(course)) {
															stu.setCourse(course);
															System.out.println("添加成功！");
															System.out.println("------------------------------");
															b37 = false;
														} else {
															System.out.println("课程无效，请重新添加：");
															System.out.println("------------------------------");
															b37 = true;
														}
													} while (b37);
													boolean b38 = false;
													do {
														System.out.println("请输入该课程考试成绩：");
														int score = in.nextInt();
														if (score < 0 || score > 100) {
															System.out.println("分数无效，请重新输入：");
															b38 = true;
														} else {
															stu.setScore(score);
															b38 = false;
														}
													} while (b38);
													Boolean b39 = false;
													do {
														System.out.println("所有班级如下：");
														MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_3));// 展示班级列表
														System.out.println("请选择添加以上班级：");
														String sName = in.next();
														if (MethodsManager.readMsg(FILENAME_3).contains(sName)) {
															stu.setClassName(sName);
															System.out.println("添加成功！");
															System.out.println("账号注册成功！");
															System.out.println("------------------------------");
															b39 = false;
														} else {
															System.out.println("班级无效，请重新添加：");
															System.out.println("------------------------------");
															b39 = true;
														}
													} while (b39);
													// 开始写入
													String fileName4 = FILENAME_7 + "/" + stuName + ".txt";
													File file4 = new File(fileName4);
													if (!file4.exists()) {
														try {
															file4.createNewFile();
														} catch (IOException e) {
															e.printStackTrace();
														}
													}
													MethodsManager.writeObj(fileName4, stu);// 保存对象
													b31 = true;
													break;
												case "2":
													b33 = false;
													boolean b40 = false;
													do {
														System.out.println("1、修改年龄");
														System.out.println("2、修改性别");
														System.out.println("3、修改班级");
														System.out.println("4、修改课程");
														System.out.println("5、修改密码");
														System.out.println("6、返回上一级");
														System.out.println("7、返回首页");
														System.out.println("请进行选择：");
														String cho = in.next();
														System.out.println("------------------------------");
														Student student = (Student) MethodsManager
																.readObj(FILENAME_7 + "/" + stuName + ".txt");
														switch (cho) {
														case "1":
															System.out.println("请输入新的年龄：");
															int nAge = in.nextInt();
															student.setId(student.getId());
															student.setUsername(student.getUsername());
															student.setPassword(student.getPassword());
															student.setSex(student.getSex());
															student.setAge(nAge);
															student.setClassName(student.getClassName());
															student.setCourse(student.getCourse());
															student.setMajor(student.getMajor());
															student.setScore(student.getScore());// 修改年龄，其他的不变
															// 修改完成后覆盖原文件写进去
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("修改成功！");
															boolean b41 = false;
															do {
																System.out.println("请输入0确认返回上页：");
																System.out.println("------------------------------");
																String res8 = in.next();
																if (res8.equals("0")) {
																	b40 = true;
																	b41 = false;
																} else {
																	System.out.println("输入无效，请重新输入！");
																	b41 = true;
																}
															} while (b41);
															break;
														case "2":
															System.out.println("请输入新的性别：");
															String nSex = in.next();
															student.setId(student.getId());
															student.setUsername(student.getUsername());
															student.setPassword(student.getPassword());
															student.setSex(nSex);
															student.setAge(student.getAge());
															student.setClassName(student.getClassName());
															student.setCourse(student.getCourse());
															student.setMajor(student.getMajor());
															student.setScore(student.getScore());// 修改性别，其他的不变
															// 修改完成后覆盖原文件写进去
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("修改成功！");
															boolean b42 = false;
															do {
																System.out.println("请输入0确认返回上页：");
																System.out.println("------------------------------");
																String res8 = in.next();
																if (res8.equals("0")) {
																	b40 = true;
																	b42 = false;
																} else {
																	System.out.println("输入无效，请重新输入！");
																	b42 = true;
																}
															} while (b42);
															break;
														case "3":
															student.setId(student.getId());
															student.setUsername(student.getUsername());
															student.setPassword(student.getPassword());
															student.setSex(student.getSex());
															student.setAge(student.getAge());
															student.setCourse(student.getCourse());
															student.setMajor(student.getMajor());
															student.setScore(student.getScore());// 修改班级，其他的不变
															Boolean b43 = false;
															do {
																System.out.println("所有班级如下：");
																MethodsManager
																		.getCMsg(MethodsManager.readMsg(FILENAME_3));// 展示班级列表
																System.out.println("请选择添加以上班级：");
																String sName = in.next();
																if (MethodsManager.readMsg(FILENAME_3)
																		.contains(sName)) {
																	student.setClassName(sName);
																	System.out.println("添加成功！");
																	System.out
																			.println("------------------------------");
																	b43 = false;
																} else {
																	System.out.println("班级无效，请重新添加：");
																	System.out
																			.println("------------------------------");
																	b43 = true;
																}
															} while (b43);
															// 修改完成后覆盖原文件写进去
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("修改成功！");
															boolean b44 = false;
															do {
																System.out.println("请输入0确认返回上页：");
																System.out.println("------------------------------");
																String res8 = in.next();
																if (res8.equals("0")) {
																	b40 = true;
																	b44 = false;
																} else {
																	System.out.println("输入无效，请重新输入！");
																	b44 = true;
																}
															} while (b44);
															break;
														case "4":
															student.setId(student.getId());
															student.setUsername(student.getUsername());
															student.setPassword(student.getPassword());
															student.setSex(student.getSex());
															student.setAge(student.getAge());
															student.setClassName(student.getClassName());
															student.setMajor(student.getMajor());
															student.setScore(student.getScore());// 修改课程，其他的不变
															Boolean b45 = false;
															do {
																System.out.println("所有课程如下：");
																MethodsManager
																		.getCMsg(MethodsManager.readMsg(FILENAME_4));// 展示课程列表
																System.out.println("请选择添加以上课程：");
																String course = in.next();
																if (MethodsManager.readMsg(FILENAME_4)
																		.contains(course)) {
																	student.setCourse(course);
																	System.out.println("添加成功！");
																	System.out
																			.println("------------------------------");
																	b45 = false;
																} else {
																	System.out.println("课程无效，请重新添加：");
																	System.out
																			.println("------------------------------");
																	b45 = true;
																}
															} while (b45);
															// 修改完成后覆盖原文件写进去
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("修改成功！");
															boolean b46 = false;
															do {
																System.out.println("请输入0确认返回上页：");
																System.out.println("------------------------------");
																String res8 = in.next();
																if (res8.equals("0")) {
																	b40 = true;
																	b46 = false;
																} else {
																	System.out.println("输入无效，请重新输入！");
																	b46 = true;
																}
															} while (b46);
															break;
														case "5":
															boolean b47 = false;
															do {
																System.out.println("请输入原密码：");
																String oPwd = in.next();
																if (!oPwd.equals(stuPwd)) {
																	System.out.println("密码错误！请重新输入：");
																	b47 = true;
																} else {
																	b47 = false;
																}
															} while (b47);
															boolean b48 = false;
															do {
																System.out.println("请输入新的密码：");
																String nPwd = in.next();
																System.out.println("请确认新密码：");
																String nPwd2 = in.next();
																if (!nPwd.equals(nPwd2)) {
																	System.out.println("两次密码输入不一致，请重新输入！");
																	b48 = true;
																} else {
																	b48 = false;
																	student.setPassword(nPwd);
																	// 修改存用户密码的文件
																	String oMes = MethodsManager.readMsg(FILENAME_6);// 先读出原文件
																	// 再替换密码
																	MethodsManager.writeMsg2(FILENAME_6,
																			oMes.replace(stuPwd, nPwd));
																}
															} while (b48);
															student.setId(student.getId());
															student.setUsername(student.getUsername());
															student.setCourse(student.getCourse());
															student.setSex(student.getSex());
															student.setAge(student.getAge());
															student.setClassName(student.getClassName());
															student.setMajor(student.getMajor());
															student.setScore(student.getScore());// 修改课程，其他的不变
															// 修改完成后覆盖原文件写进去
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("修改成功！");
															boolean b49 = false;
															do {
																System.out.println("请输入0确认返回上页：");
																String res8 = in.next();
																System.out.println("------------------------------");
																if (res8.equals("0")) {
																	b40 = true;
																	b49 = false;
																} else {
																	System.out.println("输入无效，请重新输入！");
																	b49 = true;
																}
															} while (b49);
															break;
														case "6":
															b40 = false;
															b33 = true;
															break;
														case "7":
															b40 = false;
															b33 = false;
															b31 = false;
															b0 = true;
															break;
														default:
															break;
														}
													} while (b40);
													break;
												case "3":
													b31 = true;
													b33 = false;
													break;
												case "4":
													break;
												default:
													b33 = true;
													System.out.println("输入无效，请重新输入：");
													System.out.println("------------------------------");
													break;
												}
											} while (b33);
											break;
										case "7":
											MethodsManager.removeStu(FILENAME_7, stuName);// 删除学生账号
											MethodsManager.removeMes(FILENAME_6, stuName);// 擦除登录信息
											System.out.println("删除成功！");
											System.out.println("------------------------------");
											b31 = false;
											b19 = false;
											b0 = true;
											break;
										case "8":
											String cName8 = MethodsManager.getclaName(FILENAME_7, stuName);
											System.out.println(cName8 + "的成绩信息如下：");
											System.out.println("----------------------------------------------");
											String ch = MethodsManager.getZongHe2(FILENAME_7, cName8, "语文");
											String math = MethodsManager.getZongHe2(FILENAME_7, cName8, "数学");
											String eng = MethodsManager.getZongHe2(FILENAME_7, cName8, "外语");
											StringBuilder sb = new StringBuilder("");
											sb.append("课程\t总分\t平均分\t及格率\t不及格率").append("\n").append(ch).append("\n")
													.append(math).append("\n").append(eng);
											System.out.println(sb.toString());
											System.out.println("----------------------------------------------");
											boolean b58 = false;
											do {
												System.out.println("1、导出数据");
												System.out.println("2、返回上一页");
												System.out.println("请选择：");
												String ch10 = in.next();
												System.out.println("------------------------------");
												switch (ch10) {
												case "1":
													String filePath = "F:/workspace-for-homework/FinalTest/src/com/ycz/files/"
															+ cName8 + "成绩信息.txt";
													File file2 = new File(filePath);
													if (!file2.exists()) {
														try {
															file2.createNewFile();
														} catch (IOException e) {
															e.printStackTrace();
														}
													}
													// 导出数据
													MethodsManager.writeMsg2(filePath, sb.toString());
													System.out.println("已导出！");
													System.out.println("------------------------------");
													System.out.println("请按任何键返回上一页：");
													String any19 = in.next();
													System.out.println("------------------------------");
													b58 = false;
													b31 = true;
													break;
												case "2":
													b58 = false;
													b31 = true;
													break;
												default:
													System.out.println("输入无效！请重新输入：");
													b58 = true;
													break;
												}
											} while (b58);
											break;
										case "9":
											b31 = false;
											b0 = true;
											break;
										case "10":
											b31 = false;
											b0 = true;
											break;
										default:
											System.out.println("输入无效，请重新输入：");
											System.out.println("------------------------------");
											b31 = true;
											break;
										}
									} while (b31);
								} else {
									b19 = true;
									System.out.println("密码错误！请重新输入：");
								}
							} while (b19);
						}
					} else {
						b18 = true;
						System.out.println("用户名不存在，请重新输入或使用s1账号进行注册：");
					}
				} while (b18);
				break;
			case "4":
				boolean b60 = false;
				do {
					System.out.println("1、计算质数");
					System.out.println("2、查看电脑信息");
					System.out.println("3、查看目录");
					System.out.println("4、压缩文件");
					System.out.println("5、播放音乐");
					System.out.println("6、从网上下载一首歌");
					System.out.println("7、读取文件显示到控制台");
					System.out.println("8、常用校验");
					;
					System.out.println("9、返回上一页");
					System.out.println("请选择：");
					String cho = in.next();
					System.out.println("------------------------------");
					switch (cho) {
					case "1":
						System.out.println("请输入任意一个整数：");
						int num = in.nextInt();
						System.out.println("------------------------------");
						List<Integer> lis = MethodsManager.isPrimeNumber(num);
						System.out.println(num + "以内的质数一共有" + lis.size() + "个，具体如下：");
						int j = 0;
						for (int i : lis) {
							System.out.print(i + "\t");
							j++;
							if (j % 10 == 0) {// 10个一行
								System.out.println();
							}
						}
						System.out.println();
						System.out.println("请输入任意内容返回上一页：");
						String any = in.next();
						System.out.println("------------------------------");
						b60 = true;
						break;
					case "2":
						System.out.println("当前电脑磁盘总空间为：465GB");
						System.out.println("当前电脑内存总空间为：4GB");
						System.out.println("当前电脑系统版本为：Windows Server 2012 Standard");
						System.out.println("当前电脑系统盘为：F盘");
						System.out.println("当前电脑总共有4个磁盘，分别为C盘、D盘、E盘、F盘");
						System.out.println("请输入任意内容返回上一页：");
						String any2 = in.next();
						System.out.println("------------------------------");
						b60 = true;
						break;
					case "3":
						boolean b61 = false;
						do {
							System.out.println("请输入C、D、E、F中的任意一个盘符：");
							String name = in.next();
							System.out.println("------------------------------");
							if (name.equals("c") || name.equals("C") || name.equals("d") || name.equals("D")
									|| name.equals("e") || name.equals("E") || name.equals("f") || name.equals("F")) {
								MethodsManager.getDic(name);
								System.out.println("------------------------------");
								System.out.println("请输入任意内容返回上一页：");
								String any3 = in.next();
								System.out.println("------------------------------");
								b61 = false;
								b60 = true;
							} else {
								b61 = true;
								System.out.println("输入无效，请重新输入：");
								System.out.println("------------------------------");
							}
						} while (b61);
						break;
					case "4":
						boolean b62 = false;
						do {
							System.out.println("请输入一个路径：");
							String path = in.next();
							File file = new File(path);
							if (!file.exists()) {
								System.out.println("路径不存在！请重新输入：");
								b62 = true;
							} else {
								if (file.isDirectory()) {
									System.out.println("该路径是一个目录！");
									System.out.println("开始压缩...");
									try {
										MethodsManager.compress(path, path + ".zip");
										System.out.println("按任意键返回上一页：");
										String any21 = in.next();
										System.out.println("------------------------------");
										b62 = false;
										b60 = true;
									} catch (IOException e) {
										e.printStackTrace();
									}
								} else {
									System.out.println("该路径是一个文件！");
									System.out.println("开始压缩...");
									try {
										MethodsManager.compress(path, path.replace(".txt", ".zip"));
										System.out.println("按任意键返回上一页：");
										String any22 = in.next();
										System.out.println("------------------------------");
										b62 = false;
										b60 = true;
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						} while (b62);
						break;
					case "5":
						String dicName = "F:/音乐文件";
						boolean b63 = false;
						int count = 1;
						Thread t1 = null;
						do {
							List<String> lis2 = MethodsManager.getMusic(dicName);
							System.out.println("0、返回上一页");
							boolean b64 = false;
							do {
								System.out.println("请选择序号播放：");
								String cho5 = in.next();
								System.out.println("------------------------------");
								if (!"1-2-3-4-5-6-7-8-9-10".contains(cho5)) {
									System.out.println("选择无效，请重新选择：");
									b64 = true;
								} else {
									b64 = false;
									if (count == 1) {
										t1 = MethodsManager.playMp3(
												dicName + "/" + lis2.get(Integer.parseInt(cho5) - 1),
												lis2.get(Integer.parseInt(cho) - 1));
									} else {
										if (!lis2.get(Integer.parseInt(cho5) - 1).equals(t1.getName())) {
											t1.stop();
											t1 = MethodsManager.playMp3(
													dicName + "/" + lis2.get(Integer.parseInt(cho5) - 1),
													lis2.get(Integer.parseInt(cho) - 1));
										}
									}
								}
							} while (b64);
							count++;
							System.out.println("按任意键返回上一页");
							String any9 = in.next();
							System.out.println("------------------------------");
							b63 = true;
						} while (b63);
						break;
					case "6":
						String filePath = "F:/音乐文件";
						String name = "爱江山更爱美人.mp3";
						System.out.println("请输入下载歌曲的url链接：");
						String url = in.next();
						MethodsManager.downMp3(url, filePath, name);
						System.out.println("是否进行播放？");
						System.out.println("1、是");
						System.out.println("2、否");
						System.out.println("请选择：");
						String choice = in.next();
						System.out.println("------------------------------");
						if (choice.equals("1")) {
							MethodsManager.playMp3(filePath + "/" + name, name);
							b60 = true;
						} else {
							b60 = true;
						}
						break;
					case "7":
						boolean b65 = false;
						do {
							System.out.println("请输入文件路径：");
							String path = in.next();
							System.out.println("------------------------------");
							File file = new File(path);
							if (!file.exists()) {
								System.out.println("路径不存在，请重新输入：");
								b65 = true;
							} else {
								System.out.println("读取完毕，内容如下：");
								System.out.println(MethodsManager.readMsg(path));
								System.out.println("输入任意内容返回上一页：");
								String any13 = in.next();
								System.out.println("------------------------------");
								b65 = false;
								b60 = true;
							}
						} while (b65);
						break;
					case "8":
						boolean b66 = false;
						do {
							System.out.println("1、验证手机号码：");
							System.out.println("2、验证邮箱：");
							System.out.println("3、验证密码强度：");
							System.out.println("4、验证是否为字母：");
							System.out.println("5、验证是否为数字：");
							System.out.println("6、验证是否为中文：");
							System.out.println("7、返回上一页：");
							System.out.println("请选择：");
							String cho13 = in.next();
							System.out.println("------------------------------");
							switch (cho13) {
							case "1":
								String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}";
								boolean b67 = false;
								do {
									System.out.println("请输入11位的手机号码：");
									String phone = in.next();
									System.out.println("------------------------------");
									if (phone.length() != 11) {
										System.out.println("号码长度有误！请输入11位号码：");
										b67 = true;
									} else {
										Pattern p = Pattern.compile(regex);
										Matcher m = p.matcher(phone);
										if (m.matches()) {
											System.out.println("手机号" + phone + "是正确格式！");
										} else {
											System.out.println("手机号" + phone + "是错误格式！");
										}
										System.out.println("按任意键返回上一页：");
										String any14 = in.next();
										System.out.println("------------------------------");
										b67 = false;
										b66 = true;
									}
								} while (b67);
								break;
							case "2":
								String regex2 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)"
										+ "+[a-zA-Z]{2,}$";
								System.out.println("请输入邮箱：");
								String email = in.next();
								Pattern p = Pattern.compile(regex2);
								Matcher m = p.matcher(email);
								if (m.matches()) {
									System.out.println("邮箱地址" + email + "格式正确！");
								} else {
									System.out.println("邮箱地址" + email + "格式错误！");
								}
								System.out.println("按任意键返回上一页：");
								String any15 = in.next();
								System.out.println("------------------------------");
								b66 = true;
								break;
							case "3":
								boolean b68 = false;
								do {
									System.out.println("请输入密码：");
									String pass = in.next();
									System.out.println("------------------------------");
									if (pass.length() < 6) {
										System.out.println("密码长度过短！");
										System.out.println("请重新输入：");
										b68 = true;
									} else if (pass.length() > 16) {
										System.out.println("密码长度过长！");
										System.out.println("请重新输入：");
										b68 = true;
									} else {
										MethodsManager.validatePass(pass);
										System.out.println("按任意键返回上一页：");
										String any16 = in.next();
										System.out.println("------------------------------");
										b68 = false;
										b66 = true;
									}
								} while (b68);
								break;
							case "4":
								System.out.println("请输入一个字符：");
								String sd = in.next();
								char ch = sd.toCharArray()[0];
								if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
									System.out.println(sd + "是字母");
								} else {
									System.out.println(sd + "不是字母");
								}
								System.out.println("按任意键返回上一页：");
								String any17 = in.next();
								System.out.println("------------------------------");
								b66 = true;
								break;
							case "5":
								String regnum = "\\d+";
								System.out.println("请输入一个数字：");
								String s2 = in.next();
								Pattern p3 = Pattern.compile(regnum);
								Matcher m3 = p3.matcher(s2);
								if (m3.matches()) {
									System.out.println(s2 + "是数字");
								} else {
									System.out.println(s2 + "不是数字");
								}
								System.out.println("按任意键返回上一页：");
								String any18 = in.next();
								System.out.println("------------------------------");
								b66 = true;
								break;
							case "6":
								System.out.println("请输入一个字符：");
								String zh = in.next();
								String s = zh.substring(0, 1);
								if (s.matches("[\u4e00-\u9fa5]")) {
									System.out.println(zh + "是中文");
								} else {
									System.out.println(zh + "不是中文");
								}
								System.out.println("按任意键返回上一页：");
								String any19 = in.next();
								System.out.println("-----------------------------");
								b66 = true;
								break;
							case "7":
								b66 = false;
								b60 = true;
								break;
							default:
								System.out.println("输入无效！请重新输入：");
								System.out.println("------------------------------");
								b66 = true;
								break;
							}
						} while (b66);
						break;
					case "9":
						b60 = false;
						b0 = true;
						break;
					default:
						System.out.println("输入无效，请重新输入：");
						b60 = true;
						System.out.println("------------------------------");
						break;
					}
				} while (b60);
				break;
			default:
				System.out.println("选项无效，请输入有效数字：");
				b0 = true;
				break;
			}
		} while (b0);
	}

}
