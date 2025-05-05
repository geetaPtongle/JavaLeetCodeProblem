package linkList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
//        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode head = null;
        ListNode temp = null;

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            if (head == null) {
                head = curr;
                temp = curr;
            } else {
                temp.next = curr;
                temp = curr;
            }
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return head;
    }

    // Helper to create a linked list from an array
    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test mergeKLists
    public static void main(String[] args) {
        MergeKLists sol = new MergeKLists();

        ListNode l1 = createList(new int[]{1, 4, 5});
        ListNode l2 = createList(new int[]{1, 3, 4});
        ListNode l3 = createList(new int[]{2, 6});

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode merged = sol.mergeKLists(lists);

        System.out.println("Merged List:");
        printList(merged);
    }
}
