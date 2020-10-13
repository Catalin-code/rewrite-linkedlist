package com.codecool.linkedlist;

public class SinglyLinkedList {

    private class Link {

        private int value;

        private Link next;

        Link(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;

    private int size = 0;

    public SinglyLinkedList() {
    }

    /**
     * Add a new element to the list.
     * The new element is appended to the current last item.
     *
     * @param value value to be appended
     */
    public void add(int value) {
        Link temp = new Link(value);
        if (size == 0){
            size++;
            head = temp;
        } else {
            size++;
            Link last = head;
            while (last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(temp);
        }
    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */
    public int get(int index) {
        Link temp = head;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }
        return temp.getValue();
    }

    /**
     * Returns the zero-based index of the first occurrence of a value in the list.
     *
     * @param number value to be searched
     * @return Index of 'number' if it's in the list, otherwise -1;
     */
    public int indexOf(int number) {
        Link temp = head;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (temp.getValue() == number){
                return index;
            } else {
                temp = temp.getNext();
                index++;
            }
        }
        return -1;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index  Position of the new element
     * @param number Value to be inserted.
     */
    public void insert(int index, int number) {
        Link temp = new Link(number);
        if (index == 0){
            size++;
            temp.setNext(head);
            head = temp;
        } else if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        } else {
            size++;
            Link oneBeforeIndex = head;
            Link oneAfterIndex = head;
            for (int i = 0; i < index - 1; i++) {
                oneBeforeIndex = oneBeforeIndex.getNext();
            }
            oneAfterIndex = oneBeforeIndex.getNext();
            oneBeforeIndex.setNext(temp);
            temp.setNext(oneAfterIndex);
        }
    }

    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        return size;
    }

    /**
     * Removes the element at 'index' from the array.
     *
     * @param index Position of value to be deleted.
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }

    @Override
    public String toString(){
        if (size == 0){
            return "[]";
        }
        Link temp = head;
        String array = "[";
        for (int i = 0; i < size; i++) {
            array = array + Integer.toString(temp.getValue()) + ",";
            temp = temp.getNext();
        }
        array = array.substring(0, array.length()-1) + "]";
        return array;
    }
}