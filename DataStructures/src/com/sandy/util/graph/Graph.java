package com.sandy.util.graph;

import com.sandy.util.queue.Queue;
import com.sandy.util.stack.Stack;

class Graph {
	private int n;
	private int adjacencyMatrix[][];
	Stack<Integer> s;
	Queue<Integer> q;

	public Graph(int size) {

		if (size < 2)
			n = 2;
		else
			n = size;

		s = new Stack<>();
		q = new Queue<>();

		intializeMatrix(size);
	}

	private void intializeMatrix(int size) {
		adjacencyMatrix = new int[size][size];
		for (int i = 0; i < size; ++i)
			for (int j = 0; j < size; ++j)
				adjacencyMatrix[i][j] = 0;
	}

	private boolean isConnected(int x, int y) {
		return (adjacencyMatrix[x - 1][y - 1] == 1);
	}

	public void addEdge(int x, int y) {
		adjacencyMatrix[x - 1][y - 1] = adjacencyMatrix[y - 1][x - 1] = 1;
	}

	private void DFS(int x, int required) {

		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++)
			visited[i] = false;
		s.push(x);
		visited[x - 1] = true;
		if (x == required)
			return;
		System.out.println("Depth first Search starting from vertex ");
		// cout << x << " : " << endl;
		while (!s.isEmpty()) {
			int k = s.pop();
			System.out.print(k + " ");
			for (int i = n; i > 0; --i) {
				// System.out.println(i);
				if (isConnected(k, i) && !visited[i - 1]) {
					s.push(i);
					visited[i - 1] = true;
				}
			}
		}

	}

	private void BFS(int x, int required) {

		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++)
			visited[i] = false;
		q.enQueue(x);
		visited[x - 1] = true;
		if (x == required)
			return;
		System.out.println();
		System.out.println("Breath first Search starting from vertex ");
		// cout << x << " : " << endl;
		while (!q.isEmpty()) {
			int k = q.deQueue();
			System.out.print(k + " ");
			for (int i = 1; i < n+1; i++) {
				// System.out.println(i);
				if (isConnected(k, i) && !visited[i - 1]) {
					q.enQueue(i);
					visited[i - 1] = true;
				}
			}
		}

	}

	public static void main(String[] args) {

		Graph g = new Graph(8);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(2, 6);
		g.addEdge(4, 7);
		g.addEdge(4, 8);
		g.DFS(1, 4);
		g.BFS(1, 4);
	}

}