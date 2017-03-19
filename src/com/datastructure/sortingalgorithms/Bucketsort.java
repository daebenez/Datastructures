package com.datastructure.sortingalgorithms;
import java.util.*;
/**
 * @author daebenez
 * Implementation of bucket sort in Java, this program assumes 99 to be the maximum possible number.
 * Time complexity : Average -> O(n+k) Worst -> O(n^2). 
 * http://stackoverflow.com/questions/7311415/how-is-the-complexity-of-bucket-sort-is-onk-if-we-implement-buckets-using-lin
 * Space complexity : O(n)
 */
 
 class Bucketsort{
	 
	 public List<ArrayList<Integer>> sort(int[] input){
		 List<ArrayList<Integer>> bucketholder = new ArrayList<ArrayList<Integer>>(10);
		 // create n buckets (Arraylists)
		 for(int i=0;i<10;i++)
		 {
			bucketholder.add(new ArrayList<Integer>());
		 }
		 //insert numbers into buckets according to their most significant digit (tens place)
		 //divide by 10 once to get the tens place, since maximum possible number is 99.
		 for(int j=0;j<input.length;j++)
		 {
			int temp =  input[j]/10;
			int index = (temp%10);
			bucketholder.get(index).add(input[j]);
		 }
		 // Sort individual buckets by other sorting methods.
		 for(int k=0;k<10;k++)
		 {
			 Collections.sort(bucketholder.get(k));
		 }
		 return bucketholder;
	 }
	 /*
	 public static void main(String[] args)
	 {
		 Bucketsort bs = new Bucketsort();
		 int[] input = {9,12,27,23,15,11};
		 List<ArrayList<Integer>> result = bs.sort(input);
		 for(ArrayList<Integer> al : result)
		 {
			 System.out.println(Arrays.toString(al.toArray()));
		 }
	 } */
 }