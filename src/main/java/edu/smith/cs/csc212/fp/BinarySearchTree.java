package edu.smith.cs.csc212.fp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinarySearchTree {
	//number of nodes contained in Binary Search Tree
	public int size;
	
	Node root;
	
	//a set of all nodes in the tree
	Set<Integer> listOfNodes;
	
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
		this.listOfNodes = new HashSet<>();
	}
	
	public boolean isEmpty() {
		return root == null; 
	}
	
	public boolean isLeaf(Node node) {
		return node.left == null && node.right == null;	
	}
	
	public int size() {
		Set<Integer> output = ListNodes(root);
		return output.size();
	}
	
	public Set<Integer> ListNodes(Node node) {
		Set<Integer> listOfNodes = new HashSet<>();
		RecurListNodes(node, listOfNodes);
		return listOfNodes;
	}
	
	private void RecurListNodes(Node root, Set<Integer> output) {
		
		if (root != null) {
			RecurListNodes(root.left, output);
			output.add(root.key);
			RecurListNodes(root.right, output);
		}
	}
	
	public void insert(int x) {
		root = RecurAdd(root, x);
	}
	
	private Node RecurAdd(Node root, int input) {
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
	
	//find the right second leftmost node so that we can use it to replace the node we delete
	private Node successor(Node node) {
		Node successor = node.right;
		while (successor.left != null) {
			successor = successor.left;
		}
		return successor;
	}
	
	public void remove(int x) {
		root = RecurRemove(root, x);
	}
	
	private Node RecurRemove(Node root, int x) {
	
		if (root == null) {
			return root;
		}
		
		if (root.key < x) {
			root.right = RecurRemove(root.right, x);
		}
		
		else if (root.key > x) {
			root.left = RecurRemove(root.left, x);
		}
		
		else {
			if (isLeaf(root)) {
				root = null;
				return root;
			}
			
			else if (!isLeaf(root) && root.left == null) {
				root.key = root.right.key;
				root.right = null;
				return root;
			}
			
			else if (!isLeaf(root) && root.right == null) {
				root.key = root.left.key;
				root.left = null;
				return root;
			}
			
			else if (!isLeaf(root) && root.left != null && root.right != null) {
				Node successor = successor(root);
				root.key = successor.key;
				//root.right = RecurRemove(root.right, successor(root).key);
				successor = null;
			}
			
		}
		
		return root;
		
	}
	
	public boolean search(int input) {
		Node SearchResult = RecurSearch(root, input);
		if (SearchResult == null) {
			return false;
		}
		else if (SearchResult.key == input) {
			return true;
		}
		return true;
	}
	
	private Node RecurSearch(Node root, int input) {
		if (root == null || root.key == input) {
			return root;
		}
		
		else {
			if (input <= root.key) {
				return RecurSearch(root.left, input);
			}
			
			else {
				return RecurSearch(root.right, input);
			}
		}
	}
	
	public void RecurInOrderTraversal(Node root){
		
		if (root != null) {
			RecurInOrderTraversal(root.left);
			System.out.println(root.key);
			RecurInOrderTraversal(root.right);
		}
		
	}
	
}
