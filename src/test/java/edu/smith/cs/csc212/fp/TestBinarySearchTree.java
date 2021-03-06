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
  public void testIsEmpty() {
	  BinarySearchTree empty = new BinarySearchTree();
	  Assert.assertEquals(true, empty.isEmpty());
  }
  
  @Test
  public void testInsert() {
	  BinarySearchTree data = makeData();
	  data.RecurInOrderTraversal(data.root);
  }
  
  @Test
  public void testSize() {
	  BinarySearchTree empty = new BinarySearchTree();
	  Assert.assertEquals(0, empty.size());
	  
	  BinarySearchTree data = makeData();
	  Assert.assertEquals(7, data.size());
  }
  
  @Test
  public void testListNodes() {
	  BinarySearchTree data = makeData();
	  Set<Integer> output = data.ListNodes(data.root);
	  Integer[] expected = {50, 20, 70, 40, 10, 60, 30};
	  Assert.assertArrayEquals(expected, output.toArray());
  }
  
  @Test
  public void testRemove() {
	  BinarySearchTree data = makeData();
	  data.remove(30);
	  Assert.assertEquals(6, data.size());
	  data.remove(50);
	  Assert.assertEquals(5, data.size());
	  data.remove(20);
	  Assert.assertEquals(4, data.size());
	  data.remove(80);
	  Assert.assertEquals(4, data.size());
	  Set<Integer> output = data.ListNodes(data.root);
	  Integer[] expected = {70, 40, 10, 60};
	  Assert.assertArrayEquals(expected, output.toArray());
  }
  
  @Test
  public void testSearch() {
	  BinarySearchTree data = makeData();
	  Assert.assertEquals(false, data.search(80));
	  Assert.assertEquals(true, data.search(20));
	  data.remove(10);
	  Assert.assertEquals(false, data.search(10));
  }
  
  @Test
  public void testFindmin() {
	  BinarySearchTree empty = new BinarySearchTree();
	  Assert.assertEquals(null, empty.findMin());
	  
	  BinarySearchTree data = makeData();
	  Assert.assertEquals((Integer)10, data.findMin());
  }
  
  @Test
  public void testFindmax() {
	  BinarySearchTree empty = new BinarySearchTree();
	  Assert.assertEquals(null, empty.findMax());
	  
	  BinarySearchTree data = makeData();
	  Assert.assertEquals((Integer)70, data.findMax());
  }
  
  @Test
  public void testGetRoot() {
	  BinarySearchTree empty = new BinarySearchTree();
	  Assert.assertEquals(null, empty.getRoot());
	  
	  BinarySearchTree data = makeData();
	  Assert.assertEquals((Integer)50, data.getRoot());
  }
  
}
