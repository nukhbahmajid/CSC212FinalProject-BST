package edu.smith.cs.csc212.fp;
import java.util.ArrayList;
import java.util.List;


public class BTree<Key extends Comparable<Key>> {
	
	public Node root;
	
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
		int t; //minimum degree -- why is this here lol

		public List<Node> links = new ArrayList<Node>();
		
		public List<Key> key = new ArrayList<Key>();
	
		public Node() {
			
		}
		
	}
	
	public BTree() {
		root = new Node();
	}
	
	//insert
	public void insertKey(String key) {
		if (root.key == null) {
			
		}
	}
	
}
