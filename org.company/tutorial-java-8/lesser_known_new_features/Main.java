package lesser_known_new_features;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {

	
	
	public static void main(String[] args)
	{
		//strings_example_join();
		string_example_search_text();
	}
	
	@SuppressWarnings("unused")
	private static void strings_example_join()
	{
		String stooges = String.join(", ", "Jose", "Rosmery", "Ariana");
		
		System.out.println(stooges);
		
		
		String[] strings = {"Jose", "Rosmery", "Ariana"};
		
		String joinedStrings = String.join(", ", strings);
		
		System.out.println(joinedStrings);
		
		//StringJoiner
		StringJoiner sj = new StringJoiner(",","{", "}");
		sj.setEmptyValue("No stooges yet");
		
		System.out.println(sj);
		
		sj.add("Jose");
		sj.add("Rosmery");
		sj.add("Ariana");
		
		System.out.println(sj);
		
		//Merge StringJoiner instances
		StringJoiner sj2 = new StringJoiner(",");
		sj2.add("otra bebe");
		sj.merge(sj2);
		System.out.println(sj);
		
		//Working with collections
		Set<String> set = new TreeSet<>();
		set.add("Ariana");
		set.add("Rosmery");
		set.add("Jose");
		
		StringJoiner sj3 = new StringJoiner(" and ");
		set.forEach(str -> sj3.add(str));
		
		System.out.println(sj3);
		
	}
	
	private static void string_example_search_text()
	{
		Path path = FileSystems.getDefault().getPath("files", "hamlet.txt");
		System.out.println(path);
		String searchTerm = "Bye";
		
		try(Stream<String> lines = Files.lines(path)) 
		{
			
			String line = lines.filter(l -> l.contains(searchTerm)).findFirst().orElse("the search will not found a result");
			System.out.println(line);
			
		} catch (Exception e) {
			System.out.println("there was an error");
		}
	}
	
}
