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
        ListNode res = new ListNode(Integer.MIN_VALUE); //new head
		ListNode pre = res;    
        ListNode cur = null;   //the last sorted node
		ListNode next = null;  //the first unsorted node
   
        while(head != null){
            next = head;
			head = head.next;
			next.next = null; //isolate the unsorted node
			pre = res;
			cur = pre.next;
			while(cur != null && cur.val < next.val){
				cur = cur.next;
				pre = pre.next;
			}
			pre.next = next;
			next.next = cur;
         }
        return res.next;
    }
}