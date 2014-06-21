package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

public class AlternateMerge {
  public static <T extends Comparable<T>> void altMerge(LinkedList<T> a, LinkedList<T> b) {
    LinkedListNode<T> aHead=a.getHead(), bHead=b.getHead(), aNext=null, bNext=null, last=a.getHead();
    while (aHead!=null && bHead!=null)
    {
      aNext = aHead.getNext();
      bNext = bHead.getNext();
      aHead.setNext(bHead);
      aHead = aHead.getNext();
      aHead.setNext(aNext);
      
      last = aHead;
      aHead = aHead.getNext();
      bHead = bNext;
    }
    if (aHead == null && bHead != null)
      last.setNext(bHead);
  }

  public static void main(String[] args) {
    LinkedList<Integer> a=new LinkedList<>(),b = new LinkedList<>();
    // a = 563
    a.push(3);
    a.push(6);
    a.push(5);
    // b = 842
    b.push(2);
    b.push(4);
    b.push(8);
    b.push(9);
    System.out.println(a);
    System.out.println(b);
    altMerge(a, b);
    System.out.println(a);
  }

}
