import java.util.ArrayList;
import java.util.List;

class ListNode {
  int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

class Node {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public List<Integer> printList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result;
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Use a dummy head and a tail pointer to build the merged list.
        ListNode dummy = new ListNode();
        ListNode tail = dummy;


        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining non-null list (if any).
        if (list1 != null) tail.next = list1;
        else tail.next = list2;

        return dummy.next;
    }

    public static void main(String[] args) {
        Node node = new Node();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Original list: " + node.printList(head));
        ListNode reversedHead = node.reverseList(head);
        System.out.println("Reversed list: " + node.printList(reversedHead));
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode mergedHead = node.mergeTwoLists(list1, list2);
        System.out.println("Merged list: " + node.printList(mergedHead));
        
    }
    
}
