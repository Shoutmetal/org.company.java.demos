package annotations;


@CustomAnnotation(ClassDescription="This is a Custom Method")
public class Custom {

	public Custom() {
		// TODO Auto-generated constructor stub
	}
	
	public void CustomMethod(String message)
	{
		System.out.println(message);
	}

}
