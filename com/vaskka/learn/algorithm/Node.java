/*
javac -encoding utf-8 com/vaskka/learn/algorithm/Node.java
java com/vaskka/learn/algorithm/Node
*/

package com.vaskka.learn.algorithm;

import com.vaskka.learn.algorithm.NodeFormatException;

public class Node<T> {
	//是否是根节点
	boolean isRoot = false;
	
	//子节点个数
	int childNum = 0;
	
	//子节点
	Node[] children = null;
	
	//父节点
	Node father = null;

	//节点数据
	T data;

	public Node(boolean isRoot, T data) {
		this.isRoot = isRoot;
		this.data = data;

	}

	public boolean isRootNode() {
		return isRoot;
	}

	public int getChildNum() {
		return childNum;
	}

	public Node[] getChildren() {
		return children;
	}

	public Node getFather() {
		return father;
	}

	public T getData() {
		return data;
	}

	public boolean hasChild() {
		if (this.childNum == 0) {
			return false; 
		}
		else {
			return true;
		}
	}

	public boolean hasChild(Node cld) {
		if (cld.getFather() == null) {
			return false;
		}

		if (cld.getFather().equals(this)) {
			return true;
		}
		else {
			return false;
		}
	}

	public void setFather(Node father) {
		this.father = father;
	}

	public void setChildren(Node[] children) {
		this.children = children;
		this.childNum = children.length;
	}
} 
