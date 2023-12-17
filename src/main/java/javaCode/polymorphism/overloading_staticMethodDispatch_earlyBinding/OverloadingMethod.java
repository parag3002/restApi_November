package javaCode.polymorphism.overloading_staticMethodDispatch_earlyBinding;

public class OverloadingMethod 
{

	public int sum()
	{
		int sum = 10+12;
		return sum;
	}
	
	public int sum(int getNumber)
	{
		int sum = 10+12+getNumber;
		return sum;
	}
	
	public int sum(int getNumber , int getNumber2)
	{
		int sum = 10+12+getNumber+getNumber2;
		return sum;
	}
}
