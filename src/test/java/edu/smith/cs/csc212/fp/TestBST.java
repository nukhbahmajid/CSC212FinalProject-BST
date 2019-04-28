package edu.smith.cs.csc212.fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestBST {
  
  /**
   * Make a new empty BST.
   * @return an empty BST to be tested ~.
   */
  private BST makeEmptyBST() {
    BST empty = new BST();
    return empty;
  }
  
  /**
   * Make a sample BST.
   * @return a sample BST to be tested.
   */
  private BST makeSampleBST() {
	  BST sample = new BST();
	  sample.insert(0);
	  sample.insert(1);
	  sample.insert(2);
	  sample.insert(3);
	  sample.insert(4);
	  sample.insert(5);
	  
	  return sample;
  }
  
  @Test
  public void testInOrderTraversal() {
	  BST sample = makeSampleBST();
	  System.out.println("Before: " + sample.traversalList);
	  
	  sample.orderedTraversal(sample.root);
	  
	  System.out.println("The size of list returned from the inOrderTraversal: " + sample.traversalList.size());
	 
	  
  }
  
  
  /*
   * Test if the search method works: 
   */
  @Test
  public void testSearchMethod() {
	  BST sample = makeSampleBST();
	  
	  Assert.assertEquals(true, sample.searchKey(5));
	  Assert.assertEquals(false, sample.searchKey(100));
  }
  
}