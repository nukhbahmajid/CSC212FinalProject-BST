package edu.smith.cs.csc212.fp;

import java.util.ArrayList;
import java.util.List;

public class BST {
	/*
	 * The root node - start of the binary search tree
	 */
	Node root; 

	public static class Node {
		/*
		 * The number to be stored inside a particular Node as a key: 
		 */
		int key;
		/*
		 * Left child of this Node - left child must contain a key smaller than its parent key
		 */
		Node left;
		/*
		 * Right child of this Node - right child must contain a key bigger than its parent key
		 */
		Node right;
		
		public Node(int item) {
			this.key = item;
			this.left = this.right = null; 
		}
		
	}
	
	public BST() {
		/*
		 * Initialize an empty BST
		 */
		this.root = null;
	}
	
	public void insert(int key) {
		root = recursiveInsert(root, key);
	}
	
	/*
	 * Recursively insert the int by going down the tree and checking for the right placement
	 */
	private Node recursiveInsert(Node root, int key) {
		if(root == null) {
			root = new Node(key);
			return root;
		}
		if(root.key > key) {
			root.left = recursiveInsert(root.left, key);
		} else if(root.key < key) {
			root.right = recursiveInsert(root.right, key);
		}
		return root;
	}
	
	/*
	 * In order traversal of the Binary Search Tree
	 */
	public List<Integer> inOrderTraversal(Node root) {
		List<Integer> treeAsList = new ArrayList<>();
		
		if(root != null) {
			inOrderTraversal(root.left);
			treeAsList.add(root.key);
			System.out.println(root.key);
			inOrderTraversal(root.right);
		}
		return treeAsList;
	}

}
