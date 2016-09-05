package lambda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaticMethodReference {

	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person("Jose", 31));
		people.add(new Person("Rosmery", 25));
		people.add(new Person("Ariana", 0));
		
		Collections.sort(people, Person :: compareAges);
		people.forEach(p -> System.out.println(p.getName()));
	}

}
