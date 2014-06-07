package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

public class DetectMiddle {
  public <T extends Comparable<?>> DetectMiddle(LinkedList<T> list) {
    LinkedListNode<T> fast = null, middle = list.getHead();
    if (middle != null)
      fast = middle.getNext();

    while (fast != null) {
      middle = middle.getNext();
      fast = fast.getNext();
      if (fast != null)
        fast = fast.getNext();
    }
    System.out.println("Middle element is " + middle.getData());
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.push(20);
    list.push(4);
    list.push(18);
    list.push(15);
    list.push(85);

    System.out.println(list);
    DetectMiddle dm = new DetectMiddle(list);
    System.out.println();

    list = new LinkedList<Integer>();
    list.push(20);
    list.push(4);
    list.push(18);
    list.push(15);
    System.out.println(list);
    dm = new DetectMiddle(list);
  }

}
