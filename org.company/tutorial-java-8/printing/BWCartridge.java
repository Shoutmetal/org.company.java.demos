package printing;

public class BWCartridge implements ICartridge {

	@Override
	public String toString(){
		return "BW";
	}

	@Override
	public String getFillPercentage() {
		// TODO Auto-generated method stub
		return "50%";
	}

}
