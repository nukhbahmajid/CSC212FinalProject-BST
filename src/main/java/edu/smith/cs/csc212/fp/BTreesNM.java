package edu.smith.cs.csc212.fp;

import java.util.List;

public class BTreesNM<Key extends Comparable<Key>, Value> {
	/*
	 * Minimum degree of the tree. 
	 * t - the min degree of the B-Tree. 
	 */
	final int minTreeDeg = 2;
	/*
	 * At most, the internal nodes can have 2t - 1 keys.
	 * At least, t-1 keys.
	 * 
	 * Exception root node which can have only 1 key too. 
	 */
	final int upperBoundPlus1 = 4;
	/*
	 * The root of the B-tree.
	 */
	private Node root;
	/*
	 * The height of the B-Tree. 
	 * All the leaves exist at this level. 
	 */
	private int height; 
	/*
	 * The number of key-value pairs entered in the B-Tree. 
	 */
	private int numPairs; 
	
	
	
	public BTreesNM() {
		this.root = root; 
	}
	
	
	private class Node{
		/*
		 * All the keys present in the node. Cannot exceed minTreeDeg. 
		 */
		List<Key> keys;
		/*
		 * The children from this node. Not less than t-1 ()
		 */
		List<Node> children;
		
		
		
		
		
	}

}
