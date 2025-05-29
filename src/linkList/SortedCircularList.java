package linkList;

public class SortedCircularList {
    public Node insert(Node head, int data) {
        Node newNode = new Node(data);

        // Inserting element at the start while retaining circular list
        if (head.val >= data) {
            newNode.next = head;

            Node ptr = head;
            while (ptr.next != head) {
                ptr = ptr.next;
            }
            ptr.next = newNode;

            return newNode;
        }

        Node ptr = head;
        while (ptr.next != head && ptr.next.val <= data) {
            ptr = ptr.next;
        }

        newNode.next = ptr.next;
        ptr.next = newNode;

        return head;
    }

    // Helper method to print the list in sorted order
    public void printSorted(Node head) {
        if (head == null) return;

        // Find the smallest node
        Node min = head;
        Node curr = head.next;
        while (curr != head) {
            if (curr.val < min.val) {
                min = curr;
            }
            curr = curr.next;
        }

        // Print from the smallest node
        Node temp = min;
        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != min);
        System.out.println();
    }

    public static void main(String[] args) {
        SortedCircularList scl = new SortedCircularList();

        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(4);

        head.next = node1;
        node1.next = node2;
        node2.next = head;

        head = scl.insert(head, 2);
        scl.printSorted(head);  // Output: 1 2 3 4
    }
}
