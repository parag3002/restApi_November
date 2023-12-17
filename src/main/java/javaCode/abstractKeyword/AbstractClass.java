package javaCode.abstractKeyword;

public abstract class AbstractClass 
{
	public abstract void sum();
	
	
	public void display()
	{
		System.out.println("In Abstract class Display");
	}
	
}


abstract class ChildA extends AbstractClass
{
	
	public abstract void sum();
}

class ChildB extends ChildA
{
	public void sum() 
	{
		int a =10;
		int b = 0;
		int sum;
		
		try
		{
			sum = a/b;
			System.out.println(sum);
		}
		catch(ArithmeticException e)
		{
			System.out.println("divide by 0 error");
		}
		
		
	}
}