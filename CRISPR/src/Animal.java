import java.util.ArrayList;

public class Animal<E>{
	private E type;
	private ArrayList<String> mammals = new ArrayList<>();
    private ArrayList<String> birds = new ArrayList<>();
    private ArrayList<String> insects = new ArrayList<>();
    private ArrayList<ArrayList<String>> animalBank;
    
    
	public Animal(E type) {
		//super(0, 0);
		this.type=type;
		animalBank();
		
	}
	public void animalBank() {
		
        mammals.add("Elephant");
        mammals.add("Rhinoceros");
        mammals.add("Lion");
        mammals.add("Cheeta");
        mammals.add("Giraffe");
        mammals.add("Zebra");
        birds.add("Thrush");
        birds.add("Owl");
        birds.add("Warbler");
        birds.add("Dove");
        birds.add("Shrike");
        insects.add("Mosquito");
        insects.add("Bee");
        insects.add("Fly");
        insects.add("Horsefly");
        insects.add("Ant");

        ArrayList<ArrayList<String>> animalBank = new ArrayList<>();
        animalBank.add(mammals);
        animalBank.add(birds);
        animalBank.add(insects);
        this.animalBank = animalBank;
    }
	
	public String getType() {
		if (this.type.getClass()=="".getClass()) {
			//System.out.println("lol");
			return ".";
		}
			return this.getName();
	}
	
	public String getAnimalClass() {
		return(((Animal) this.type).getType());
		//return "";
	}
	public String findType(String name) {
		for (int i=0;i<this.animalBank.size();i++) {
			for (int j=0; j<this.animalBank.get(i).size();j++) {
				if ((this.animalBank.get(i).get(j).toLowerCase().equals(name))&& (i==0)) {
					String type="mammal";
					return (type);
				}
				else if ((this.animalBank.get(i).get(j).toLowerCase().equals(name))&& (i==1)) {
					String type="bird";
					return (type);
				}
				else if ((this.animalBank.get(i).get(j).toLowerCase().equals(name))&& (i==2)) {
					String type="insect";
					return (type);
				}
				
				
			}
		}
		return "";
	}
	public String getName() {
		if (this.type.getClass()=="".getClass()) {
			return ".";
		}
		// TODO Auto-generated method stub
		return  ((Animal) this.type).getName();
	}
	public String getSpecial() {
		// TODO Auto-generated method stub
		return ((Animal) this.type).getSpecial();
	}
	public void decAge() {
		// TODO Auto-generated method stub
		((Animal) this.type).decAge();
	}
	public int getAge() {
		// TODO Auto-generated method stub
		return ((Animal) this.type).getAge();
	}
	public int getSquare() {
		// TODO Auto-generated method stub
		return ((Animal) this.type).getSquare();
	}
	public void square() {
		// TODO Auto-generated method stub
		((Animal) this.type).square();
	}
	public int getFacing() {
		// TODO Auto-generated method stub
		return ((Animal) this.type).getFacing();
	}
	public void changeFacing() {
		// TODO Auto-generated method stub
		((Animal) this.type).changeFacing();
	}
	public String getDirection() {
		// TODO Auto-generated method stub
		return ((Animal) this.type).getDirection();
	}
}
