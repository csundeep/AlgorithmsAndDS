package com.sandy.util.singleLinkedList;

import com.sandy.util.Node;

public class SingleLinkedList<T> {

	private Node<T> root;
	private Node<T> end;

	public void insertAtTheEnd(T data) {
		Node<T> newNode = new Node<>(data);
		if (root == null) {
			root = newNode;
			end = newNode;
		} else {
			Node<T> curr = end;
			curr.setNextNode(newNode);
			end = newNode;

		}

	}

	public void insertElementAtStart(T data) {
		Node<T> newNode = new Node<>(data);
		if (root == null) {
			root = newNode;
			end = newNode;
		} else {
			newNode.setNextNode(root);
			root = newNode;

		}

	}

	// public Integer deleteAtTheEnd() {
	// if (root == null) {
	// return null;
	// } else {
	// Node curr = end;
	// curr.setNextNode(newNode);
	// end = newNode;
	//
	// }
	//
	// }

	public T deleteElementAtStart() {
		if (root == null) {
			return null;
		} else {
			Node<T> deletedNode = root;

			return deletedNode.getData();

		}

	}

	public void createLinkedList(T[] input) {
		for (T data : input) {
			insertAtTheEnd(data);
		}

	}

	public void displayList() {
		Node<T> curr = root;
		if (curr == null) {
			System.out.println("List is Empty");
			return;
		}

		do {

			System.out.print(curr.getData() + "  ");
			curr = curr.getNextNode();

		} while (curr != null);

	}

	public void recDisplay() {

		if (root == null) {
			System.out.println("List is Empty");

			return;
		}
		Node<T> curr = root;
		recursiveDisplay(curr);

	}

	private void recursiveDisplay(Node<T> curr) {
		if (curr == null)
			return;
		System.out.print(curr.getData() + "  ");
		recursiveDisplay(curr.getNextNode());
	}

	public static void main(String[] args) {

		SingleLinkedList<Integer> sll = new SingleLinkedList<>();
		Integer input[] = { 5, 9, 89, 56, 23, 45, 12, 78 };

		sll.createLinkedList(input);
		sll.insertElementAtStart(35);

		sll.recDisplay();

	}

}
