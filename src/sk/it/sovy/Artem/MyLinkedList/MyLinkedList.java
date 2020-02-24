package sk.it.sovy.Artem.MyLinkedList;

import sk.it.sovy.Artem.Node.Node;

public class MyLinkedList {
    private Node head;
    //private Node end;

    public MyLinkedList() {
        this.head = null;
    }

    public void addToFront(Node node) {
        if (node == null)
            return;

        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    public void addToEnd(Node node) {
        if (node == null)
            return;
        if (head == null)
            head = node;
        else {
            Node tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(node);
        }

    }

    public int getSize() {
        Node tmp = head;
        if (tmp == null)
            return 0;
        int count = 0;
        while (tmp != null) {
            tmp = tmp.getNext();
            count++;
        }
        return count;
    }


    public void add(Node node, int position) {
        if (node == null)
            return;
        if (position <= 0)
            addToFront(node);
        else {
            if (position >= getSize())
                addToEnd(node);
            else {
                Node tmp = head;
                for (int i = 1; i < position; i++)
                    tmp = tmp.getNext();
                node.setNext(tmp.getNext());
                tmp.setNext(node);
            }
        }
    }

    public void print() {
        if (head == null)
            System.out.println("The linked list is empty! There is nothing to print");
        else {
            Node tmp = head;
            while (tmp != null) {
                System.out.println(tmp.getData());
                tmp = tmp.getNext();
            }
        }
    }

    public boolean remove(Node node) {
        if (head == null || node == null)
            return false;
        if (head == node) {
            head = node.getNext();
            return true;
        }
        Node tmp = head;
        while (tmp.getNext() != node) {
            tmp = tmp.getNext();

            if (tmp == null)
                return false;
        }

        tmp.setNext(tmp.getNext().getNext());
        return true;
    }

    public void removeAll() {
        head = null;
    }

    public Node findByName(String name) {
        if (head == null || name == null)
            return null;

        Node tmp = head;
        if (!(tmp.getData() instanceof String)){
            return null;
        }
        while (tmp != null) {
            if (tmp.getData().equals(name))
                return tmp;
            tmp = tmp.getNext();
        }
        return null;
    }
}
