package grettings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import printing.BWCartridge;
import printing.ICartridge;
import printing.Printer;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Printer<BWCartridge> printer = new Printer<BWCartridge>(true, "MY PRINTER", new BWCartridge());
		//Printer<ColorCartridge> printer2 = new Printer<ColorCartridge>(true, "MY PRINTER", new ColorCartridge());
		
		//printOne(printer2);
		
		printer.loadPaper(10);
		printer.print(5);
		//printer.outPutPages();
		
		printer.outputPage(2);
		
		
		Set<Integer> mySet = new HashSet<Integer>();
		
		mySet.add(1);
		mySet.add(2);
		mySet.add(3);
		mySet.add(1);
		
		System.out.println(mySet.size());
		
		Queue<String> myQueue = new LinkedList<String>();
		myQueue.offer("a");
		myQueue.offer("b");
		myQueue.offer("c");
		
		while(myQueue.peek() != null)
		{
			
			System.out.println(myQueue.poll());
		}
	}
	
	public static void printOne(Printer<? extends ICartridge> printer)
	{
		String fillPercentage = printer.getCartridge().getFillPercentage();
		System.out.println(fillPercentage);
	}

}
