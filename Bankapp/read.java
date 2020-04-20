package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class read {
	public static List<String[]> read(String file) {
		List<String[]> data = new LinkedList<String[]>();
		String DATAROW;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((DATAROW = br.readLine()) != null) {
				String[] DATARECORDS = DATAROW.split(",");
				data.add(DATARECORDS);
			}
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("COULD NOT FIND FILE BUFFER");
			e.printStackTrace();
		}
		return data;
	}

}

