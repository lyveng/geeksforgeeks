package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 * 
 * @author emmanuel
 *
 */
public class DeleteElementsWithGreaterValueOnRightSide {
  public static <T extends Comparable<T>> void deleteGreater(LinkedList<T> list) {
    list.setHead(deleteGreaterUTil(list.getHead()));
  }

  public static <T extends Comparable<T>> LinkedListNode<T> deleteGreaterUTil(LinkedListNode<T> node) {
    if (node == null || node.getNext() == null)
      return node;
    node.setNext(deleteGreaterUTil(node.getNext()));
    if (node.getData().compareTo(node.getNext().getData()) < 0)
      return node.getNext();
    return node;
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(10);
    a.push(8);
    a.push(9);
    a.push(11);
    System.out.println(a);
    deleteGreater(a);
    System.out.println(a);
    System.out.println();

    a = new LinkedList<>();
    a.push(3);
    a.push(2);
    a.push(6);
    a.push(5);
    a.push(11);
    a.push(10);
    a.push(15);
    a.push(12);
    System.out.println(a);
    deleteGreater(a);
    System.out.println(a);
  }
}
