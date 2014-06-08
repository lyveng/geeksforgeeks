package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

public class ListIntersection {
  

  public <T extends Comparable<T>> ListIntersection(LinkedList<T> a, LinkedList<T> b) {
    System.out.println("First list is " + a);
    System.out.println("Second list is " + b);
    int l1 = a.getLength(), l2 = b.getLength();
    LinkedListNode<T> longer = l1 > l2 ? a.getHead() : b.getHead();
    LinkedListNode<T> shorter = l1 > l2 ? b.getHead() : a.getHead();
    System.out.println("longer is " + longer + "\nshorter is " + shorter);
    for (int i=0; i<Math.abs(l1 - l2);i++)
      longer = longer.getNext();
    while (longer!=null && shorter!=null && !longer.getData().equals(shorter.getData())) {
      longer = longer.getNext();
      shorter = shorter.getNext();
    }
    System.out.println("They intersect at node " + longer.getData());
    System.out.println();
  }
  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    LinkedList<Integer> b = new LinkedList<>();
    a.push(10);
    a.push(20);
    a.push(30);
    a.push(40);
    a.push(50);
    b.push(10);
    b.push(20);
    b.push(30);
    b.push(80);
    b.push(90);
    b.push(95);
    b.push(99);
    new ListIntersection(a, b);
  }

}
