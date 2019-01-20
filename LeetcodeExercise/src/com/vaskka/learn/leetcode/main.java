package com.vaskka.learn.leetcode;

import com.vaskka.learn.leetcode.solve.JewelsAndStones;
import com.vaskka.learn.leetcode.solve.UniqueEmail;

public class main {

	private static void L(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		UniqueEmail t = new UniqueEmail();
		
		String[] l = new String[3];
		l[0] = "test.email+alex@leetcode.com";
		l[1] = "test.e.mail+bob.cathy@leetcode.com";
		l[2] = "testemail+david@lee.tcode.com";
		L(t.numUniqueEmails(l));
	}
}
