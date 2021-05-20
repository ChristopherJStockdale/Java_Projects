import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

public class FileIO {

	private File labFile;

	public FileIO() {
		//  constructor 
		labFile = new File("Lab_Answers.csv");
	}

	public void parseFile() {
		// this will be to for the requirements

		try {
			FileReader fr = new FileReader(labFile);
			BufferedReader br = new BufferedReader(fr);
			// make a String called line
			String line;

			// read the header line in the file
			line = br.readLine();
			// print out header line 
			System.out.println(line);

			// while line is equal to the next line of the bufferedreader is not equal to null
			// this means read the next line in the file until there are not more line to read
			while (  ( line = br.readLine() ) != null     ) {

				// make an array to hold the columns 
				String[] lineColumns;
				// break the line up to columns. break on the comma and delete the comma
				lineColumns = line.split(",");
 
				// print every line
				System.out.println(line);



			}
			
			// when completely done with reading close the Reader
			br.close();

		} catch (Exception e) {

			e.printStackTrace();
		}


	}

	public static void main(String[] args) {

		FileIO lab9 = new FileIO();
		lab9.parseFile();

	}

}
