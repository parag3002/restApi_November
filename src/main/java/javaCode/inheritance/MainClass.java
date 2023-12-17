package javaCode.inheritance;

public class MainClass 
{

	public static void main(String args[])
	{
		System.out.println("Inside Main method Class");
		
		ChildB objB = new ChildB(); //Achieving single and multilevel inheritance
		
		objB.parentMethod_A();
		objB.childMethodA();
		objB.childMethodB();
	}
}
