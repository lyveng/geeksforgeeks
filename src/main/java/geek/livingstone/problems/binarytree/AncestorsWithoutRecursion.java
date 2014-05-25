package geek.livingstone.problems.binarytree;

import java.util.Stack;

import geek.livingstone.adt.BinaryTreeNode;

public class AncestorsWithoutRecursion {

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
    BinaryTreeNode root = new BinaryTreeNode(26);
    root.right = new BinaryTreeNode(3);
    root.right.right = new BinaryTreeNode(3);
    root.left = new BinaryTreeNode(10);
    root.left.left = new BinaryTreeNode(4);
    root.left.left.right = new BinaryTreeNode(30);
    root.left.right = new BinaryTreeNode(6);

    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    Stack<BinaryTreeNode> ancestors = new Stack<BinaryTreeNode>();
    BinaryTreeNode cur = root;
    BinaryTreeNode anc = null;
    do
    {
      while (cur!=null)
      {
        if (cur.right != null)
          stack.push(cur.right);
        stack.push(cur);
        ancestors.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      anc = ancestors.pop();
      assert anc == cur;
      if (cur.right != null && !stack.isEmpty() && cur.right == stack.peek())
      {
        stack.pop();
        stack.push(cur);
        ancestors.push(cur);
        cur = cur.right;
      }
      else
      {
        System.out.println(String.format("%d\t\t%s", cur.data, ancestors.toString()));
        cur = null;
      }
    } while (!stack.isEmpty());
  }

}
