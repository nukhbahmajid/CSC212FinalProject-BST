package edu.smith.cs.csc212.fp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BST {
	/**
	 * The root node - start of the binary search tree
	 */
	Node root; 
	
	/**
	 * Inorder traversal by having an external list and adding to it. (Works!) 
	 */
	List<Integer> traversalList;

	public static class Node {
		/**
		 * The number to be stored inside a particular Node as a key: 
		 */
		int key;
		/**
		 * Left child of this Node - left child must contain a key smaller than its parent key
		 */
		Node left;
		/**
		 * Right child of this Node - right child must contain a key bigger than its parent key
		 */
		Node right;
		
		public Node(int item) {
			this.key = item;
			this.left = this.right = null;
		}
		/**
		 * Is this node a "leaf" - one of the terminal nodes of the tree?
		 */
		public boolean isLeaf() {
			if(this.right == null && this.left == null) {
				return true;
			} else {
				return false;
			}
		}
		
	}
	
	public BST() {
		/**
		 * Initialize an empty BST
		 */
		this.root = null;
		this.traversalList = new ArrayList<>();
	}
	
	public void insert(int key) {
		root = recursiveInsert(root, key);
	}
	
	/**
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
	
	/**
	 * In order traversal of the Binary Search Tree - private version. 
	 */
	private void inOrderTraversal(Node root) {
		
		if(root != null) {
			inOrderTraversal(root.left);
			this.traversalList.add(root.key);
			System.out.println(root.key);
			inOrderTraversal(root.right);
		} 
		
	}
	
	/**
	 * In order traversal of the Binary Search Tree - public version.
	 */
	public List<Integer> orderedTraversal(Node node) {
		this.traversalList = new ArrayList<>();
		inOrderTraversal(node);
		return this.traversalList;
	}
	
	/**
	 * Search for the int provided as argument in the method statement.
	 */
	public boolean searchKey(int isKey) {
		Node foundNode = searchRecursive(this.root, isKey);
		
		if(foundNode == null || foundNode.key != isKey) {
			System.out.println("Did not find a node containing the key " + isKey + ".");
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Search that is called recursively, by a private method: 
	 */
	private Node searchRecursive(Node root, int isKey) {
		if(root == null || root.key == isKey) {
			return root;
		}
		
		if(root.key > isKey) {
			searchRecursive(root.left, isKey);
		}
		
		return searchRecursive(root.right, isKey);
	}
	
	/**
	 * Get the minimum key stored in this BST - the floor. 
	 */
	public Integer getFloor() {
		if(this.root == null) {
			return null;
		} else {
			Node leftMost = this.root;
			while(leftMost.left != null) {
				leftMost = leftMost.left;
			}
			return leftMost.key;
		}
	}
	

	/**
	 * Get the maximum key stored in this BST - the ceiling. 
	 */
	public Integer getCeiling() {
		if(this.root == null) {
			return null;
		} else {
			Node rightMost = this.root;
			while(rightMost.right != null) {
				rightMost = rightMost.right;
			}
			return rightMost.key;
		}
	}
	
	/**
	 * Get the root node of this BST 
	 */
	public Integer getRoot() {
		if(this.root == null) {
			System.out.println("Error: The tree is empty!");
			return null;
		} else {
			return this.root.key;
		}
	}
	
	/**
	 * Get the key with the minimum value in a given subtree - assist method for deletion
	 */
	public int getMinFromSubtree(Node subtreeStart) {
		int minKey = subtreeStart.key;
		while(subtreeStart.left != null) {
			minKey = subtreeStart.left.key;
			subtreeStart = subtreeStart.left;
		}
		return minKey; 
	}
	
	/**
	 * Delete a node with the key in the BST.
	 */
	public void deleteKey(int key) {
		// This key does not exist in this BST
		if(this.searchKey(key) == false) {
			System.out.println("The tree doesn't contain the key:" + key);
		} else {
			// This key is present in this BST
			root = deleteRecursive(root, key);
			
		}

	}
	
	/**
	 * Private recursive method to get the Node containing the key to be deleted. - INCOMPLETE
	 */
	private Node deleteRecursive(Node root, int key) {
		return root;
	}
	

}
