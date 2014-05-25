package geek.livingstone.adt;

public class BinaryTreeNode {
  @Override
  public String toString() {
    return "" + data;
  }

  public int data;
  public BinaryTreeNode left = null;
  public BinaryTreeNode right = null;

  public BinaryTreeNode(int value) {
    data = value;
  }

  public boolean isLeafNode() {
    return left == null && right == null;
  }

  public static void printInOrder(BinaryTreeNode node) {
    if (node == null)
      return;
    printInOrder(node.left);
    System.out.print(node.data);
    System.out.print(" ");
    printInOrder(node.right);
  }
}