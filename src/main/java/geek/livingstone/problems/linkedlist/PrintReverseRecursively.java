package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at
 * http://www.geeksforgeeks.org/write-a-recursive-function-to-print-reverse-of-a-linked-list/
 * 
 * @author emmanuel
 * 
 */
public class PrintReverseRecursively {
  public static void printReverse(LinkedListNode<Integer> node) {
    if (node == null) return;
    printReverse(node.getNext());
    System.out.print(node.getData() + " ");
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(10);
    a.push(20);
    a.push(30);
    a.push(40);
    a.push(50);
    System.out.println(a);
    printReverse(a.getHead());
  }

}
