package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a
 * Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree
 * and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. A
 * leaf node is also considered as SumTree.
 * 
 * Problem Statement at http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 * 
 * @author emmanuel
 * 
 */
public class CheckSumTree {
  public boolean isSumTree(BinaryTreeNode root) {
    return isSumTreeRecursive(root).isSumTree;
  }

  public ReturnValue isSumTreeRecursive(BinaryTreeNode node) {
    if (node == null)
      return new ReturnValue(0, true);
    else if (node.isLeafNode())
      return new ReturnValue(node.data, true);
    else {
      ReturnValue isLeftSumTree = isSumTreeRecursive(node.left);
      ReturnValue isRightSumTree = isSumTreeRecursive(node.right);
      if (isLeftSumTree.isSumTree && isRightSumTree.isSumTree
          && (isLeftSumTree.sumOfSubTree + isRightSumTree.sumOfSubTree) == node.data) {
        return new ReturnValue(isLeftSumTree.sumOfSubTree + isRightSumTree.sumOfSubTree + node.data, true);
      }
      else {
        return new ReturnValue(0, false);
      }
    }
  }

  class ReturnValue {
    int sumOfSubTree;
    boolean isSumTree;

    ReturnValue(int sumOfSubTree, boolean isSumTree) {
      this.sumOfSubTree = sumOfSubTree;
      this.isSumTree = isSumTree;
    }
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(26);
    root.left = new BinaryTreeNode(10);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(6);
    root.right.right = new BinaryTreeNode(3);

    CheckSumTree obj = new CheckSumTree();
    System.out.println(obj.isSumTree(root));
  }
}
