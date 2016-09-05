package enumerators;

public class Mian {

	public static void main(String[] args) {
		
		Color white = Color.white;

		System.out.println("The color is " + white);
				
		GeometricShape circle = GeometricShape.circle;
				
		System.out.println("The geometric shape is " + circle.getShape());
				
		for(Color color : Color.values())
		{
			System.out.println("Color is: " + color);
					
		}
				
		for(GeometricShape geoShape : GeometricShape.values())
		{
			System.out.println("The geometric shape is: " + geoShape.getShape());
					
		}

	}

}
