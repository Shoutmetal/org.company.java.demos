package lambda_expressions;

public interface IPerson {
	public String getName();
	public void setName(String name);
	public int getAge();
	public void setAge(int age);
	
	default String getPersonInfo()
	{
		return getName() + " (" + getAge() + ")";
	}
}
