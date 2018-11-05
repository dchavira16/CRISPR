
public class Insect extends Animal{
	private String name;
	private String gender;
	private String direction;
	
	public Insect(String[] line) {
		super("");
		String name = line[2];
		String gender = line[3];
		String direction = line[4];
		this.name=name;
		this.gender=gender;
		this.direction = direction;
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return this.name;
	}
	public String getType() {
		// TODO Auto-generated method stub
		return "insect";
	}
	@Override 
	public String toString() {
		return this.name.substring(0,1);
	}

}
