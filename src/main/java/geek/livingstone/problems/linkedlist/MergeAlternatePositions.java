package geek.livingstone.problems.linkedlist;

/**
 * Full problem at
 * http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
 * 
 * @author emmanuel
 * 
 */
public class MergeAlternatePositions {
  private static class Node {
    int data;
    Node next;

    Node(int data) {
      super();
      this.data = data;
    }
  }

  private static void print(Node node) {
    if (node == null)
      return;
    System.out.print(node.data);
    node = node.next;
    while (node != null) {
      System.out.print(" -> " + node.data);
      node = node.next;
    }
    System.out.println();
  }

  public static void merge(Node a, Node b) {
    Node aNext, bNext, aPrev = null;
    while (a != null && b != null) {
      aNext = a.next;
      bNext = b.next;

      // Remove node from list b
      b.next = null;

      // Add node to list a
      a.next = b;
      b.next = aNext;

      aPrev = a;
      a = aNext;
      b = bNext;
    }

    if (aPrev != null && a == null && b != null)
      aPrev.next = b;
  }

  public static void main(String[] args) {
    Node a = new Node(5);
    a.next = new Node(7);
    a.next.next = new Node(17);
    a.next.next.next = new Node(13);
    a.next.next.next.next = new Node(11);

    Node b = new Node(12);
    b.next = new Node(10);
    b.next.next = new Node(2);
    b.next.next.next = new Node(4);
    b.next.next.next.next = new Node(6);

    print(a);
    print(b);
    merge(a, b);
    System.out.println();
    print(a);
    print(b);
  }

}
