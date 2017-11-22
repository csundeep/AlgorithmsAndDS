package com.sandy.util.doubleLinkedList;

import com.sandy.util.Node;

public class DoubleLinkedList<T> {

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
			newNode.setPrevNode(curr);
			end = newNode;

		}

	}

	public Node<T> getRoot() {
		return root;
	}

	public Node<T> getEnd() {
		return end;
	}

	public void insertElementAtStart(T data) {
		Node<T> newNode = new Node<T>(data);
		if (root == null) {
			root = newNode;
			end = newNode;
		} else {
			newNode.setNextNode(root);
			root.setPrevNode(newNode);
			root = newNode;

		}

	}

	public T deleteAtTheEnd() {
		if (root == null) {
			return null;
		} else {
			Node<T> deletedNode = end;
			end = deletedNode.getPrevNode();

			if (end != null)
				end.setNextNode(null);
			else
				root = null;

			deletedNode.setPrevNode(null);
			return deletedNode.getData();
		}

	}

	public T deleteAtTheStart() {
		if (root == null) {
			return null;
		} else {
			Node<T> deletedNode = root;
			root = deletedNode.getNextNode();

			if (root == null)
				end = null;
			else
				root.setPrevNode(null);

			deletedNode.setNextNode(null);
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

	public void recDisplayReverse() {
		if (root == null) {
			System.out.println("List is Empty");

			return;
		}
		Node<T> curr = end;
		recursiveDisplayReverse(curr);

	}

	private void recursiveDisplayReverse(Node<T> curr) {
		if (curr == null)
			return;
		System.out.print(curr.getData() + "  ");
		recursiveDisplayReverse(curr.getPrevNode());
	}

	public static void main(String[] args) {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
		Integer input[] = { 5, 9, 89, 56, 23, 45, 12, 78 };

		dll.createLinkedList(input);

		dll.insertElementAtStart(47);

		dll.recDisplay();

		System.out.println();
		System.out.println("Deleted element is " + dll.deleteAtTheStart());
		dll.recDisplay();

		System.out.println();
		System.out.println("Deleted element is " + dll.deleteAtTheEnd());
		dll.recDisplay();
		System.out.println();

	}

}
