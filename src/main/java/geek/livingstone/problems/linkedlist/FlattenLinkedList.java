package geek.livingstone.problems.linkedlist;

/**
 * Full problem at http://www.geeksforgeeks.org/flattening-a-linked-list/
 * 
 * @author emmanuel
 * 
 */
public class FlattenLinkedList {
  
  public static Node flatten(Node head) {
    if (head == null || head.right == null) {
      return head;
    }
    Node next = head.right;
    head.right = null;
    return merge(head, flatten(next));
  }

  public static Node merge(Node a, Node b) {
    if (a == null && b == null)
      return null;
    else if (a == null)
      return b;
    else if (b == null)
      return a;
    if (a.data < b.data) {
      a.down = merge(a.down, b);
      return a;
    }
    else {
      b.down = merge(a, b.down);
      return b;
    }
  }

  private static class Node {
    int data;
    Node right;
    Node down;

    Node(int data) {
      super();
      this.data = data;
    }
  }

  public static void print(Node node) {
    Node down;
    while (node != null) {
      System.out.print(node.data);
      down = node.down;
      while (down != null) {
        System.out.print(" -> " + down.data);
        down = down.down;
      }
      if (node.right != null) {
        System.out.println();
        System.out.println("|");
        System.out.println("V");
      }
      node = node.right;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(5);
    head.down = new Node(7);
    head.down.down = new Node(8);
    head.down.down.down = new Node(30);

    head.right = new Node(10);
    head.right.down = new Node(20);

    head.right.right = new Node(19);
    head.right.right.down = new Node(22);
    head.right.right.down.down = new Node(50);

    head.right.right.right = new Node(28);
    head.right.right.right.down = new Node(35);
    head.right.right.right.down.down = new Node(40);
    head.right.right.right.down.down.down = new Node(45);

    print(head);
    Node mergeHead = flatten(head);
    System.out.println("\n\n");
    print(mergeHead);
  }

}
