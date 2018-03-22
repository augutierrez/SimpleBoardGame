public class Student extends Person
{
	private String school;
	private int id;
	private int level;

	public static final int ELEMENTARY =  0;
	public static final int MIDDLE = 1;	
	public static final int HIGH = 2;
	public static final int COLLEGE = 3;


	public Student(String fname, String lName, String school, int id, int level)
	{
		super(fname, lName);
		this.school = school;
		this.id = id;
		this.level = level;
	}

	public String toString()
	{
		String result = "STUDENT: "+getName()+" "+getBirthday();
		result += "\n\t"+this.school+" "+this.id+" ";
		switch(this.level){
			case 0: result+="ELEMENTARY";
				break;
			case 1: result+="MIDDLE";
				break;
			case 2: result+="HIGH";
				break;
			case 3: result+="COLLEGE";
				break;
			default:
				result+="UNKNOWN";
		}
		return result;
	}

	public void greeting()
	{
		super.greeting();
		System.out.println("\tI am a student at "+school+".");
	}
}