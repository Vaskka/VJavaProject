package com.vaskka.learn.leetcode.solve;

import java.util.Hashtable;

import com.vaskka.learn.leetcode.Solve;

public class UniqueMorseRepresentations extends Solve {

	private Hashtable<Character, String> mapping;
	
	public UniqueMorseRepresentations() {
		// TODO Auto-generated constructor stub
		id = 804;
		name = "唯一的莫尔斯密码词";
	}
	
	private void initMapping() {
		mapping = new Hashtable();
		mapping.put('a', ".-");
		mapping.put('b', "-...");
		mapping.put('c', "-.-.");
		mapping.put('d', "-..");
		mapping.put('e', ".");
		mapping.put('f', "..-.");
		mapping.put('g', "--.");
		mapping.put('h', "....");
		mapping.put('i', "..");
		mapping.put('j', ".---");
		mapping.put('k', "-.-");
		mapping.put('l', ".-..");
		mapping.put('m', "--");
		mapping.put('n', "-.");
		mapping.put('o', "---");
		mapping.put('p', ".--.");
		mapping.put('q', "--.-");
		mapping.put('r', ".-.");
		mapping.put('s', "...");
		mapping.put('t', "-");
		mapping.put('u', "..-");
		mapping.put('v', "...-");
		mapping.put('w', ".--");
		mapping.put('x', "-..-");
		mapping.put('y', "-.--");
		mapping.put('z', "--..");
		
	}
	
    public int uniqueMorseRepresentations(String[] words) {
        
    	initMapping();
    	Hashtable<String, String> result = new Hashtable<>();
    	
    	for (String s : words) {
    		
    		StringBuilder sb = new StringBuilder();
    		
    		for (Character c : s.toCharArray()) {
    			sb.append(mapping.get(c));
    		}
    		
    		result.put(sb.toString(), s);
    	}
    	
    	return result.keySet().size();
    	
    }

}
