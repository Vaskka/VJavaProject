/*
javac -encoding utf-8 com/vaskka/learn/algorithm/Tree.java
java com/vaskka/learn/algorithm/Tree
*/

package com.vaskka.learn.algorithm;

import com.vaskka.learn.algorithm.Node;
import com.vaskka.learn.algorithm.NotRootNodeException;
import com.vaskka.learn.algorithm.Relatable;

public class Tree {
	//节点个数
	int nodeNum = 0;

	//root节点
	Node root = null;

	//所有的节点列表
	Node[] Nodes = null;

	//采用深度优先算法计算树的节点个数
	private void setNodeNum(Node nd) {
		this.nodeNum++;
		Node node = nd;

		if (node.hasChild() == false) {
			return;
		}


		Node[] childrenNode = node.getChildren();
		for (int i = 0; i < node.getChildren().length; i++) {
			setNodeNum(childrenNode[i]);
		}

	}

	//获得节点总个数
	public int getNodeNum() {
		return this.nodeNum;
	}

	//***Debug***打印所有节点的数据的toString()结果
	public void showNodesData(Node nd) {
		Node node = nd;

		System.out.println(node.getData().toString());

		if (!node.hasChild()) {

			return;
		}
		
		Node[] childrenNode = node.getChildren();
		for (int i = 0; i < node.getChildren().length; i++) {

			showNodesData(childrenNode[i]);
		}
	}

	//获得root节点
	public Node getRootNode() {
		return this.root;
	}

	/**
	*<p>构造Tree对象的新实例</p>
	*@param nodes     Node[]    该树中所有节点的数组(root节点需位于首位)(且经过实现了Relatable接口的类确定父子关系)
	*@param relatable Relatable 规定树中节点的父子关系
	*/
	public Tree (Node[] nodes, Relatable relatable) throws NotRootNodeException {
		relatable.setRelationship(nodes);

		if (!nodes[0].isRootNode()) {
			throw new NotRootNodeException(nodes[0], "该节点不是根节点");
		}

		this.root = nodes[0];

		//计算节点总个数
		setNodeNum(this.root);
	}


}
