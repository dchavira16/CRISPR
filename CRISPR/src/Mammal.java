
public class Mammal extends Animal {
	private int age;
	private String name;
	private String gender;
	private String direction;
	private int lastEat;
	public Mammal(String[] line) {
		super("");
		this.age=100;
		this.lastEat=10;
		String name = line[2];
		String gender = line[3];
		String direction = line[4];
		this.name=name;
		this.gender=gender;
		this.direction = direction;
		// TODO Auto-generated constructor stub
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
		return "mammal";
	}
	@Override 
	public String toString() {
		return this.name.substring(0,1);
	}

}

