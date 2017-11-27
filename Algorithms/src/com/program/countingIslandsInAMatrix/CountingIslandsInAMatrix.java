package com.program.countingIslandsInAMatrix;

import com.sandy.util.Pair;
import com.sandy.util.queue.Queue;

public class CountingIslandsInAMatrix {

	private int[][] ocean = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 1, 0, 0, 1 } };

	private int row = 4;
	private int col = 4;
	private Queue<Pair<Integer>> points;

	public CountingIslandsInAMatrix() {
		points = new Queue<>();
	}

	public static void main(String[] args) {

		CountingIslandsInAMatrix c = new CountingIslandsInAMatrix();
		System.out.println(c.findIslands());

	}

	private int findIslands() {

		int islands = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (ocean[i][j] == 1) {
					ocean[i][j] = 2;
					points.enQueue(new Pair<Integer>(i, j));

					while (!points.isEmpty()) {
						Pair<Integer> point = points.deQueue();
						if (point.getX() + 1 < row && ocean[point.getX() + 1][point.getY()] == 1) {
							ocean[point.getX() + 1][point.getY()] = 2;
							points.enQueue(new Pair<Integer>(point.getX() + 1, point.getY()));
						}
						if (point.getX() - 1 >= 0 && ocean[point.getX() - 1][point.getY()] == 1) {
							ocean[point.getX() - 1][point.getY()] = 2;
							points.enQueue(new Pair<Integer>(point.getX() - 1, point.getY()));
						}
						if (point.getY() + 1 < col && ocean[point.getX()][point.getY() + 1] == 1) {
							ocean[point.getX()][point.getY() + 1] = 2;
							points.enQueue(new Pair<Integer>(point.getX(), point.getY() + 1));
						}
						if (point.getY() - 1 >= 0 && ocean[point.getX()][point.getY() - 1] == 1) {
							ocean[point.getX()][point.getY() - 1] = 2;
							points.enQueue(new Pair<Integer>(point.getX(), point.getY() - 1));
						}

					}
					islands++;
				}

			}
		}

		return islands;

	}

}
