package javaCode.constructor;

public class MainClass 
{

	public static void main(String args[])
	{
		ParentA parent = new ParentA(10,10);
		parent.displaySum();
		
		ChildA childa = new ChildA();
		childa.displaySum();
		
		ChildB childb = new ChildB();
		childb.displaySum();
		
	}
}
