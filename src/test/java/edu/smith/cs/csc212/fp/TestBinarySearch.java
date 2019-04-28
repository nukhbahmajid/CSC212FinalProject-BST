package edu.smith.cs.csc212.fp;

import org.junit.Assert;
import org.junit.Test;

public class TestBinarySearch {
	private BinarySearchTreeJH makeEmptyBinaryTree() {
		BinarySearchTreeJH emptytree = new BinarySearchTreeJH();
	    return emptytree;
	  }
	  
	  private BinarySearchTreeJH newBinaryTree() {
		  BinarySearchTreeJH tree = new BinarySearchTreeJH();
		  tree.addNode(0);
		  tree.addNode(1);
		  tree.addNode(2);
		  tree.addNode(3);
		  tree.addNode(4);
		  tree.addNode(5);
		  
		  return tree;
	  }
	  
	  
	  @Test
	  public void testBinarySearch() {
		  BinarySearchTreeJH tree = newBinaryTree();
		  if (tree.search(tree.root, -4) == true) {
			  System.out.println("key found");
		  } else if (tree.search(tree.root, -4) == false) {
			  System.out.println("key not found");
		  }
	  }
	  
	  @Test
	  public void testfindmin() {
		  BinarySearchTreeJH tree = newBinaryTree();
		  Assert.assertEquals(0, tree.findmin(tree.root));
	  }
	  
	  @Test
	  public void testfindmax() {
		  BinarySearchTreeJH tree = newBinaryTree();
		  Assert.assertEquals(5, tree.findmax(tree.root));
	  }
	  
}
