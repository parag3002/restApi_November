package javaCode.interfaceConcept.interfacee;

public class MainClass 
{

	public static void main(String args[])
	{
		InterfaceA obj = new ClassChildA();
		obj.display();
		obj.sum();
		int y = ClassChildA.s; // static and final variable from InterfaceA
		System.out.println(y);
	}
	
}


// Hybrid Interface

interface A1
{
	public void ride();

}

interface B1
{
	public void ride();
}

class C1 implements A1 , B1
{
	public void ride() 
	{
		System.out.println("Override");
	}
}