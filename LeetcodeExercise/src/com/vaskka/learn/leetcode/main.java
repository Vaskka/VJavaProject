package com.vaskka.learn.leetcode;

import java.util.*;

import com.vaskka.learn.leetcode.solve.JewelsAndStones;
import com.vaskka.learn.leetcode.solve.UniqueEmail;

public class main {

	private static void L(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		List<Integer> l  = new LinkedList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(10);
		
		l.add(1, 2000);
		
		for (int i : l) {
			L(i);
		}
		
	}
}
