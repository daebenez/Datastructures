package com.epi.Recursion;
import java.util.*;
public class TowerOfHanoi {
	
	public static void tower(int n, Deque<Integer> source, Deque<Integer> aux, Deque<Integer> target)
	{
		if(n<1)
		{
			return;
		}
		tower(n-1,source, target, aux);
		target.offer(source.poll());
		System.out.println("Move"+target.peek());
		tower(n-1,aux,source,target);
	}
	
	public static void tower(int n, String source, String aux, String target)
	{
		if(n<1)
		{
			return;
		}
		tower(n-1,source, target, aux);
		System.out.println("Move "+n+" from "+source+" to "+target);
		tower(n-1,aux,source,target);
	}
	
	
	
	public static void main(String[] args)
	{
		Deque<Integer> s = new LinkedList<Integer>();
		Deque<Integer> a = new LinkedList<Integer>();
		Deque<Integer> t = new LinkedList<Integer>();
		s.offer(4);
		s.offer(3);
		s.offer(2);
		s.offer(1);
		//tower(4,s,a,t);
		
		
		String so = "A";
		String au = "B";
		String ta = "C";
		tower(4,so,au,ta);
		
	}

}
