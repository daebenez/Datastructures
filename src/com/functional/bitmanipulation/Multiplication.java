/**
 * @author daebenez
 * Multiplication using bit manipulation.
 * Multiply second integer by 2 power n where n is the number of set bits in the first integer.
 * Time complexity -> O(log n) | because an integer n has log n bits.
 */

class Multiplication{

	/**
	 * use a bit mask to check if the bit at a position for int b is set to 1, if so left shift int a once. Repeat for all set bits 
         * in int a.Finally Add a to the product if first bit of b is 1.
	 * @return : product of 2 numbers.
	 */
	public static int multiplyNumbers(int a,int b)
	{
		int ans =0;
		int product = 0;
		for(int i=1;i<32;i++)
		{
		  ans = ((b & (1<<i))!=0) ? (a << i) : 0; // Dividing int b by 2 like so b>>1 and (b & 1)!=0 is another way of finding set bit.
		  product = product + ans;
		}
		ans = ((b & 1)==1) ? a:0;
		product += ans;
		return product;
	}

	/*
	public static void main(String[] args)
	{
		Multiplication multObj = new Multiplication();
  		System.out.println(multObj. multiplyNumbers(33,64));
	}
	*/
	
}
