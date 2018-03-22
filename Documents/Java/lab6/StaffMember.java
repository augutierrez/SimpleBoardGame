//Create a new StaffMember class.

public class StaffMember extends Person
{
	private int role;
	private int salary;

	public static int Secretary = 0;
	public static int Libarian = 1;
	public static int Cafeteria = 2;
	public static int Security = 3;
	
	
	public StaffMember(String fname, String lName, int role)
	{
		super(fname, lName);
		this.role = role;
		salary = 60000;
	}

	public String toString()
	{
		String result = "STAFF MEMBER: "+getName()+" "+getBirthday();
		result += "\n\t"+this.role+" "+this.salary+" ";
		switch(this.role){
			case 0: result+="SECRETARY";
				break;
			case 1: result+="LIBARIAN";
				break;
			case 2: result+="CAFETERIA";
				break;
			case 3: result+="SECURITY";
				break;
			default:
				result+="UNKNOWN";
		}
		return result;
	}
	

	public void greeting()
	{
		String result;
		switch(this.role){
			case 0: result="SECRETARY";
				break;
			case 1: result="LIBARIAN";
				break;
			case 2: result="CAFETERIA";
				break;
			case 3: result="SECURITY";
				break;
			default:
				result="UNKNOWN";
			}

		super.greeting();
		System.out.println("\tI am a staff member, my role is: " + result);
	}



}