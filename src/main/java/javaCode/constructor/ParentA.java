package javaCode.constructor;

public class ParentA 
{

	int sum;
	
	public ParentA() 
	{
		sum= 10;
	}
	
	public ParentA(int a)
	{
		sum=10+a;
	}
	
	public ParentA(int a , int b)
	{
		this.sum = 10+a+b;
	}
	
	
	public void displaySum()
	{
		System.out.println("Displaying sum --------->"+sum);
	}
}
