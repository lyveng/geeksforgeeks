package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Convert Full binary tree to DLL.
 * @author emmanuel
 *
 */
public class BinaryTreeToDLL {
  public static BinaryTreeNode head;
  public static BinaryTreeNode prev;
  public static void visit(BinaryTreeNode node)
  {
    if (node == null)
      return;
    visit(node.left);
    if (prev == null)
      head = node;
    else
      prev.right = node;
    node.left = prev;
    prev = node;
    visit(node.right);
  }

  public static void printDLL(BinaryTreeNode bt)
  {
    while (bt != null)
    {
      System.out.print(bt.data);
      System.out.print(" ");
      bt = bt.right;
    }
  }
  public static void main(String[] args) {
    /* Construct the following tree
        10
       /   \
     12     15
     / \    /
    25 30  36
    */
    BinaryTreeNode bt = new BinaryTreeNode(10);
    bt.right = new BinaryTreeNode(15);
    bt.right.left = new BinaryTreeNode(36);
    bt.left = new BinaryTreeNode(12);
    bt.left.left = new BinaryTreeNode(25);
    bt.left.right = new BinaryTreeNode(30);
    
    visit(bt);
    printDLL(head);

  }

}
