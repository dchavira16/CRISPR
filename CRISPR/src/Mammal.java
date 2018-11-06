
public class Mammal extends Animal {
	private int age;
	private String name;
	private String gender;
	private String direction;
	private int lastEat;
	private int facing;
	public Mammal(String[] line) {
		super("");
		this.facing=1;
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
	public void changeFacing() {
		if(this.facing==1) {
			this.facing=0;
		}
		else if(this.facing==0) {
			this.facing=1;
		}
	}
	public int getFacing() {
		return this.facing;
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

