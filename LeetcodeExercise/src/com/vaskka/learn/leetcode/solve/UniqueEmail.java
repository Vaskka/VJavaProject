package com.vaskka.learn.leetcode.solve;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import com.vaskka.learn.leetcode.Solve;

public class UniqueEmail extends Solve {
	public UniqueEmail() {
		id = 929;
		name = "独特的Email";
	}
	
	/**
	 * 处理点
	 * @param s
	 * @return String 
	 */
	private String stripPoint(String s) {
		StringBuilder sb = new StringBuilder();
		
		for (char c : s.toCharArray()) {
			if (c != '.') {
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 处理加号后面省略
	 * @param s
	 * @return String
	 */
	private String stripPlus(String s) {
		StringBuilder sb = new StringBuilder();
		
		for (char c : s.toCharArray()) {
			 if (c != '+') {
				 sb.append(c);
			 }
			 else {
				 break;
			 }
		}
		
		return sb.toString();
	}
	
	/**
	 * 返回本地名称
	 * @param s
	 * @return String 
	 */
	private String getFrontName(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c != '@') {
				sb.append(c);
			}
			else {
				break;
			}
			
		}
		
		return sb.toString();
	}
	
	/**
	 * 返回域名
	 * @param s
	 * @return String 
	 */
	private String getBackName(String s) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = s.toCharArray().length - 1; i >=0 ; i--) {
			char c = s.toCharArray()[i];
			if (c != '@') {
				sb.insert(0, c);
			}
			else {
				break;
			}
			
		}
		
		return sb.toString();
		
	}
	
	
    public int numUniqueEmails(String[] emails) {

    	
        List<String> list = new ArrayList();
        for (String s : emails) {
        	String front = getFrontName(s);
        	String back = getBackName(s);
        	
        	String afterFront = stripPlus(front).replaceAll(".", "");
        	
        	String newString = afterFront + back;
        	
        	boolean flag = true;
        	for (String ele : list) {
        		if (ele.equals(newString)) {
        			flag = false;
        			break;
        		}
        	}
        	
        	if (flag) {
        		list.add(newString);
        	}
        	
        }
    	
    	return list.size();
    }
}
