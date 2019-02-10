package com.vaskka.learn.leetcode.solve;

import java.util.*;

public class RepeatedNTimes {

    public int repeatedNTimes(int[] A) {
        Hashtable<Integer, Integer> t = new Hashtable<>();
        
        for (int i = 0; i < A.length; i++) {
        	Integer k = t.get(A[i]);
        	
        	if (k == null) {
        		t.put(A[i], 1);
        	}
        	else {
        		k++;
        		if (k.equals((A.length / 2))) {
        			return A[i];
        		}
        		t.put(A[i], k);
        	}
        	
        }
        
        return -1;
       
    }
   
      
}
