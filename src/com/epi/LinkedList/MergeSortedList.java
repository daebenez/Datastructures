package com.epi.LinkedList;

public class MergeSortedList {
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode p1 = l1,p2 = l2;
         ListNode dummyHead = new ListNode(0);
         ListNode current = dummyHead;
         while(p1!=null && p2!=null)
         {
             if(p1.val<=p2.val)
             {
                 current.next = p1;
                 p1 = p1.next;
             }
             else
             {
                 current.next = p2;
                 p2 = p2.next;
             }
             current = current.next;
         }
         current.next = (p1==null)? p2 : p1;
         return dummyHead.next;
	    }
}
