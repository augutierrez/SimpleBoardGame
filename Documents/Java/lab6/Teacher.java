public class Teacher extends Person
{
	private String degree;
	private double salary;
	public static final double BASE_SALARY = 80000.00;

	public Teacher(String fName, String lName, String degree)
	{
		super(fName, lName);
		this.degree = degree;
		this.salary = BASE_SALARY;	
	}

	public String toString()
	{
		String result = "TEACHER: "+getName()+" "+getBirthday();
		result += "\n\t"+degree+" "+salary;
		return result;
	}

	public void greeting()
	{
		System.out.println("Good morning class.");
		super.greeting();
		System.out.println("\tMy whole name is "+super.firstName+" "+super.lastName);
		System.out.println("\tI will be teaching Parallel Programming this semester.");
	}
}