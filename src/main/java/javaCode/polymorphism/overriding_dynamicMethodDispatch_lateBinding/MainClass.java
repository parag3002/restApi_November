package javaCode.polymorphism.overriding_dynamicMethodDispatch_lateBinding;

public class MainClass {

	public static void main(String[] args) 
	{
		Gadget gadget = new Gadget();
		Laptop laptop = new Laptop();
		PDA pda = new PDA();
		
		gadget.display();
		laptop.display();
		pda.display();

	}

}
