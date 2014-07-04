package geek.livingstone.problems.binarytree;

import java.util.LinkedList;
import java.util.Stack;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/reverse-level-order-traversal/
 * 
 * @author emmanuel
 * 
 */
public class ReverseLevelOrderTraversal {
  public static void reverseLevlOrder(BinaryTreeNode root) {
    LinkedList<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    Stack<Integer> stack = new Stack<>();
    BinaryTreeNode current;
    while (!queue.isEmpty()) {
      current = queue.remove();
      stack.push(current.data);
      if (current.left != null)
        queue.add(current.left);
      if (current.right != null)
        queue.add(current.right);
    }
    while (!stack.empty()) {
      int val = stack.pop();
      System.out.print(val + " ");
    }
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);
    root.right.right = new BinaryTreeNode(6);
    reverseLevlOrder(root);
  }

}
