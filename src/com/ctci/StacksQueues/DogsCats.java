package com.ctci.StacksQueues;
import java.util.LinkedList;
/**
 * CTCI Q3.6
 * Program to create a datastructure using linkedlists, which can store dog and cat objects
 * Maintain 2 lists, use wrapper object to store each animal and its associated line number
 * time stamp.
 * @author daebenez
 */

public class DogsCats {
		LinkedList<DogCatWrapper> dogQueue = new LinkedList<DogCatWrapper>();
		LinkedList<DogCatWrapper> catQueue = new LinkedList<DogCatWrapper>();
		int count = 0;
		
		public void insertDog(String name)
		{
			DogCatWrapper dog = new DogCatWrapper();
			dog.setName(name);
			dog.setNumber(count++);
			dogQueue.add(dog);
		}
		
		public void insertCat(String name)
		{
			DogCatWrapper cat = new DogCatWrapper();
			cat.setName(name);
			cat.setNumber(count++);
			catQueue.add(cat);
		}
		
		public DogCatWrapper getFirstAnimal()
		{
			if(dogQueue.peek().getNumber() > catQueue.peek().getNumber())
			{
				return catQueue.removeFirst();
			}
			else
			{
				return dogQueue.removeFirst();
			}
		}
		
		public DogCatWrapper getFirstDog()
		{
			return dogQueue.removeFirst();
		}
		
		public DogCatWrapper getFirstCat()
		{
			return catQueue.removeFirst();
		}
		
		public static void main(String[] args)
		{
			DogsCats temp = new DogsCats();
			temp.insertDog("DogOne");
			temp.insertCat("CatOne");
			temp.insertDog("DogTwo");
			temp.insertDog("DogThree");
			temp.insertDog("CatTwo");
			System.out.println(temp.getFirstAnimal().getName());
			System.out.println(temp.getFirstDog().getName());
			System.out.println(temp.getFirstCat().getName());
		}
}
