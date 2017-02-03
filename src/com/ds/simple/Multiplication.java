/**
 * @author daebenez
 * Multiplication using bit manipulation.
 */

class Multiplication{

	/**
	 * use a bit mask to find if a binary digit at a position is 1, then left shift position 		 * times. Add 1 to the product if first digit is 1.
	 * @return : product of 2 numbers.
	 */
	public static int multiplyNumbers(int a,int b)
	{
		int ans =0;
		int product = 0;
		for(int i=1;i<32;i++)
		{
		  ans = ((b & (1<<i))!=0) ? (a << i) : 0;
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
