package geek.livingstone.problems.binarytree;


public class InOrderSuccessor {
  public static Node prevNode = null;
  
  public static void populateInorderSuccesor(Node root) {
    prevNode = null;
    visit(root);
  }

  public static void visit(Node node)
  {
    if (node == null)
      return;
    visit(node.left);
    if (prevNode != null)
      prevNode.successor = node;
    prevNode = node;
    visit(node.right);
  }

  public static void print(Node node)
  {
    while (node != null) {
      System.out.print(node.data);
      System.out.print(" --> ");
      node = node.successor;
    }
  }
  public static void main(String[] args) {
    /*
     * Constructed binary tree is
     *                 1
     *               /   \
     *              2      3
     *             / \    / \
     *            4   5  6   7
     *           / \        / \
     *          8   9      10 11
     */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left= new Node(6);
    root.right.right = new Node(7);
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.right.right.left = new Node(10);
    root.right.right.right = new Node(11);
    populateInorderSuccesor(root);
    print(root.left.left.left);
  }

  private static class Node {
    int data;
    Node left;
    Node right;
    Node successor;

    public Node(int data) {
      this.data = data;
    }
  }
}
