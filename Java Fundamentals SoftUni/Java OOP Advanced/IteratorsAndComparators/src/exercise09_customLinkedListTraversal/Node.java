package exercise09_linkedListTraversal;

public class Node<T> {

     private T data;
     private Node next;

    public Node() {
        this.setData(data);
        this.setNext(next);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
