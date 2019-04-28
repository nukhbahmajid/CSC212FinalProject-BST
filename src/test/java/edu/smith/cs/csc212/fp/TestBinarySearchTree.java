package edu.smith.cs.csc212.fp;

import org.junit.Test;

import edu.smith.cs.csc212.fp.BinarySearchTree.Node;

import java.util.List;
import java.util.Set;

import org.junit.Assert;

public class TestBinarySearchTree {

  private BinarySearchTree makeData() {
	  BinarySearchTree data = new BinarySearchTree();
	  data.insert(50);
	  data.insert(20);
	  data.insert(40);
	  data.insert(30);
	  data.insert(60);
	  data.insert(10);
	  data.insert(70);
	  return data;
	}
  
  @Test
  public void testInsert() {
	  BinarySearchTree data = makeData();
	  data.RecurInOrderTraversal(data.root);
  }
  
  @Test
  public void testSize() {
	  BinarySearchTree data = makeData();
	  Assert.assertEquals(7, data.size());
  }
  
  @Test
  public void testListNodes() {
	  BinarySearchTree data = makeData();
	  Set<Integer> output = data.ListNodes(data.root);
	  for (int i : output) {
		  System.out.println(i);
	  }
  }
  
  @Test
  public void testRemove() {
	  BinarySearchTree data = makeData();
	  data.remove(70);
	  data.remove(40);
	  data.remove(20);
	  data.remove(80);
	  Assert.assertEquals(4, data.size());
	  Set<Integer> output = data.ListNodes(data.root);
	  for (int i : output) {
		  System.out.println(i);
	  }
  }
  
  @Test
  public void testSearch() {
	  BinarySearchTree data = makeData();
	  Assert.assertEquals(false, data.search(80));
	  Assert.assertEquals(true, data.search(20));
	  data.remove(10);
	  Assert.assertEquals(false, data.search(10));
  }
  
}
