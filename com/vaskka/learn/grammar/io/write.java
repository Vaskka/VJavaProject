/*
javac com/vaskka/learn/grammar/io/write.java
java com/vaskka/learn/grammar/io/TestWrite
*/

package com.vaskka.learn.grammar.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

/**
*write sth into testWrite.txt
*/
class TestWrite {
	static String testFilePath = "testWrite.txt";


	static String Line1 = "This is a line";
	static String Line2 = "This is another line";
	
	static Charset chst = Charset.forName("US-ASCII");

	static List<String> content = Arrays.asList(Line1, Line2);
/*
	static boolean userInput(Scanner input) {

	}
*/
	public static void main(String[] args) {
		Path testWrite = Paths.get(TestWrite.testFilePath);
		Scanner input = new Scanner(System.in);

		try {
			Files.write(testWrite, TestWrite.content, TestWrite.chst);

		}
		catch (IOException e) {
			e.printStackTrace();
		}

		List<String> readLines = null;

		try {
			readLines = Files.readAllLines(testWrite, chst);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		if (readLines != null) {
			for (String ts : readLines) {
				System.out.println(ts);
			}
		}

	}
}
