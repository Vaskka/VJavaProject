package com.vaskka.learn.leetcode.solve;

import com.vaskka.learn.leetcode.Solve;

public class SortArrayByParity extends Solve {

	public SortArrayByParity() {
		// TODO Auto-generated constructor stub
		id = 905;
		name = "°´ÆæÅ¼ÅÅÐòÊý×é";
	}
	
//    public int[] sortArrayByParity(int[] A) {
//    	int oldAxis = A.length - 1;
//    	
//        for (int i = 0; i < A.length; i++) {
//        	if (A[i] % 2 != 0) {
//        		for (int j = oldAxis; j > i; j--) {
//        			if (A[j] % 2 == 0) {
//        				int temp = A[i];
//        				A[i] = A[j];
//        				A[j] = temp;
//        				
//        				oldAxis = j - 1;
//        				break;
//        			}
//        			
//        		}
//        	}
//        	else {
//        		continue;
//        	}
//        }
//        
//        return A;
//    }
    
    public int[] sortArrayByParity(int[] A) {
    	int evenIndex = 0;
    	int  oddIndex = A.length - 1;
    	
    	while (evenIndex < A.length && oddIndex >= 0 && evenIndex < oddIndex) {
	    	while (evenIndex < A.length && A[evenIndex] % 2 == 0) {
	    		evenIndex ++;
	    	}
	    	
	    	while (oddIndex >= 0 && A[oddIndex] % 2 != 0) {
	    		oddIndex --;
	    	}
	    	
	    	if (evenIndex < oddIndex && evenIndex < A.length && oddIndex >= 0) {
	    		int temp = A[evenIndex];
	    		A[evenIndex] = A[oddIndex];
	    		A[oddIndex] = temp;
	    	}
    	}
    	
        
        return A;
    }

}
