/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author m-w-n
 */
public class LinkedList
{
    static class Node
    {

        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    Node head; //head of list
    LinkedList()    //Constructor
    {
        head = null;
    }
    void sortedInsert(Node new_node)
    {
        Node current = head;
        if(current == null)         //Case: the list is empty
        {
            new_node.next = new_node;
            head = new_node;
        }else if(current.data >= new_node.data)     //Case: the current_node(head) has data greater than the data of the new_node, then we will add the new_node the head since the head  has the the least data.
        {
            while (current.next != head)
                current = current.next;
            current.next = new_node;
            new_node.next = head;
            head = new_node;
        }
        else
        {
            while (current.next != head && current.next.data< new_node.data)
            {
                current = current.next;
            }
                new_node.next = current.next;
                current.next = new_node;
        }
    }
        void printList()
        {
            if(head != null)
            {
                Node temp = head;
                do
                {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                } while (temp != head);  
            }
        }
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        int arr[] = new int[] {12, 56, 2, 11, 1, 90};
        Node temp = null;
        for (int i = 0; i < 6; i++)
        {
            temp = new Node(arr[i]);
            list.sortedInsert(temp);
        }
        list.printList();
    }
}