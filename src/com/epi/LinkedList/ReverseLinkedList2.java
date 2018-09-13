package com.epi.LinkedList;

public class ReverseLinkedList2 {
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode p1 = dummy;
	        int count =1;
	        while(count<m)
	        {
	            p1 = p1.next;
	            count++;
	        }
	        
	        ListNode p2 = p1.next;
	        ListNode p3 = p2.next;
	        count++;
	        while(count<=n)
	        {
	            p2.next = p3.next;
	            p3.next = p1.next;
	            p1.next = p3;
	            p3 = p2.next;
	            count++;
	        }
	        return dummy.next;
	    }
}
