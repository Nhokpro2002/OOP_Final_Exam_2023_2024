package hus.oop.mybookmanager;

import java.util.NoSuchElementException;

public class MyLinkedList extends AbstractMyList {
    private Node head;
    private int size;

    private class MyLinkedListIterator implements MyIterator {
        private Node currentNode;

        public MyLinkedListIterator(int start) {
            currentNode = getNodeByIndex(start);
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }

    /**
     * Constructor to initialize the list.
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(Object data, int index) {
        Node targetNode = getNodeByIndex(index);
        targetNode.data = data;
    }

    @Override
    public void insertAtStart(Object value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void insertAtEnd(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node tail = getNodeByIndex(size - 1);
            tail.next = newNode;
        }
        size++;
    }

    @Override
    public void insertAtPosition(Object value, int index) {
        checkBoundaries(index, size); // Allow inserting at size (end of list)
        if (index == 0) {
            insertAtStart(value);
        } else {
            Node previousNode = getNodeByIndex(index - 1);
            Node newNode = new Node(value);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
            size++;
        }
    }

    @Override
    public void remove(int index) {
        checkBoundaries(index, size);
        if (index == 0) {
            head = head.next;
        } else {
            Node previousNode = getNodeByIndex(index - 1);
            previousNode.next = previousNode.next.next;
        }
        size--;
    }

    private Node getNodeByIndex(int index) {
        checkBoundaries(index, size);
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public MyIterator iterator(int start) {
        checkBoundaries(start, size); // Ensure starting index is valid
        return new MyLinkedListIterator(start);
    }

    @Override
    public Node get(int index) {
        return getNodeByIndex(index);
    }
}
