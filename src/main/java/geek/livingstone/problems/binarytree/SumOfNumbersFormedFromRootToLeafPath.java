package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 * 
 * @author emmanuel
 * 
 */
public class SumOfNumbersFormedFromRootToLeafPath {
  public static int sum(BinaryTreeNode root) {
    return sum(root, 0);
  }

  private static int sum(BinaryTreeNode root, int numberFormed) {
    if (root == null)
      return 0;
    else if (root.isLeafNode())
      return (numberFormed * 10 + root.data);
    return sum(root.left, numberFormed * 10 + root.data) + sum(root.right, numberFormed * 10 + root.data);
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

    System.out.println(sum(root));
  }

}
