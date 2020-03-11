package com.ycz.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.ycz.pojo.Student;
import com.ycz.pojo.Teacher;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * 此类用来封装一些方法
 * 
 * @author Administrator
 *
 */
public final class MethodsManager {

	// 定义一个方法，用于读取文件内容
	public static String readMsg(String filePath) {
		StringBuilder sb = new StringBuilder("");
		File file = new File(filePath);// 实例化文件对象
		try {
			InputStream in = new FileInputStream(file);// 基于文件对象建立输入流
			byte[] bys = new byte[102400];// 暂存的容器
			int len = in.read(bys);// 读取文件
			sb.append(new String(bys, 0, len));
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	// 定义一个方法，将字符串进行分割，并且存放在map里
	// 这个方法只用来处理管理员,一次分割
	public static Map<String, String> getMap(String str) {
		String[] strs = str.split(":");
		Map<String, String> map = new HashMap<String, String>();
		map.put(strs[0], strs[1]);
		return map;
	}

	// 定义一个方法，分割字符串，存放在map里
	// 二次分割，用来处理老师和学生
	public static Map<String, String> getMap2(String str) {
		Map<String, String> map = new HashMap<String, String>();
		// 一次分割，将不同人的信息分隔开
		String[] strs = str.split(",");
		for (int i = 0; i < strs.length; i++) {
			// 二次分割，将账号和密码分开，作为键值存进map
			String[] strs2 = strs[i].split(":");
			map.put(strs2[0], strs2[1]);
		}
		return map;
	}

	// 定义一个方法，进行写入保存操作，无覆盖
	public static void writeMsg(String filePath, String mess) {
		File file = new File(filePath);// 文件对象
		try {
			// 基于文件对象建立输出流，注意第二个参数为true才不会覆盖原来的文本信息
			OutputStream os = new FileOutputStream(file, true);
			byte[] bys = mess.getBytes();// 将字符串转换成字节数组
			os.write(bys);// 写入
			os.close();// 关闭流
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 定义一个方法，进行写入保存操作，覆盖原文件
	public static void writeMsg2(String filePath, String mess) {
		File file = new File(filePath);// 文件对象
		try {
			// 基于文件对象建立输出流，注意第二个参数为true才不会覆盖原来的文本信息
			OutputStream os = new FileOutputStream(file);
			byte[] bys = mess.getBytes();// 将字符串转换成字节数组
			os.write(bys);// 写入
			os.close();// 关闭流
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 定义一个方法，写入对象到本地文件，无覆盖
	public static void writeObj(String filePath, Object obj) {
		File file = new File(filePath);// 目标文件对象
		try {
			FileOutputStream fos = new FileOutputStream(file, true);// 基于目标文件对象建立输出流
			ObjectOutputStream oos = new ObjectOutputStream(fos);// 基于输出流实例化序列化对象
			oos.writeObject(obj);// 写入
			oos.close();
			fos.close();// 关闭流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 定义一个方法，写入对象到本地文件，覆盖原内容
	public static void writeObj2(String filePath, Object obj) {
		File file = new File(filePath);// 目标文件对象
		try {
			FileOutputStream fos = new FileOutputStream(file);// 基于目标文件对象建立输出流
			ObjectOutputStream oos = new ObjectOutputStream(fos);// 基于输出流实例化序列化对象
			oos.writeObject(obj);// 写入
			oos.close();
			fos.close();// 关闭流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 定义一个方法，用于读取用户对象
	public static Object readObj(String filePath) {
		Object obj = null;
		File file = new File(filePath);// 文件对象
		try {
			FileInputStream fis = new FileInputStream(file);// 基于文件对象建立输入流
			ObjectInputStream ois = new ObjectInputStream(fis);// 基于输入流建立对象输入流
			obj = ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	// 定义一个方法，用于展示课程和班级列表
	public static void getCMsg(String str) {
		String[] strs = str.split(",");// 分割字符串
		for (int i = 0; i < strs.length; i++) {
			System.out.println("★" + strs[i]);
		}
	}

	// 定义一个方法，用于查看学生平均成绩时向用户展示的列表
	public static void seeAvg(String str) {
		String[] strs = str.split(",");// 分割字符串
		for (int i = 0; i < strs.length; i++) {
			System.out.println((i + 1) + "、" + "查看" + strs[i]);
		}
	}

	// 定义一个方法，获取所有老师对象，并且按照ID升序排列
	public static Set<Teacher> getAllObj(String dicName) {
		TreeSet<Teacher> set = new TreeSet<>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {// 重写TreeSet的Comparator排序器的compare方法
				Teacher t1 = (Teacher) o1;
				Teacher t2 = (Teacher) o2;
				// 改变排序规则，按照ID升序
				if (t1.getId() > t2.getId()) {
					return 1;
				} else if (t1.getId() < t2.getId()) {
					return -1;
				}
				return 0;
			}
		});
		File file = new File(dicName);
		File[] f = file.listFiles();// 获取目录下的所有文件的数组
		for (int i = 0; i < f.length; i++) {// 遍历目录下的所有文件，逐个读取
			Teacher t = (Teacher) readObj(dicName + "/" + f[i].getName());
			set.add(t);
		}
		return set;
	}

	// 定义一个方法，获取所有学生对象，并且按照ID升序排列
	public static Set<Student> getAllObj2(String dicName) {
		TreeSet<Student> set = new TreeSet<>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {// 重写TreeSet的Comparator排序器的compare方法
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				// 改变排序规则，按照ID升序
				if (s1.getId() > s2.getId()) {
					return 1;
				} else if (s1.getId() < s2.getId()) {
					return -1;
				}
				return 0;
			}
		});
		File file = new File(dicName);
		File[] f = file.listFiles();// 获取目录下的所有文件的数组
		for (int i = 0; i < f.length; i++) {// 遍历目录下的所有文件，逐个读取
			Student s = (Student) readObj(dicName + "/" + f[i].getName());
			set.add(s);
		}
		return set;
	}

	// 定义一个方法，验证用户注册
	public static boolean validateRrgis(String fileName, String name) {
		File file = new File(fileName);
		boolean b = false;
		File[] f = file.listFiles();
		for (int i = 0; i < f.length; i++) {
			if (f[i].getName().contains(name)) {// 包含返回true
				b = true;
				break;
			} else {
				b = false;// 不包含返回false
			}
		}
		return b;
	}

	// 定义一个方法用注销学生账号
	public static void removeStu(String dicName, String name) {
		File file = new File(dicName + "/" + name + ".txt");
		if (file.exists()) {
			file.delete();
		}
	}

	// 定义一个方法删除账号和密码
	public static void removeMes(String fileName, String name) {
		String s = MethodsManager.readMsg(fileName);// 先读取出来
		Map<String, String> map = MethodsManager.getMap2(s);// 分割存到map里
		StringBuilder sb = new StringBuilder("");
		String pwd = map.get(name);// 获取密码
		sb.append(name).append(":").append(pwd).append(",");
		String str = s.replace(sb.toString(), "");// 用空白符替换掉用户信息
		// 最后将新的内容覆盖写进去
		MethodsManager.writeMsg2(fileName, str);
	}

	// 定义一个方法，获取所有学生对象，并且按照成绩升序排列
	public static Set<Student> getStu(String dicName) {
		TreeSet<Student> set = new TreeSet<>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {// 重写TreeSet的Comparator排序器的compare方法
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				// 改变排序规则，按照ID升序
				if (s1.getScore() > s2.getScore()) {
					return 1;
				} else if (s1.getScore() < s2.getScore()) {
					return -1;
				}
				return 1;
			}
		});
		File file = new File(dicName);
		File[] f = file.listFiles();// 获取目录下的所有文件的数组
		for (int i = 0; i < f.length; i++) {// 遍历目录下的所有文件，逐个读取
			Student s = (Student) readObj(dicName + "/" + f[i].getName());
			set.add(s);
		}
		return set;
	}

	// 定义一个方法，获取所有学生对象，并且按照成绩降序排列
	public static Set<Student> getStu2(String dicName) {
		TreeSet<Student> set = new TreeSet<>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {// 重写TreeSet的Comparator排序器的compare方法
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				// 改变排序规则，按照ID升序
				if (s1.getScore() < s2.getScore()) {
					return 1;
				} else if (s1.getScore() > s2.getScore()) {
					return -1;
				}
				return 1;
			}
		});
		File file = new File(dicName);
		File[] f = file.listFiles();// 获取目录下的所有文件的数组
		for (int i = 0; i < f.length; i++) {// 遍历目录下的所有文件，逐个读取
			Student s = (Student) readObj(dicName + "/" + f[i].getName());
			set.add(s);
		}
		return set;
	}

	// 定义一个方法，统计学生的平均成绩
	public static int getAvgScore(String name, String dicName) {
		int sum = 0;
		int count = 0;
		Set<Student> set = MethodsManager.getStuObj(dicName);
		for (Student s : set) {
			if (s.getCourse().equals(name)) {
				sum += s.getScore();
				count++;
			}
		}
		return sum / count;
	}

	// 定义一个方法，统计及格学生所占百分比
	public static double getPassPer(String name, String dicName) {
		double count = 0;
		double countSum = 0;
		Set<Student> set = MethodsManager.getStuObj(dicName);
		for (Student s : set) {
			if (s.getCourse().equals(name)) {
				countSum += 1;
				if (s.getScore() >= 60) {
					count += 1;
				}
			}
		}
		return Math.rint((count / countSum) * 100);
	}

	// 定义一个方法，统计学生的总成绩
	public static int getSumScore(String name, String dicName) {
		int sum = 0;
		Set<Student> set = MethodsManager.getStuObj(dicName);
		for (Student s : set) {
			if (s.getCourse().equals(name)) {
				sum += s.getScore();
			}
		}
		return sum;
	}

	// 定义一个方法，获取所有学生的姓名
	public static String getStuName(String dicName) {
		StringBuilder sb = new StringBuilder("");
		File file = new File(dicName);
		File[] f = file.listFiles();// 获取目录下的所有文件的数组
		for (int i = 0; i < f.length; i++) {// 遍历目录下的所有文件，逐个读取
			Student s = (Student) readObj(dicName + "/" + f[i].getName());
			sb.append(s.getUsername());
		}
		return sb.toString();
	}

	// 定义一个方法，获取所有学生对象
	public static Set<Student> getStuObj(String dicName) {
		Set<Student> set = new HashSet<>();
		File file = new File(dicName);
		File[] f = file.listFiles();// 获取目录下的所有文件的数组
		for (int i = 0; i < f.length; i++) {// 遍历目录下的所有文件，逐个读取
			Student s = (Student) readObj(dicName + "/" + f[i].getName());
			set.add(s);
		}
		return set;
	}

	// 定义一个方法，获取ID值的暂缺值集合
	public static TreeSet<Integer> getIdSet(String dicName) {
		List<Integer> lis = new ArrayList<>();
		TreeSet<Integer> tSet = new TreeSet<>();
		File file = new File(dicName);
		File[] f = file.listFiles();// 获取目录下的所有文件的数组
		for (int i = 0; i < f.length; i++) {// 遍历目录下的所有文件，逐个读取
			Student s = (Student) readObj(dicName + "/" + f[i].getName());
			lis.add(s.getId());
		}
		Collections.sort(lis);
		int max = lis.get(lis.size() - 1);
		for (int i = 1; i <= max; i++) {
			if (!lis.contains(i)) {
				tSet.add(i);
			}
		}
		return tSet;
	}

	// 定义一个方法，获取ID值的最大值
	public static int getIdMax(String dicName) {
		List<Integer> lis = new ArrayList<>();
		File file = new File(dicName);
		File[] f = file.listFiles();// 获取目录下的所有文件的数组
		for (int i = 0; i < f.length; i++) {// 遍历目录下的所有文件，逐个读取
			Student s = (Student) readObj(dicName + "/" + f[i].getName());
			lis.add(s.getId());
		}
		Collections.sort(lis);
		return lis.get(lis.size() - 1);
	}

	// 定义一个方法，获取老师所在的班级
	public static String getStuClassName(String dicName, String name) {
		Teacher t = (Teacher) MethodsManager.readObj(dicName + "/" + name + ".txt");
		return t.getClassName();
	}

	// 定义一个方法，获取老师所教授的课程
	public static String getCourse(String dicName, String name) {
		Teacher t = (Teacher) MethodsManager.readObj(dicName + "/" + name + ".txt");
		return t.getCourse();
	}

	// 定义一个方法，获取老师所教授的课程
	public static String getCourse2(String dicName, String name) {
		Student s = (Student) MethodsManager.readObj(dicName + "/" + name + ".txt");
		return s.getCourse();
	}

	// 定义一个方法，筛选出某个班级内选了某课程的学生集合
	public static Set<Student> getSureStu(String dicName1, String dicName2, String name) {
		Set<Student> set = new HashSet<>();
		Set<Student> set2 = new HashSet<>();
		set = MethodsManager.getStu(dicName1);
		// 获取班级
		String cName = MethodsManager.getStuClassName(dicName2, name);
		// 获取课程
		String course = MethodsManager.getCourse(dicName2, name);
		for (Student s : set) {
			if (s.getClassName().equals(cName) && s.getCourse().equals(course)) {
				set2.add(s);
			}
		}
		return set2;
	}

	// 定义一个方法，筛选出某个班级内选了某课程的学生姓名
	public static String getSureStuName(String dicName1, String dicName2, String name) {
		StringBuilder sb = new StringBuilder("");
		Set<Student> set = new HashSet<>();
		Set<Student> set2 = new HashSet<>();
		set = MethodsManager.getStu(dicName1);
		// 获取班级
		String cName = MethodsManager.getStuClassName(dicName2, name);
		// 获取课程
		String course = MethodsManager.getCourse(dicName2, name);
		for (Student s : set) {
			if (s.getClassName().equals(cName) && s.getCourse().equals(course)) {
				set2.add(s);
			}
		}
		for (Student s : set2) {
			sb.append(s.getUsername());
		}
		return sb.toString();
	}

	// 定义一个方法，统计指定班级指定课程的平均成绩
	public static int getSureAvg(String dicName1, String dicName2, String name) {
		int sum = 0;
		Set<Student> set = new HashSet<>();
		Set<Student> set2 = new HashSet<>();
		set = MethodsManager.getStu(dicName1);
		// 获取班级
		String cName = MethodsManager.getStuClassName(dicName2, name);
		// 获取课程
		String course = MethodsManager.getCourse(dicName2, name);
		for (Student s : set) {
			if (s.getClassName().equals(cName) && s.getCourse().equals(course)) {
				set2.add(s);
			}
		}
		for (Student s : set2) {
			sum += s.getScore();
		}
		return sum / set2.size();
	}

	// 定义一个方法，将指定班级指定课程学生成绩升序排列
	public static Set<Student> sortSureScore(String dicName1, String dicName2, String name) {
		Set<Student> set = new HashSet<>();
		TreeSet<Student> tSet = new TreeSet<>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {// 重写TreeSet的Comparator排序器的compare方法
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				// 改变排序规则，按照ID升序
				if (s1.getScore() > s2.getScore()) {
					return 1;
				} else if (s1.getScore() < s2.getScore()) {
					return -1;
				}
				return 1;
			}
		});
		set = MethodsManager.getStu(dicName1);
		// 获取班级
		String cName = MethodsManager.getStuClassName(dicName2, name);
		// 获取课程
		String course = MethodsManager.getCourse(dicName2, name);
		for (Student s : set) {
			if (s.getClassName().equals(cName) && s.getCourse().equals(course)) {
				tSet.add(s);
			}
		}
		return tSet;
	}

	// 定义一个方法，将指定班级指定课程学生成绩降序排列
	public static Set<Student> sortSureScore2(String dicName1, String dicName2, String name) {
		Set<Student> set = new HashSet<>();
		TreeSet<Student> tSet = new TreeSet<>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {// 重写TreeSet的Comparator排序器的compare方法
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				// 改变排序规则，按照ID升序
				if (s1.getScore() < s2.getScore()) {
					return 1;
				} else if (s1.getScore() > s2.getScore()) {
					return -1;
				}
				return 1;
			}
		});
		set = MethodsManager.getStu(dicName1);
		// 获取班级
		String cName = MethodsManager.getStuClassName(dicName2, name);
		// 获取课程
		String course = MethodsManager.getCourse(dicName2, name);
		for (Student s : set) {
			if (s.getClassName().equals(cName) && s.getCourse().equals(course)) {
				tSet.add(s);
			}
		}
		return tSet;
	}

