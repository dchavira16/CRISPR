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
	        Bird b = new Bird("blank", "blank", "0");
	        Insect i = new Insect(line);
	        Mammal m = new Mammal("blank", "blank", "");
	        String allLines = "";
	        for (ArrayList<ArrayList<Animal>> row: this.eco) {
	        	for (ArrayList<Animal> cols : row) {
	        		allLines+=(cols.get(0).getType());
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
			this.eco.get(x).get(y).set(0,bug);			
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
				String type = test.findType(this.eco.get(x).get(y).get(i).getName());
				if (type.equals("insect")){
					Animal temp = this.eco.get(x).get(y).get(i);
					this.eco.get(x).get(y).set(i, test);
					if (y-1>=0) {
						this.eco.get(x).get(y-1).add(i,temp);
					}
				}
			}
		}
		
	}
	private void moveAll() {
		// TODO Auto-generated method stub
		for (int i=0;i<this.eco.size();i++) {//row
			for (int j=0;j<this.eco.get(i).size();j++) {//col
				for (int k=0;k<this.eco.get(i).get(j).size();k++) {
					Animal temp = new Animal(this.eco.get(i).get(j).get(k));
					Animal test = new Animal(".");
					String type = test.findType(temp.getName());
					//its printing the animal object instead of the first letter.
					if (type.equals("insect")){
						System.out.println(type);
						this.eco.get(i).get(j).set(k, test);
						if (j-1>=0) {
							this.eco.get(i).get(j-1).add(k,temp);
						}
					}
				}
			}
		}
	}
}
