package com.vaskka.learn.datastructure.impl;

import com.vaskka.learn.datastructure.adt.Tree;

public class BinaryTree<E> implements Tree<E> {

	private BinaryTreeNode<E> root;
	
	public BinaryTree(BinaryTreeNode<E> root) {
		// TODO Auto-generated constructor stub
		this.root = root;
	}

	@Override
	public E getRoot() {
		// TODO Auto-generated method stub
		return root.getValue();
	}

}
