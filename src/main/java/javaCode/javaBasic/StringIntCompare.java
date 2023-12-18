package javaCode.javaBasic;

public class StringIntCompare 
{

	public static void main(String[] args) 
	{
		
		String firstName = "36";
	
		int age = 36;
		
		String ageAsString = String.valueOf(age);
		System.out.println("age as String---->"+ageAsString);
		boolean b = firstName.equals(ageAsString);
		System.out.println(b);
		
		int intFirstName = Integer.parseInt(firstName);
		System.out.println("firstName as int--->"+intFirstName);
		boolean c = age==intFirstName;
		System.out.println(c);

	}

}
