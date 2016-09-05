package fileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CapitalizationReader extends BufferedReader {

	public CapitalizationReader(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String readLine() throws IOException {
		// TODO Auto-generated method stub
		String line = super.readLine();
		
		if(line != null)
			return line.toUpperCase();
		
		return null;
	}

	

}
