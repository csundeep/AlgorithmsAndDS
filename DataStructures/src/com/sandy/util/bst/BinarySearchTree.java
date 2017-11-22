package com.sandy.util.bst;

import com.sandy.util.TreeNode;
import com.sandy.util.queue.Queue;
import com.sandy.util.stack.Stack;

public class BinarySearchTree {

	private static TreeNode root;
	private Stack<TreeNode> stack;
	private Queue<TreeNode> queue;

	public BinarySearchTree() {
		stack = new Stack<>();
		queue = new Queue<>();
	}

	private void createBST(int[] input) {
		for (int data : input) {

			insert(data);

		}

	}

	private void insert(int data) {

		TreeNode newNode = new TreeNode(data);

		if (root == null) {
			root = newNode;
		} else {

			TreeNode curr = root;
			while (true) {
				TreeNode parent = curr;
				if (data > curr.getData()) {
					curr = curr.getRight();
					if (curr == null) {
						parent.setRight(newNode);
						return;
					}

				} else {
					curr = curr.getLeft();

					if (curr == null) {
						parent.setLeft(newNode);
						return;
					}
				}

			}

		}

	}

	private void inOrder(TreeNode p) {
		if (p.getLeft() != null)
			inOrder(p.getLeft());
		System.out.print(p.getData() + " ");
		if (p.getRight() != null)
			inOrder(p.getRight());
	}

	private void preOrder(TreeNode p) {
		System.out.print(p.getData() + " ");
		if (p.getLeft() != null)
			preOrder(p.getLeft());
		if (p.getRight() != null)
			preOrder(p.getRight());
	}

	private void postOrder(TreeNode p) {
		if (p.getLeft() != null)
			postOrder(p.getLeft());
		if (p.getRight() != null)
			postOrder(p.getRight());
		System.out.print(p.getData() + " ");
	}

	private void bfs() {

		if (root != null)
			queue.enQueue(root);
		else
			return;

		TreeNode node;
		while ((node = queue.deQueue()) != null) {
			System.out.print(node.getData() + " ");

			if (node.getLeft() != null)
				queue.enQueue(node.getLeft());

			if (node.getRight() != null)
				queue.enQueue(node.getRight());

		}

	}

	private void dfs() {
		if (root != null)
			stack.push(root);
		else
			return;
		TreeNode node;
		Queue<TreeNode> queue = new Queue<>();
		while ((node = stack.pop()) != null) {
			queue.enQueue(node);

			if (node.getRight() != null)
				stack.push(node.getRight());

			if (node.getLeft() != null)
				stack.push(node.getLeft());

		}

		while ((node = queue.deQueue()) != null) {
			System.out.print(node.getData() + " ");
		}

	}

	static int sumOfLeafNodes, sumOfRightLeafNodes;

	private void sumOfLeafNodes(TreeNode curr) {

		if (curr == null)
			return;
		if (curr.getLeft() == null && curr.getRight() == null)
			sumOfLeafNodes += curr.getData();

		sumOfLeafNodes(curr.getLeft());
		sumOfLeafNodes(curr.getRight());

	}

	private void sumOfRightLeafNodes(TreeNode curr) {

		if (curr == null)
			return;

		if (curr.getRight() != null)
			if (curr.getRight().getLeft() == null && curr.getRight().getRight() == null)
				sumOfRightLeafNodes += curr.getRight().getData();

		sumOfRightLeafNodes(curr.getLeft());
		sumOfRightLeafNodes(curr.getRight());

	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		int input[] = { 12, 78, 5, 2, 9, 89, 56,65, 23,15, 45 };
		bst.createBST(input);
		System.out.println("InOrder Traversel: ");
		bst.inOrder(root);
		System.out.println();
		System.out.println("Pre Order Traversel: ");
		bst.preOrder(root);
		System.out.println();
		System.out.println("Post Order Traversel: ");
		bst.postOrder(root);
		System.out.println();
		System.out.println("Level Order or breath first Traversel: ");
		bst.bfs();
		System.out.println();
		System.out.println("Depth first Traversel: ");
		bst.dfs();
		System.out.println();
		TreeNode curr = root;
		bst.sumOfLeafNodes(curr);
		System.out.println("Sum of Leaf Nodes : " + sumOfLeafNodes);
		System.out.println();
		curr = root;
		bst.sumOfRightLeafNodes(curr);
		System.out.println("Sum of Right Leaf Nodes : " + sumOfRightLeafNodes);

	}

}
