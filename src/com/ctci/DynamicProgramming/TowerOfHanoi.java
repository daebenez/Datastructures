package com.ctci.DynamicProgramming;
import java.util.Stack;
/**
 * Program to recursively solve the tower of Hanoi problem
 * @author daebenez
 * Time complexity : O(2^N) Details : https://www.youtube.com/watch?v=oZ0MP5euLQ0
 */
public class TowerOfHanoi {
	
	Stack s1 = new Stack();
	Stack s2 = new Stack();
	Stack s3 = new Stack();
	
	public TowerOfHanoi(int n) {
		for(int i=n;i>0;i--)
		{
			s1.push(i);
		}
	}
	
	public void tower(int disk,Stack source,Stack destination,Stack buffer)
	{
		if(disk<1)
		{
			return;
		}
		else
		{
			tower(disk-1,source,buffer,destination);
			destination.push(source.pop());
			tower(disk-1,buffer,destination,source);
		}
	}
	/*
	public static void main(String[] args)
	{
		TowerOfHanoi obj = new TowerOfHanoi(6);
		obj.tower(6, obj.s1, obj.s3, obj.s2);
		System.out.println(obj.s3.size());
		
		for(int i=0;i<obj.s3.size();i++)
		{
			System.out.print(obj.s3.get(i));
		}
	} */

}
