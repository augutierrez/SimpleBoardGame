import java.util.*;

public class PersonDemo
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to the Person Demo to showcase Polymorphism.\n");
		ArrayList<Person> humans = new ArrayList<Person>();
 
		Person p = new Person("Lisa", "Leese");
		p.setBirthday(1978, 10, 20);
		humans.add(p);

		p = new Student("Enrique", "Bascur", "USF", 123, Student.COLLEGE);
		p.setBirthday(2010, 4, 6);
		humans.add(p);

		p = new Teacher("Peter", "Pacheco", "PhD in Mathematics");
	        p.setBirthday(1950, 11, 6);
		humans.add(p);

		p = new StaffMember("Tony", "Gutierrez", 0);
		p.setBirthday(1999, 3, 11);
		humans.add(p);
		

		PersonDemo demo = new PersonDemo();
		demo.displayGreeting(humans);
	}

	private void displayGreeting(ArrayList<Person> array)
	{
		for (Person p: array)
			p.greeting();
	}
}