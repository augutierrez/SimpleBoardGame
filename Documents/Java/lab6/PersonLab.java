import java.util.*;

public class PersonLab
{

	public static void main(String[] args)
	{
		boolean done = false;
		Scanner in = new Scanner(System.in);
		PersonLab demo = new PersonLab();
		ArrayList<Person> humans = new ArrayList<Person>();

		System.out.println("Welcome to the Human Database Lab.\n");

		while(!done)
		{
			System.out.println("S)tudent input T)eacher input M)ember of Staff Input L)ist community G)reeting Q)uit");
			String input = in.next();
			if(input.equals("S") || input.equals("T") || input.equals("M"))
			{
				System.out.print("Enter first name:");
				String fname = in.next();
				System.out.print("Enter last name:");
				String lname = in.next();

				if(input.equals("S"))
					demo.addStudent(humans, in, fname, lname);
				else if(input.equals("T"))
					demo.addTeacher(humans,in, fname, lname);
				//uncomment the lines below if your new subclass Staff works
				else if(input.equals("M"))
					demo.addMember(humans,in, fname, lname);
			} 	
			else if(input.equals("L"))
				demo.list(humans);
			else if(input.equals("G"))
				demo.displayGreeting(humans);
			else if(input.equals("Q"))
				done = true;
		}
 

	}


	private void addTeacher(ArrayList<Person> humans, Scanner in, String first, String last)
	{
		System.out.print("Enter degree:");
		String degree = in.next();
		Teacher person = new Teacher(first, last, degree);
		humans.add(person);
		//add code here
	}

	private void addStudent(ArrayList<Person> humans, Scanner in, String first, String last)
	{
		System.out.print("Enter school: ");
		String school = in.next();
		System.out.print("Enter id: ");
		int id = in.nextInt();
		System.out.print("Enter level: ");
		int level = in.nextInt();
		Student person = new Student(first, last, school, id, level);
		humans.add(person);
		//add code here
	}

	private void addMember (ArrayList<Person> humans, Scanner in, String first, String last)
	{
		System.out.println("Enter role (number): ");
		int role = in.nextInt();
		StaffMember person = new StaffMember(first, last, role);
		humans.add(person);
	}

	private void displayGreeting(ArrayList<Person> array)
	{
		for (int x = 0; x < array.size() ; x++)
		{
			array.get(x).greeting();
		}
	}

	private void list(ArrayList<Person> array)
	{
		for (int x = 0; x < array.size() ; x++)
		{
			System.out.println(array.get(x));
		}
	}
}