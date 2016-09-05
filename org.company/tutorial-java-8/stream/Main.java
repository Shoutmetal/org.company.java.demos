package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Stream;

import lambda_expressions.Person;

public class Main {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person("Jose", 31));
		people.add(new Person("Rosmery", 25));
		people.add(new Person("Ariana", 0));

		@SuppressWarnings("unused")
		Predicate<Person> pred = (p) -> p.getAge() > 25;
		
		//displayPeople(people, pred);
		
		//stream_example_creation();
		//stream_example_aggregating();
		
		stream_example_sum();
	}
	
	@SuppressWarnings("unused")
	private static void displayPeople(List<Person> people, Predicate<Person> pred) {
		people.stream()
		.parallel() //<- multiple processors
		.filter(pred)
		.forEach(p -> System.out.println(p.getPersonInfo()));
		
		//multiple processors
		people.parallelStream()
		.filter(pred)
		.forEach(p -> System.out.println(p.getPersonInfo()));
	}
	
	@SuppressWarnings("unused")
	private static void stream_example_creation()
	{
		Person[] people = {
				new Person("Jose", 31),
				new Person("Rosmery", 25),
				new Person("Ariana", 0)
		};
		
		Stream<Person> stream = Stream.of(people);
		Stream<Person> array_stream = Arrays.stream(people);
		
		stream.forEach(p -> System.out.println(p.getPersonInfo()));
		
		array_stream.forEach(p -> System.out.println(p.getPersonInfo()));
	}
	
	@SuppressWarnings("unused")
	private static void stream_example_aggregating(){
		
		List<String> strings = new ArrayList<String>();
		for(int i=1;i<= 10000; i++)
			strings.add("Item " + i);
		
		strings
		.stream()
		.parallel()
		.forEach(str -> System.out.println(str));
		
		
		Long count = strings.stream().parallel().count();
		System.out.println("Total: " + count);
		
	}

	private static void stream_example_sum()
	{
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person("Jose", 31));
		people.add(new Person("Rosmery", 25));
		people.add(new Person("Ariana", 0));
		
		int sum = people.stream().mapToInt(p -> p.getAge()).sum();
		
		System.out.println(sum);
		OptionalDouble avg = people.stream().mapToInt(p -> p.getAge()).average();
		
		if(avg.isPresent())
			System.out.println(avg.getAsDouble());
		else
			System.out.println("Average was not calculated.");
	}	
}
