package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

public class DeepestLeftLeafNode {
  private ThreadLocal<Integer> maxLevel = new ThreadLocal<Integer>();

  private ThreadLocal<BinaryTreeNode> leafNode = new ThreadLocal<BinaryTreeNode>();

  private void findUtil(BinaryTreeNode node, int level) {
    if (node == null) return;
    if (node.left != null && node.left.isLeafNode() && (level+1) > maxLevel.get()) {
      maxLevel.set(level+1);
      leafNode.set(node.left);
    }
    findUtil(node.left, level + 1);
    findUtil(node.right, level + 1);
  }

  public synchronized BinaryTreeNode find(BinaryTreeNode root) {
    maxLevel.set(0);
    leafNode.set(null);
    findUtil(root, 1);
    return leafNode.get();
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.right.left = new BinaryTreeNode(5);
    root.right.right = new BinaryTreeNode(6);
    root.right.left.right = new BinaryTreeNode(7);
    root.right.right.right = new BinaryTreeNode(8);
    root.right.left.right.left = new BinaryTreeNode(9);
    root.right.right.right.right = new BinaryTreeNode(10);

    DeepestLeftLeafNode obj = new DeepestLeftLeafNode();
    System.out.println(obj.find(root));
  }

}
