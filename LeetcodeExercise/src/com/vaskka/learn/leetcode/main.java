package com.vaskka.learn.leetcode;

import java.util.*;

import com.vaskka.learn.leetcode.solve.*;

public class main {

	private static void L(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		SubsetsWithDup s = new SubsetsWithDup();
		
		int[] nums = {1, 2, 2};
		
		List<List<Integer>> r = s.subsetsWithDup(nums);
		
		for (List<Integer> subList : r) {
			for (int i : subList) {
				System.out.print(i);
				System.out.print(' ');
				
			}
			L("");
		}
		
		L("ok");
	}
}
