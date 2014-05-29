/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode h = head; //new head
        head = head.next;  //old head
        ListNode n = head; //old cursor
        ListNode t = h;  //new cursor
        h.next = null;
   
        while(head != null){
            n = head.next;
            if(head.val <= h.val){
                head.next = h;
                h = head;
            }else{
                t = h;
                while(t.next != null){
                    if(head.val <= t.next.val){
                        head.next = t.next;
                        t.next = head;
                        break;
                    }else{
                        t = t.next;
                    }
                }
                if(t.next == null){
                    t.next = head;
                    head.next = null;
                }
            }
            head = n;
         }
        return h;
    }
}