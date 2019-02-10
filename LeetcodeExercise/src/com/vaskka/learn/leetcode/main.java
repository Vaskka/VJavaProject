package com.vaskka.learn.leetcode;

import java.util.*;

import com.vaskka.learn.leetcode.solve.*;

public class main {

	private static void L(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		int[] A = {5, 1, 5, 2, 5, 3, 5, 4};
		
		RepeatedNTimes t = new RepeatedNTimes();
		
		t.repeatedNTimes(A);
	}
}
