package linkList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }}

class DleteNodes {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode prev = head;
        ListNode curr = head;

        while (curr != null) {
            // Step 1: Skip m nodes
            for (int i = 0; i < m && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }

            // Step 2: Delete next n nodes
            for (int i = 0; i < n && curr != null; i++) {
                curr = curr.next;
            }

            // Connect the m-th node to the (m+n)-th node
            prev.next = curr;
        }

        return head;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        DleteNodes solution = new DleteNodes();
        int m = 2; // Skip 2 nodes
        int n = 2; // Delete 2 nodes
        ListNode result = solution.deleteNodes(head, m, n);

        // Print the resulting linked list
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
