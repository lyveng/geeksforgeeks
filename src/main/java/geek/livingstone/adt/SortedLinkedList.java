package geek.livingstone.adt;

public class SortedLinkedList<T extends Comparable> extends LinkedList<T> {

  @Override
  public void push(T data) {
    LinkedListNode<T> cur = getHead(), prev = null;
    while (cur != null && cur.getData().compareTo(data) < 0) {
      prev = cur;
      cur = cur.getNext();
    }
    LinkedListNode<T> newNode = new LinkedListNode<T>(data);
    if (prev == null) {
      if (cur != null) {
        newNode.setNext(getHead());
      }
      setHead(newNode);
    }
    else {
      newNode.setNext(cur);
      prev.setNext(newNode);
    }
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new SortedLinkedList<>();
    list.push(20);
    list.push(4);
    list.push(15);
    list.push(19);
    list.push(85);
    list.push(11);
    list.push(85);
    list.push(15);
    list.push(4);
    list.push(20);
    System.out.println(list);
  }
}
