package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * 
 * @author emmanuel
 * 
 */
public class ReverseLinkedListGroups {
  public static <T extends Comparable<T>> void reverse(LinkedList<T> list, int k) {
    list.setHead(reverseUtil(list.getHead(), k));
  }

  private static <T extends Comparable<T>> LinkedListNode<T> reverseUtil(LinkedListNode<T> node, int k) {
    if (node == null) return null;
    LinkedListNode<T> first = node, last = first;
    for (int i = 1; i < k && last.getNext() != null; i++)
      last = last.getNext();
    LinkedListNode<T> next = last.getNext();
    last.setNext(null);
    LinkedListNode<T> newFirst = reverseList(first);
    first.setNext(reverseUtil(next, k));
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
    a.push(5);
    a.push(4);
    a.push(3);
    a.push(2);
    a.push(1);
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
