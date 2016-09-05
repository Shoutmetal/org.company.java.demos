package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Printer {


	public Printer() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTextFromFile(String location) throws IOException
	{
		FileReader reader = new FileReader(location);
		BufferedReader bReader = new BufferedReader(reader);
		@SuppressWarnings("resource")
		CapitalizationReader cReader = new CapitalizationReader(bReader);
		
		
		String allText = "";
		
		String line;
		while((line = cReader.readLine()) != null)
		{
			allText += line + "\n";
		}

		if(bReader != null)
			bReader.close();
				
		return allText;
	}
	
	public void outPutPage(String location, String text) throws IOException{
		
		PrintWriter writer = new PrintWriter(new FileWriter(location));
		writer.println(text);
		
		if(writer != null)
			writer.close();
		
	}

}
