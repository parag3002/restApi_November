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
