package javaCode.interfaceConcept.interfacee;

public class ClassChildA implements InterfaceA
{
	public void display() 
	{
		System.out.println("Inside ChildA class display method");
	}
	
	public void sum() 
	{
		int a = 10+20;
		System.out.println(a);
	}
}
