package enumerators;

public enum GeometricShape {


	triangle("Triangle"),
	circle("Circle"),
	square("Square"),
	rectangle("Rectangle");
	
	private String form;

	private GeometricShape(String form){
		this.form = form;
	}

	public String getShape() {
		return form;
	}
}
