package javaCode.encapsulation;

public class MainClass 
{
	
	public static void main(String args[])
	{
		Encapsulation obj = new Encapsulation();
		
		obj.setName("Govinda");
		obj.setAge(40);
		obj.setEmp_id(101);
		
		String name = obj.getName();
		int age = obj.getAge();
		int emp_id = obj.getEmp_id();
		
		System.out.println(name+" "+age+" "+emp_id);
		
		
	}
}
