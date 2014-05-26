package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Sum of all the numbers that are formed from root to leaf paths
 * 
 * Full problem at http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 * 
 * @author emmanuel
 *
 */
public class SumOfAllNumbersFormedFromRootToLeafPaths {
  public static int sum(BinaryTreeNode node, int pathSum, int sum) {
    if (node == null)
      return sum;
    if (node.isLeafNode()) {
      return sum + pathSum * 10 + node.data;
    }
    sum = sum(node.left, pathSum * 10 + node.data, sum);
    sum = sum(node.right, pathSum * 10 + node.data, sum);
    return sum;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(6);
    root.left = new BinaryTreeNode(3);
    root.right = new BinaryTreeNode(5);
    root.left.left = new BinaryTreeNode(2);
    root.left.right = new BinaryTreeNode(5);
    root.right.right = new BinaryTreeNode(4);
    root.left.right.left = new BinaryTreeNode(7);
    root.left.right.right = new BinaryTreeNode(4);
    System.out.println(sum(root, 0, 0));
  }

}
