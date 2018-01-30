/*
javac com/vaskka/tool/comparefile/comparefile.java
java com/vaskka/tool/comparefile/TestStream
*/

package com.vaskka.tool.comparefile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
//import java.nio.file.LinkOption;
import java.nio.file.StandardOpenOption;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class CompareFiles {
	/**
	*<p>Compare whether two file is same</p>
	*@param  one Path the first file for compare
	*@param  one Path the second file for compare
	*@return true for the same otherwise not
	*/
	public boolean compareTwoFiles(Path one, Path another) throws NoSuchFileException {
		
		//deal if the file not exist
		if (Files.notExists(one)) {
			throw new NoSuchFileException(one.toString());
		}
		if (Files.notExists(another)) {
			throw new NoSuchFileException(another.toString());
		}

		//if the size of two file is not the same return false
		try {
			if (Files.size(one) != Files.size(another)) {
				return false;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		//try-with-resource 
		try (InputStream strm1 = Files.newInputStream(one, StandardOpenOption.READ);
			 InputStream strm2 = Files.newInputStream(another, StandardOpenOption.READ)) {
			int b1;
			int b2;

			//compase every byte
			do {
				b1 = strm1.read();
				b2 = strm2.read();

				if (b1 != b2) {
					return false;
				}
			} while (b1 != -1);

			return true;
		}
		catch (IOException e) {
			return false;
		}

	}
}


class TestStream {

	static String onePaths = null;
	static String anotherPaths = null;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please input one file's src:");
		TestStream.onePaths     = input.nextLine();
		System.out.println("Please input another file's src:");
		TestStream.anotherPaths = input.nextLine();

		Path oneFile = Paths.get(TestStream.onePaths);
		Path anotherFile = Paths.get(TestStream.anotherPaths);

		CompareFiles tempTest = new CompareFiles();

		try {
			if (tempTest.compareTwoFiles(oneFile, anotherFile)) {
				System.out.println("Same");
			}
			else {
				System.out.println("No");
			}
		}	
		catch (NoSuchFileException e) {
			e.printStackTrace();
		}

	}
}