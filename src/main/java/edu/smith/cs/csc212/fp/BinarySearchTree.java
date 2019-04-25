package edu.smith.cs.csc212.fp;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	//number of nodes contained in Binary Search Tree
	public int size;
	
	Node root;
	
	public class Node {
		//the key stored in a node
		int key;
		//left node
		Node left;
		//right node
		Node right;
		
		public Node(int x) {
			this.key = x;
			this.left = null;
			this.right = null;
		}
	}
	
	public BinarySearchTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null; 
	}
	
	public int size() {
		int count = 0;
		if (root != null) {
			count ++;
			
		}
		
		return size;
	}
	
	public void insert(int x) {
		root = RecurAdd(root, x);
	}
	
	public Node RecurAdd(Node root, int input) {
		if (root == null) {
			root = new Node(input);
			return root;
		}
		
		if (input <= root.key) {
			root.left = RecurAdd(root.left, input);
		}
		else if (input > root.key) {
			root.right = RecurAdd(root.right, input);
		}
		
		return root;
		
	}
	
	public void remove(int x) {
		
	}
	
	public Node RecurRemove(Node root, int input) {
		return root;
		
	}
	
	
	public List<Integer> RecurInOrderTraversal(Node root){
		List<Integer> InOrder = new ArrayList<>();
		
		if (root != null) {
			RecurInOrderTraversal(root.left);
			InOrder.add(root.key);
			RecurInOrderTraversal(root.right);
		}
		
		return InOrder;
	}
	
}
