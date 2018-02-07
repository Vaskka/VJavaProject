/*
javac -encoding utf-8 com/vaskka/learn/algorithm/Relatable.java
java com/vaskka/learn/algorithm/Relatable
*/

package com.vaskka.learn.algorithm;

import com.vaskka.learn.algorithm.Node;

//定义树中全部节点之间的父子关系
public interface Relatable {
	/**
	*<p>树中节点的父子关系</p>
	*@param nodes Node[] 待定义的节点数组
	*/
	public void setRelationship(Node[] nodes);
} 

