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
    list.setHead(segregateUtil(list.getHead()));
  }

  public static LinkedListNode<Integer> segregateUtil(LinkedListNode<Integer> node) {
    LinkedListNode<Integer> last = getLast(node), initialEnd = last, current = node, head = node, prev = null, next;
    while (current != initialEnd) {
      if (current.getData() % 2 == 1) {
        next = current.getNext();
        current.setNext(null);
        last.setNext(current);
        last = current;
        current = next;
        if (prev == null) {
          // The first element in the list is getting processed. So need to set new head to be
          // returned.
          head = current;
        } else if (next.getData() % 2 == 0) {
          prev.setNext(next);
          prev = current;
        }
      } else {
        prev = current;
        current = current.getNext();
      }
    }
    return head;
  }

  public static LinkedListNode<Integer> getLast(LinkedListNode<Integer> node) {
    LinkedListNode<Integer> last = node;
    while (last != null && last.getNext() != null)
      last = last.getNext();
    return last;
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
  }

}
