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
    Node curLevel, nextLevelFirstNode=root, prevNode;
    while (nextLevelFirstNode != null) {
      curLevel = nextLevelFirstNode;
      nextLevelFirstNode = null;
      prevNode = null;
      while (curLevel != null) {
        if (curLevel.left != null) {
          if (prevNode != null)
            prevNode.nextRight = curLevel.left;
          else
            nextLevelFirstNode = curLevel.left;
          prevNode = curLevel.left;
        }
        if (curLevel.right != null) {
          if (prevNode != null)
            prevNode.nextRight = curLevel.right;
          else
            nextLevelFirstNode = curLevel.right;
          prevNode = curLevel.right;
        }
        curLevel = curLevel.nextRight;
      }
    }
  }

  /**
   * Prints the nextRight pointers in a level.
   * 
   * @param node
   */
  public static void print(Node node) {
    Node curLevel, nextLevel=node;
    while (nextLevel!=null) {
      curLevel = nextLevel;
      nextLevel = null;
      while (curLevel != null) {
        System.out.print(curLevel.data + " --> ");
        if (nextLevel == null) {
          if (curLevel.left != null)
            nextLevel = curLevel.left;
          else if (curLevel.right != null)
            nextLevel = curLevel.right;
        }
        curLevel = curLevel.nextRight;
      }
      System.out.println("null");
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
}
