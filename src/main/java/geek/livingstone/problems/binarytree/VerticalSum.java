package geek.livingstone.problems.binarytree;

import java.util.Map;
import java.util.TreeMap;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Vertical Sum in a given Binary Tree
 * 
 * Full problem at http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 * @author emmanuel
 *
 */
public class VerticalSum {

  public static void getVerticalSum(BinaryTreeNode root, Map<Integer, Integer> sumMap) {
    sumMap.clear();
    sumMap.put(0, root.data);
    visit(root.left, sumMap, true, 0);
    visit(root.right, sumMap, false, 0);
  }

  public static void visit(BinaryTreeNode node, Map<Integer, Integer> sumMap, boolean isLeftChild, int parentHorizontalDistFromRoot) {
    if (node == null)
      return;
    int key = isLeftChild ? (parentHorizontalDistFromRoot - 1) : (parentHorizontalDistFromRoot + 1);
    int value = sumMap.containsKey(key) ? (sumMap.get(key) + node.data) : node.data;
    sumMap.put(key, value);
    visit(node.left, sumMap, true, key);
    visit(node.right, sumMap, false, key);
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);
    root.right.left = new BinaryTreeNode(6);
    root.right.right = new BinaryTreeNode(7);
    TreeMap<Integer, Integer> sumMap = new TreeMap<Integer, Integer>();
    getVerticalSum(root, sumMap);
    int keyOffset = sumMap.firstKey() < 0 ? Math.abs(sumMap.firstKey()) : 0;
    for (Integer key : sumMap.navigableKeySet())
      System.out.println(String.format("%d : %d", key + keyOffset + 1, sumMap.get(key)));
  }

}