	// 定义一个方法，获取本班成绩的综合信息
	public static String getZongHe(String dicName1, String dicName2, String name, String course) {
		StringBuilder sb = new StringBuilder("");
		int sum = 0;
		double count = 0;
		int countSum = 0;
		Set<Student> set = new HashSet<>();
		Set<Student> set2 = new HashSet<>();
		set = MethodsManager.getStu(dicName1);
		// 获取班级
		String cName = MethodsManager.getStuClassName(dicName2, name);
		for (Student s : set) {
			if (s.getClassName().equals(cName)) {
				set2.add(s);
			}
		}
		for (Student s : set2) {
			if (s.getCourse().equals(course)) {
				sum += s.getScore();
				countSum++;
				if (s.getScore() >= 60) {
					count++;
				}
			}
		}
		sb.append(course).append("\t").append(sum).append("\t").append(sum / countSum).append("\t")
				.append(Math.rint(count / countSum * 100) + "%").append("\t")
				.append(100 - (Math.rint(count / countSum * 100)) + "%");
		return sb.toString();
	}

	// 定义一个方法，获取本班成绩的综合信息
	public static String getZongHe2(String dicName1, String cName, String course) {
		StringBuilder sb = new StringBuilder("");
		int sum = 0;
		double count = 0;
		int countSum = 0;
		Set<Student> set = new HashSet<>();
		Set<Student> set2 = new HashSet<>();
		set = MethodsManager.getStu(dicName1);
		for (Student s : set) {
			if (s.getClassName().equals(cName)) {
				set2.add(s);
			}
		}
		for (Student s : set2) {
			if (s.getCourse().equals(course)) {
				sum += s.getScore();
				countSum++;
				if (s.getScore() >= 60) {
					count++;
				}
			}
		}
		sb.append(course).append("\t").append(sum).append("\t").append(sum / countSum).append("\t")
				.append(Math.rint(count / countSum * 100) + "%").append("\t")
				.append(100 - (Math.rint(count / countSum * 100)) + "%");
		return sb.toString();
	}

