/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 6 & 7
Any and all work in this file is my own.
*/ 

public class SingleNode {
    protected String item;
    protected SingleNode next;

    public SingleNode(String item) {
        this.item = item;
        this.next = null;
    }

    public SingleNode(String item, SingleNode next) {
        this.item = item;
        this.next = next;
    }
}
