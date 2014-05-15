package geek.livingstone.adt;

public class BinaryTreeNode {
  public int data;
  public BinaryTreeNode left = null;
  public BinaryTreeNode right = null;

  public BinaryTreeNode(int value) {
    data = value;
  }

  public boolean isLeafNode() {
    return left == null && right == null;
  }
}