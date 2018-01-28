/*
javac com/vaskka/learn/grammar/io/io.java
java com/vaskka/learn/grammar/io/Program

*/

package com.vaskka.learn.grammar.io;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.DirectoryStream;


class Program {

	static void printDirectoryAllFile(String path) {
		//record if this path is all files
		boolean isAllFiles = true;
		Path parent = Paths.get(path);
		try (DirectoryStream<Path> chileren = Files.newDirectoryStream(parent)) {
			for (Path child : chileren) {
				//if has one directory at last
				if (Files.isDirectory(child)) {
					isAllFiles = false;
					Program.printDirectoryAllFile(child.toString());
				}
				else {
					System.out.println(child);
				}

			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		if (isAllFiles) 
			return;

	}

	public static void main(String[] args) {
		//init FileSystem
		FileSystem oneSys = FileSystems.getDefault();
		
		//get Path
		Path newFile = Paths.get("com\\vaskka\\learn\\grammar\\io\\test.txt");

		try {
			if (!(Files.exists(newFile)))
				Files.createFile(newFile);

		}
		catch (IOException e) {
			e.printStackTrace();
		}

		//create Directory
		String testDirectoryPath = "com\\vaskka\\learn\\grammar\\io\\test";
		Path testDirectory = Paths.get(testDirectoryPath);
		try {
			if (!(Files.exists(testDirectory))) {
				Files.createDirectory(testDirectory);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		//print a directory's all file path
		String parentPath = "com\\vaskka\\learn\\grammar\\io";
		Program.printDirectoryAllFile(parentPath);


	}	

}