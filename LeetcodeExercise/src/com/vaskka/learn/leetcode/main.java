package com.vaskka.learn.leetcode;

import com.vaskka.learn.leetcode.solve.JewelsAndStones;

public class main {

	private static void L(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		JewelsAndStones t = new JewelsAndStones();
		L(t.numJewelsInStones("aA", "aAAbbbb"));
		L(t.numJewelsInStones("z", "ZZ"));
	}
}
