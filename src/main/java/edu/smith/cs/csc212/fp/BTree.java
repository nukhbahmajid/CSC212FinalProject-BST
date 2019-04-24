package edu.smith.cs.csc212.fp;
import java.util.ArrayList;
import java.util.List;


public class BTree<T extends Comparable<T>> {
	
	public int size; //size
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Node<T> root;
	
	public static class Node<T> {
		int t; //minimum degree -- why is this here

		//public List<Node<T>> links = new ArrayList<Node<T>>();
		Node[] children = new Node[4];
		
		//https://stackoverflow.com/questions/19478225/array-of-generic-nodes-java
		@SuppressWarnings("unchecked")
		Node<T>[] links = (Node<T>[]) new Node[4];
		
		public List<String> key = new ArrayList<>();
		
		public Node (Node<T>[] links, List<String> key) {
			this.links = links;
			this.key = key;
		}
		
	}
	
	public void insertKey(String key) {
		Node<T> root = new Node<T>(null, null);
		
	}
	
}
