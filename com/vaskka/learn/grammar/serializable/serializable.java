/*
javac com/vaskka/learn/grammar/serializable/serializable.java
java com/vaskka/learn/grammar/serializable/TestSerializable
*/

package com.vaskka.learn.grammar.serializable;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//implement Serializable
class Student implements Serializable {
	public String name;
	public int id;
	public int old;

	public Student(String n, int i, int o) {
		this.name = n;
		this.id   = i;
		this.old  = o;
	}

}


class TestSerializable {

	public static void main(String[] args) {
		Student oneStudent = new Student("Vaskka", 2017, 18);

		Path serialPath = Paths.get("\\TestSerial");

		try (OutputStream ots        = Files.newOutputStream(serialPath, StandardOpenOption.CREATE);
			 ObjectOutputStream oots = new ObjectOutputStream(ots)) {

			//write a object
			oots.writeObject(oneStudent);
			//write a String
			oots.writeObject("This is a Student Object!");

		}
		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("=====================================");
		//test ObjectInputStream
		try (InputStream its = Files.newInputStream(serialPath, StandardOpenOption.READ);
			 ObjectInputStream oits = new ObjectInputStream(its)) {

			Student deSerialStudent = (Student)oits.readObject();
			System.out.println(deSerialStudent.name);
			System.out.println(deSerialStudent.id);
			System.out.println(deSerialStudent.old);

			String deSerialString = (String)oits.readObject();
			System.out.println(deSerialString);

		}	
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
