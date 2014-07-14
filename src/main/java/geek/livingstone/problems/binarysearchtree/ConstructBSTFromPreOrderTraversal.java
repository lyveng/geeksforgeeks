package geek.livingstone.problems.binarysearchtree;

import java.util.Stack;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
 * 
 * @author emmanuel
 * 
 */
public class ConstructBSTFromPreOrderTraversal {
  public static BinaryTreeNode constructBST(int[] pre) {
    int index = 0, min, max;
    Stack<BinaryTreeNode> s = new Stack<>();
    Stack<Integer> minStack = new Stack<>(), maxStack = new Stack<>();
    BinaryTreeNode root = new BinaryTreeNode(pre[index++]), cur;
    s.push(root);
    minStack.push(Integer.MIN_VALUE);
    maxStack.push(Integer.MAX_VALUE);
    while (index < pre.length) {
      cur = s.pop();
      min = minStack.pop();
      max = maxStack.pop();
      if (cur.left == null && pre[index] < cur.data && pre[index] > min)
      {
        cur.left = new BinaryTreeNode(pre[index++]);
        s.push(cur);
        minStack.push(min);
        maxStack.push(max);

        s.push(cur.left);
        minStack.push(min);
        maxStack.push(cur.data);
      }
      else if (cur.right == null && pre[index] < max && pre[index] > cur.data)
      {
        cur.right = new BinaryTreeNode(pre[index++]);
        s.push(cur.right);
        minStack.push(cur.data);
        maxStack.push(max);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = constructBST(new int[] {10, 5, 1, 7, 40, 50});
    BinaryTreeNode.printInOrder(root);
  }

}
