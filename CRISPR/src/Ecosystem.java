import java.util.ArrayList;

public class Ecosystem {
	private ArrayList<ArrayList>eco;
	private ArrayList<ArrayList> row;
	private ArrayList<Animal> col;
	
	
	public Ecosystem(int rows,int cols) {
		
		ArrayList<ArrayList> eco= new ArrayList<ArrayList>();
		this.eco=eco;
		for (int i=0;i<=rows;i++) {
			ArrayList<ArrayList> row = new ArrayList<ArrayList>();
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
		 	String[] line = new String[0];
	        Bird b = new Bird("blank", "blank", "0");
	        Insect i = new Insect(line);
	        Mammal m = new Mammal("blank", "blank", "");
	        String allLines = "";
	        for (ArrayList<ArrayList> row: this.eco) {
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
		String coor = line[1];
		String name = line[2];
		String gender = line[3];
		String special = line[4];
		String type = blank.findType(name);
		System.out.println(type);
		if (type.equals("insect")) {
			Insect insect = new Insect(line);
		}
	}
}
