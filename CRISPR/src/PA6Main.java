import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PA6Main {

	public static void main(String[] args) {
		ArrayList<String> commands=input(args);
		Ecosystem eco = createEco(commands);
		read(commands,eco);
		//eco.print();
	}
	public static void read(ArrayList<String> commands, Ecosystem eco) {
		for (int i=3;i<commands.size();i++) {
			String[] line=commands.get(i).split("\\s+");
			
			String command=line[0];
			//System.out.println(line[0]);
			if(command.equals("create")) {
				//System.out.println("lol");
				eco.create(line);
			}
			else if (command.equals("move")) {
				eco.move(line);
			}
			else if (command.equals("print")) {
				eco.print();
			}
		}
		
	}
	public static Ecosystem createEco(ArrayList<String> commands) {
		int rows = Integer.parseInt(commands.get(0).substring(6));
		int cols = Integer.parseInt(commands.get(1).substring(6));
		Ecosystem eco = new Ecosystem(rows,cols);		
		return eco;
	}
	public static ArrayList input(String[] args) {
        ArrayList<String> commands = new ArrayList<String>();
        String filename = args[0];
        try {
            Scanner file = new Scanner(new File(filename));
            while (file.hasNextLine()) {
                commands.add(file.nextLine().toLowerCase());
            }
        } catch (Exception e) {
            System.err.println("ERROR: File not found.");
            System.exit(1);
        }
        return commands;
    }
	

}
