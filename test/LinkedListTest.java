import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.it.sovy.Artem.MyLinkedList.MyLinkedList;
import sk.it.sovy.Artem.Node.Node;

import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSize() {
        MyLinkedList list = new MyLinkedList();
        assertEquals(0, list.getSize(), "Suppose to be 0!");
        Node<String> node_1 = new Node<>("Test node 1");
        Node<String> node_2 = new Node<>("Test node 2");
        Node<String> node_3 = new Node<>("Test node 3");
        list.addToFront(node_1);
        assertEquals(1, list.getSize(), "Suppose to be 1!");
        list.addToEnd(node_2);
        assertEquals(2, list.getSize(), "Suppose to be 2!");
        list.add(node_3, 1);
        assertEquals(3, list.getSize(), "Suppose to be 3!");
        list.remove(node_2);
        assertEquals(2, list.getSize(), "Suppose to be 2 again after last remove!");
        list.removeAll();
        assertEquals(0, list.getSize(), "Suppose to be 0 after removeAll!");

    }

    @Test
    void addTest() {
        MyLinkedList list = new MyLinkedList();
        Node<String> node_1 = new Node<>("Test node 1");
        Node<String> node_2 = new Node<>("");
        Node<String> node_3 = new Node<>("");
        Node<Integer> node_4 = new Node<>(10);
        Node<Date> node_5 = new Node<>(new Date());
        Node<Object> node_6 = new Node<>(15.5f);
        Node<String> node_7 = new Node<>("Test node 7");


        assertEquals(0, list.getSize(), "Suppose to be 0!");
        list.addToFront(node_1);
        assertNotNull(list.findByName("Test node 1"));
        assertNull(list.findByName("Test node 2"));
        list.addToFront(null);
        list.addToEnd(null);
        list.add(null, 1);
        assertEquals(1, list.getSize(), "Suppose to be 1!");
        list.addToFront(node_5);
        assertEquals(node_5, list.getHead());
        list.addToFront(node_6);
        assertNotEquals(node_5, list.getHead());

        list.addToEnd(node_4);
        Node tmp = list.getHead();
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        assertEquals(node_4, tmp);

        list.addToEnd(node_7);
        tmp = list.getHead();
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }

        assertNotEquals(node_4, tmp);
        assertEquals(node_7, tmp);

        list.removeAll();
        Node<String> node_11 = new Node<>("Test node 11");
        Node<String> node_12 = new Node<>("Test node 12");
        Node<String> node_13 = new Node<>("Test node 13");
        Node<String> node_14 = new Node<>("Test node 14");
        Node<String> node_15 = new Node<>("Test node 15");
        Node<String> node_16 = new Node<>("Test node 16");

        assertNull(list.getHead());
        list.addToFront(node_11);
        list.addToFront(node_12);
        list.add(node_13, 0);
        assertEquals(node_13, list.getHead());
        list.add(node_14, -1);
        assertEquals(node_14, list.getHead());
        list.add(node_15, 7485);

        tmp = list.getHead();
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }

        assertEquals(node_15, tmp);

        list.add(node_16, 2);
        assertEquals(node_16, list.getHead().getNext().getNext());

        list.remove(node_15);

        tmp = list.getHead();
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }

        assertNotEquals(tmp, node_15);

        list.removeAll();

        list.add(node_12, 426);
        assertEquals(node_12, list.getHead());
    }

    @Test
    void remove() {
        MyLinkedList list = new MyLinkedList();
        Node<String> node_12 = new Node<>("Test node 12");
        Node<String> node_13 = new Node<>("Test node 13");
        Node<String> node_14 = new Node<>("Test node 14");

        list.addToFront(node_12);
        list.addToFront(node_13);
        list.addToFront(node_14);
        list.remove(node_14);

        assertEquals(node_13, list.getHead());
    }
}