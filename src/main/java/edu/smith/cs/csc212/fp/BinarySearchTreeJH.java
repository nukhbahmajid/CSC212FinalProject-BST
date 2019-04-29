package edu.smith.cs.csc212.fp;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeJH {

	public Node root;
	public Node leaf;
	
	public BinarySearchTreeJH() {
		this.root = null;
	}
	
	public int size; //size
	//t is 2
	//at least 1 key and at most 3 keys
	
	//return size
	public int size() {
		return size;
	}
	
	//check to see if node is empty
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//check to see if it's a leaf
	public boolean isLeaf(Node leaf) {
		if (leaf == null) {
			return false;
		}
		if (leaf.leftchild == null && leaf.rightchild == null) {
			return true;
		}
		return isLeaf(leaf);
	}
	
	//Node class
	public class Node {
		int key;
		
		Node leftchild;
		Node rightchild;

		//public List<Node> links = new ArrayList<Node>();
		//public List<Key> key = new ArrayList<Key>();
	
		public Node(int key) {
			this.key = key;
		}
		
	}
	
	public void addNode (int newKey) {
		root = insertNodeR(root, newKey);
	}
	
	public Node insertNodeR(Node root, int newkey) {
		Node newN = new Node(newkey);
		
		if (root == null) {
			root = newN;
			return root;
		}
			Node rootNode = root;
		if (newkey < rootNode.key) {
				rootNode.leftchild = insertNodeR(rootNode.leftchild, newkey);
		} else if (newkey > rootNode.key) {
				rootNode.rightchild = insertNodeR(rootNode.rightchild, newkey);
		}
		
		return root;
	}
	
	//my own remove method = lol --i'm just trying to practice
	public void removeRoot (Node root, int key) {
		if (root.key == key) { //if you want to remove the root
			Node succ = root.rightchild; //get successor
			while (succ.leftchild != null) { //go to leftmost child of successor
				succ = succ.leftchild;
				//if node is a leaf
				if (isLeaf(succ) == true) {
					succ = root;
				}
				//if Node has one children
				if (succ.rightchild != null); {
					succ = root;
					succ.rightchild = succ; //right child takes successor place
				}
				//if Node has two children
				if (succ.rightchild != null && succ.leftchild != null) {
					succ = root;
					succ.leftchild = succ;
				}
			}
		}
	}
	
	public boolean search (Node root, int searchKey) {
		
		//if nothing is in the root, return false
		if (root == null) {
			return false;
		}
		
		//if the key is in the root, return true
		if (searchKey == root.key) {
			return true;
		}
		
		if (searchKey < root.key) { //if searchkey is less than root key, go to left
			search (root.leftchild, searchKey); //look through leftchild
		} else if (searchKey > root.key) {
			search (root.rightchild, searchKey); //look through rightchild
		}
		return true;
	}
	
	public int findMin (Node root) {
		Node currentNode = root;
		
		while (currentNode.leftchild != null) {
			currentNode = currentNode.leftchild;
		}
		return (currentNode.key);
	}
	
	public int findMax (Node root) {
		Node currentNode = root;
		
		while (currentNode.rightchild != null) {
			currentNode = currentNode.rightchild;
		}
		return (currentNode.key);
	}
	
	
}
