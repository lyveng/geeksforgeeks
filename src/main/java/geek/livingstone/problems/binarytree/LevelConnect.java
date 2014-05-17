package geek.livingstone.problems.binarytree;


/**
 * Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure
 * of the given Binary Tree node is like following.
 * 
 *  struct node{
      int data;
      struct node* left;
      struct node* right;
      struct node* nextRight;  
    }
 * 
 * @author emmanuel
 * 
 */
public class LevelConnect {
  /**
   * Populates the nextRight variable of all the nodes with the next right node in the current
   * level.
   * 
   * @param root
   */
  public static void connect(Node root) {
    if (root == null)
      return;
    Node parent = root;
    Node curLevel = root.left != null ? root.left : root.right;
    boolean isLeftChild = root.left != null;
    while (curLevel != null) {
      Node curNode = curLevel;
      while (curNode != null) {
        /*System.out.println(String.format("CurNode : %d, Parent : %d, isLeftChild : %s",
            curNode.data, parent.data, isLeftChild));*/
        RetValue ret = getNextRight(curNode, parent, isLeftChild);
        if (ret == null)
          break;
        curNode.nextRight = ret.node;
        curNode = curNode.nextRight;
        parent = ret.parent;
        isLeftChild = ret.isLeftChild;
      }
      try {
        RetValue ret = getNextLevel(curLevel);
        curLevel = ret.node;
        parent = ret.parent;
        isLeftChild = ret.isLeftChild;
      } catch (NoNextLevelException e) {
        break;
      }
    }
  }

  /**
   * Gets the next right node in the current level for the given curNode.
   * 
   * @param curNode
   * @param parent
   * @param isLeftChild
   * @return
   */
  private static RetValue getNextRight(Node curNode, Node parent, boolean isLeftChild) {
    if (isLeftChild && parent.right != null)
      return new RetValue(parent.right, parent, false);
    parent = parent.nextRight;
    while (parent != null) {
      if (parent.left != null)
        return new RetValue(parent.left, parent, true);
      else if (parent.right != null)
        return new RetValue(parent.right, parent, false);
      else
        parent = parent.nextRight;
    }
    return null;
  }

  private static class RetValue {
    Node node;
    Node parent;
    boolean isLeftChild;

    RetValue(Node nextRight, Node parent, boolean isLeftChild) {
      this.node = nextRight;
      this.parent = parent;
      this.isLeftChild = isLeftChild;
    }

  }

  /**
   * Prints the nextRight pointers in a level.
   * 
   * @param node
   */
  public static void print(Node node) {
    Object nullObj = null;
    while (node != null) {
      Node curNode = node;
      while (curNode != null) {
        System.out.print(curNode.data);
        System.out.print(" --> ");
        curNode = curNode.nextRight;
      }
      System.out.println(nullObj);
      try {
        node = getNextLevel(node).node;
      } catch (NoNextLevelException e) {
        break;
      }
    }
  }

  /**
   * Gets the starting node in the next level. The node.nextRight needs to be filled in for the
   * current level for this to work.
   * 
   * @param node
   * @return
   * @throws NoNextLevelException
   */
  public static RetValue getNextLevel(Node node) throws NoNextLevelException {
    while (node != null) {
      if (node.left != null)
        return new RetValue(node.left, node, true);
      else if (node.right != null)
        return new RetValue(node.right, node, false);
      else
        node = node.nextRight;
    }
    throw new NoNextLevelException();
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
    connect(root);
    print(root);
  }

  private static class Node {
    int data;
    Node left;
    Node right;
    Node nextRight;

    public Node(int data) {
      this.data = data;
    }
  }

  private static class NoNextLevelException extends Exception {
    private static final long serialVersionUID = 2227569230160690616L;
  }
}
