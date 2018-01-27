/*
javac com/vaskka/learn/grammar/collection/collection.java
java com/vaskka/learn/grammar/collection/Program

*/
package com.vaskka.learn.grammar.collection;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Comparator;


class qwComparator implements Comparator{
	public int compare(Object one, Object another) {
		if (((Common)one).qw >= ((Common)another).qw){
			return 1;
		}
		return -1;
	}
}

class Common implements Comparable {
	public int qw = 2;
	public String str = "jkl";

	public int compareTo(Object obj) {

		if (obj == null) {
			return -1;
		}

		Common temp = (Common)obj;
		if (this.equals(temp)) {
			return 1;
		}

		if (this.qw >= temp.qw) {
			return 1;
		}
		else {
			if (this.str.compareTo(temp.str) > 0) {
				return 1;
			}
		}

		return -1;
	}
}

@SuppressWarnings("unchecked") 
class Program {
	static void show (Map c) {


		/*
		for (int i = 0; i < c.size(); i++) {
			System.out.println(keys.get(i));
		}
		*/
	}

	public static void main(String[] args) {
		/*
		ArrayList myList = new ArrayList();
		String str1 = "qwer";
		int a = 233;
		float b = 5.8738978f;
		
		myList.add(32);

		
		if (myList.add(str1)) {
			System.out.println(str1 + " add successful!");
		}

		if (myList.add(a)) {
			System.out.println(String.valueOf(a) + " add successful!");
		}	

		if (myList.add(b)) {
			System.out.println(String.valueOf(b) + " add successful!");
		}

		Common oneCommonObject = new Common();

		if (myList.add(oneCommonObject)) {
			System.out.println(oneCommonObject.toString() + " add successful!");
		}
		System.out.println("--------------------");
		System.out.println("Size: " + String.valueOf(myList.size()));
		System.out.println("--------------------");
		
		int i = 0;
		for (Object obj : myList) {
			if (obj.equal(oneCommonObject)) {
				Common temp = myList[i];
				System.out.println(temp.qw);
				System.out.println(temp.str);
			}
			System.out.println(obj);
			i++;
		}
		
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(1) instanceof Common) {
				System.out.println("asa");
				Common temp = (Common)myList.get(i);
				System.out.println(temp.qw);
				System.out.println(temp.str);
			}

		}
		*/

		/*
		Set mySet = new HashSet();

		int[] a = new int[3];

		a[0] = 2;
		a[1] = 5;
		a[2] = 5;

		for (int i = 0; i < a.length; i++) {
			if (mySet.add(a[i])) {
				System.out.printf("%d has added successfully!\n", a[i]);
			}
			else {
				System.out.printf("%d has not added successfully!\n", a[i]);
			}
		}

		for (Object obj : mySet) {
			System.out.println((int)obj);
		}
		System.out.println();
		System.out.println(mySet.size());



		Queue myQueue = new LinkedList();


		int[] a = new int[3];

		a[0] = 2;
		a[1] = 5;
		a[2] = 7;

		for (int i = 0; i < a.length; i++) {
			if (myQueue.offer(a[i])) {
				System.out.printf("%d has added successfully!\n", a[i]);	
			}
			else {
				System.out.printf("%d has not added successfully!\n", a[i]);
			}
		}

		for (Object obj : myQueue) {
			System.out.println((int)obj);
		}
		System.out.printf("Size:%d\n", myQueue.size());
	

		for (int i = 0; i < myQueue.size(); i++) {
			System.out.println(myQueue.remove());
		}

		Iterator itr = myQueue.iterator();
		while (itr.hasNext()) {
			int b = (int)itr.next();
			if (b == 5) {
				System.out.println(itr.remove());
			}
		}

		System.out.printf("Size:%d\n", myQueue.size());

		*/
		/*
		Map myMap = new HashMap();
		myMap.put("qw", "qweer");
		myMap.put(2, "tuwej");
		myMap.put(2, "asdff");

		//Program.show(myMap);
		System.out.println(myMap.get(2));
		*/

		Common A = new Common();
		Common B = new Common();
		Common C = new Common();
		C.qw = 23;
		B.qw = 88;	
		C.str = "dasdaasdasdas";

		Common[] test = new Common[3];
		test[0] = A;
		test[1] = B;
		test[2] = C;

		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i].qw);
			System.out.println(test[i].str);
			System.out.println("------------");


		}

		Arrays.sort(test, new qwComparator());

		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i].qw);
			System.out.println(test[i].str);
			System.out.println("------------");


		}
	}
}