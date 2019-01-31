package com.vaskka.learn.leetcode;

import java.util.*;

import com.vaskka.learn.leetcode.solve.*;

public class main {

	private static void L(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		WordGo w = new WordGo();
		
		List<String> l = new ArrayList<>();
		
		l.add("hot");
		l.add("dot");
		l.add("dog");
		l.add("lot");
		l.add("log");
		l.add("cog");
		
		w.ladderLength("hit", "cog", l);
	}
}
