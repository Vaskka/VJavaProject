package com.vaskka.learn.test;

import com.vaskka.learn.algorithm.Node;
import com.vaskka.learn.algorithm.Tree;
import com.vaskka.learn.algorithm.NotRootNodeException;
import com.vaskka.learn.algorithm.NodeFormatException;
import com.vaskka.learn.algorithm.Relatable;

@SuppressWarnings(value={"unchecked"})
class TreeTest {

	static Node<String> A = new Node(true, "A");
	static Node<String> B = new Node(false, "B");
	static Node<String> C = new Node(false, "C");
	static Node<String> D = new Node(false, "D");
	static Node<String> E = new Node(false, "E");
	static Node<String> F = new Node(false, "F");
	static Node<String> G = new Node(false, "G");
	static Node<String> H = new Node(false, "H");


	public static void main(String[] args) {

		Node[] nodes = {A, B, C, D, E, F, G, H};
		
		try {
			Tree myTree = new Tree(nodes, new Relatable() {

				public void setRelationship(Node[] nodes) {
					Node[] children = new Node[2];
					children[0] = B;
					children[1] = C;
					A.setChildren(children);
					for (int i = 0; i < children.length; i++) {
						children[i].setFather(A);
					}

					children = new Node[2];
					children[0] = D;
					children[1] = E;
					B.setChildren(children);
					for (int i = 0; i < children.length; i++) {
						children[i].setFather(B);
					}

					children = new Node[3];
					children[0] = F;
					children[1] = G;
					children[2] = H;
					C.setChildren(children);
					for (int i = 0; i < children.length; i++) {
						children[i].setFather(C);
					}
				}
			});
			myTree.showNodesData(myTree.getRootNode());
			System.out.println(myTree.getNodeNum());
		}
		catch (NotRootNodeException e) {
			System.out.println(e.getMessage());
		}
		
		

	}
}
