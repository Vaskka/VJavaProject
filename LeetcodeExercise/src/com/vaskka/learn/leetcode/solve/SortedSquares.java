package com.vaskka.learn.leetcode.solve;

public class SortedSquares {

    public int[] sortedSquares(int[] A) {
    	
    	for (int i = 0; i < A.length; i++) {
    		A[i] = A[i] * A[i];
    	}
    	
    	for (int i = 0; i < A.length; i ++) {
    		for (int j = 0; j < A.length - i - 1; j++) {
    			if (A[j] > A[j + 1]) {
    				int t = A[j];
    				A[j] = A[j + 1];
    				A[j + 1] = t;
    			}
    		}
    	}
    	
    	return A;
        
    }

}
