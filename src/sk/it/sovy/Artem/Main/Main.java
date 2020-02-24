package sk.it.sovy.Artem.Main;

import sk.it.sovy.Artem.MyLinkedList.MyLinkedList;
import sk.it.sovy.Artem.Node.Node;

public class Main {
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        Node<String> node = new Node<>("Student");
        Node<String> node_1 = new Node<>("Teacher");
        Node<String> node_2 = new Node<>("Clicker");
        Node<String> node_3 = new Node<>("Tuckers");
        Node<String> node_4 = new Node<>("Bart");
        Node<String> node_5 = new Node<>("Robert");

        list.addToFront(node);
        list.addToFront(node_1);
        list.addToEnd(node_2);
        list.add(node_3, 12);
        list.add(node_4, -4);
        //list.add(node_5, );

        //list.remove(list.findByName("Student"));

        System.out.println(list.findByName("Student").getData());

        Node<Integer> node_6 = new Node<>(14);

        //list.remove(node_1);
        //list.remove(node_5);
        //list.remove(null);



        list.print();
        System.out.println(list.getSize());

    }
}
