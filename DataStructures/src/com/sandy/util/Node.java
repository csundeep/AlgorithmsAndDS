package com.sandy.util;

public class Node<T> {

	private T data;
	private Node<T> nextNode;
	private Node<T> prevNode;

	public Node(T data) {
		super();
		this.data = data;
	}

	public Node(T data, Node<T> nextNode) {
		super();
		this.data = data;
		this.nextNode = nextNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public Node<T> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node<T> prevNode) {
		this.prevNode = prevNode;
	}

}
