package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Construct a special tree from given preorder traversal Full problem at
 * http://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/
 * 
 * Given an array ‘pre[]‘ that represents Preorder traversal of a spacial binary tree where every
 * node has either 0 or 2 children. One more array ‘preLN[]‘ is given which has only two possible
 * values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]‘ indicates that the corresponding node in Binary
 * Tree is a leaf node and value ‘N’ indicates that the corresponding node is non-leaf node. Write a
 * function to construct the tree from the given two arrays.
 * 
 * @author emmanuel
 * 
 */
public class SpecialBinaryTreeFromPreOrderTraversal {
  private static int visitedIndex = 0;
  public static BinaryTreeNode buildTree(int[] pre, char[] preLN) {
    if (visitedIndex >= pre.length)
      return null;
    BinaryTreeNode node = new BinaryTreeNode(pre[visitedIndex]);
    if (preLN[visitedIndex] == 'N') {
      visitedIndex++;
      node.left = buildTree(pre, preLN);
      node.right = buildTree(pre, preLN);
    }
    else
      visitedIndex++;
    return node;
  }

  public static void main(String[] args) {
    int[] pre = new int[] {10,30,20,5,15};
    char[] preLN = new char[] {'N', 'N', 'L', 'L', 'L'};
    BinaryTreeNode root = buildTree(pre, preLN);
    BinaryTreeNode.printInOrder(root);
  }

}
