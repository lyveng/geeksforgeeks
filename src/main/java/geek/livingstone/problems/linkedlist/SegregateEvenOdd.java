package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 * 
 * @author emmanuel
 * 
 */
public class SegregateEvenOdd {

  public static void segregate(LinkedList<Integer> list) {
    LinkedListNode<Integer> current = list.getHead();
    LinkedListNode<Integer> last = list.getLast(), listEnd = last, next, prev = null;
    while (current != null && current != listEnd && current.getData() % 2 == 1) {
      next = current.getNext();
      current.setNext(null);
      last.setNext(current);
      current = next;
      last = last.getNext();
    }
    list.setHead(current);
    prev = current;
    current = current.getNext();
    while (current != null && current != listEnd) {
      if (current.getData() % 2 == 0) {
        prev = current;
        current = current.getNext();
      } else {
        next = current.getNext();
        prev.setNext(next);
        current.setNext(null);
        last.setNext(current);
        last = current;
        current = next;
      }
    }
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(6);
    a.push(7);
    a.push(1);
    a.push(4);
    a.push(5);
    a.push(10);
    a.push(12);
    a.push(8);
    a.push(15);
    a.push(17);
    System.out.println(a);
    segregate(a);
    System.out.println(a);
    System.out.println();
  }

}
