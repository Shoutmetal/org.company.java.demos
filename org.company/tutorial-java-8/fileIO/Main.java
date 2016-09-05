package fileIO;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	
	private static Path root =  Paths.get(System.getProperty("user.dir") + "/src/fileIO/");
	

	public static void main(String[] args) throws IOException {
		
		
		String file = "text.txt";
		Printer printer = new Printer();
		
		
		printer.outPutPage(root + file, printer.getTextFromFile(root + file) + "Hello World");
		
		System.out.println(printer.getTextFromFile(root + file));
	}
}
