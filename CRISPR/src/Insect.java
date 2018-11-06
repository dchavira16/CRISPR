
public class Insect extends Animal{
	private int age;
	private String name;
	private String gender;
	private String direction;
	private int square;
	public Insect(String[] line) {
		super("");
		this.square=4;
		this.age=20;
		String name = line[2];
		String gender = line[3];
		String direction = line[4];
		this.name=name;
		this.gender=gender;
		this.direction = direction;
		// TODO Auto-generated constructor stub
	}
	public void square() {
		this.square-=1;
		if (this.square==0) {
			this.square=4;
		}
	}
	public int getSquare() {
		return this.square;
	}
	public int getAge() {
		return this.age;
	}
	public void decAge() {
		this.age-=1;
	}
	public String getSpecial() {
		return this.direction;
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
