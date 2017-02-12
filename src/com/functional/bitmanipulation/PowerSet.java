package com.ds.simple;

/**
 * @author daebenez
 * Finding powerset using bit manipulation.
 */
class PowerSet{
	public void powerSet(int[] input)
	{
	  // find the total number of subsets which is 2 power n.
	  int n = 1<<input.length;
	  int buffer = 0;
	  for(int i=0;i<n;i++)
	  {
            System.out.print("{");
	    buffer = i;
 	    int pos = input.length-1;
	    while(buffer>0)
	    {
	      if((buffer & 1)==1)
	      	System.out.print(input[pos]+",");
	      buffer = buffer>>1;
	      pos--;
	    }
	    System.out.print("}");
	  }
	}
	/*
	public static void main(String[] args)
	{
	  PowerSet obj = new PowerSet();
	  int[] a = {1,2,3};
	  obj.powerSet(a);
	}
	*/
  }
	    
	
