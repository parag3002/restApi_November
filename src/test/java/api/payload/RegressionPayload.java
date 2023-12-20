package api.payload;


public class RegressionPayload 
{

	private String title;
	private String author;
	private int published;
	
	public RegressionPayload()
	{
		
	}
	
	public  RegressionPayload(String title, String author, int published)
	{
		this.title = title;
		this.author = author;
		this.published = published;
	}
	
	public void display()
	{
		System.out.println(this.title+" "+this.author+" "+this.published);
	}
	
	
}
