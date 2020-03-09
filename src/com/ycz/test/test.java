package com.ycz.test;

import java.io.File;
import java.util.Set;

import com.ycz.pojo.Student;
import com.ycz.util.MethodsManager;

public class test {

	public static void main(String[] args) {

		String s = "F:/workspace-for-homework/FinalTest/src/com/ycz/files/Ñ§Éú";
		Set <Student> set = MethodsManager.getStu(s);
		File file = new File(s);
		System.out.println(file.listFiles().length);
	}
}
