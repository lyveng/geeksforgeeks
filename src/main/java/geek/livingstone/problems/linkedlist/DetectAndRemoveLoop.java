package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 * 
 * @author emmanuel
 * 
 */
public class DetectAndRemoveLoop {
  public static <T extends Comparable<T>> void detectAndRemoveLoop(LinkedList<T> list) {
    LinkedListNode<T> loopNode = detectLoopNode(list.getHead());
    int loopLength = getLoopLength(loopNode);
    LinkedListNode<T> loopEndNode = detectLoopEndNode(list.getHead(), loopLength);
    loopEndNode.setNext(null);
  }

  private static <T extends Comparable<T>> LinkedListNode<T> detectLoopNode(LinkedListNode<T> node) {
    LinkedListNode<T> slow = node, fast = node;
    while (fast != null) {
      slow = slow.getNext();
      fast = fast.getNext();
      if (fast != null) fast = fast.getNext();
      if (slow == fast) return slow;
    }
    return null;
  }

  private static <T extends Comparable<T>> int getLoopLength(LinkedListNode<T> node) {
    LinkedListNode<T> current = node.getNext();
    int loopLength = 1;
    while (current != node) {
      loopLength++;
      current = current.getNext();
    }
    return loopLength;
  }

  private static <T extends Comparable<T>> LinkedListNode<T> detectLoopEndNode(LinkedListNode<T> head, int loopLength) {
    LinkedListNode<T> end = head, slow = head;
    for (int i = 1; i < loopLength; i++)
      end = end.getNext();
    while (end.getNext() != slow) {
      slow = slow.getNext();
      end = end.getNext();
    }
    return end;
  }


  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(5);
    a.push(4);
    a.push(3);
    a.push(2);
    a.push(1);
    a.getHead().getNext().getNext().getNext().getNext().setNext(a.getHead().getNext());

    detectAndRemoveLoop(a);
    System.out.println(a);
  }

}
