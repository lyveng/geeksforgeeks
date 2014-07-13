package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * 
 * @author emmanuel
 *
 */
public class BoundaryTraversal {
  private static void printLeftBoundary(BinaryTreeNode root) {
    if (root.isLeafNode())
      return;
    System.out.print(root.data + " -> ");
    if (root.left != null)
      printLeftBoundary(root.left);
    else if (root.right != null)
      printLeftBoundary(root.right);
  }

  private static void printLeafNodes(BinaryTreeNode root) {
    if (root.isLeafNode()) {
      System.out.print(root.data + " -> ");
      return;
    }
    if (root.left != null)
      printLeafNodes(root.left);
    if (root.right != null)
      printLeafNodes(root.right);
  }

  private static void printRightBoundaryBottomUp(BinaryTreeNode root) {
    if (root.isLeafNode())
      return;
    if (root.right != null)
      printRightBoundaryBottomUp(root.right);
    else if (root.left != null)
      printRightBoundaryBottomUp(root.left);
    System.out.print(root.data + " -> ");
  }

  public static void printBoundaryTraversal(BinaryTreeNode root) {
    if (root == null)
      return;
    printLeftBoundary(root);
    printLeafNodes(root);
    printRightBoundaryBottomUp(root);
    System.out.println();
  }

  public static void main(String[] args) {
    /*
     * Constructed binary tree is
     *                 1
     *               /   \
     *              2      3
     *             / \    / \
     *            4   5  6   7
     *           / \        / \
     *          8   9      10 11
     */
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);
    root.right.left = new BinaryTreeNode(6);
    root.right.right = new BinaryTreeNode(7);
    root.left.left.left = new BinaryTreeNode(8);
    root.left.left.right = new BinaryTreeNode(9);
    root.right.right.left = new BinaryTreeNode(10);
    root.right.right.right = new BinaryTreeNode(11);
    printBoundaryTraversal(root);
  }

}
