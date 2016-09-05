package printing;

import java.util.HashMap;
import java.util.Map;

public class Printer<T> implements IMachine {

	
	private String modelNumber;
	private PaperTray PaperTray = new PaperTray();
	private Machine machine;
	private T cartridge;
	//private List<Page> pages = new ArrayList<Page>();
	private Map<Integer, Page> pagesMap = new HashMap<Integer, Page>();
	
	public Printer(boolean isOn, String modelNumber, T cartridge) {
		this.machine = new Machine(isOn);
		this.modelNumber = modelNumber;
		this.cartridge = cartridge;
	}
	
	@Override
	public void turnOn() {
		System.out.println("Warming up printer.");
		machine.turnOn();
	};
	
	public <U extends ICartridge> void printUsingCartridge(U cartridge, String message)
	{
		System.out.println(cartridge.getFillPercentage());
		System.out.println(message);
		System.out.println(cartridge.getFillPercentage());

	}
	
	public void print(int copies){
		
		System.out.println(cartridge.toString());
		
		String onStatus = "";
		
		if(machine.isOn())
			onStatus = " is On!";
		else
			onStatus = " is Off!";
		
		String textToPrint = modelNumber + onStatus;
		
		int pageNumber = 1;
		while(copies > 0 && !PaperTray.isEmpty())
		{
			//System.out.println(textToPrint);
			
			//pages.add(new Page(textToPrint));
			pagesMap.put(pageNumber,new Page(textToPrint + " : " + pageNumber));
			
			copies--;
			pageNumber++;
			PaperTray.usePage();
			
		}
		
		if(PaperTray.isEmpty())
			System.out.println("Load mode paper");
		
	}
	
	public void outputPage(int pageNumber)
	{
		System.out.println(pagesMap.get(pageNumber).getText());
	}

	public void loadPaper(int count) {
		
		PaperTray.addPaper(count);
	}
	
	public T getCartridge()
	{
		return cartridge;
	}

	@Override
	public void turnOff() {
		machine.turnOff();
		
	}

	@Override
	public boolean isOn() {
		return machine.isOn();
	}
}
