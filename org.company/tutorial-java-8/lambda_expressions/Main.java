package lambda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {

 		//lambdaExpressionExample();
		
		//lambda_expression_example_simple_interface();
		
		//lambda_expression_example_interface_with_args();
		
		//lambda_expression_example_compare_strings();
		
		lambda_expression_example_filters();
	}
	
	@SuppressWarnings("unused")
	private static void lambdaExpressionExample()
	{
		
		ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

		//lambda expression
		Runnable r = () -> 
		{
			System.out.println("run one");
			System.out.println("run two");
			
		};
		singleExecutor.submit(r);
		singleExecutor.shutdown();
	}
	
	@SuppressWarnings("unused")
	private static void lambda_expression_example_simple_interface()
	{
		SimpleInterface obj = () -> System.out.println("Say something");
		obj.doSomething();
	}
	
	@SuppressWarnings("unused")
	private static void lambda_expression_example_interface_with_args()
	{
		InterfaceWithArgs obj = (x,y) -> System.out.println("value 1: " + x + " value 2: " + y);
		obj.doSomething(7, 88);
		
	}
	
	public static void lambda_expression_example_compare_strings()
	{
		List<String> strings = new ArrayList<String>();
		strings.add("AAA");
		strings.add("bbb");
		strings.add("CCC");
		strings.add("ddd");
		strings.add("EEE");
		
		Collections.sort(strings);
		
		//simple case-sensitive sort operation
		System.out.println("Simple Sort");
		strings.forEach((str)-> System.out.println(str));
		
		//simple case-insensitive sort operation
//		Collections.sort(strings, new Comparator<String>(){
//			@Override
//			public int compare(String str1,String str2 )
//			{
//				return str1.compareToIgnoreCase(str2);
//			}
//		});
		
		strings.forEach((str)-> System.out.println(str));
		
		//simple case-insensitive sort operation -> Using lambda expressions
		Comparator<String> compare = (str1, str2) ->{ return str1.compareToIgnoreCase(str2); };
		Collections.sort(strings,compare);
		
		System.out.println("Sort with comparator");
		strings.forEach((str)-> System.out.println(str));

		
	}
	
	@SuppressWarnings("unused")
	private static void lambda_expression_example_filters(){
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person("Jose", 31));
		people.add(new Person("Rosmery", 25));
		people.add(new Person("Ariana", 0));
		
		Predicate<Person> pred = (p) -> p.getAge() > 25;
		Predicate<Person> pred2 = (p) -> p.getAge() == 25;
		
//		Predicate<Person> pred = new Predicate<Person>(){
//
//			@Override
//			public boolean test(Person p) {
//				// TODO Auto-generated method stub
//				return (p.getAge())>=25;
//			}
//		};
		
		displayPeople(people, pred2);
		
//		for(Person person : people)
//		{
//			if(pred.test(person))
//				System.out.println(person.getName());
//		}
	}

	private static void displayPeople(List<Person> people, Predicate<Person> pred) {
		people.forEach((p)->
		{
			if(pred.test(p))
				System.out.println(p.getPersonInfo());
			
		});
	}
}
