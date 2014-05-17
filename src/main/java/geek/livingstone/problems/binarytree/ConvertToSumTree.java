package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

public class ConvertToSumTree {
  public static void convert(BinaryTreeNode root)
  {
    visit(root);
  }

  private static void printInorder(BinaryTreeNode node)
  {
    if (node == null)
      return;
    printInorder(node.left);
    System.out.print(node.data);
    System.out.print(" --> ");
    printInorder(node.right);
  }

  private static int visit(BinaryTreeNode node)
  {
    if (node == null)
      return 0;
    int leftSum = visit(node.left);
    int rightSum = visit(node.right);
    int nodeValue = node.data;
    if (node.isLeafNode())
      node.data = 0;
    else
      node.data = leftSum + rightSum;
    return nodeValue + node.data;
  }

  public static void main(String[] args) {
    /* Running on the following tree.
     *                  10
                      /     \
                    -2       6
                   /   \    / \ 
                  8    -4  7   5

     */
    BinaryTreeNode root = new BinaryTreeNode(10);
    root.left = new BinaryTreeNode(-2);
    root.right = new BinaryTreeNode(6);
    root.left.left = new BinaryTreeNode(8);
    root.left.right = new BinaryTreeNode(-4);
    root.right.left = new BinaryTreeNode(7);
    root.right.right = new BinaryTreeNode(5);
    convert(root);
    printInorder(root);
  }

}
