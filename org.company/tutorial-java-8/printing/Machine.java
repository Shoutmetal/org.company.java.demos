package printing;

public class Machine implements IMachine{

	private boolean isOn;
	
	public Machine(boolean isOn){
		
		this.isOn = isOn;
	}
	
	public void turnOn(){
		
		isOn = true;
		System.out.println("Machine is on");
	}
	
	public void turnOff(){
		isOn= false;
		
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	
	
}
