package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 * 
 * @author emmanuel
 *
 */
public class ReverseLinkedListAlternateGroups {
  public static <T extends Comparable<T>> void reverse(LinkedList<T> list, int k) {
    list.setHead(reverseUtil(list.getHead(), k));
  }

  private static <T extends Comparable<T>> LinkedListNode<T> reverseUtil(LinkedListNode<T> node, int k) {
    if (node == null) return null;
    LinkedListNode<T> first = node, last = first, midFirst=null, midLast = first;
    for (int i = 1; i < 2*k && last.getNext() != null; i++) {
      if (i%k==0)
      {
        midLast = last;
        midFirst = last.getNext();
        last = last.getNext();
        midLast.setNext(null);
      }
      else
        last = last.getNext();
      if (i < k)
        midLast = last;
    }
    if (midLast == last)
    {
      last.setNext(null);
      return reverseList(first);
    }
    LinkedListNode<T> next = last.getNext();
    midLast.setNext(null);
    LinkedListNode<T> newFirst = reverseList(first);
    last.setNext(reverseUtil(next, k));
    first.setNext(midFirst);
    return newFirst;
  }

  private static <T extends Comparable<T>> LinkedListNode<T> reverseList(LinkedListNode<T> node) {
    if (node == null || node.getNext() == null) return node;
    LinkedListNode<T> prev = null, cur = node, next;
    while (cur != null) {
      next = cur.getNext();
      cur.setNext(prev);
      prev = cur;
      cur = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(11);
    a.push(10);
    a.push(9);
    a.push(8);
    a.push(7);
    a.push(6);
    a.push(5);
    a.push(4);
    a.push(3);
    a.push(2);
    a.push(1);
    System.out.println("Original " + a);
    reverse(a, 2);
    System.out.println("Reversed " + a);
  }
}
