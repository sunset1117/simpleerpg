package db_test;

public class House extends Cube{
	
	private String material;
	private String name;
	private String password;
	private String userID;
	
	public House() {
		
	}
	
	public House(double length, double width, double height, String material) {
		super(length, width, height);
		this.material = material;
	}

	
	public String getInfo() {
		
		return super.getInfo() + "材質 = " + material;
	}
}
