package edu.smith.cs.csc212.fp;

import java.util.List;

public class BTrees<Key extends Comparable<Key>> {
	private int height;
	
	//number of keys stored in nodes
	public int size;
	
	private static class Node {
		public Node root;
		//number of nodes
		Node[] children = new Node[4];
		//number of keys in one node
		public int numKeys;
		//key in the node
		public String key;
		//a list of keys in one node
		public List<String> keys;
		
		public Node(int i) {
			
		}	
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return size;
		// adding a comment here
	}
	
	public void add(Key key) {

	}
	
	
}
