package assignment2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Rule extends HashMap<ArrayList<String>, String> {
    // on creation loads all key phrases/words and responses to hashMap 
	public Rule() {
		innitRules();
	}
	// read in all rules for chat bot
	public void innitRules() {
		String filename = "./word.txt";
		Path path = Paths.get(filename);
		ArrayList<String> temp = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(path);
		
			//read text file line by line
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				// if is not a answer add it to array list
				if(line.charAt(0) != '.') {
					temp.add(line);
				// if line is an answer add arraylist and response to hash
				}else {
					put(temp, line.substring(1));
					temp = new ArrayList<String>();
				}
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}