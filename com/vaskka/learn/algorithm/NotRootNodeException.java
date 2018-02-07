/*
javac -encoding utf-8 com/vaskka/learn/algorithm/NodeFormatException.java
java com/vaskka/learn/algorithm/NodeFormatException
*/

package com.vaskka.learn.algorithm;

import com.vaskka.learn.algorithm.Node;
/**
*节点格式异常
*
*/
public class NodeFormatException extends Exception {

	Node exceptionNode = null;

	public NodeFormatException(Node exceptionNode, String message) {
		super(message);
		this.exceptionNode = exceptionNode;
	}

	public Node getExceptionNode() {
		return exceptionNode;
	}
}
