package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

public class DetectMiddle<T> {
  private LinkedListNode<T> middlePrev;
  private LinkedListNode<T> middle;

  public DetectMiddle(LinkedList<T> list) {
    middle = list.getHead();
    middlePrev = null;
    LinkedListNode<T> fast = null;
    if (middle != null)
      fast = middle.getNext();
    
    while (fast != null) {
      middlePrev = middle;
      middle = middle.getNext();
      fast = fast.getNext();
      if (fast != null)
        fast = fast.getNext();
    }
  }

  public LinkedListNode<T> getMiddle() {
    return middle;
  }

  /**
   * Splits the linked list into half. Stores the first half in the object passed in the constructor
   * and returns a new linked list representing the second half.
   * 
   * @return
   */
  public LinkedList<T> splitIntoHalf() {
    middlePrev.setNext(null);
    LinkedList<T> list = new LinkedList<T>();
    list.setHead(middle);
    return list;
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.push(20);
    list.push(4);
    list.push(15);
    list.push(85);

    System.out.println(list);
    DetectMiddle<Integer> dm = new DetectMiddle<>(list);
    System.out.println("Middle element is " + dm.getMiddle());
  }

}
