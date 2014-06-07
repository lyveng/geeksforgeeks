package geek.livingstone.adt;

public class LinkedList<T> {
  private LinkedListNode<T> head;
  
  public void push(T data) {
    LinkedListNode<T> newNode = new LinkedListNode<T>(data);
    if (head == null) {
      head = newNode;
      return;
    }
    newNode.setNext(head);
    head = newNode;
  }

  public LinkedListNode<T> getHead() {
    return head;
  }

  public void setHead(LinkedListNode<T> head) {
    this.head = head;
  }

  public void reverse() {
    LinkedListNode<T> prev = null, cur = head, next;
    while (cur != null) {
      next = cur.getNext();
      cur.setNext(prev);
      prev = cur;
      cur = next;
    }
    head = prev;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("LinkedList [");
    LinkedListNode<T> cur = head;
    while (cur != null) {
      sb.append(cur.getData());
      sb.append(" ");
      cur = cur.getNext();
    }
    sb.deleteCharAt(sb.length()-1);
    sb.append(']');
    return sb.toString();
  }
}
