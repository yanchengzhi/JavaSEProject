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

	// ͨ��·��
	private static String DIC = "F:/workspace-for-homework/FinalTest/src/com/ycz/files";
	// ����Ա�˺������ļ�·��
	private static String FILENAME_0 = DIC + "/Admin.txt";
	// ��ʦ�˺������ļ�·��
	private static String FILENAME_2 = DIC + "/Teachers.txt";
	// �༶��Ϣ����·��
	private static String FILENAME_3 = DIC + "/className.txt";
	// �γ���Ϣ����·��
	private static String FILENAME_4 = DIC + "/Course.txt";
	// ��Ŷ����Ŀ¼
	private static String FILENAME_5 = DIC + "/��ʦ";
	// ѧ���˺������ļ�·��
	private static String FILENAME_6 = DIC + "/Students.txt";
	// ��Ŷ����Ŀ¼
	private static String FILENAME_7 = DIC + "/ѧ��";

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Boolean b0 = false;
		System.out.println("�������������������������");
		System.out.println("��     ��ӭ��������ѧԺ��ѧ����ϵͳ         ��");
		System.out.println("�������������������������");
		do {
			System.out.println("1�����ǹ���Ա");
			System.out.println("2��������ʦ");
			System.out.println("3������ѧ��");
			System.out.println("4�����ù���");
			System.out.println("------------------------------");
			System.out.println("��ѡ����Ӧ��ѡ�");
			String res = in.next();
			System.out.println("------------------------------");
			switch (res) {
			case "1":
				// �������û���֮ǰ���ȴӱ��ؽ������û�����������ļ���ȡ�������Ա��������֤
				String res0 = MethodsManager.readMsg(FILENAME_0);
				// ���map����ֻ���һ�Լ�ֵ����Ϊ�û�����ֵΪ����
				Map<String, String> map = MethodsManager.getMap(res0);
				boolean b2 = false;
				Label: do {
					System.out.println("�������û�����");
					String username = in.next();
					// �Ƚ����û�����֤
					if (map.containsKey(username)) {
						b2 = false;
						Boolean b3 = false;
						do {
							System.out.println("���������룺");
							String pwd0 = in.next();
							System.out.println("------------------------------");
							if (pwd0.equals(map.get(username))) {
								b3 = false;
								System.out.println("��¼�ɹ���");
								System.out.println("------------------------------");
								Boolean b6 = false;
								do {
									System.out.println("1���鿴����ѧ��");
									System.out.println("2���鿴������ʦ");
									System.out.println("3������鿴");
									System.out.println("4����Ӱ༶");
									System.out.println("5����ӿγ�");
									System.out.println("6��������һ��");
									System.out.println("7���������");
									System.out.println("�����ѡ��");
									String res2 = in.next();
									System.out.println(
											"------------------------------------------------------------------------------------------------------");
									switch (res2) {
									case "1":
										File file2 = new File(FILENAME_7);
										if (!file2.exists()) {// ����ļ��в������򴴽�
											file2.mkdirs();
										}
										if (file2.listFiles().length == 0) {// ���ѧ����δע��
											System.out.println("��δע�ᣬ����ѧ����Ϣ��");
											Boolean b8 = false;
											do {
												System.out.println("1�������ϼ�");
												System.out.println("2�����ض���");
												System.out.println("��ѡ��");
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
													System.out.println("��ѡ����Ч���֣�");
													System.out.println("------------------------------");
													b8 = true;
												}
											} while (b8);
										} else {
											System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�༶   \tרҵ\t �γ�\t   �ɼ�");
											// ���÷�����ȡ���ж���
											Set<Student> set = MethodsManager.getAllObj2(FILENAME_7);
											for (Student s : set) {
												System.out.println(s.toString());
											}
											System.out.println(
													"------------------------------------------------------------------------------------------------------");
											Boolean b7 = false;
											do {
												System.out.println("1�������ϼ�");
												System.out.println("2�����ض���");
												System.out.println("��ѡ��");
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
													System.out.println("��ѡ����Ч���֣�");
													System.out.println("------------------------------");
													b7 = true;
												}
											} while (b7);
										}
										break;
									case "2":
										File file = new File(FILENAME_5);
										if (!file.exists()) {// ����ļ��в������򴴽�
											file.mkdirs();
										}
										if (file.listFiles().length == 0) {// �����ʦ��δע��
											System.out.println("��δע�ᣬ������ʦ��Ϣ��");
											Boolean b8 = false;
											do {
												System.out.println("1�������ϼ�");
												System.out.println("2�����ض���");
												System.out.println("��ѡ��");
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
													System.out.println("��ѡ����Ч���֣�");
													System.out.println("------------------------------");
													b8 = true;
												}
											} while (b8);

										} else {
											System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�γ�\t�༶");
											// ���÷�����ȡ���ж���
											Set<Teacher> set = MethodsManager.getAllObj(FILENAME_5);
											for (Teacher t : set) {
												System.out.println(t.toString());
											}
											System.out.println(
													"----------------------------------------------------------------");
											Boolean b7 = false;
											do {
												System.out.println("1�������ϼ�");
												System.out.println("2�����ض���");
												System.out.println("��ѡ��");
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
													System.out.println("��ѡ����Ч���֣�");
													System.out.println("------------------------------");
													b7 = true;
												}
											} while (b7);
										}
										break;
									case "3":
										boolean b42 = false;
										do {
											System.out.println("1�����Ա�鿴");
											System.out.println("2�����༶�鿴");
											System.out.println("3���鿴�ɼ�����80�ֵ�ѧ��");
											System.out.println("4���鿴�ɼ�����80�ֵ�ѧ��");
											System.out.println("5���鿴�ɼ�С��80�ֵ�ѧ��");
											System.out.println("6���鿴����ѧ������Ϣ");
											System.out.println("7���鿴ѧ����ƽ���ɼ�");
											System.out.println("8�����ɼ�����鿴����ѧ��");
											System.out.println("9�����ɼ�����鿴����ѧ��");
											System.out.println("10���鿴��ǰѧ������ʦ������");
											System.out.println("11����ʾ�ɼ��ۺ���Ϣ");
											System.out.println("12��������һҳ");
											System.out.println("13��������ҳ");
											System.out.println("��ѡ��");
											String num = in.next();
											System.out.println("------------------------------");
											switch (num) {
											case "1":
												boolean b50 = false;
												do {
													System.out.println("1���鿴��");
													System.out.println("2���鿴Ů");
													System.out.println("3��������һ��");
													System.out.println("��ѡ��");
													String cho4 = in.next();
													System.out.println("------------------------------");
													switch (cho4) {
													case "1":
														boolean b51 = false;
														do {
															System.out.println("1���鿴����ʦ");
															System.out.println("2���鿴��ѧ��");
															System.out.println("3��������һ��");
															System.out.println("��ѡ��");
															String cho5 = in.next();
															System.out.println("------------------------------");
															switch (cho5) {
															case "1":
																System.out.println("��������ʦ��Ϣ���£�");
																System.out.println(
																		"----------------------------------------------------------------");
																System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�γ�\t�༶");
																Set<Teacher> set8 = MethodsManager
																		.getAllObj(FILENAME_5);
																for (Teacher t : set8) {
																	if (t.getSex().equals("��")) {
																		System.out.println(t.toString());
																	}
																}
																System.out.println(
																		"----------------------------------------------------------------");
																System.out.println("�����������ַ�������һҳ��");
																int any9 = in.nextInt();
																b51 = true;
																break;
															case "2":
																System.out.println("������ѧ����Ϣ���£�");
																System.out.println(
																		"--------------------------------------------------------------------------------");
																System.out.println(
																		"ID\t ����\t    ����\t\t�Ա�\t����\t�༶   \tרҵ\t �γ�\t   �ɼ�");
																Set<Student> set9 = MethodsManager
																		.getAllObj2(FILENAME_7);
																for (Student s : set9) {
																	if (s.getSex().equals("��")) {
																		System.out.println(s.toString());
																	}
																}
																System.out.println(
																		"---------------------------------------------------------------------------------");
																System.out.println("�����������ַ�������һҳ��");
																int any10 = in.nextInt();
																b51 = true;
																break;
															case "3":
																b51 = false;
																b50 = true;
																break;
															default:
																System.out.println("������Ч�����������룺");
																b51 = true;
																break;
															}
														} while (b51);
														break;
													case "2":
														boolean b52 = false;
														do {
															System.out.println("1���鿴Ů��ʦ");
															System.out.println("2���鿴Ůѧ��");
															System.out.println("3��������һ��");
															System.out.println("��ѡ��");
															String cho5 = in.next();
															System.out.println("------------------------------");
															switch (cho5) {
															case "1":
																System.out.println("����Ů��ʦ��Ϣ���£�");
																System.out.println(
																		"----------------------------------------------------------------");
																System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�γ�\t�༶");
																Set<Teacher> set8 = MethodsManager
																		.getAllObj(FILENAME_5);
																for (Teacher t : set8) {
																	if (t.getSex().equals("Ů")) {
																		System.out.println(t.toString());
																	}
																}
																System.out.println(
																		"----------------------------------------------------------------");
																System.out.println("�����������ַ�������һҳ��");
																int any9 = in.nextInt();
																b52 = true;
																break;
															case "2":
																System.out.println("����Ůѧ����Ϣ���£�");
																System.out.println(
																		"--------------------------------------------------------------------------------");
																System.out.println(
																		"ID\t ����\t    ����\t\t�Ա�\t����\t�༶   \tרҵ\t �γ�\t   �ɼ�");
																Set<Student> set9 = MethodsManager
																		.getAllObj2(FILENAME_7);
																for (Student s : set9) {
																	if (s.getSex().equals("Ů")) {
																		System.out.println(s.toString());
																	}
																}
																System.out.println(
																		"---------------------------------------------------------------------------------");
																System.out.println("�����������ַ�������һҳ��");
																int any10 = in.nextInt();
																b52 = true;
																break;
															case "3":
																b52 = false;
																b50 = true;
																break;
															default:
																System.out.println("������Ч�����������룺");
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
														System.out.println("������Ч�����������룺");
														break;
													}
												} while (b50);
												break;
											case "2":
												boolean b48 = false;
												do {
													System.out.println("1�����༶�鿴��ʦ");
													System.out.println("2�����༶�鿴ѧ��");
													System.out.println("3��������һҳ");
													System.out.println("��ѡ��");
													String cho2 = in.next();
													System.out.println("------------------------------");
													switch (cho2) {
													case "1":
														System.out.println("������༶���ƣ�");
														String cName = in.next();
														System.out.println("------------------------------");
														Set<Teacher> set6 = MethodsManager.getAllObj(FILENAME_5);
														if (MethodsManager.readMsg(FILENAME_3).contains(cName)) {
															System.out.println(cName + "������ʦ��Ϣ���£�");
															System.out.println(
																	"----------------------------------------------------------------");
															System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�γ�\t�༶");
															for (Teacher t : set6) {
																if (cName.equals(t.getClassName())) {
																	System.out.println(t.toString());
																}
															}
														} else {
															System.out.println("�˰༶�����ڣ����֤���������룺");
														}
														System.out.println(
																"----------------------------------------------------------------");
														System.out.println("������������Ϣ������һҳ��");
														String any7 = in.next();
														System.out.println("------------------------------");
														b48 = true;
														break;
													case "2":
														System.out.println("������༶���ƣ�");
														String cName2 = in.next();
														System.out.println("------------------------------");
														Set<Student> set7 = MethodsManager.getAllObj2(FILENAME_7);
														if (MethodsManager.readMsg(FILENAME_3).contains(cName2)) {
															System.out.println(cName2 + "����ѧ����Ϣ���£�");
															System.out.println(
																	"--------------------------------------------------------------------------");
															System.out.println(
																	"ID\t ����\t    ����\t\t�Ա�\t����\t�༶   \tרҵ\t �γ�\t   �ɼ�");
															for (Student s : set7) {
																if (cName2.equals(s.getClassName())) {
																	System.out.println(s.toString());
																}
															}
														} else {
															System.out.println("�˰༶�����ڣ����֤���������룺");
														}
														System.out.println(
																"---------------------------------------------------------------------------");
														System.out.println("������������Ϣ������һҳ��");
														String any8 = in.next();
														System.out.println("------------------------------");
														b48 = true;
														break;
													case "3":
														b48 = false;
														b42 = true;
														break;
													default:
														System.out.println("������Ч�����������룺");
														b48 = true;
														break;
													}
												} while (b48);
												break;
											case "3":
												System.out.println("����80�ֵ�ѧ����Ϣ���£�");
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�༶   \tרҵ\t �γ�\t   �ɼ�");
												Set<Student> set6 = MethodsManager.getAllObj2(FILENAME_7);
												for (Student s : set6) {
													if (s.getScore() > 80) {
														System.out.println(s.toString());
													}
												}
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("�����������������һҳ��");
												String any = in.next();
												System.out.println("------------------------------");
												b42 = true;
												break;
											case "4":
												System.out.println("����80�ֵ�ѧ����Ϣ���£�");
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�༶   \tרҵ\t �γ�\t   �ɼ�");
												Set<Student> set5 = MethodsManager.getAllObj2(FILENAME_7);
												for (Student s : set5) {
													if (s.getScore() == 80) {
														System.out.println(s.toString());
													}
												}
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("�����������������һҳ��");
												String any2 = in.next();
												System.out.println("------------------------------");
												b42 = true;
												break;
											case "5":
												System.out.println("С��80�ֵ�ѧ����Ϣ���£�");
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�༶   \tרҵ\t �γ�\t   �ɼ�");
												Set<Student> set4 = MethodsManager.getAllObj2(FILENAME_7);
												for (Student s : set4) {
													if (s.getScore() < 80) {
														System.out.println(s.toString());
													}
												}
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("�����������������һҳ��");
												String any4 = in.next();
												System.out.println("------------------------------");
												b42 = true;
												break;
											case "6":
												System.out.println("������ѧ��ID��");
												String id = in.next();
												System.out.println("������ѧ��������");
												String name = in.next();
												System.out.println("------------------------------");
												System.out.println("��ѧ��������Ϣ���£�");
												System.out.println(
														"-------------------------------------------------------------------------------");
												if (!MethodsManager.getStuName(FILENAME_7).contains(name)) {
													System.out.println("�޴�����Ϣ��");
												} else {
													Student stu = (Student) MethodsManager
															.readObj(FILENAME_7 + "/" + name + ".txt");
													if (id.equals(Integer.toString(stu.getId()))
															&& name.equals(stu.getUsername())) {
														System.out.println(stu.toString());
													} else {
														System.out.println("����������˶Ժ��������룺");
													}
												}
												System.out.println(
														"-------------------------------------------------------------------------------");
												System.out.println("�����������������һҳ��");
												String any3 = in.next();
												System.out.println("------------------------------");
												b42 = true;
												break;
											case "7":
												boolean b46 = false;
												do {
													MethodsManager.seeAvg(MethodsManager.readMsg(FILENAME_4));// ����չʾ�б�ѯ���û�
													System.out.println("4��������һҳ");
													System.out.println("��ѡ��");
													String res10 = in.next();
													System.out.println("------------------------------");
													switch (res10) {
													case "1":
														System.out.println("ƽ���ɼ�Ϊ��"
																+ MethodsManager.getAvgScore("����", FILENAME_7));
														System.out.println("------------------------------");
														System.out.println("�����������������һҳ��");
														String res11 = in.next();
														b46 = true;
														System.out.println("------------------------------");
														break;
													case "2":
														System.out.println("ƽ���ɼ�Ϊ��"
																+ MethodsManager.getAvgScore("��ѧ", FILENAME_7));
														System.out.println("------------------------------");
														System.out.println("�����������������һҳ��");
														String res12 = in.next();
														b46 = true;
														System.out.println("------------------------------");
														break;
													case "3":
														System.out.println("ƽ���ɼ�Ϊ��"
																+ MethodsManager.getAvgScore("����", FILENAME_7));
														System.out.println("------------------------------");
														System.out.println("�����������������һҳ��");
														String res13 = in.next();
														b46 = true;
														System.out.println("------------------------------");
														break;
													case "4":
														b46 = false;
														b42 = true;
														break;
													default:
														System.out.println("������Ч�����������룺");
														b46 = true;
														break;
													}
												} while (b46);
												break;
											case "8":
												System.out.println("����ѧ����Ϣ���£�");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�༶   \tרҵ\t �γ�\t   �ɼ�");
												Set<Student> set = MethodsManager.getStu2(FILENAME_7);
												for (Student s : set) {
													System.out.println(s.toString());
												}
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												boolean b45 = false;
												do {
													System.out.println("������0ȷ�Ϸ�����һҳ��");
													String res9 = in.next();
													System.out.println("------------------------------");
													if (res9.equals("0")) {
														b45 = false;
														b42 = true;
													} else {
														System.out.println("������Ч�����������룺");
														b45 = true;
													}
												} while (b45);
												break;
											case "9":
												System.out.println("����ѧ����Ϣ���£�");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t ����\t    ����\t\t�Ա�\t����\t�༶   \tרҵ\t �γ�\t   �ɼ�");
												Set<Student> set2 = MethodsManager.getStu(FILENAME_7);
												for (Student s : set2) {
													System.out.println(s.toString());
												}
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												boolean b44 = false;
												do {
													System.out.println("������0ȷ�Ϸ�����һҳ��");
													String res9 = in.next();
													System.out.println("------------------------------");
													if (res9.equals("0")) {
														b44 = false;
														b42 = true;
													} else {
														System.out.println("������Ч�����������룺");
														b44 = true;
													}
												} while (b44);
												break;
											case "10":
												Set<Teacher> tSet = MethodsManager.getAllObj(FILENAME_5);
												Set<Student> sSet = MethodsManager.getStuObj(FILENAME_7);
												System.out.println("��ǰһ������ʦ��" + tSet.size() + "��");
												System.out.println("��ǰһ����ѧ����" + sSet.size() + "��");
												System.out.println("��ǰ��ʦ��ѧ��������Ϊ��" + (tSet.size() + sSet.size()) + "��");
												boolean b43 = false;
												do {
													System.out.println("������0ȷ�Ϸ�����һҳ��");
													String res9 = in.next();
													System.out.println("------------------------------");
													if (res9.equals("0")) {
														b43 = false;
														b42 = true;
													} else {
														System.out.println("������Ч�����������룺");
														b43 = true;
													}
												} while (b43);
												break;
											case "11":
												boolean b53 = false;
												do {
													MethodsManager.seeAvg(MethodsManager.readMsg(FILENAME_4));
													System.out.println("4��������һ��");
													System.out.println("��ѡ��");
													String cho6 = in.next();
													System.out.println(
															"------------------------------------------------");
													switch (cho6) {
													case "1":
														System.out.println("�����ۺϳɼ����£�");
														System.out.println("�ܳɼ�\tƽ���ɼ�\t����ٷֱ�\t   δ����ٷֱ�");
														System.out.println(MethodsManager.getSumScore("����", FILENAME_7)
																+ "  \t  "
																+ MethodsManager.getAvgScore("����", FILENAME_7) + "\t  "
																+ MethodsManager.getPassPer("����", FILENAME_7) + "%"
																+ "\t   "
																+ (100 - MethodsManager.getPassPer("����", FILENAME_7))
																+ "%");
														System.out.println(
																"------------------------------------------------");
														System.out.println("�����������ַ�������һҳ��");
														String any10 = in.next();
														b53 = true;
														System.out.println("------------------------------");
														break;
													case "2":
														System.out.println("��ѧ�ۺϳɼ����£�");
														System.out.println("�ܳɼ�\tƽ���ɼ�\t����ٷֱ�\t   δ����ٷֱ�");
														System.out.println(MethodsManager.getSumScore("��ѧ", FILENAME_7)
																+ "  \t  "
																+ MethodsManager.getAvgScore("��ѧ", FILENAME_7) + "\t  "
																+ MethodsManager.getPassPer("��ѧ", FILENAME_7) + "%"
																+ "\t   "
																+ (100 - MethodsManager.getPassPer("��ѧ", FILENAME_7))
																+ "%");
														System.out.println(
																"------------------------------------------------");
														System.out.println("�����������ַ�������һҳ��");
														String any11 = in.next();
														b53 = true;
														System.out.println("------------------------------");
														break;
													case "3":
														System.out.println("Ӣ���ۺϳɼ����£�");
														System.out.println("�ܳɼ�\tƽ���ɼ�\t����ٷֱ�\t   δ����ٷֱ�");
														System.out.println(MethodsManager.getSumScore("����", FILENAME_7)
																+ "  \t  "
																+ MethodsManager.getAvgScore("����", FILENAME_7) + "\t  "
																+ MethodsManager.getPassPer("����", FILENAME_7) + "%"
																+ "\t   "
																+ (100 - MethodsManager.getPassPer("����", FILENAME_7))
																+ "%");
														System.out.println(
																"------------------------------------------------");
														System.out.println("�����������ַ�������һҳ��");
														String any12 = in.next();
														b53 = true;
														System.out.println("------------------------------");
														break;
													case "4":
														b53 = false;
														b42 = true;
														break;
													default:
														System.out.println("������Ч�����������룺");
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
										if (!file3.exists()) {// �ļ������ڣ��򴴽��ļ�
											try {
												file3.createNewFile();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										System.out.println("������༶���ƣ�");
										StringBuilder sb = new StringBuilder("");
										String cName = in.next();
										sb.append(cName).append(",");
										if (file3.length() == 0) {
											MethodsManager.writeMsg(FILENAME_3, sb.toString());
											System.out.println("��ӳɹ���");
											System.out.println("------------------------------");
										} else {
											String str = MethodsManager.readMsg(FILENAME_3);
											if (str.contains(cName)) {
												System.out.println("�˰༶�Ѵ��ڣ�");
												System.out.println("------------------------------");
											} else {
												MethodsManager.writeMsg(FILENAME_3, sb.toString());
												System.out.println("��ӳɹ���");
												System.out.println("------------------------------");
											}
										}
										b6 = true;
										break;
									case "5":
										File file4 = new File(FILENAME_4);
										if (!file4.exists()) {// �ļ������ڣ��򴴽��ļ�
											try {
												file4.createNewFile();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										System.out.println("������γ����ƣ�");
										StringBuilder sb2 = new StringBuilder("");
										String couName = in.next();
										sb2.append(couName).append(",");
										if (file4.length() == 0) {
											MethodsManager.writeMsg(FILENAME_4, sb2.toString());
											System.out.println("��ӳɹ���");
											System.out.println("------------------------------");
										} else {
											String str = MethodsManager.readMsg(FILENAME_4);
											if (str.contains(couName)) {
												System.out.println("�˿γ��Ѵ��ڣ�");
												System.out.println("------------------------------");
											} else {
												MethodsManager.writeMsg(FILENAME_4, sb2.toString());
												System.out.println("��ӳɹ���");
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
										System.out.println("��ѡ����Ч���֣�");
										break;
									}
								} while (b6);
							} else {
								b3 = true;
								System.out.println("����������������룺");
							}
						} while (b3);
					} else {
						System.out.println("�û��������ڣ����������룺");
						b2 = true;
					}
				} while (b2);
				break;
			case "2":// ��ʦѡ��
				String tecName;
				String tecPwd;
				Boolean b4 = false;
				Label2: do {
					String res2 = MethodsManager.readMsg(FILENAME_2);
					Map<String, String> map2 = MethodsManager.getMap2(res2);
					System.out.println("�������û�����");
					String username2 = in.next();
					tecName = username2;
					if (map2.containsKey(username2)) {
						b4 = false;
						if (username2.equals("t1")) {
							StringBuilder sb = new StringBuilder("");
							System.out.println("ע����ʦ�˺ţ�");
							System.out.println("------------------------------");
							System.out.println("�������˺ţ�");
							String tName = in.next();
							System.out.println("���������룺");
							String tPass = in.next();
							sb.append(tName).append(":").append(tPass).append(",");
							// �����û��������Ϣ
							MethodsManager.writeMsg(FILENAME_2, sb.toString());
							System.out.println("ע��ɹ���");
							System.out.println("�����µ�¼��");
							System.out.println("------------------------------");
							b4 = true;
						} else {
							Boolean b5 = false;
							do {
								System.out.println("���������룺");
								String pwd2 = in.next();
								tecPwd = pwd2;
								if (pwd2.equals(map2.get(username2))) {
									b5 = false;
									System.out.println("��¼�ɹ���");
									System.out.println("------------------------------");
									Boolean b6 = false;
									do {
										System.out.println("1���鿴����ѧ��");
										System.out.println("2�����Ա�鿴ѧ��");
										System.out.println("3���鿴�ɼ�����60�ֵ�ѧ��");
										System.out.println("4���鿴�ɼ�����60�ֵ�ѧ��");
										System.out.println("5���鿴�ɼ�С��60�ֵ�ѧ��");
										System.out.println("6���鿴����ѧ����Ϣ");
										System.out.println("7���鿴ѧ��ƽ���ɼ�");
										System.out.println("8�����ɼ�����鿴����ѧ��");
										System.out.println("9�����ɼ�����鿴����ѧ��");
										System.out.println("10����ʾ�ɼ��ۺ���Ϣ");
										System.out.println("11��ע����ʦ�˺�");
										System.out.println("12���޸���ʦ��Ϣ");
										System.out.println("13��������һ��");
										System.out.println("14�����ض���");
										System.out.println("�����ѡ��");
										String res3 = in.next();
										System.out.println("------------------------------");
										boolean b13 = false;
										Label3: do {
											String claName = MethodsManager.getStuClassName(FILENAME_5, tecName);// ��ȡ��ʦ���ڰ༶
											String couName = MethodsManager.getCourse(FILENAME_5, tecName);// ��ȡ��ʦ�����ڵĿγ�
											switch (res3) {
											case "1":
												System.out.println("����ѧ������Ϣ���£�");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
												Set<Student> set2 = MethodsManager.getStuObj(FILENAME_7);
												for (Student s : set2) {
													if (s.getClassName().equals(claName)
															&& s.getCourse().equals(couName)) {
														System.out.println(s.toString2());
													}
												}
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("�����������������һҳ��");
												String any11 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "2":
												boolean b55 = false;
												do {
													System.out.println("1���鿴��");
													System.out.println("2���鿴Ů");
													System.out.println("3��������һҳ");
													System.out.println("��ѡ��");
													String cho6 = in.next();
													System.out.println("------------------------------");
													switch (cho6) {
													case "1":
														System.out.println("������ѧ����Ϣ���£�");
														System.out.println(
																"------------------------------------------------------------------------------------------------------");
														System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
														Set<Student> set3 = MethodsManager.getStuObj(FILENAME_7);
														for (Student s : set3) {
															if (s.getClassName().equals(claName)
																	&& s.getCourse().equals(couName)) {
																if (s.getSex().equals("��")) {
																	System.out.println(s.toString2());
																}
															}
														}
														System.out.println(
																"------------------------------------------------------------------------------------------------------");
														System.out.println("�����������������һҳ��");
														String any12 = in.next();
														System.out.println("------------------------------");
														b6 = true;
														break;
													case "2":
														System.out.println("����Ůѧ����Ϣ���£�");
														System.out.println(
																"------------------------------------------------------------------------------------------------------");
														System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
														Set<Student> set4 = MethodsManager.getStuObj(FILENAME_7);
														for (Student s : set4) {
															if (s.getClassName().equals(claName)
																	&& s.getCourse().equals(couName)) {
																if (s.getSex().equals("Ů")) {
																	System.out.println(s.toString2());
																}
															}
														}
														System.out.println(
																"------------------------------------------------------------------------------------------------------");
														System.out.println("�����������������һҳ��");
														String any13 = in.next();
														System.out.println("------------------------------");
														b6 = true;
														break;
													case "3":
														b6 = true;
														break Label3;
													default:
														System.out.println("������Ч�����������룺");
														System.out.println("------------------------------");
														b55 = true;
														break;
													}
												} while (b55);
												break;
											case "3":
												System.out.println("����60�ֵ�����ѧ����Ϣ���£�");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
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
												System.out.println("�����������������һҳ��");
												String any13 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "4":
												System.out.println("����60�ֵ�����ѧ����Ϣ���£�");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
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
												System.out.println("�����������������һҳ��");
												String any14 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "5":
												System.out.println("С��60�ֵ�����ѧ����Ϣ���£�");
												System.out.println(
														"------------------------------------------------------------------------------------------------------");
												System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
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
												System.out.println("�����������������һҳ��");
												String any15 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "6":
												Set<Student> set7 = MethodsManager.getSureStu(FILENAME_7, FILENAME_5,
														tecName);
												System.out.println("������ѧ��ID");
												int sID = in.nextInt();
												System.out.println("������ѧ��������");
												String sName = in.next();
												System.out.println("------------------------------");
												System.out.println("��ѧ����Ϣ���£�");
												System.out.println(
														"------------------------------------------------------------");
												System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
												if (!MethodsManager.getStuName(FILENAME_7).contains(sName)) {
													System.out.println("�޴�����Ϣ��");
												} else {
													Student stu = (Student) MethodsManager
															.readObj(FILENAME_7 + "/" + sName + ".txt");
													if (sID == stu.getId() && sName.equals(stu.getUsername())) {
														if (MethodsManager
																.getSureStuName(FILENAME_7, FILENAME_5, tecName)
																.contains(sName)) {
															System.out.println(stu.toString2());
														} else {
															System.out.println("����������˶Ժ��������룺");
														}
													} else {
														System.out.println("����������˶Ժ��������룺");
													}
												}
												System.out.println(
														"------------------------------------------------------------");
												System.out.println("�밴�����������һҳ��");
												String any12 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "7":
												System.out.println(claName + couName + "ƽ���ɼ�Ϊ��"
														+ MethodsManager.getSureAvg(FILENAME_7, FILENAME_5, tecName));
												System.out.println("------------------------------");
												System.out.println("�밴�����������һҳ��");
												String any16 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "8":
												Set<Student> set = MethodsManager.sortSureScore(FILENAME_7, FILENAME_5,
														tecName);
												System.out.println("����ѧ���ɼ����£�");
												System.out.println("----------------------------------------------");
												System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
												for (Student s : set) {
													System.out.println(s.toString2());
												}
												System.out.println("----------------------------------------------");
												System.out.println("�밴�����������һҳ��");
												String any17 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "9":
												Set<Student> set3 = MethodsManager.sortSureScore2(FILENAME_7,
														FILENAME_5, tecName);
												System.out.println("����ѧ���ɼ����£�");
												System.out.println("----------------------------------------------");
												System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
												for (Student s : set3) {
													System.out.println(s.toString2());
												}
												System.out.println("----------------------------------------------");
												System.out.println("�밴�����������һҳ��");
												String any18 = in.next();
												System.out.println("------------------------------");
												b6 = true;
												break;
											case "10":
												System.out.println(claName + "���ۺϳɼ���Ϣ���£�");
												System.out.println("----------------------------------------------");
												String ch = MethodsManager.getZongHe(FILENAME_7, FILENAME_5, tecName,
														"����");
												String math = MethodsManager.getZongHe(FILENAME_7, FILENAME_5, tecName,
														"��ѧ");
												String eng = MethodsManager.getZongHe(FILENAME_7, FILENAME_5, tecName,
														"����");
												StringBuilder sb = new StringBuilder("");
												sb.append("�γ�\t�ܷ�\tƽ����\t������\t��������").append("\n").append(ch).append("\n")
														.append(math).append("\n").append(eng);
												System.out.println(sb.toString());
												System.out.println("----------------------------------------------");
												boolean b56 = false;
												do {
													System.out.println("1����������");
													System.out.println("2��������һҳ");
													System.out.println("��ѡ��");
													String ch10 = in.next();
													System.out.println("------------------------------");
													switch (ch10) {
													case "1":
														String filePath = "F:/workspace-for-homework/FinalTest/src/com/ycz/files/"
																+ claName + "�ۺϳɼ���Ϣ.txt";
														File file = new File(filePath);
														if (!file.exists()) {
															try {
																file.createNewFile();
															} catch (IOException e) {
																e.printStackTrace();
															}
														}
														// ��������
														MethodsManager.writeMsg2(filePath, sb.toString());
														System.out.println("�ѵ�����");
														System.out.println("------------------------------");
														System.out.println("�밴�κμ�������һҳ��");
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
														System.out.println("������Ч�����������룺");
														b56 = true;
														break;
													}
												} while (b56);
												break;
											case "11":
												// ������ڣ����������ļ��������ý�ʦID
												// length�������ص���long���ͣ���Ҫת��
												int len = new File(FILENAME_5).listFiles().length;
												Teacher t = new Teacher();
												if (MethodsManager.getIdMax(FILENAME_5) == len)// ���ǵ�ɾ��ѧ��֮��������IDֵ�����ظ����������ʽ
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
													System.out.println("������������");
													String tName = in.next();
													boolean b11 = MethodsManager.validateRrgis(FILENAME_5, tName);
													if (b11 == false) {
														if (!tName.equals(tecName)) {
															System.out.println("���˺��޷�ע��������ʦ�����������룺");
															b9 = true;
														} else {
															t.setUsername(tName);
															b9 = false;
														}
													} else {
														System.out.println("���û���ע�ᣬ�޷��ظ�ע�ᣡ");
														System.out.println("------------------------------");
														boolean b12 = false;
														do {
															System.out.println("������0ȷ�Ϸ�����һҳ��");
															String s2 = in.next();
															System.out.println("------------------------------");
															if (s2.equals("0")) {
																b6 = true;
																break Label3;
															} else {
																System.out.println("������Ч��������0��");
																b12 = true;
															}
														} while (b12);
													}
												} while (b9);
												Boolean b10 = false;
												do {
													System.out.println("���������룺");
													String tPass = in.next();
													if (!tPass.equals(tecPwd)) {
														b10 = true;
														System.out.println("���¼���벻һ�£����������룺");
													} else {
														t.setPassword(tPass);
														b10 = false;
													}
												} while (b10);
												System.out.println("�������Ա�");
												String tSex = in.next();
												t.setSex(tSex);
												System.out.println("���������䣺");
												int tAge = in.nextInt();
												t.setAge(tAge);
												System.out.println("------------------------------");
												Boolean b7 = false;
												do {
													System.out.println("���пγ����£�");
													MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_4));// չʾ�γ��б�
													System.out.println("��ѡ��������Ͽγ̣�");
													String course = in.next();
													if (MethodsManager.readMsg(FILENAME_4).contains(course)) {
														t.setCourse(course);
														System.out.println("��ӳɹ���");
														System.out.println("------------------------------");
														b7 = false;
													} else {
														System.out.println("�γ���Ч����������ӣ�");
														System.out.println("------------------------------");
														b7 = true;
													}
												} while (b7);
												Boolean b8 = false;
												do {
													System.out.println("���а༶���£�");
													MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_3));// չʾ�༶�б�
													System.out.println("��ѡ��������ϰ༶��");
													String cName = in.next();
													if (MethodsManager.readMsg(FILENAME_3).contains(cName)) {
														t.setClassName(cName);
														System.out.println("��ӳɹ���");
														System.out.println("�˺�ע��ɹ���");
														System.out.println("------------------------------");
														b8 = false;
													} else {
														System.out.println("�༶��Ч����������ӣ�");
														System.out.println("------------------------------");
														b8 = true;
													}
												} while (b8);
												// ��ʼд������ļ�
												String fileName3 = FILENAME_5 + "/" + tecName + ".txt";
												File file4 = new File(fileName3);
												if (!file4.exists()) {
													try {
														file4.createNewFile();
													} catch (IOException e) {
														e.printStackTrace();
													}
												}
												MethodsManager.writeObj(fileName3, t);// �������
												b6 = true;
												break;
											case "12":
												b0 = false;
												boolean b14 = false;
												do {
													System.out.println("1���޸��Ա�");
													System.out.println("2���޸�����");
													System.out.println("3���޸�����");
													System.out.println("4��������һ��");
													System.out.println("5��������ҳ");
													System.out.println("�����ѡ��");
													String res5 = in.next();
													System.out.println("------------------------------");
													Teacher tec = (Teacher) MethodsManager
															.readObj(FILENAME_5 + "/" + tecName + ".txt");
													switch (res5) {
													case "1":
														System.out.println("�������µ��Ա�");
														String nSex = in.next();
														tec.setId(tec.getId());
														tec.setUsername(tec.getUsername());
														tec.setAge(tec.getAge());
														tec.setClassName(tec.getClassName());
														tec.setCourse(tec.getCourse());
														tec.setPassword(tec.getPassword());
														tec.setSex(nSex);// �޸��Ա������Ĳ���
														// �޸���ɺ󸲸�ԭ�ļ�д��ȥ
														MethodsManager.writeObj2(FILENAME_5 + "/" + tecName + ".txt",
																tec);
														System.out.println("�޸ĳɹ���");
														boolean b15 = false;
														do {
															System.out.println("������0ȷ�Ϸ�����ҳ��");
															String res6 = in.next();
															if (res6.equals("0")) {
																b14 = true;
																b15 = false;
															} else {
																System.out.println("������Ч�����������룡");
																b15 = true;
															}
														} while (b15);
														break;
													case "2":
														System.out.println("�������µ����䣺");
														int nAge = in.nextInt();
														tec.setId(tec.getId());
														tec.setUsername(tec.getUsername());
														tec.setAge(nAge);
														tec.setClassName(tec.getClassName());
														tec.setCourse(tec.getCourse());
														tec.setPassword(tec.getPassword());
														tec.setSex(tec.getSex());// �޸����䣬�����Ĳ���
														// �޸���ɺ󸲸�ԭ�ļ�д��ȥ
														MethodsManager.writeObj2(FILENAME_5 + "/" + tecName + ".txt",
																tec);
														System.out.println("�޸ĳɹ���");
														boolean b16 = false;
														do {
															System.out.println("������0ȷ�Ϸ�����ҳ��");
															String res6 = in.next();
															if (res6.equals("0")) {
																b14 = true;
																b16 = false;
															} else {
																System.out.println("������Ч�����������룡");
																b16 = true;
															}
														} while (b16);
														break;
													case "3":
														boolean b18 = false;
														do {
															System.out.println("������ԭ���룺");
															String oPwd = in.next();
															if (!oPwd.equals(tecPwd)) {
																System.out.println("����������������룺");
																b18 = true;
															} else {
																b18 = false;
															}
														} while (b18);
														boolean b19 = false;
														do {
															System.out.println("�������µ����룺");
															String nPwd = in.next();
															System.out.println("��ȷ�������룺");
															String nPwd2 = in.next();
															if (!nPwd.equals(nPwd2)) {
																System.out.println("�����������벻һ�£����������룡");
																b19 = true;
															} else {
																b19 = false;
																tec.setPassword(nPwd);
																// �޸Ĵ��û�������ļ�
																String oMes = MethodsManager.readMsg(FILENAME_2);// �ȶ���ԭ�ļ�
																// ���滻����
																MethodsManager.writeMsg2(FILENAME_2,
																		oMes.replace(tecPwd, nPwd));
															}
														} while (b19);
														tec.setId(tec.getId());
														tec.setUsername(tec.getUsername());
														tec.setAge(tec.getAge());
														tec.setClassName(tec.getClassName());
														tec.setCourse(tec.getCourse());
														tec.setSex(tec.getSex());// �޸����룬�����Ĳ���
														// �޸���ɺ󸲸�ԭ�ļ�д��ȥ
														MethodsManager.writeObj2(FILENAME_5 + "/" + tecName + ".txt",
																tec);
														System.out.println("�޸ĳɹ���");
														boolean b17 = false;
														do {
															System.out.println("������0ȷ�Ϸ�����ҳ��");
															String res6 = in.next();
															if (res6.equals("0")) {
																b14 = true;
																b17 = false;
															} else {
																System.out.println("������Ч�����������룡");
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
												System.out.println("��ѡ����Ч���֣�");
												System.out.println("------------------------------");
												break;
											}
										} while (b13);
									} while (b6);
								} else {
									b5 = true;
									System.out.println("����������������룺");
								}
							} while (b5);
						}
					} else {
						b4 = true;
						System.out.println("�û��������ڣ������������ʹ��t1�˺Ž���ע�᣺");
					}
				} while (b4);
				break;
			case "3":
				// ѧ��ѡ��
				String stuName;
				String stuPwd;
				Boolean b18 = false;
				Label2: do {
					String res2 = MethodsManager.readMsg(FILENAME_6);
					Map<String, String> map2 = MethodsManager.getMap2(res2);
					System.out.println("�������û�����");
					String username2 = in.next();
					stuName = username2;
					if (map2.containsKey(username2)) {
						b18 = false;
						if (username2.equals("s1")) {
							StringBuilder sb = new StringBuilder("");
							System.out.println("ע��ѧ���˺ţ�");
							System.out.println("------------------------------");
							System.out.println("�������˺ţ�");
							String sName = in.next();
							System.out.println("���������룺");
							String sPass = in.next();
							sb.append(sName).append(":").append(sPass).append(",");
							// �����û��������Ϣ
							MethodsManager.writeMsg(FILENAME_6, sb.toString());
							System.out.println("ע��ɹ���");
							System.out.println("�����µ�¼��");
							System.out.println("------------------------------");
							b18 = true;
						} else {
							Boolean b19 = false;
							do {
								System.out.println("���������룺");
								String pwd2 = in.next();
								stuPwd = pwd2;
								if (pwd2.equals(map2.get(username2))) {
									b19 = false;
									System.out.println("��¼�ɹ���");
									System.out.println("------------------------------");
									boolean b31 = false;
									do {
										System.out.println("1���鿴��������ѧ��");
										System.out.println("2�����Ա�鿴����ѧ��");
										System.out.println("3�����ұ���ѧ��");
										System.out.println("4�����γ̲鿴");
										System.out.println("5���鿴���ڰ����ʦ��Ϣ");
										System.out.println("6��ע��/�޸�ѧ���˺�");
										System.out.println("7��ע���˺�");
										System.out.println("8���鿴����ɼ�");
										System.out.println("9��������һҳ");
										System.out.println("10��������ҳ");
										System.out.println("�����ѡ��");
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
												System.out.println("����δע�ᣬ�޷��鿴��");
												boolean b32 = false;
												do {
													System.out.println("����0������һҳע�᣺");
													String res7 = in.next();
													System.out.println("------------------------------");
													if (res7.equals("0")) {
														b31 = true;
														b32 = false;
													} else {
														System.out.println("������Ч��������0ȷ�Ϸ�����һҳ��");
														b32 = true;
													}
												} while (b32);
											} else {
												System.out.println(cName + "����ѧ����Ϣ���£�");
												System.out.println(
														"--------------------------------------------------------------------------------------");
												System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
												Set<Student> set = MethodsManager.getclaStu(FILENAME_7, cName);
												for (Student s : set) {
													System.out.println(s.toString2());
												}
												System.out.println(
														"--------------------------------------------------------------------------------------");
												System.out.println("�밴�����������һҳ��");
												String any = in.next();
												System.out.println("------------------------------");
												b31 = true;
											}
											break;
										case "2":
											boolean b56 = false;
											String cName2 = MethodsManager.getclaName(FILENAME_7, stuName);
											do {
												System.out.println("1���鿴��");
												System.out.println("2���鿴Ů");
												System.out.println("3��������һҳ");
												System.out.println("��ѡ��");
												String cho = in.next();
												System.out.println("------------------------------");
												switch (cho) {
												case "1":
													System.out.println(cName2 + "������ѧ����Ϣ���£�");
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
													Set<Student> set = MethodsManager.getclaStu(FILENAME_7, cName2);
													for (Student s : set) {
														if (s.getSex().equals("��")) {
															System.out.println(s.toString2());
														}
													}
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("�밴�����������һҳ��");
													String any2 = in.next();
													System.out.println("------------------------------");
													b31 = true;
													break;
												case "2":
													System.out.println(cName2 + "����Ůѧ����Ϣ���£�");
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
													Set<Student> set2 = MethodsManager.getclaStu(FILENAME_7, cName2);
													for (Student s : set2) {
														if (s.getSex().equals("Ů")) {
															System.out.println(s.toString2());
														}
													}
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("�밴�����������һҳ��");
													String any3 = in.next();
													System.out.println("------------------------------");
													b31 = true;
													break;
												case "3":
													b56 = false;
													b31 = true;
													break;
												default:
													System.out.println("������Ч�����������룡");
													System.out.println("------------------------------");
													b56 = true;
													break;
												}
											} while (b56);
											break;
										case "3":
											String cName3 = MethodsManager.getclaName(FILENAME_7, stuName);
											System.out.println("������Ҫ���ҵ�ѧ��������");
											String name = in.next();
											System.out.println("------------------------------");
											if (MethodsManager.getsName(FILENAME_7, cName3).contains(name)) {
												Student stu = (Student) MethodsManager
														.readObj(FILENAME_7 + "/" + name + ".txt");
												System.out.println("���ҵ���Ϣ���£�");
												System.out.println(
														"--------------------------------------------------------------------------------------");
												System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
												System.out.println(stu.toString2());
												System.out.println(
														"--------------------------------------------------------------------------------------");
												System.out.println("�밴�����������һҳ��");
												String any2 = in.next();
												System.out.println("------------------------------");
												b31 = true;
											} else {
												System.out.println("�����޴�ѧ����");
												System.out.println("------------------------------");
												b31 = true;
											}
											break;
										case "4":
											String cName4 = MethodsManager.getclaName(FILENAME_7, stuName);
											boolean b57 = false;
											do {
												MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_4));
												System.out.println("��0������һҳ��");
												System.out.println("��ѡ��鿴�Ŀγ̣�");
												System.out.println("------------------------------");
												String couName = in.next();
												if (MethodsManager.readMsg(FILENAME_4).contains(couName)) {
													System.out.println("ѡ��" + couName + "������ѧ����Ϣ���£�");
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("ID\t����\t�Ա�\t�༶\t�γ�\t  �ɼ�");
													Set<Student> set = MethodsManager.getclaStu(FILENAME_7, cName4);
													for (Student s : set) {
														if (s.getCourse().equals(couName)) {
															System.out.println(s.toString2());
														}
													}
													System.out.println(
															"--------------------------------------------------------------------------------------");
													System.out.println("�밴�����������һҳ��");
													String any = in.next();
													System.out.println("------------------------------");
													b57 = true;
												} else {
													if (couName.equals("0")) {
														b57 = false;
														b31 = true;
													} else {
														System.out.println("�޴˿γ̣�");
														System.out.println("------------------------------");
														b57 = true;
													}
												}
											} while (b57);
											break;
										case "5":
											String cName5 = MethodsManager.getclaName(FILENAME_7, stuName);
											System.out.println("����������ʦ��Ϣ���£�");
											System.out.println("-------------------------------------------------");
											System.out.println("����\t�Ա�\t����\t���ڰ༶\t���ڿγ�");
											Set<Teacher> set = MethodsManager.getTecObj(FILENAME_5, cName5);
											for (Teacher t : set) {
												System.out.println(t.toString2());
											}
											System.out.println("-------------------------------------------------");
											System.out.println("�밴�����������һҳ��");
											String any2 = in.next();
											System.out.println("------------------------------");
											b31 = true;
											break;
										case "6":
											boolean b33 = false;
											do {
												System.out.println("1��ע��ѧ���˺�");
												System.out.println("2���޸�ѧ���˺�");
												System.out.println("3��������һ��");
												System.out.println("4��������ҳ");
												System.out.println("��ѡ��");
												String res7 = in.next();
												System.out.println("------------------------------");
												switch (res7) {
												case "1":
													b33 = false;
													int len = new File(FILENAME_7).listFiles().length;
													Student stu = new Student();
													if (MethodsManager.getIdMax(FILENAME_7) == len)// ���ǵ�ɾ��ѧ��֮��������IDֵ�����ظ����������ʽ
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
														System.out.println("������������");
														String sName = in.next();
														boolean b11 = MethodsManager.validateRrgis(FILENAME_5, sName);
														if (b11 == false) {
															if (!sName.equals(stuName)) {
																System.out.println("���˺��޷�ע������ѧԱ�����������룺");
																b34 = true;
															} else {
																stu.setUsername(stuName);
																b34 = false;
															}
														} else {
															System.out.println("���û���ע�ᣬ�޷��ظ�ע�ᣡ");
															System.out.println("------------------------------");
															boolean b35 = false;
															do {
																System.out.println("������0ȷ�Ϸ�����һҳ��");
																String s2 = in.next();
																System.out.println("------------------------------");
																if (s2.equals("0")) {
																	b35 = false;
																	b33 = true;
																} else {
																	System.out.println("������Ч��������0��");
																	b35 = true;
																}
															} while (b35);
														}
													} while (b34);
													Boolean b36 = false;
													do {
														System.out.println("���������룺");
														String sPass = in.next();
														if (!sPass.equals(stuPwd)) {
															b36 = true;
															System.out.println("���¼���벻һ�£����������룺");
														} else {
															stu.setPassword(sPass);
															b36 = false;
														}
													} while (b36);
													System.out.println("�������Ա�");
													String sSex = in.next();
													stu.setSex(sSex);
													System.out.println("���������䣺");
													int sAge = in.nextInt();
													stu.setAge(sAge);
													System.out.println("������רҵ��");
													String major = in.next();
													stu.setMajor(major);
													System.out.println("------------------------------");
													Boolean b37 = false;
													do {
														System.out.println("���пγ����£�");
														MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_4));// չʾ�γ��б�
														System.out.println("��ѡ��������Ͽγ̣�");
														String course = in.next();
														if (MethodsManager.readMsg(FILENAME_4).contains(course)) {
															stu.setCourse(course);
															System.out.println("��ӳɹ���");
															System.out.println("------------------------------");
															b37 = false;
														} else {
															System.out.println("�γ���Ч����������ӣ�");
															System.out.println("------------------------------");
															b37 = true;
														}
													} while (b37);
													boolean b38 = false;
													do {
														System.out.println("������ÿγ̿��Գɼ���");
														int score = in.nextInt();
														if (score < 0 || score > 100) {
															System.out.println("������Ч�����������룺");
															b38 = true;
														} else {
															stu.setScore(score);
															b38 = false;
														}
													} while (b38);
													Boolean b39 = false;
													do {
														System.out.println("���а༶���£�");
														MethodsManager.getCMsg(MethodsManager.readMsg(FILENAME_3));// չʾ�༶�б�
														System.out.println("��ѡ��������ϰ༶��");
														String sName = in.next();
														if (MethodsManager.readMsg(FILENAME_3).contains(sName)) {
															stu.setClassName(sName);
															System.out.println("��ӳɹ���");
															System.out.println("�˺�ע��ɹ���");
															System.out.println("------------------------------");
															b39 = false;
														} else {
															System.out.println("�༶��Ч����������ӣ�");
															System.out.println("------------------------------");
															b39 = true;
														}
													} while (b39);
													// ��ʼд��
													String fileName4 = FILENAME_7 + "/" + stuName + ".txt";
													File file4 = new File(fileName4);
													if (!file4.exists()) {
														try {
															file4.createNewFile();
														} catch (IOException e) {
															e.printStackTrace();
														}
													}
													MethodsManager.writeObj(fileName4, stu);// �������
													b31 = true;
													break;
												case "2":
													b33 = false;
													boolean b40 = false;
													do {
														System.out.println("1���޸�����");
														System.out.println("2���޸��Ա�");
														System.out.println("3���޸İ༶");
														System.out.println("4���޸Ŀγ�");
														System.out.println("5���޸�����");
														System.out.println("6��������һ��");
														System.out.println("7��������ҳ");
														System.out.println("�����ѡ��");
														String cho = in.next();
														System.out.println("------------------------------");
														Student student = (Student) MethodsManager
																.readObj(FILENAME_7 + "/" + stuName + ".txt");
														switch (cho) {
														case "1":
															System.out.println("�������µ����䣺");
															int nAge = in.nextInt();
															student.setId(student.getId());
															student.setUsername(student.getUsername());
															student.setPassword(student.getPassword());
															student.setSex(student.getSex());
															student.setAge(nAge);
															student.setClassName(student.getClassName());
															student.setCourse(student.getCourse());
															student.setMajor(student.getMajor());
															student.setScore(student.getScore());// �޸����䣬�����Ĳ���
															// �޸���ɺ󸲸�ԭ�ļ�д��ȥ
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("�޸ĳɹ���");
															boolean b41 = false;
															do {
																System.out.println("������0ȷ�Ϸ�����ҳ��");
																System.out.println("------------------------------");
																String res8 = in.next();
																if (res8.equals("0")) {
																	b40 = true;
																	b41 = false;
																} else {
																	System.out.println("������Ч�����������룡");
																	b41 = true;
																}
															} while (b41);
															break;
														case "2":
															System.out.println("�������µ��Ա�");
															String nSex = in.next();
															student.setId(student.getId());
															student.setUsername(student.getUsername());
															student.setPassword(student.getPassword());
															student.setSex(nSex);
															student.setAge(student.getAge());
															student.setClassName(student.getClassName());
															student.setCourse(student.getCourse());
															student.setMajor(student.getMajor());
															student.setScore(student.getScore());// �޸��Ա������Ĳ���
															// �޸���ɺ󸲸�ԭ�ļ�д��ȥ
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("�޸ĳɹ���");
															boolean b42 = false;
															do {
																System.out.println("������0ȷ�Ϸ�����ҳ��");
																System.out.println("------------------------------");
																String res8 = in.next();
																if (res8.equals("0")) {
																	b40 = true;
																	b42 = false;
																} else {
																	System.out.println("������Ч�����������룡");
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
															student.setScore(student.getScore());// �޸İ༶�������Ĳ���
															Boolean b43 = false;
															do {
																System.out.println("���а༶���£�");
																MethodsManager
																		.getCMsg(MethodsManager.readMsg(FILENAME_3));// չʾ�༶�б�
																System.out.println("��ѡ��������ϰ༶��");
																String sName = in.next();
																if (MethodsManager.readMsg(FILENAME_3)
																		.contains(sName)) {
																	student.setClassName(sName);
																	System.out.println("��ӳɹ���");
																	System.out
																			.println("------------------------------");
																	b43 = false;
																} else {
																	System.out.println("�༶��Ч����������ӣ�");
																	System.out
																			.println("------------------------------");
																	b43 = true;
																}
															} while (b43);
															// �޸���ɺ󸲸�ԭ�ļ�д��ȥ
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("�޸ĳɹ���");
															boolean b44 = false;
															do {
																System.out.println("������0ȷ�Ϸ�����ҳ��");
																System.out.println("------------------------------");
																String res8 = in.next();
																if (res8.equals("0")) {
																	b40 = true;
																	b44 = false;
																} else {
																	System.out.println("������Ч�����������룡");
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
															student.setScore(student.getScore());// �޸Ŀγ̣������Ĳ���
															Boolean b45 = false;
															do {
																System.out.println("���пγ����£�");
																MethodsManager
																		.getCMsg(MethodsManager.readMsg(FILENAME_4));// չʾ�γ��б�
																System.out.println("��ѡ��������Ͽγ̣�");
																String course = in.next();
																if (MethodsManager.readMsg(FILENAME_4)
																		.contains(course)) {
																	student.setCourse(course);
																	System.out.println("��ӳɹ���");
																	System.out
																			.println("------------------------------");
																	b45 = false;
																} else {
																	System.out.println("�γ���Ч����������ӣ�");
																	System.out
																			.println("------------------------------");
																	b45 = true;
																}
															} while (b45);
															// �޸���ɺ󸲸�ԭ�ļ�д��ȥ
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("�޸ĳɹ���");
															boolean b46 = false;
															do {
																System.out.println("������0ȷ�Ϸ�����ҳ��");
																System.out.println("------------------------------");
																String res8 = in.next();
																if (res8.equals("0")) {
																	b40 = true;
																	b46 = false;
																} else {
																	System.out.println("������Ч�����������룡");
																	b46 = true;
																}
															} while (b46);
															break;
														case "5":
															boolean b47 = false;
															do {
																System.out.println("������ԭ���룺");
																String oPwd = in.next();
																if (!oPwd.equals(stuPwd)) {
																	System.out.println("����������������룺");
																	b47 = true;
																} else {
																	b47 = false;
																}
															} while (b47);
															boolean b48 = false;
															do {
																System.out.println("�������µ����룺");
																String nPwd = in.next();
																System.out.println("��ȷ�������룺");
																String nPwd2 = in.next();
																if (!nPwd.equals(nPwd2)) {
																	System.out.println("�����������벻һ�£����������룡");
																	b48 = true;
																} else {
																	b48 = false;
																	student.setPassword(nPwd);
																	// �޸Ĵ��û�������ļ�
																	String oMes = MethodsManager.readMsg(FILENAME_6);// �ȶ���ԭ�ļ�
																	// ���滻����
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
															student.setScore(student.getScore());// �޸Ŀγ̣������Ĳ���
															// �޸���ɺ󸲸�ԭ�ļ�д��ȥ
															MethodsManager.writeObj2(
																	FILENAME_7 + "/" + stuName + ".txt", student);
															System.out.println("�޸ĳɹ���");
															boolean b49 = false;
															do {
																System.out.println("������0ȷ�Ϸ�����ҳ��");
																String res8 = in.next();
																System.out.println("------------------------------");
																if (res8.equals("0")) {
																	b40 = true;
																	b49 = false;
																} else {
																	System.out.println("������Ч�����������룡");
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
													System.out.println("������Ч�����������룺");
													System.out.println("------------------------------");
													break;
												}
											} while (b33);
											break;
										case "7":
											MethodsManager.removeStu(FILENAME_7, stuName);// ɾ��ѧ���˺�
											MethodsManager.removeMes(FILENAME_6, stuName);// ������¼��Ϣ
											System.out.println("ɾ���ɹ���");
											System.out.println("------------------------------");
											b31 = false;
											b19 = false;
											b0 = true;
											break;
										case "8":
											String cName8 = MethodsManager.getclaName(FILENAME_7, stuName);
											System.out.println(cName8 + "�ĳɼ���Ϣ���£�");
											System.out.println("----------------------------------------------");
											String ch = MethodsManager.getZongHe2(FILENAME_7, cName8, "����");
											String math = MethodsManager.getZongHe2(FILENAME_7, cName8, "��ѧ");
											String eng = MethodsManager.getZongHe2(FILENAME_7, cName8, "����");
											StringBuilder sb = new StringBuilder("");
											sb.append("�γ�\t�ܷ�\tƽ����\t������\t��������").append("\n").append(ch).append("\n")
													.append(math).append("\n").append(eng);
											System.out.println(sb.toString());
											System.out.println("----------------------------------------------");
											boolean b58 = false;
											do {
												System.out.println("1����������");
												System.out.println("2��������һҳ");
												System.out.println("��ѡ��");
												String ch10 = in.next();
												System.out.println("------------------------------");
												switch (ch10) {
												case "1":
													String filePath = "F:/workspace-for-homework/FinalTest/src/com/ycz/files/"
															+ cName8 + "�ɼ���Ϣ.txt";
													File file2 = new File(filePath);
													if (!file2.exists()) {
														try {
															file2.createNewFile();
														} catch (IOException e) {
															e.printStackTrace();
														}
													}
													// ��������
													MethodsManager.writeMsg2(filePath, sb.toString());
													System.out.println("�ѵ�����");
													System.out.println("------------------------------");
													System.out.println("�밴�κμ�������һҳ��");
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
													System.out.println("������Ч�����������룺");
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
											System.out.println("������Ч�����������룺");
											System.out.println("------------------------------");
											b31 = true;
											break;
										}
									} while (b31);
								} else {
									b19 = true;
									System.out.println("����������������룺");
								}
							} while (b19);
						}
					} else {
						b18 = true;
						System.out.println("�û��������ڣ������������ʹ��s1�˺Ž���ע�᣺");
					}
				} while (b18);
				break;
			case "4":
				boolean b60 = false;
				do {
					System.out.println("1����������");
					System.out.println("2���鿴������Ϣ");
					System.out.println("3���鿴Ŀ¼");
					System.out.println("4��ѹ���ļ�");
					System.out.println("5����������");
					System.out.println("6������������һ�׸�");
					System.out.println("7����ȡ�ļ���ʾ������̨");
					System.out.println("8������У��");;
					System.out.println("9��������һҳ");
					System.out.println("��ѡ��");
					String cho = in.next();
					System.out.println("------------------------------");
					switch (cho) {
					case "1":
						System.out.println("����������һ��������");
						int num = in.nextInt();
						System.out.println("------------------------------");
						List<Integer> lis = MethodsManager.isPrimeNumber(num);
						System.out.println(num + "���ڵ�����һ����" + lis.size() + "�����������£�");
						int j = 0;
						for (int i : lis) {
							System.out.print(i + "\t");
							j++;
							if (j % 10 == 0) {// 10��һ��
								System.out.println();
							}
						}
						System.out.println();
						System.out.println("�������������ݷ�����һҳ��");
						String any = in.next();
						System.out.println("------------------------------");
						b60 = true;
						break;
					case "2":
						System.out.println("��ǰ���Դ����ܿռ�Ϊ��465GB");
						System.out.println("��ǰ�����ڴ��ܿռ�Ϊ��4GB");
						System.out.println("��ǰ����ϵͳ�汾Ϊ��Windows Server 2012 Standard");
						System.out.println("��ǰ����ϵͳ��Ϊ��F��");
						System.out.println("��ǰ�����ܹ���4�����̣��ֱ�ΪC�̡�D�̡�E�̡�F��");
						System.out.println("�������������ݷ�����һҳ��");
						String any2 = in.next();
						System.out.println("------------------------------");
						b60 = true;
						break;
					case "3":
						boolean b61 = false;
						do {
							System.out.println("������C��D��E��F�е�����һ���̷���");
							String name = in.next();
							System.out.println("------------------------------");
							if (name.equals("c") || name.equals("C") || name.equals("d") || name.equals("D")
									|| name.equals("e") || name.equals("E") || name.equals("f") || name.equals("F")) {
								MethodsManager.getDic(name);
								System.out.println("------------------------------");
								System.out.println("�������������ݷ�����һҳ��");
								String any3 = in.next();
								System.out.println("------------------------------");
								b61 = false;
								b60 = true;
							} else {
								b61 = true;
								System.out.println("������Ч�����������룺");
								System.out.println("------------------------------");
							}
						} while (b61);
						break;
					case "4":
						boolean b62 = false;
						do {
							System.out.println("������һ��·����");
							String path = in.next();
							File file = new File(path);
							if (!file.exists()) {
								System.out.println("·�������ڣ����������룺");
								b62 = true;
							} else {
								if (file.isDirectory()) {
									System.out.println("��·����һ��Ŀ¼��");
									System.out.println("��ʼѹ��...");
									try {
										MethodsManager.compress(path, path + ".zip");
										System.out.println("�������������һҳ��");
										String any21 = in.next();
										System.out.println("------------------------------");
										b62 = false;
										b60 = true;
									} catch (IOException e) {
										e.printStackTrace();
									}
								} else {
									System.out.println("��·����һ���ļ���");
									System.out.println("��ʼѹ��...");
									try {
										MethodsManager.compress(path, path.replace(".txt", ".zip"));
										System.out.println("�������������һҳ��");
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
						String dicName = "F:/�����ļ�";
						boolean b63 = false;
						int count = 1;
						Thread t1 = null;
						do {
							List<String> lis2 = MethodsManager.getMusic(dicName);
							System.out.println("0��������һҳ");
							boolean b64 = false;
							do {
								System.out.println("��ѡ����Ų��ţ�");
								String cho5 = in.next();
								System.out.println("------------------------------");
								if (!"1-2-3-4-5-6-7-8-9-10".contains(cho5)) {
									System.out.println("ѡ����Ч��������ѡ��");
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
							System.out.println("�������������һҳ");
							String any9 = in.next();
							System.out.println("------------------------------");
							b63 = true;
						} while (b63);
						break;
					case "6":
						String filePath = "F:/�����ļ�";
						String name = "����ɽ��������.mp3";
						System.out.println("���������ظ�����url���ӣ�");
						String url = in.next();
						MethodsManager.downMp3(url, filePath, name);
						System.out.println("�Ƿ���в��ţ�");
						System.out.println("1����");
						System.out.println("2����");
						System.out.println("��ѡ��");
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
							System.out.println("�������ļ�·����");
							String path = in.next();
							System.out.println("------------------------------");
							File file = new File(path);
							if (!file.exists()) {
								System.out.println("·�������ڣ����������룺");
								b65 = true;
							} else {
								System.out.println("��ȡ��ϣ��������£�");
								System.out.println(MethodsManager.readMsg(path));
								System.out.println("�����������ݷ�����һҳ��");
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
							System.out.println("1����֤�ֻ����룺");
							System.out.println("2����֤���䣺");
							System.out.println("3����֤����ǿ�ȣ�");
							System.out.println("4����֤�Ƿ�Ϊ��ĸ��");
							System.out.println("5����֤�Ƿ�Ϊ���֣�");
							System.out.println("6����֤�Ƿ�Ϊ���ģ�");
							System.out.println("7��������һҳ��");
							System.out.println("��ѡ��");
							String cho13 = in.next();
							System.out.println("------------------------------");
							switch (cho13) {
							case "1":
								String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}";
								boolean b67 = false;
								do {
									System.out.println("������11λ���ֻ����룺");
									String phone = in.next();
									System.out.println("------------------------------");
									if (phone.length() != 11) {
										System.out.println("���볤������������11λ���룺");
										b67 = true;
									} else {
										Pattern p = Pattern.compile(regex);
										Matcher m = p.matcher(phone);
										if (m.matches()) {
											System.out.println("�ֻ���" + phone + "����ȷ��ʽ��");
										} else {
											System.out.println("�ֻ���" + phone + "�Ǵ����ʽ��");
										}
										System.out.println("�������������һҳ��");
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
								System.out.println("���������䣺");
								String email = in.next();
								Pattern p = Pattern.compile(regex2);
								Matcher m = p.matcher(email);
								if (m.matches()) {
									System.out.println("�����ַ" + email + "��ʽ��ȷ��");
								} else {
									System.out.println("�����ַ" + email + "��ʽ����");
								}
								System.out.println("�������������һҳ��");
								String any15 = in.next();
								System.out.println("------------------------------");
								b66 = true;
								break;
							case "3":
								boolean b68 = false;
								do {
									System.out.println("���������룺");
									String pass = in.next();
									System.out.println("------------------------------");
									if (pass.length() < 6) {
										System.out.println("���볤�ȹ��̣�");
										System.out.println("���������룺");
										b68 = true;
									} else if (pass.length() > 16) {
										System.out.println("���볤�ȹ�����");
										System.out.println("���������룺");
										b68 = true;
									} else {
										MethodsManager.validatePass(pass);
										System.out.println("�������������һҳ��");
										String any16 = in.next();
										System.out.println("------------------------------");
										b68 = false;
										b66 = true;
									}
								} while (b68);
								break;
							case "4":
								System.out.println("������һ���ַ���");
								String sd = in.next();
								char ch = sd.toCharArray()[0];
								if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
									System.out.println(sd + "����ĸ");
								} else {
									System.out.println(sd + "������ĸ");
								}
								System.out.println("�������������һҳ��");
								String any17 = in.next();
								System.out.println("------------------------------");
								b66 = true;
								break;
							case "5":
								String regnum = "\\d+";
								System.out.println("������һ�����֣�");
								String s2 = in.next();
								Pattern p3 = Pattern.compile(regnum);
								Matcher m3 = p3.matcher(s2);
								if (m3.matches()) {
									System.out.println(s2 + "������");
								} else {
									System.out.println(s2 + "��������");
								}
								System.out.println("�������������һҳ��");
								String any18 = in.next();
								System.out.println("------------------------------");
								b66 = true;
								break;
							case "6":
								System.out.println("������һ���ַ���");
								String zh = in.next();
								String s = zh.substring(0, 1);
								if (s.matches("[\u4e00-\u9fa5]")) {
									System.out.println(zh + "������");
								} else {
									System.out.println(zh + "��������");
								}
								System.out.println("�������������һҳ��");
								String any19 = in.next();
								System.out.println("------------------------------");
								b66 = true;
								break;
							case "7":
								b66 = false;
								b60 = true;
								break;
							default:
								System.out.println("������Ч�����������룺");
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
						System.out.println("������Ч�����������룺");
						b60 = true;
						System.out.println("------------------------------");
						break;
					}
				} while (b60);
				break;
			default:
				System.out.println("ѡ����Ч����������Ч���֣�");
				b0 = true;
				break;
			}
		} while (b0);
	}

}
