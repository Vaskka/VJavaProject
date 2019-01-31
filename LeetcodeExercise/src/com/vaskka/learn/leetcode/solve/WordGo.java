package com.vaskka.learn.leetcode.solve;

import java.util.*;

class Node {

	// 自身index
	int id;
	String data;
	
	// 当前邻居index
	int neighborIndex;
	
	// 邻居表
	int[] neighbors;
	
	
	Node(int id, String s, int[] neighbor) {
		data = s;
		this.neighbors = neighbor;
		this.id = id;
		
		this.neighborIndex = 0;
	}
	
	// 添加一个邻居
	void addNeighbor(Node n) {
		neighbors[neighborIndex] = n.id;
		neighborIndex++;
	}
	
	Node() {} 
}

public class WordGo {

	// 全部结点表
	Node[] nodes;
	
	// 是否已经检查过
	boolean[] visited;
	
	int min;
	
	boolean done;
	
	private void dfs(Node root, String end, int curr) {

		System.out.println("data:" + root.data);
		System.out.println("curr:" + String.valueOf(curr));
		System.out.println("-------------------");
		
		if (root.data == end) {
//			done = true;
			if (min < curr && min != -1) 
				return;
			else {
				min = curr;
				return;
			}
		}
		
		visited[root.id] = true;
		
		// 递归检查自己的邻居
		for (int i : root.neighbors) {
			if (!visited[i]) {
				dfs(nodes[i], end, curr + 1);
			}
		}
		
	}
	
	// check can be a neighbor
	private boolean stat(String s1, String s2) {
		int sum = 0;
		for (char c : s1.toCharArray()) {
			for (char cc : s2.toCharArray()) {
				if (cc == c) {
					sum++;

					if (sum == s1.length() - 1) {
						// System.out.println(s1 + " get " + s2);
						return true;
					}
					break;
				}
			}
		}
		
		return false;
		
	}
	
	// solve
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	
    	// init
    	nodes = new Node[wordList.size() + 1];
    	
    	for (int i = 1; i < nodes.length; i++) {
    		nodes[i] = new Node();
    		nodes[i].id = i;
    		nodes[i].data = wordList.get(i - 1);
    		nodes[i].neighbors = new int[wordList.size()];
    	}
    	
    	// nodes[0] be set beginWord
    	nodes[0] = new Node(0, beginWord, new int[wordList.size() - 1]);
    	
    	// 建树
    	for (int i = 0; i < nodes.length; i++) {
    		for (int j = i + 1; j < nodes.length; j++) {
    			// 检查是否可以做邻居
    			if (stat(nodes[i].data, nodes[j].data)) {
    				nodes[i].addNeighbor(nodes[j]);
    				nodes[j].addNeighbor(nodes[i]);
    				
    			}
    		}
    	}
    	
    	// dfs
    	visited = new boolean[wordList.size() + 1];
    	min = -1;
    	done = false;
    	dfs(nodes[0], endWord, 1);
    	
    	System.out.print(min);
    	return min;
    }
}
