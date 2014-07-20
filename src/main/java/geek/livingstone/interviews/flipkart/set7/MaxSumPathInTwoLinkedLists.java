package geek.livingstone.interviews.flipkart.set7;


public class MaxSumPathInTwoLinkedLists {
  public static void printMaxSumPath(Node a, Node b) {
    Node aCur = a, bCur = b, prevCommonA = a, prevCommonB = b;
    Node start, end;
    int aSum = 0, bSum = 0;
    while (aCur != null && bCur != null) {
      if (aCur.data == bCur.data) {
        if (aSum >= bSum) {
          start = prevCommonA;
          end = aCur;
        } else {
          start = prevCommonB;
          end = bCur;
        }
        while (start != end) {
          System.out.print(start.data + " ");
          start = start.next;
        }
        prevCommonA = aCur;
        prevCommonB = bCur;
        aSum = 0;
        bSum = 0;
        aCur = aCur.next;
        bCur = bCur.next;
      } else if (aCur.data < bCur.data) {
        aSum += aCur.data;
        aCur = aCur.next;
      } else {
        bSum += bCur.data;
        bCur = bCur.next;
      }
    }
    while (aCur != null) {
      aSum += aCur.data;
      aCur = aCur.next;
    }
    while (bCur != null) {
      bSum += bCur.data;
      bCur = bCur.next;
    }
    if (aSum >= bSum) {
      start = prevCommonA;
      end = aCur;
    } else {
      start = prevCommonB;
      end = bCur;
    }
    while (start != end) {
      System.out.print(start.data + " ");
      start = start.next;
    }

    System.out.println();
  }

  public static void main(String[] args) {
    Node a = new Node(1);
    a.next = new Node(3);
    a.next.next = new Node(30);
    a.next.next.next = new Node(90);
    a.next.next.next.next = new Node(120);
    a.next.next.next.next.next = new Node(240);
    a.next.next.next.next.next.next = new Node(511);
    Node b = new Node(0);
    b.next = new Node(3);
    b.next.next = new Node(12);
    b.next.next.next = new Node(32);
    b.next.next.next.next = new Node(90);
    b.next.next.next.next.next = new Node(125);
    b.next.next.next.next.next.next = new Node(240);
    b.next.next.next.next.next.next.next = new Node(249);
    printMaxSumPath(a, b);
  }

  private static class Node {
    Node next;
    int data;

    Node(int data) {
      super();
      this.data = data;
    }
  }
}