	// 定义一个方法，获取本班所有学生
	public static Set<Student> getclaStu(String dicName, String claName) {
		Set<Student> set = MethodsManager.getStuObj(dicName);// 获取所有学生对象
		Set<Student> set2 = new HashSet<>();
		for (Student s : set) {
			if (s.getClassName().equals(claName)) {// 按班级筛选
				set2.add(s);
			}
		}
		return set2;
	}

	// 定义一个方法，获取班级
	public static String getclaName(String dicName, String name) {
		Student stu = (Student) MethodsManager.readObj(dicName + "/" + name + ".txt");
		return stu.getClassName();
	}

	// 定义一个方法，获取班级所有学生姓名
	public static String getsName(String dicName, String claName) {
		Set<Student> set = MethodsManager.getStuObj(dicName);// 获取所有学生对象
		Set<Student> set2 = new HashSet<>();
		for (Student s : set) {
			if (s.getClassName().equals(claName)) {// 按班级筛选
				set2.add(s);
			}
		}
		StringBuilder sb = new StringBuilder("");
		for (Student s : set2) {
			sb.append(s.getUsername());
		}
		return sb.toString();
	}

	// 定义一个方法，获取本班所有老师对象
	public static Set<Teacher> getTecObj(String dicName, String cName) {
		Set<Teacher> set = MethodsManager.getAllObj(dicName);
		Set<Teacher> set2 = new HashSet<>();
		for (Teacher t : set) {
			if (t.getClassName().equals(cName)) {
				set2.add(t);
			}
		}
		return set2;
	}

