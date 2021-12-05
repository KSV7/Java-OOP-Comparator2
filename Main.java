package com.gmail.kutepov89.sergey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<File> tempList = Arrays.asList(new File("a.txt"), new File("b.txt"), new File("c.txt"), new File("d.txt"), new File("e.txt"));
		Comparator<File> comp = (a, b) -> Integer.compare(checkFile(a), checkFile(b));
		tempList.sort(comp);
		System.out.println(tempList);
	}

	public static Integer checkFile(File f) {
		int res = 0;
		try (BufferedReader file = new BufferedReader(new FileReader(f.getName()))) {
			String str = "";
			for (; (str = file.readLine()) != null;) {
				res += str.replaceAll("(?i)[^,.-?! ]+", "").length();
			}
			return res;
		} catch (IOException e) {
			return 0;
		}
	}
	
}
