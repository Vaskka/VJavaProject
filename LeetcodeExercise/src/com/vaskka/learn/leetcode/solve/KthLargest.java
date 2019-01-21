package com.vaskka.learn.leetcode.solve;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import com.vaskka.learn.leetcode.Solve;

/**
 * @author Vaskka
 *
 */
public class KthLargest extends Solve {

	
	int k;
	
	List<Integer> list;
	
	public KthLargest(int k, int[] nums) {
		// TODO Auto-generated constructor stub
		id = 703;
		name = "数据流中的第K大元素";
	
		
		this.k = k;
		
		this.list = new ArrayList<>(nums.length);
		
		for (int i : nums) {
			list.add(i);
		}
		
		
		Collections.sort(list, (i1, i2) -> {
			return i2 - i1;
		});
		

	}
	
    public int add(int val) {
    	list.add(val);
    	
		Collections.sort(list, (i1, i2) -> {
			return i2 - i1;
		});
		
		return this.list.get(k - 1);
    }

}
