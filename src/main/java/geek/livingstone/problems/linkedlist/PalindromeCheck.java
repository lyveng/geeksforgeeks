package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

public class PalindromeCheck {
  private boolean isPalindrome;
  
  public <T extends Comparable> PalindromeCheck(LinkedList<T> list) {
    // Split the linked list into two halves.
    LinkedListNode<T> slow=list.getHead(), fast=list.getHead(), slowPrev = null;
    int count = 0;
    if (fast != null) {
      fast = fast.getNext();
      count++;
    }
    while (fast != null) {
      slowPrev = slow;
      slow = slow.getNext();
      fast = fast.getNext();
      count++;
      if (fast != null) {
        fast = fast.getNext();
        count++;
      }
    }

    LinkedList<T> secondHalf = new LinkedList<>();
    slowPrev.setNext(null);
    if (count % 2 == 0)
      secondHalf.setHead(slow);
    else
      secondHalf.setHead(slow.getNext());
    secondHalf.reverse();

    // Compare first half and reversed second half.
    LinkedListNode<T> a=list.getHead(), b=secondHalf.getHead();
    while (a!=null && b!=null)
    {
      if (!a.getData().equals(b.getData())) {
        break;
      }
      a = a.getNext();
      b = b.getNext();
    }

    // Reverse second half again to get original second half and join it with original list.
    secondHalf.reverse();
    slowPrev.setNext(slow);
    if (a!=null || b!=null)
      System.out.println(list + " is not a palindrome");
    else
      System.out.println(list + " is a palindrome");
    
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.push(20);
    list.push(4);
    list.push(15);
    list.push(85);
    list.push(11);
    list.push(85);
    list.push(15);
    list.push(4);
    list.push(20);
    PalindromeCheck p = new PalindromeCheck(list);

    list = new LinkedList<Integer>();
    list.push(20);
    list.push(4);
    list.push(15);
    list.push(85);
    list.push(85);
    list.push(15);
    list.push(20);
    p = new PalindromeCheck(list);
  }

}
