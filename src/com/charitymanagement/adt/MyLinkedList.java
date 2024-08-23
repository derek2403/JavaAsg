package com.charitymanagement.adt;

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Remove element by value
    public boolean remove(T data) {
        if (head == null) {
            return false;
        }

        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return true;
        }

        Node<T> current = head;
        Node<T> previous = null;
        while (current != null && !current.getData().equals(data)) {
            previous = current;
            current = current.getNext();
        }

        if (current != null) {
            previous.setNext(current.getNext());
            size--;
            return true;
        }

        return false;
    }

    // Find element by value
    public T search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    // Display all elements
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    // Get size of the linked list
    public int size() {
        return size;
    }

    // Filter elements based on a criteria
    public MyLinkedList<T> filter(FilterCriteria<T> criteria) {
        MyLinkedList<T> filteredList = new MyLinkedList<>();
        Node<T> current = head;
        while (current != null) {
            if (criteria.match(current.getData())) {
                filteredList.add(current.getData());
            }
            current = current.getNext();
        }
        return filteredList;
    }

    // Functional interface for filtering
    @FunctionalInterface
    public interface FilterCriteria<T> {
        boolean match(T data);
    }
}
