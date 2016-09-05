package nashorn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

	public static void main(String[] args) throws ScriptException, FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		
		Path root = Paths.get(System.getProperty("user.dir") + "/src/nashorn");
		
		File f = new File(root + "/HelloWorld.js");
		Reader reader = new FileReader(f);
		
		
//		String script = "var welcome = 'Hello,';"
//				+ "welcome += ' Jose Olivares';"
//				+ "welcome";
		
		Object result = engine.eval(reader);
		
		System.out.println(result);
	}

}
