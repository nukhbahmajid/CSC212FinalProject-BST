package edu.smith.cs.csc212.fp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinarySearchTree {
	/**
	 * number of nodes contained in Binary Search Tree
	 */
	public int size;
	
	/**
	 * The root node - start of the binary search tree
	 */
	Node root;

	/**
	 * the node in bst can have a maximum of two children and one key value stored
	 * in it
	 * @author jialinzhang
	 *
	 */
	public class Node {
		/**
		 * the value that is stored in a node
		 */
		int key;
		
		/**
		 * left child of a node - the key value should be smaller than its parent value
		 */
		Node left;
		
		/**
		 * right child of a node - the key value should be larger than its parent value
		 */
		Node right;
		
		/**
		 * construct a new node
		 * @param x - the key value stored in the node
		 */
		public Node(int x) {
			this.key = x;
			this.left = null;
			this.right = null;
		}
		
	}
	
	/**
	 * initialize an empty binary search tree
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * determine whether the binary search tree is empty or not
	 * @return - the boolean if the root is null or not
	 */
	public boolean isEmpty() {
		return root == null; 
	}
	
	/**
	 * determine whether the node is a leaf node (doesn't have any children) or not
	 * @param node - the node we want to know whether it's a leaf or not
	 * @return - the boolean if the node is a leaf or not
	 */
	public boolean isLeaf(Node node) {
		return node.left == null && node.right == null;	
	}
	
	/**
	 * the number of nodes inside the bst
	 * @return - the size
	 */
	public int size() {
		Set<Integer> output = ListNodes(root);
		return output.size();
	}
	
	/**
	 * get the minimum key stored in this BST
	 * @return - the minimum key
	 */
	public Integer findMin() {
		if (this.root == null) {
			return null;
		}
		Node currentNode = this.root;
		
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return (currentNode.key);
	}
	
	/**
	 * get the maximum key stored in this BST
	 * @return - the maximum key
	 */
	public Integer findMax() {
		if (this.root == null) {
			return null;
		}
		Node currentNode = this.root;
		
		while (currentNode.right != null) {
			currentNode = currentNode.right;
		}
		return (currentNode.key);
	}
	
	/**
	 * get the root node of this BST 
	 * @return - the key of the root node
	 */
	public Integer getRoot() {
		if(this.root == null) {
			System.out.println("Error: The tree is empty!");
			return null;
		} 
		
		else {
			return this.root.key;
		}
	}
	
	/**
	 * call the recursive listNodes method to get list of nodes this is under the
	 * node we take in
	 * @param node - the root of the (sub)tree that we want to loop over
	 * @return - a set of nodes that are under the node we take in
	 */
	public Set<Integer> ListNodes(Node node) {
		Set<Integer> listOfNodes = new HashSet<>();
		RecurListNodes(node, listOfNodes);
		return listOfNodes;
	}
	
	/**
	 * loop over every node in the tree and add them to a set
	 * @param root - the node we're currently at
	 * @param output - a set of nodes in the (sub)tree
	 */
	private void RecurListNodes(Node root, Set<Integer> output) {
		if (root != null) {
			RecurListNodes(root.left, output);
			output.add(root.key);
			RecurListNodes(root.right, output);
		}
	}
	
	/**
	 * call the recursive insert method
	 * @param x - the key value that we want to insert
	 */
	public void insert(int x) {
		root = RecurAdd(root, x);
	}
	
	/**
	 * insert the node recursively
	 * @param root - the node we're currently at
	 * @param input - the key value that we want to insert
	 * @return - the node we insert into the BST
	 */
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
	
	/**
	 * find the right leftmost node so that we can use it to replace the node we delete
	 * @param node - the node that we want to be replaced by the successor
	 * @return - the right leftmost child of the node
	 */
	private Node successor(Node node) {
		Node successor = node.right;
		
		while (successor.left != null) {
			successor = successor.left;
		}
		return successor;
	}
	
	/**
	 * call the recursive remove method
	 * @param x - the key value that we want to remove
	 */
	public void remove(int x) {
		root = RecurRemove(root, x);
	}
	
	/**
	 * find the node that needs to be deleted recursively and then delete the node
	 * once we found that
	 * @param root - the node we're currently at
	 * @param x - the key value that we want to delete
	 * @return - the node that we need to delete
	 */
	private Node RecurRemove(Node root, int x) {
		//if the tree is empty (base case)
		if (root == null) {
			return root;
		}
		
		//keep finding the key recursively
		if (root.key < x) {
			root.right = RecurRemove(root.right, x);
		}
		
		else if (root.key > x) {
			root.left = RecurRemove(root.left, x);
		}
		
		else {
			//if the node we want to delete is a leaf
			if (isLeaf(root)) {
				root = null;
				return root;
			}
			
			//if the node has only right child
			else if (!isLeaf(root) && root.left == null) {
				//then we replace the node with its right child
				root.key = root.right.key;
				//delete its right child
				root.right = null;
				return root;
			}
			
			//if the node has only left child
			else if (!isLeaf(root) && root.right == null) {
				//then we replace the node with its left child
				root.key = root.left.key;
				//delete its left child
				root.left = null;
				return root;
			}
			
			//if the node has two children
			else if (!isLeaf(root) && root.left != null && root.right != null) {
				//then we replace the node with its right node's leftmost child 
			    Node successor = successor(root);
				root.key = successor.key;
				//delete that child
				successor = null;
			}
			
		}
		
		return root;
		
	}
	
	/**
	 * call the recursive searching method
	 * @param input - the key value want to search
	 * @return - whether the value is in the tree or not
	 */
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
	
	/**
	 * search the input value recursively
	 * @param root - the start node of the recursive searching
	 * @param input - the key value want to search
	 * @return - the node that we want to find
	 */
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
	
	/**
	 * In order traversal of the BST
	 * @param root - the start node of the traversal
	 */
	public void RecurInOrderTraversal(Node root){
		if (root != null) {
			RecurInOrderTraversal(root.left);
			System.out.println(root.key);
			RecurInOrderTraversal(root.right);
		}
		
	}
	
}
