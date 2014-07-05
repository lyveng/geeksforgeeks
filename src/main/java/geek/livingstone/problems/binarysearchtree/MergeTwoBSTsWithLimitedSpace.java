package geek.livingstone.problems.binarysearchtree;

import java.util.Stack;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
 * 
 * @author emmanuel
 * 
 */
public class MergeTwoBSTsWithLimitedSpace {
  public static void mergePrint(BinaryTreeNode t1, BinaryTreeNode t2) {
    Stack<BinaryTreeNode> s1 = new Stack<>(), s2 = new Stack<>();
    BinaryTreeNode c1 = t1, c2 = t2;
    while ((c1 != null || !s1.empty()) && (c2 != null || !s2.empty())) {
      while (c1 != null) {
        s1.push(c1);
        c1 = c1.left;
      }
      while (c2 != null) {
        s2.push(c2);
        c2 = c2.left;
      }

      if (s1.peek().data < s2.peek().data) {
        c1 = s1.pop();
        System.out.print(c1.data + " ");
        c1 = c1.right;
      } else {
        c2 = s2.pop();
        System.out.print(c2.data + " ");
        c2 = c2.right;
      }
    }

    while (c1 != null || !s1.empty()) {
      while (c1 != null) {
        s1.push(c1);
        c1 = c1.left;
      }
      c1 = s1.pop();
      System.out.print(c1.data + " ");
      c1 = c1.right;
    }

    while (c2 != null || !s2.empty()) {
      while (c2 != null) {
        s1.push(c2);
        c2 = c2.left;
      }
      c2 = s2.pop();
      System.out.print(c2.data + " ");
      c2 = c2.right;
    }
  }

  public static void main(String[] args) {
    BinaryTreeNode t1 = new BinaryTreeNode(3);
    t1.left = new BinaryTreeNode(1);
    t1.right = new BinaryTreeNode(5);

    BinaryTreeNode t2 = new BinaryTreeNode(4);
    t2.left = new BinaryTreeNode(2);
    t2.right = new BinaryTreeNode(6);

    mergePrint(t1, t2);
  }

}
