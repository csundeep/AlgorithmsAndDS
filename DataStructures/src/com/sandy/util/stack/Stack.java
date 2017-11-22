package com.sandy.util.stack;

import com.sandy.util.doubleLinkedList.DoubleLinkedList;

public class Stack<T> {

	private DoubleLinkedList<T> dll;

	public Stack() {
		dll = new DoubleLinkedList<>();

	}

	public void push(T data) {
		dll.insertElementAtStart(data);
	}

	public T pop() {

		return dll.deleteAtTheStart();

	}

	public T peek() {
		T value = dll.deleteAtTheStart();
		if (value == null)
			return null;
		else {

			dll.insertElementAtStart(value);
			return value;
		}

	}

	public boolean isEmpty() {
		if (peek() == null)
			return true;
		return false;
	}

	public void display() {

		dll.recDisplay();

	}

	public static void main(String[] args) {

		Stack<Integer> s = new Stack<>();

		s.push(56);
		s.push(35);
		s.push(75);

		System.out.println(s.peek());
		s.display();
		System.out.println();
		s.pop();
		s.display();
		System.out.println();
		System.out.println(s.peek());

	}

}
