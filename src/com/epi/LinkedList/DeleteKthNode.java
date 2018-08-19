package com.epi.LinkedList;

public class DeleteKthNode {
	public static ListNode delete(ListNode head,int k)
	{
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = p1;
		int count = 0;
		while(count<k)
		{
			p2 = p2.next;
			count++;
		}
		while(p2!=null)
		{
			p1 = p1.next;
			p2 = p2.next;
 		}
		p1.next = p1.next.next;
		return fakeHead.next;
	}

}
