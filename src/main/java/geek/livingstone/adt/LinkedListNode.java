package geek.livingstone.adt;

public class LinkedListNode<T extends Comparable> {
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

  @Override
  public String toString() {
    return data.toString();
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    return super.equals(obj);
  }
}
