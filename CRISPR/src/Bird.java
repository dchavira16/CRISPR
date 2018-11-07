
public class Bird extends Animal{

	private int age;
	private String name;
	private String gender;
	private int steps;
	private int lastEat;
	private int facing;
	private int defaultSteps;
	private String direction;
	public Bird(String[] line) {
		super("");
		this.direction="d";
		this.facing=1;
		this.age=100;
		this.lastEat=10;
		String name = line[2];
		String gender = line[3];
		int defaultSteps=Integer.parseInt(line[4]);
		int steps = Integer.parseInt(line[4]);
		this.defaultSteps=defaultSteps;
		this.name=name;
		this.gender=gender;
		this.steps = steps;
		// TODO Auto-generated constructor stub
	}
	public void resetSteps() {
		this.steps=this.defaultSteps;
	}
	public void decSteps() {
		this.steps-=1;
	}
	public int getSteps() {
		return this.steps;
	}
	public String getDirection() {
		return this.direction;
	}
	public void changeDirectionTo(String direction) {
		this.direction=direction;
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
		return "bird";
	}
	@Override 
	public String toString() {
		return this.name.substring(0,1);
	}
}
