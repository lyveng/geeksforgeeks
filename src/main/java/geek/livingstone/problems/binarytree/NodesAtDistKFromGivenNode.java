package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * 
 * @author emmanuel
 * 
 */
public class NodesAtDistKFromGivenNode {
  private static void printNodesAtDistK(BinaryTreeNode node, int k) {
    if (node == null)
      return;
    if (k == 0) {
      System.out.print(node.data + " ");
      return;
    }
    printNodesAtDistK(node.left, k - 1);
    printNodesAtDistK(node.right, k - 1);
  }

  public static int printNodesAtDistK(BinaryTreeNode node, BinaryTreeNode target, int k) {
    if (node == null)
      return -1;
    if (node == target) {
      printNodesAtDistK(node, k);
      return k - 1;
    }
    int leftRet = printNodesAtDistK(node.left, target, k);
    if (leftRet == 0)
      System.out.print(node.data + " ");
    else if (leftRet > 0) {
      printNodesAtDistK(node.right, leftRet - 1);
      return leftRet - 1;
    }
    int rightRet = printNodesAtDistK(node.right, target, k);
    if (rightRet == 0)
      System.out.print(node.data + " ");
    else if (rightRet > 0) {
      printNodesAtDistK(node.left, rightRet - 1);
      return rightRet - 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(20);
    root.left = new BinaryTreeNode(8);
    root.right = new BinaryTreeNode(22);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(12);
    root.left.right.left = new BinaryTreeNode(10);
    root.left.right.right = new BinaryTreeNode(14);
    printNodesAtDistK(root, root.left, 2);
  }

}
