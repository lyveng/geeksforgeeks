package geek.livingstone.problems.binarysearchtree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/
 * 
 * @author emmanuel
 * 
 */
public class PrintKeysInGivenRange {
  public static void printRange(BinaryTreeNode root, int start, int end) {
    if (root == null)
      return;
    if (start < root.data)
      printRange(root.left, start, end);
    if (start <= root.data && end >= root.data)
      System.out.print(root.data + " ");
    if (end > root.data)
      printRange(root.right, start, end);
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(20);
    root.left = new BinaryTreeNode(8);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(12);
    root.right = new BinaryTreeNode(22);
    printRange(root, 13, 15);
  }

}
