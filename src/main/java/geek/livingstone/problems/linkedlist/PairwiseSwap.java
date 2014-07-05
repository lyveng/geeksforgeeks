package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 * 
 * @author emmanuel
 * 
 */
public class PairwiseSwap {
  public static <T extends Comparable<T>> LinkedListNode<T> swapUtil(LinkedListNode<T> node) {
    if (node == null) return null;
    LinkedListNode<T> prev = node;
    LinkedListNode<T> cur = node.getNext();
    if (cur == null) return node;
    LinkedListNode<T> next = cur.getNext();
    prev.setNext(swapUtil(next));
    cur.setNext(prev);
    return cur;
  }

  public static <T extends Comparable<T>> void pairwiseSwap(LinkedList<T> list) {
    list.setHead(swapUtil(list.getHead()));
  }

  public static <T extends Comparable<T>> LinkedListNode<T> swapUtil2(LinkedListNode<T> node) {
    if (node == null || node.getNext() == null)
      return node;
    LinkedListNode<T> next = node.getNext().getNext(), a = node, b = node.getNext();
    b.setNext(a);
    a.setNext(swapUtil2(next));
    return b;
  }

  public static <T extends Comparable<T>> void pairwiseSwap2(LinkedList<T> list) {
    list.setHead(swapUtil2(list.getHead()));
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(5);
    a.push(4);
    a.push(3);
    a.push(2);
    a.push(1);
    System.out.println(a);
    pairwiseSwap(a);
    System.out.println(a);
    pairwiseSwap(a);
    System.out.println(a);
  }
}
