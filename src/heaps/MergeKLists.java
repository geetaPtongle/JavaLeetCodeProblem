package heaps;

import java.util.PriorityQueue;

class ListNode {
    int val;          // the value of the node
    ListNode next;    // reference to the next node in the list

    // Constructors
    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode node : lists){
            if(node !=null)
                pq.offer(node);
        }
        ListNode head =null;
        ListNode temp =null;

        while(!pq.isEmpty()){
            ListNode curr= pq.poll();
            if(head ==null){
                head =curr;
                temp =curr;
            }
            else{
                temp.next=curr;
                temp=curr;
            }
            if(curr.next !=null){
                pq.offer(curr.next);
            }
        }
        return head;
    }

    public ListNode mergeKListsUingDevideConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;

        ListNode l1 = mergeLists(lists, left, mid);
        ListNode l2 = mergeLists(lists, mid + 1, right);

        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        else curr.next = l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKLists sol = new MergeKLists();

        // Example: [[1->4->5], [1->3->4], [2->6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        ListNode mergedHead = sol.mergeKLists(lists);
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " -> ");
            mergedHead = mergedHead.next;
        }

        ListNode mergedHead1 = sol.mergeKListsUingDevideConquer(lists);
        while (mergedHead1 != null) {
            System.out.print("Geeta" + mergedHead1.val + " -> ");
            mergedHead1= mergedHead1.next;
        }
    }
}
