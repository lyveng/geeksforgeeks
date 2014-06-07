package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;

public class ReverseLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.push(20);
    list.push(4);
    list.push(15);
    list.push(85);

    System.out.println(list);
    list.reverse();
    System.out.println("Reversed Linked List :");
    System.out.println(list);
  }

}
