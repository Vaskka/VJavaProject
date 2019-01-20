package com.vaskka.learn.leetcode.solve;

import com.vaskka.learn.leetcode.Solve;

public class JewelsAndStones extends Solve {
	public JewelsAndStones() {
		id = 771;
		name = "石头与宝石";
	}
	
	
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        
    	for (char i : S.toCharArray()) {
        	for (char j : J.toCharArray()) {
        		if (i == j) {
        			count++;
        			break;
        		}
        	}
        }
    	
    	return count;
    }
	
}
