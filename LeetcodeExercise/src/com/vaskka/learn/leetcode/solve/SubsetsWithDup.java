package com.vaskka.learn.leetcode.solve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.vaskka.learn.leetcode.Solve;

public class SubsetsWithDup extends Solve {

	public SubsetsWithDup() {
		// TODO Auto-generated constructor stub
		id = 90;
		name = "子集";
	}

	private HashSet<List<Integer>> getSubset(int[] nums, int startIndex, int endIndex) {
		if (endIndex == 0) {
			// {1}
			List<Integer> phi = new ArrayList<>();
			phi.add(nums[0]);
			HashSet<List<Integer>> phiResult = new HashSet<>();
			phiResult.add(phi);
			
			return phiResult;
		}
		
		int endEle = nums[endIndex];
		HashSet<List<Integer>> resultSubSubset = getSubset(nums, startIndex, endIndex - 1);
		
		HashSet<List<Integer>> temp = new HashSet<>();
		
		// 复制原有全部子集
		for (List<Integer> subTemp : resultSubSubset) {
			List<Integer> newSubTemp = new ArrayList<>();
			
			for (int i : subTemp) {
				newSubTemp.add(i);
			}
			temp.add(newSubTemp);
		}
		
		// 加空集
		List<Integer> phi = new ArrayList<>();
		resultSubSubset.add(phi);
		
		// 加新的子集
		for (List<Integer> subsetEle : resultSubSubset) {
			subsetEle.add(endEle);
		}
		
		
		// 加上自身
		resultSubSubset.addAll(temp);
		
		return resultSubSubset;
	}
	
	
	private boolean listEqual(List<Integer> l1, List<Integer> l2) {
		if (l1.size() != l2.size()) {
			return false;
		}
		
		Collections.sort(l1);
		Collections.sort(l2);
		
		for (int i = 0; i < l1.size(); i++) {
			if (l1.get(i) != l2.get(i)) {
				return false;
			}
		}
		
		return true;
	}
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	HashSet<List<Integer>> resultHashSet = getSubset(nums, 0, nums.length - 1);
    	resultHashSet.add(new ArrayList<>());
    	
    	List<List<Integer>> result = new ArrayList<>();
    	
    	for (List<Integer> l : resultHashSet) {
    		boolean flag = false;
    		for (List<Integer> rl : result) {
    			if (listEqual(l, rl)) {
    				flag = true;
    			}
    			
    		}
    		
    		if (!flag) {
    			result.add(l);
    		}
    	}
    	
    	return result;
    }

}
