package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Find the maximum sum leaf to root path in a Binary Tree
 * 
 * http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
 * 
 * @author emmanuel
 *
 */
public class MaxLeafToRootPathSum {
  public static int maxLeafPathSum = Integer.MIN_VALUE;
  public static BinaryTreeNode targetNode = null;

  public static void findMaxSumLeafNode(BinaryTreeNode node, int pathSum) {
    if (node == null)
      return;
    if (node.isLeafNode()) {
      if ((node.data + pathSum) > maxLeafPathSum) {
        maxLeafPathSum = node.data + pathSum;
        targetNode = node;
      }
    }
    findMaxSumLeafNode(node.left, pathSum + node.data);
    findMaxSumLeafNode(node.right, pathSum + node.data);
  }

  public static boolean printPath(BinaryTreeNode root) {
    if (root == null)
      return false;
    if (root == targetNode || printPath(root.left) || printPath(root.right)) {
      System.out.print(root.data);
      System.out.print(" ");
      return true;
    }
    else
      return false;
  }
  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(10);
    root.left = new BinaryTreeNode(-2);
    root.right = new BinaryTreeNode(7);
    root.left.left = new BinaryTreeNode(8);
    root.left.right = new BinaryTreeNode(-4);
    maxLeafPathSum = Integer.MIN_VALUE;
    targetNode = null;
    findMaxSumLeafNode(root, 0);
    System.out.println(maxLeafPathSum);
    System.out.println(targetNode.data);
    printPath(root);
  }

}
