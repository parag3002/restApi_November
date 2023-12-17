package javaCode.polymorphism.overloading_staticMethodDispatch_earlyBinding;

public class MainClass 
{
	public static void main(String args[])
	{
		OverloadingMethod obj = new OverloadingMethod();
		
		int result = obj.sum();
		System.out.println(result);
		result = obj.sum(10);
		System.out.println(result);
		result = obj.sum(10,20);
		System.out.println(result);
		
	}
	
}
