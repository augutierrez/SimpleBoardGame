import java.time.*;

public class Person
{
	protected String firstName;
	protected String lastName;
	private LocalDate birthday;	

	public Person()
	{
		this.firstName = null;
		this.lastName = null;
		birthday = null;
		System.out.println("Default Person Constructor");
	}
	public Person(String fName, String lName)
	{
		this.firstName = fName;
		this.lastName = lName;
		birthday = LocalDate.now();
	}

	public void greeting()
	{
		System.out.println("Hello, my name is "+this.firstName+".\n\tI am a person.");
	}

	public String toString()
	{
		return "PERSON: "+getName()+" "+getBirthday();
	}

	public void setBirthday(int year, int month, int day)
	{
		this.birthday = LocalDate.of(year, month, day);
	}

	public String getName()
	{
		return firstName+" "+lastName;
	}

	public String getBirthday()
	{
		return birthday.toString();
	}
}