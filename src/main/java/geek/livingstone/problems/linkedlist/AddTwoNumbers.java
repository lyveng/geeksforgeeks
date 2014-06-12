package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 * 
 * @author emmanuel
 *
 */
public class AddTwoNumbers {
  public static LinkedList<Integer> add(LinkedList<Integer> a, LinkedList<Integer> b) {
    LinkedList<Integer> c = new LinkedList<>();
    c.setHead(addUtil(a.getHead(), b.getHead()));
    return c;
  }

  public static LinkedListNode<Integer> addUtil(LinkedListNode<Integer> a, LinkedListNode<Integer> b) {
    LinkedListNode<Integer> head = null, current = null;
    int carry = 0;
    while (a!=null && b!=null) {
      if (current != null) {
        current.setNext(new LinkedListNode<Integer>(a.getData() + b.getData() + carry));
        current = current.getNext();
      }
      else {
        current = new LinkedListNode<Integer>(a.getData() + b.getData() + carry);
        head = current;
      }
      carry = current.getData() / 10;
      current.setData(current.getData() % 10);
      a = a.getNext();
      b = b.getNext();
    }
    while (a!=null)
    {
      if (current != null) {
        current.setNext(new LinkedListNode<Integer>(a.getData() + carry));
        current = current.getNext();
      }
      else {
        current = new LinkedListNode<Integer>(a.getData() + carry);
        head = current;
      }
      carry = current.getData() / 10;
      current.setData(current.getData() % 10);
      a = a.getNext();
    }
    while (b!=null)
    {
      if (current != null) {
        current.setNext(new LinkedListNode<Integer>(b.getData() + carry));
        current = current.getNext();
      }
      else {
        current = new LinkedListNode<Integer>(b.getData() + carry);
        head = current;
      }
      carry = current.getData() / 10;
      current.setData(current.getData() % 10);
      b = b.getNext();
    }
    if (carry > 0)
      current.setNext(new LinkedListNode<Integer>(carry));
    return head;
  }

  public static void main(String[] args) {
    LinkedList<Integer> a=new LinkedList<>(),b = new LinkedList<>(),c;
    // a = 563
    a.push(3);
    a.push(6);
    a.push(5);
    // b = 842
    b.push(2);
    b.push(4);
    b.push(8);
    c = add(a,b);
    System.out.println(a + " + " + b +"\n" + c);
    System.out.println();

    a=new LinkedList<>();
    b = new LinkedList<>();
    // a = 563
    a.push(6);
    a.push(4);
    a.push(9);
    a.push(5);
    a.push(7);
    // b = 842
    b.push(4);
    b.push(8);
    c = add(a,b);
    System.out.println(a + " + " + b +"\n" + c);
    System.out.println();
  }

}
