package com.sandy.util.queue;

import com.sandy.util.doubleLinkedList.DoubleLinkedList;

public class Queue<T> {
	DoubleLinkedList<T> dll;

	public Queue() {
		dll = new DoubleLinkedList<>();

	}

	public void enQueue(T data) {
		dll.insertElementAtStart(data);
	}

	public T deQueue() {

		return dll.deleteAtTheEnd();

	}

	public void display() {

		dll.recDisplayReverse();

	}

	public T peek() {
		T value = dll.deleteAtTheEnd();
		if (value == null)
			return null;
		else {
			dll.insertAtTheEnd(value);
			return value;
		}

	}

	public boolean isEmpty() {
		if (peek() == null)
			return true;
		return false;
	}

	public static void main(String[] args) {

		Queue<Integer> q = new Queue<>();

		q.enQueue(56);
		q.enQueue(35);
		q.enQueue(75);
		q.deQueue();
		q.display();
		System.out.println();
		System.out.println(q.peek());

	}
}
