import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

public class FileIO {
	int faveCount = 0;
	int faveWrong = 0;
	int vamp = 0;
	int were = 0;
	int monsterTotal = 0;
	int blanks = 0;
	String color;
	int colorCount = 0;
	static String[] lines;

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
			//			setLines(line, cNum);
			// print out header line 
			System.out.println(line);

			// while line is equal to the next line of the buffered reader is not equal to null
			// this means read the next line in the file until there are not more line to read


			while (  ( line = br.readLine() ) != null     ) {

				// make an array to hold the columns 
				String[] lineColumns;
				// break the line up to columns. break on the comma and delete the comma
				lineColumns = line.split(",");


				try {

					double number = Double.parseDouble(lineColumns[3]);
					faveCount = faveCount + 1;
					System.out.println(number);
				} catch (Exception e) {

					faveCount = faveCount - 1;
					faveWrong = faveWrong + 1;
					e.printStackTrace();
				}

				try {
					String monster = lineColumns[2];

					if ( monster.equals("Vampire")) {
						vamp = vamp + 1;
					}

					else if (monster.equals("Werewolf")) {
						were = were + 1;
					}

					else {

					}

				} catch (Exception e) {

					e.printStackTrace();
				}

				try {
					String cmpr = " ";

					for (int i = 0; i < lineColumns.length; i++) {

						if (cmpr.equals(lineColumns[i])==true) {
							blanks = blanks++;
						}
						else {

						}
					}
				} catch(Exception e) {

					e.printStackTrace();
				}

				try {

					color = lineColumns[1];
						if (color.equals("Red")) {
							colorCount = colorCount++;
						}
						else if (color.equals("Blue")) {
							colorCount = colorCount++;
						}
						else if (color.equals("Yellow")) {
							colorCount = colorCount++;
						}
						else {}


				} catch(Exception e) {
					e.printStackTrace();
				}

				if (vamp > were) {
					monsterTotal = vamp - were;
				}
				else if (were > vamp) {
					monsterTotal = were - vamp;
				}
				else {
				}
				// print every line
				System.out.println(line);



			}

			

			// Write numCount to file
			// when completely done with reading close the Reader
			br.close();

		} catch (Exception e) {

			e.printStackTrace();
		}


	
	
	try {
		String fileName = "Results.txt";
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("count of valid numbers: ");
		bw.write(String.valueOf(faveCount));
		bw.newLine();
		
		bw.write("count of invalid numbers: ");
		bw.write(String.valueOf(faveWrong));
		bw.newLine();
		
		bw.write("count of Vampires: ");
		bw.write(String.valueOf(vamp));
		bw.newLine();
		
		bw.write("count of Werewolves: ");
		bw.write(String.valueOf(were));
		bw.newLine();
		
		bw.write("difference in monster faves: ");
		bw.write(String.valueOf(monsterTotal));
		bw.newLine();
		
		bw.write("count of blanks: ");
		bw.write(String.valueOf(blanks));
		bw.newLine();
		
		bw.write("count of RBY colors: ");
		bw.write(String.valueOf(colorCount));
		bw.newLine();
		
		bw.close();
		
	} catch(Exception e) {
		
	}

	}

	public static void main(String[] args) {

		FileIO lab9 = new FileIO();
		lab9.parseFile();

	}

	//		public static void analyzeFile() {
	//	
	//		}
	//	
	//		public static void setLines(String newLine, int num) {
	//			lines[num] = newLine;
	//			num = num+1;
	//		}
	//	
	//		public static String getLine(int num) {
	//			return lines[num];
	//		}

}
