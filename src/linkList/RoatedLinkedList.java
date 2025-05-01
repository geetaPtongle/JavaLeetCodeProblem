package linkList;

import java.util.LinkedList;
class Node {
    int num;
    Node next;
    Node(int a) {
        num = a;
        next = null;
    }
}
public class RoatedLinkedList {
    public static void main(String[] args) {
        RoatedLinkedList rll = new RoatedLinkedList();
        Node head = null;
        //inserting Node
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,4);
        head=insertNode(head,5);

        System.out.println("Original list: ");
        printList(head);

        int k = 10;
        Node newHead = rotateRight(head,k);//calling function for rotating right  of the nodes by k times

        System.out.println("After "+k+" iterations: ");
        printList(newHead);


    }
    static Node insertNode(Node head,int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }
    public static Node rotateRight(Node head, int k) {
        if(head ==null || head.next == null) return head;
        int n;
        Node tail =head;
        for( n=1; tail.next != null; n++){
            tail = tail.next;
        }
        tail.next=head;
        k %=n;
        Node new_head=head, new_tail=head;
        for(int i=1; i<n-k;i++){
            new_tail=new_tail.next;
        }
        new_head=new_tail.next;
        new_tail.next=null;
        return new_head;
    }

    static void printList(Node head) {
        while(head.next != null) {
            System.out.print(head.num+"->");
            head = head.next;
        }
        System.out.println(head.num);

    }
}
