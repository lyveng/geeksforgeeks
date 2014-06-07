package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

public class LoopDetection<T> {
  private boolean hasLoop;

  public LoopDetection(LinkedList<T> list) {
    LinkedListNode<T> slow=list.getHead(), fast=list.getHead().getNext();
    while (fast != null) {
      if (slow == fast) {
        hasLoop = true;
        return;
      }
      slow = slow.getNext();
      fast = fast.getNext();
      if (fast != null)
        fast = fast.getNext();
    }
  }

  public boolean hasLoop() {
    return hasLoop;
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.push(20);
    list.push(4);
    list.push(15);
    list.push(85);

    LoopDetection<Integer> loop = new LoopDetection<Integer>(list);
    System.out.println(loop.hasLoop());

    // Add a loop
    list.getHead().getNext().getNext().getNext().setNext(list.getHead());
    loop = new LoopDetection<Integer>(list);
    System.out.println(loop.hasLoop());
  }
}
