package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 * 
 * @author emmanuel
 * 
 */
public class RemoveDuplicatesSortedLL {
  public static <T extends Comparable<T>> void removeDuplicates(LinkedList<T> list) {
    LinkedListNode<T> cur = list.getHead(), prev = list.getHead();
    while (cur != null) {
      while (prev.getData().equals(cur.getData()))
        cur = cur.getNext();
      prev.setNext(cur);
      prev = cur;
      cur = cur.getNext();
    }
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(10);
    a.push(20);
    a.push(20);
    a.push(20);
    a.push(40);
    a.push(50);
    a.push(50);
    a.push(50);
    a.push(50);
    a.push(50);
    a.push(60);
    a.push(70);
    System.out.println(a);
    removeDuplicates(a);
    System.out.println(a);
  }

}