	// 定义一个方法，判断给定的数是否为素数，并统计素数的个数
	// ps：素数指大于1且只能被1和自身整数的自然数
	public static List<Integer> isPrimeNumber(int num) {
		List<Integer> lis = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			int count = 0;// 用来统计整除次数
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
				if (count > 2) {// 整除次数超过2，一定不是素数，此时可以跳出里层循环，提高效率
					break;
				}
			}
			if (count == 2) {// 定义素数的标准就是整除次数为2
				lis.add(i);
			}
		}
		return lis;
	}

	// 定义一个方法，统计任意磁盘下的文件目录
	public static void getDic(String path) {
		File file = new File(path + ":/");
		String[] files = file.list();// 统计所有文件和目录
		System.out.println(path + "盘下目录和文件的数量一共为：" + files.length + ",具体如下：");
		for (int i = 0; i < files.length; i++) {
			File file2 = new File(file + files[i]);
			System.out.println(path + "-----" + "\t\t" + file2.getName() + "\t\t\t"
					+ new SimpleDateFormat("YYYY-MM-dd hh:mm").format(new Date(file2.lastModified())) + "\t\t"
					+ file2.length() + "\t");
		}
	}

	/**
	 * 以下定义一系列方法，用于压缩
	 * 
	 * @throws IOException
	 */
	public static void compress(String srcPath, String dscPath) throws IOException {
		File srcFile = new File(srcPath);
		File dscFile = new File(dscPath);// 实例化两个文件对象
		if (!srcFile.exists()) {// 如果文件不存在，抛出异常
			throw new FileNotFoundException(srcPath + "不存在！");
		}
		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		try {
			fos = new FileOutputStream(dscFile);// 实例化输出流对象
			CheckedOutputStream cos = new CheckedOutputStream(fos, new CRC32());// 基于输出流对象实例化压缩输出流对象
			zipOut = new ZipOutputStream(cos);
			String baseDir = "";
			compress(srcFile, zipOut, baseDir);// 调用后面定义的方法压缩文件
			System.out.println("压缩已完成！");
		} finally {// 以下关闭相关流，放在finally块里，强制执行，释放内存资源
			if (zipOut != null) {
				zipOut.close();
				fos = null;
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

	private static void compress(File file, ZipOutputStream zipOut, String baseDir) throws IOException {
		if (file.isDirectory()) {// 是目录的话调用压缩目录的方法
			compressDirectory(file, zipOut, baseDir);
		} else {// 否则调用压缩文件的方法
			compressFile(file, zipOut, baseDir);
		}
	}

	// 定义一个方法，用于压缩文件
	private static void compressFile(File file, ZipOutputStream zipOut, String baseDir) throws IOException {
		if (!file.exists()) {
			return;
		}

		BufferedInputStream bis = null;// 定义缓冲输入流
		try {
			bis = new BufferedInputStream(new FileInputStream(file));// 实例化缓冲输入流对象
			ZipEntry entry = new ZipEntry(baseDir + file.getName());// 实例化ZipEntry对象
			zipOut.putNextEntry(entry);// 创建压缩流的进入点
			int count;// 暂存器
			byte[] bys = new byte[1024000];// 字节数组暂时容器
			while ((count = bis.read(bys, 0, bys.length)) != -1) {// 当未到最后一个字符时
				zipOut.write(bys, 0, count);// 压缩
			}
		} finally {
			if (bis != null) {
				bis.close();
			}
		}

	}

	// 定义一个方法，用于压缩目录
	private static void compressDirectory(File dir, ZipOutputStream zipOut, String baseDir) throws IOException {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {// 将目录中的所有文件遍历出来，再按压缩文件的方法处理
			compress(files[i], zipOut, baseDir + dir.getName() + "/");
		}

	}

	// 定义一个方法，搜索指定目录处的mp3文件
	public static List<String> getMusic(String dicName) {
		List<String> lis = new ArrayList<>();
		File file = new File(dicName);
		File[] files = file.listFiles();
		for (int i = 0; i < file.length(); i++) {
			System.out.println((i + 1) + "、" + files[i].getName());
			lis.add(files[i].getName());
			if (i == 9) {
				break;
			}
		}
		return lis;
	}

	// 定义一个方法，用来播放mp3格式音乐
	private static Player player = null;

	public static Thread playMp3(String dicName, String name) {
		Thread t0 = null;
		File mp3 = new File(dicName);
		try {
			FileInputStream in = new FileInputStream(mp3);
			BufferedInputStream bis = new BufferedInputStream(in);
			player = new Player(bis);
			t0 = new Thread(() -> {
				try {
					player.play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
			}, name);
			t0.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t0;
	}

	// 定义一个方法，下载一首歌曲
	public static void downMp3(String urlStr, String filePath, String name) {
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			URL url = new URL(urlStr);// 基于下载地址构建URL对象
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();// 打开链接
			conn.setConnectTimeout(1000 * 5);// 设置超时时间
			InputStream in = conn.getInputStream();// 基于链接获取输入流
			File file2 = new File(filePath + "/" + name);// 保存的文件对象
			FileOutputStream fos = new FileOutputStream(file2);// 建立输出流
			byte[] bys = new byte[1024 * 1024 * 10];// 字节数组容器
			int count = 0;
			System.out.println("下载中.....");
			while ((count = in.read(bys, 0, bys.length)) > 0) {
				fos.write(bys, 0, count);
			}
			System.out.println("已下载完成！");
			fos.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 定义一个方法，用于校验密码强度
	public static void validatePass(String password) {
		StringBuilder sb = new StringBuilder("");
		String reg1 = "^\\d{6,16}";// 定义强度为弱
		String reg2 = "^[a-zA-Z0-9]{6,16}$";// 定义强度为中
		Pattern p = Pattern.compile(reg1);
		Matcher m = p.matcher(password);
		Pattern p2 = Pattern.compile(reg2);
		Matcher m2 = p2.matcher(password);
		if (m.matches()) {
			System.out.println("密码强度较弱！");
		}else if (m2.matches()) {
			System.out.println("密码强度中等！");
		}else{
			System.out.println("密码强度较强！");
		}
	}

}
