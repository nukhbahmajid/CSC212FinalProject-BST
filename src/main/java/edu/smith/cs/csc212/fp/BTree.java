package edu.smith.cs.csc212.fp;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class BTree<T extends Comparable<T>> {
	
	public int size; //size
	//t is 2
	//at least 1 key and at most 3 keys
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	Node<T> root = new Node<T>(null, null);
	
	public static class Node<T> {
		int t; //minimum degree -- why is this here

		//public List<Node<T>> links = new ArrayList<Node<T>>();
		Node[] children = new Node[3]; //fixed list of children or links
		T[] arrayofkeys = (T[]) new Array[2]; //fixed list of keys (integers)
		
		//https://stackoverflow.com/questions/19478225/array-of-generic-nodes-java
		@SuppressWarnings("unchecked") //ignore this
		Node<T>[] links = (Node<T>[]) new Node[4]; //ignore this
		
		public List<Integer> key = new ArrayList<>();
		
		public Node (Node<T>[] links, List<Integer> key) {
			this.links = links;
			this.key = key;
		}
		
	}
	
	public void insertKey(String key) {
		if (root.key == null) {
			
		}
	}
	
}
