package com.vaskka.learn.grammar.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Stu implements Comparable<Stu> {
	public int id;
	public Stu(int i) {
		this.id = i;
	}	

	@Override
	public int compareTo(Stu another) {
		//如果 调用者 的id大于 待比较者 的id，返回1，否则返回-1(升序)
		//this 代指 调用者
		if (this.id >= another.id) {
			return 1;
		}
		else {
			return -1;
		}
	}
}

class Program {
	public static void main(String[] args) {

		//构造一个id为12的Stu对象
		Stu stu1 = new Stu(12);
		//构造一个id为7的Stu对象
		Stu stu2 = new Stu(7);
		//构造一个id为20的Stu对象
		Stu stu3 = new Stu(20);

		List<Stu> testList = new ArrayList<Stu>(3);
		testList.add(stu1);
		testList.add(stu2);
		testList.add(stu3);
		//未排序
		for (Stu s : testList) {
			System.out.println(s.id);
		}
		System.out.println("++======++");
		//排序后
		Collections.sort(testList);
		for (Stu s : testList) {
			System.out.println(s.id);
		}

	}
}
