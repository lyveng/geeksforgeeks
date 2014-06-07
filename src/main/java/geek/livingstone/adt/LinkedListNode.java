package geek.livingstone.adt;

public class LinkedListNode<T> {
  private T data;
  private LinkedListNode<T> next;

  public LinkedListNode(T data) {
    super();
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public LinkedListNode<T> getNext() {
    return next;
  }

  public void setNext(LinkedListNode<T> next) {
    this.next = next;
  }
}
