package edu.smith.cs.csc212.fp;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeJH {

	public Node root;
	
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
		int hm = newkey;
		
		if (root == null) {
			root = newN;
			return root;
		} else {
			Node rootNode = root;
			if (newkey < rootNode.key) {
				if (rootNode.leftchild == null) {
					rootNode.leftchild = newN;
				} else {
					rootNode.leftchild = insertNodeR(rootNode.leftchild, hm);
					
				}
			} else {
				if (rootNode.rightchild == null) {
					rootNode.rightchild = newN;
				} else {
					rootNode.rightchild = insertNodeR(rootNode.rightchild, hm);
					
				}
			}
		}
		return root;
	}
	
	public boolean search (Node root, int searchKey) {
		
		if (root == null) {
			return false;
		}
		
		if (searchKey == root.key) {
			return true;
		}
		
		if (searchKey < root.key) {
			search (root.leftchild, searchKey);
		} else if (searchKey > root.key) {
			search (root.rightchild, searchKey);
		}
		return true;
	}
	
}
