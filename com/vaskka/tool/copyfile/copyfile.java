/*
javac com/vaskka/tool/copyfile/copyfile.java
java com/vaskka/tool/copyfile/TestStream
*/

package com.vaskka.tool.copyfile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.LinkOption;
import java.nio.file.StandardOpenOption;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


class CopyFiles {

	/**
	*<p>copy one file to another place</p>
	*the source path must be exist and the destination path must be not exist
	*@param souce Path the source file path
	*@param destination Path the destination file path 
	*@return void
	*/
	public void copyFiles(Path source, Path destination) throws IOException {
		
		//deal if source is not exist or destination is exist
		if (Files.notExists(source) || Files.exists(destination)) {
			throw new IOException("Source path:" + source.toString() + " must be exist!"
								+ "destination path:" + destination.toString() + " must be not exist!");
		}

		//try-with-resource
		try (InputStream  ipt = Files.newInputStream(source, StandardOpenOption.READ);
			 OutputStream opt = Files.newOutputStream(destination, StandardOpenOption.CREATE);) {
			//save the source data
			byte[] dataByte = new byte[1024];

			//identify how many bytes with once read
			int num = ipt.read(dataByte);

			while (num != -1) {
				//write into output stream with $num byte
				opt.write(dataByte, 0, num);
				num = ipt.read(dataByte);
			}

		}
		catch (IOException e) {
			throw e;
		}

	}
}

class TestStream {

	static String source      = null;
	static String destination = null;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("Please input the source path:(must be exist)");
		TestStream.source      = input.nextLine();
		System.out.println("Please input the destination path:(must be not exist)");
		TestStream.destination = input.nextLine();

		Path oneFile  = Paths.get(TestStream.source);
		Path destPath = Paths.get(TestStream.destination);
		
		CopyFiles cpyfls = new CopyFiles();

		try {
			cpyfls.copyFiles(oneFile, destPath);
			System.out.println("copy successfully!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
