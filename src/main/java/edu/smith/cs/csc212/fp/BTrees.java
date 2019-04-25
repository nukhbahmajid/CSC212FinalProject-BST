package edu.smith.cs.csc212.fp;

import java.util.ArrayList;
import java.util.List;

public class BTrees<Key extends Comparable<Key>> {
	private int height;
	
	//number of keys stored in nodes
	public int size;
	
	public Node root;
	
	public class Node {
		//arrayList of nodes
		List<Node> children = new ArrayList<Node>();
		//arrayList of keys
		List<Key> keys = new ArrayList<Key>();
		//number of children
		public int numKeys;
		//key in the node
		//public String key;
		//a list of keys in one node
		//public List<String> keys;
		
		public boolean isLeaf() {
			// return true if all children are null
			
		}
		
		public int numChildren() {
			return numKeys + 1;
		}
		
		public Node() {
			
		}
	
	}
	
//	private static class Key {
//        private Comparable key;
//        public Key(Comparable key) {
//            this.key = key;
//        }
//    }
	
	public BTrees() {
		root = new Node();
	}
	
	public boolean isEmpty() {
		return size() == 0; 
	}
	
	public int size() {
		return size;
	}
	
	public void add(Key key) {
		if (this.isEmpty()) {
			root.keys[0] = key;
		}
		
	}
	
	public void split() {
	// added a comment
	}
	
}
