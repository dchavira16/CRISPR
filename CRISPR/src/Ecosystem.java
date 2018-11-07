import java.util.ArrayList;

public class Ecosystem {
	private ArrayList<ArrayList<ArrayList<Animal>>> eco;
	private ArrayList<ArrayList> row;
	private ArrayList<Animal> col;
	
	public Ecosystem(int rows,int cols) {
		
		ArrayList<ArrayList<ArrayList<Animal>>> eco= new ArrayList<ArrayList<ArrayList<Animal>>>();
		this.eco=eco;
		for (int i=0;i<=rows;i++) {
			ArrayList<ArrayList<Animal>> row = new ArrayList<ArrayList<Animal>>();
			for (int j=0;j<=cols;j++) {
				ArrayList<Animal> col= new ArrayList<Animal>();
				Animal blank = new Animal(".");
				col.add(blank);
				row.add(col);
			}
			this.eco.add(row);
		}
	}
	public void print() {
		 	String[] line = new String[10];
	       
	        String allLines = "";
	        for (ArrayList<ArrayList<Animal>> row: this.eco) {
	        	for (ArrayList<Animal> cols : row) { 
	        		allLines+=(cols.get(0).getName().substring(0,1));
	        	}
	        	allLines+="\n";
	        }
	        System.out.println(allLines);
	 }
	public void create(String[] line) {
		// TODO Auto-generated method stub
		Animal blank = new Animal("blank");
		int x = Integer.parseInt(line[1].substring(1, 2));
		int y = Integer.parseInt(line[1].substring(3, 4));
		String name = line[2];
		String gender = line[3];
		String special = line[4];
		String type = blank.findType(name);
		if (type.equals("insect")) {
			Insect insect = new Insect(line);
			Animal bug = new Animal(insect);
			this.eco.get(x).get(y).add(0,bug);			
		}
		if (type.equals("mammal")) {
			Mammal mammal = new Mammal(line);
			Animal furball = new Animal(mammal);
			this.eco.get(x).get(y).add(0,furball);			
		}
		if (type.equals("bird")) {
			Bird bird= new Bird(line);
			Animal birdie = new Animal(bird);
			this.eco.get(x).get(y).add(0,bird);			
		}
		
	}
	public void move(String[] line) {
		if (line.length==1) {
			this.moveAll();
		}
		else if (line[1].contains("(")) {
			int x = Integer.parseInt(line[1].substring(1, 2));
			int y = Integer.parseInt(line[1].substring(3, 4));
			
			for (int i=0;i<this.eco.get(x).get(y).size();i++) {
				Animal test = new Animal(".");
				Animal temp = this.eco.get(x).get(y).get(i);
				String type = test.findType(this.eco.get(x).get(y).get(i).getName());
				if (type.equals("insect")){
					
					this.eco.get(x).get(y).set(0, test);
					if (y-1>=0) {
						this.eco.get(x).get(y-1).add(0,temp);
						temp.decAge();
					}
					else {
						System.out.println("lol");
						this.eco.get(x-1).get(this.eco.get(x-1).size()-1).add(0,temp);
						temp.decAge();
					}
				
				}
				else if (type.equals("mammal")) {
					moveMammal(temp,test,temp.getSpecial(),x,y,i);
				}
				else if(type.equals("bird")) {
					moveBird(temp,test,temp.getSpecial(),x,y,i);
				}
			}
		}
		
	}
	private void moveBird(Animal temp, Animal test, String special, int x, int y, int i) {
		// TODO Auto-generated method stub
		if (temp.getDirection().equals("d")){
			
			this.eco.get(x+1).get(y).add(0,temp);
			this.eco.get(x).get(y).set(0,test);
		}
	}
	private void moveAll() {
		for (int i=0;i<this.eco.size();i++) {//row
			for (int j=0;j<this.eco.get(i).size();j++) {//col
				for (int k=0;k<this.eco.get(i).get(j).size();k++) {
					Animal temp = new Animal(this.eco.get(i).get(j).get(k));
					Animal test = new Animal(".");
					String type = test.findType(temp.getName());
					if (type.equals("insect")) {
						moveInsect(temp,test,temp.getSpecial(),i,j,k);
					}
					else if (type.equals("mammal")) {
						moveMammal(temp,test,temp.getSpecial(),i,j,k);
					}
				}
			}
		}
	}
	private void moveMammal(Animal temp, Animal test, String special, int x, int y, int i) {
		// TODO Auto-generated method stub
		if(special.equals("right")) {
			moveMammalRight(temp,test,special,x,y,i);
			
		}
		
		
	}
	private void moveMammalRight(Animal temp, Animal test, String special, int x, int y, int i) {
		// TODO Auto-generated method stub
		System.out.println(temp.getFacing());
		this.eco.get(x).get(y).set(0, test);
		if (temp.getFacing()==1) {//up
			if(x-1>=0) {
				this.eco.get(x-1).get(y).add(0, temp);
			}
			else {
				
				//System.out.println("lol");
				int end = this.eco.size()-1;
				//this.eco.get(end).get(1).add(0,temp);
				this.eco.get(end).get(y+1).add(0,temp);
				
			}
			temp.changeFacing();	
		}else {// go left
			if(y-1>=0) {
				this.eco.get(x).get(y-1).add(0, temp);				
			}
			else {
				int end = this.eco.get(x).size()-1;
				this.eco.get(x+1).get(end).add(0,temp);	
			}
			temp.changeFacing();
		}
		
	}
	private void moveInsect(Animal temp, Animal test, String direction, int i, int j, int k) {
		// TODO Auto-generated method stub
		int square=temp.getSquare();
		//System.out.println(square);
		if (square!=0) {
			if(square%2==0) {
				moveSide(temp,test,direction,i,j,k);
				
			}
			else if (square%2==1) {
				moveUp(temp,test,direction,i,j,k);
			}
		}
		temp.decAge();
	}
	private void moveUp(Animal temp, Animal test, String direction, int i, int j, int k) {
		// TODO Auto-generated method stub
		if (i-1>=0) {
			this.eco.get(i-1).get(j).add(0,temp);
			this.eco.get(i).get(j).add(k, test);
		}else {
			this.eco.get(this.eco.size()-1).get(this.eco.get(this.eco.size()-1).size()-1).add(0, temp);
			this.eco.get(0).get(j).add(0, test);
		}
		temp.square();
	}
	private void moveSide(Animal temp, Animal test, String direction, int i, int j, int k) {
		// TODO Auto-generated method stub
		if (j-1>=0) {
			this.eco.get(i).get(j-1).add(0,temp);
			this.eco.get(i).get(j).add(0,test);
		}
		else if (j==0){
			int end = this.eco.get(i).size()-1;
			System.out.println(i+""+j);
			this.eco.get(i).get(end).add(0, temp);
			this.eco.get(i).get(0).clear();
			this.eco.get(i).get(0).add(0,test);
			for (ArrayList<Animal> cols: this.eco.get(i)) {
				for (Animal animal: cols) {
					System.out.print(animal.getType());
				}
				System.out.println("");
			}
			//this.eco.get(i).get(end).set(0, temp);
			
		}
		temp.square();
	}
}
