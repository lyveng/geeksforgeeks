package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/largest-independent-set-problem/
 * 
 * @author emmanuel
 * 
 */
public class LargestIndependentSet {
  public static int LIS(BinaryTreeNode root) {
    BinaryTreeNode lisRoot = createLISTree(root);
    return lisRoot.data;
  }

  private static BinaryTreeNode createLISTree(BinaryTreeNode root) {
    if (root == null)
      return null;
    else if (root.isLeafNode())
      return new BinaryTreeNode(1);
    BinaryTreeNode node = new BinaryTreeNode(0);
    node.left = createLISTree(root.left);
    node.right = createLISTree(root.right);
    int lisExclRoot = getNodeValue(node.left) + getNodeValue(node.right);
    int lisInclRoot = 1;
    if (node.left != null)
      lisInclRoot += (getNodeValue(node.left.left) + getNodeValue(node.left.right));
    if (node.right != null)
      lisInclRoot += (getNodeValue(node.right.left) + getNodeValue(node.right.right));
    node.data = Math.max(lisExclRoot, lisInclRoot);
    return node;
  }

  private static int getNodeValue(BinaryTreeNode node) {
    if (node == null)
      return 0;
    return node.data;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(10);
    root.left = new BinaryTreeNode(20);
    root.right = new BinaryTreeNode(30);
    root.left.left = new BinaryTreeNode(40);
    root.left.right = new BinaryTreeNode(50);
    root.left.right.left = new BinaryTreeNode(70);
    root.left.right.right = new BinaryTreeNode(80);
    root.right.right = new BinaryTreeNode(60);
    System.out.println(LIS(root));
  }

}
