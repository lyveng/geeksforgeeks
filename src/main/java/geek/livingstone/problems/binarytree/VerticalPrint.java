package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Full problem at http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 * 
 * @author emmanuel
 * 
 */
public class VerticalPrint {
  public static void print(BinaryTreeNode root) {
    Map<Integer, List<Integer>> traversal = new TreeMap<>();
    printUtil(root, 0, traversal);
    for (Integer key : traversal.keySet()) {
      System.out.println(traversal.get(key));
    }
  }

  private static void printUtil(BinaryTreeNode node, int horizDistFromRoot, Map<Integer, List<Integer>> traversal) {
    if (node == null)
      return;
    if (!traversal.containsKey(horizDistFromRoot))
      traversal.put(horizDistFromRoot, new ArrayList<Integer>());
    traversal.get(horizDistFromRoot).add(node.data);
    printUtil(node.left, horizDistFromRoot - 1, traversal);
    printUtil(node.right, horizDistFromRoot + 1, traversal);
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);
    root.right.left = new BinaryTreeNode(6);
    root.right.right = new BinaryTreeNode(7);
    root.right.left.right = new BinaryTreeNode(8);
    root.right.right.right = new BinaryTreeNode(9);
    print(root);
  }

}
