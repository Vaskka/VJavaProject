package com.vaskka.learn.leetcode.solve;

public class DiStringMatch {

    public int[] diStringMatch(String S) {
        int minIndex = 0;
        int maxIndex = S.length();
        char[] cs = S.toCharArray();
        int[] result = new int[S.length() + 1];
        
        int i = 0;
        for (; i < S.length(); i++) {
        	if (cs[i] == 'I') {
        		result[i] = minIndex;
        		minIndex++;
        	}
        	else {
        		result[i] = maxIndex;
        		maxIndex--;
        	}
        	
        }
        
        result[i] = minIndex;
        
        return result;
    }
}
