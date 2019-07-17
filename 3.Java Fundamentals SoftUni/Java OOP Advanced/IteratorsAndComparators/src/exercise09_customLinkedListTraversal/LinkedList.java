package exercise09_linkedListTraversal;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements Iterable<Node> {

    private Node head;
    int sizeCounter = 0;

    public void add(int data) {
        sizeCounter++;
        Node node = new Node();
        node.setData(data);
        node.setNext(null);

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(node);
        }
    }

    public boolean remove(int data) {
        Node nodeBeforeDelete = this.head;
        if (nodeBeforeDelete == null) { // List in empty
            return false;
        } else if (nodeBeforeDelete.getData().equals(data)) {
            this.head = this.head.getNext();
            sizeCounter--;
            return true;
        }
        while (true) {
            Node next = nodeBeforeDelete.getNext();
            if (next == null) { // No data found in list
                return false;
            } else if (next.getData().equals(data)) {
                break;
            }
            nodeBeforeDelete = next;
        }
        Node next = nodeBeforeDelete.getNext();
        nodeBeforeDelete.setNext(next.getNext());
        next.setNext(null);
        sizeCounter--;
        return true;
    }

    @Override
    public Iterator<Node> iterator() {
        return new LinkedListIterator();
    }

    private final class LinkedListIterator implements Iterator<Node> {

        Node next;

        LinkedListIterator() {
            next = head;
        }

        @Override
        public boolean hasNext() {
            return (next != null);
        }

        @Override
        public Node next() {
            if (next == null) {
                throw new NoSuchElementException();
            }
            Node res = next;
            next = next.getNext();
            return res;
        }
    }
}
