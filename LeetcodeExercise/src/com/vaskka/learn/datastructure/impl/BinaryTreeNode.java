package com.vaskka.learn.datastructure.impl;

import com.vaskka.learn.datastructure.adt.Node;

public class BinaryTreeNode<E> implements Node<E> {

	private E value;
	
	private BinaryTreeNode<E> leftChild;
	
	private BinaryTreeNode<E> rightChild;
	
	private BinaryTreeNode<E> parentNode;
	
	public BinaryTreeNode(E value, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public E getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public BinaryTreeNode<E> getLeftChild() {
		return leftChild;
	}
	
	public BinaryTreeNode<E> getRightChild() {
		return rightChild;
	}
	
	public BinaryTreeNode<E> getParentNode() {
		return parentNode;
	}
	
	public void setLeftChild(BinaryTreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(BinaryTreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}
	
	public void setParentNode(BinaryTreeNode<E> parentNode) {
		this.parentNode = parentNode;
	}

}
