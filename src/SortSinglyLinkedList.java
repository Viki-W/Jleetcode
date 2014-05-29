/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null) {  
            return head;  
        }  
        return mergeSort(head);  
    }  
  
    private ListNode mergeSort(ListNode head) {  
        if (head == null || head.next == null) {  
            return head;  
        }  
  
        // find the mid node, and split to two lists  
        ListNode p = head;  
        ListNode q = head;  
        ListNode pPre = p;  
        while (q != null && q.next != null) {  
            pPre = p;  
            p = p.next;  
            q = q.next.next;  
        }  
        pPre.next = null; // split  
  
        // divide and conquer  
        ListNode l1 = mergeSort(head);  
        ListNode l2 = mergeSort(p);  
  
        // merge  
        return merge(l1, l2);  
    }  
  
    private ListNode merge(ListNode l1, ListNode l2) {  
        ListNode guard = new ListNode(0); // guard  
        ListNode tail = guard;  
        while (l1 != null && l2 != null) {  
            if (l1.val < l2.val) {  
                tail.next = l1;  
                l1 = l1.next;  
            } else {  
                tail.next = l2;  
                l2 = l2.next;  
            }  
            tail = tail.next;  
        }  
  
        if (l1 != null) {  
            tail.next = l1;  
        } else {  
            tail.next = l2;  
        }  
        return guard.next;  
    }  
  
}