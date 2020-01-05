package com.arya.advance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class WordCountInFile {

	static String fileName = "C:\\Muni\\MyEclipse_2017_WorkSpace\\AG_Trunk\\Sample\\src\\com\\arya\\advance\\programs\\wordCount.txt";

	public static void main(String[] args) {

		withJava7();
		withJava8();

	}

	private static void withJava7() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, " ");

				while (st.hasMoreTokens()) {
					String temp = st.nextToken();
					if (map.containsKey(temp))
						map.put(temp, map.get(temp) + 1);
					else
						map.put(temp, 1);
				}
			}

			System.out.println(map);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static void withJava8() {
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			Map<String, Integer> map = new HashMap<String, Integer>();

			stream.forEach(line -> {
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					String temp = st.nextToken();
					if (map.containsKey(temp))
						map.put(temp, map.get(temp) + 1);
					else
						map.put(temp, 1);
				}
			});

			System.out.println(map);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
