import java.util.ArrayList;

public class Animal{
	private Object type;
	private ArrayList<String> mammals = new ArrayList<>();
    private ArrayList<String> birds = new ArrayList<>();
    private ArrayList<String> insects = new ArrayList<>();
    private ArrayList<ArrayList<String>> animalBank;
    
    
	public Animal(Object type) {
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
		
		return this.type.toString();//this.type.toString();
	}
	
	public String getAnimalClass() {
		return(((Animal) this.type).getType());
		//return "";
	}
	public String findType(String name) {
		//System.out.println(name);
		// TODO Auto-generated method stub
		for (int i=0;i<this.animalBank.size();i++) {
			//System.out.println(this.animalBank.get(i));
			for (int j=0; j<this.animalBank.get(i).size();j++) {
				//System.out.println(i+""+j);
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
		// TODO Auto-generated method stub
		if (this.getAnimalClass().equals(".")){
			return "";
		}
		return ((Animal) this.type).getName();
	}
}
