package geek.livingstone.problems.binarytree;

import java.util.Stack;

import geek.livingstone.adt.BinaryTreeNode;

public class IterativePostOrderUsingOneStack {

  public static void main(String[] args) {
    /* Construct the following tree
        26
       /   \
     10     3
     / \     \
    4   6     3
     \
      30
    */
    BinaryTreeNode bt = new BinaryTreeNode(26);
    bt.right = new BinaryTreeNode(3);
    bt.right.right = new BinaryTreeNode(3);
    bt.left = new BinaryTreeNode(10);
    bt.left.left = new BinaryTreeNode(4);
    bt.left.left.right = new BinaryTreeNode(30);
    bt.left.right = new BinaryTreeNode(6);

    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    BinaryTreeNode root = bt;
    do {
      while (root != null) {
        if (root.right != null)
          stack.push(root.right);
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (root.right != null && !stack.isEmpty() && root.right == stack.peek()) {
        stack.pop();
        stack.push(root);
        root = root.right;
      }
      else {
        System.out.print(String.format("%d ", root.data));
        root = null;
      }
    } while (!stack.isEmpty());
  }

}
