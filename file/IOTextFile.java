package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import data.ArrayListPersonE;
import data.ListPerson;
import data.Person;

public class IOTextFile {
	
	// Constant
	public static final String INPUT_FILE = "C:\\dataInput.txt";
	public static final String OUTPUT_FILE = "C:\\dataOutput.txt";
	public static final String HEADER_FILE = "// Data example\n"
		+ "// Created by:\n" + "//  Nguyen Trong Phuc\n"
		+ "// Created on:\n" + "//  19/3/2012\n"
		+ "// Data structure:\n" 
		+ "//  Numero{int}; Name{String}; Birthday{Date(MM/DD/YYYY)}; Address{String}; \\newline\n"
		+ "// Start \n\n";
	public static final String FOOTER_FILE = "\n\n// End.";

	// Static function
	
	/*
	 * Read data from file
	 * Input: 
	 * 		name of input data file
	 * Output:
	 * 		true: if file is readable
	 * 		list of person
	 */
	public static boolean readData(String fileName, ListPerson listPerson){		
		try{
			File file = new File(fileName);			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			// Read data from file - line
			String strLine;
			int count = 0;
			while ((strLine = br.readLine()) != null)   {
				strLine = strLine.trim();
				if (strLine!=null && strLine.length()>=0){
					if (!strLine.startsWith("//")){
						// Split by ";"
						String[] data = strLine.split(";");
						if (data!=null && data.length==4){
							try{
								int numero = Integer.parseInt(data[0].trim());
								String name = data[1].trim(); 
								Date birth = new Date(data[2].trim());
								String add = data[3].trim();
								Person p = new Person(numero, name, birth, add); 										
								listPerson.addPerson(p);
								count++;
							}catch(NumberFormatException e){
								System.out.println("This line is incorrect!");								
							}catch(IllegalArgumentException e){
								System.out.println("This line is incorrect!");
							}							
						}
					}
				}				
			}			
			br.close();
			fr.close();
		}catch(FileNotFoundException e){			
			e.printStackTrace();
			return false;
		}catch(NullPointerException e){			
			e.printStackTrace();
			return false;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * Read data from file
	 * Input: 
	 * 		name of input data file
	 * Output:
	 * 		true: if file is readable
	 * 		list of person
	 */
	public static boolean readData(String fileName, ArrayListPersonE listPerson){		
		try{
			File file = new File(fileName);			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			// Read data from file - line
			String strLine;
			int count = 0;
			while ((strLine = br.readLine()) != null)   {
				strLine = strLine.trim();
				if (strLine!=null && strLine.length()>=0){
					if (!strLine.startsWith("//")){
						// Split by ";"
						String[] data = strLine.split(";");
						if (data!=null && data.length==4){
							try{
								int numero = Integer.parseInt(data[0].trim());
								String name = data[1].trim(); 
								Date birth = new Date(data[2].trim());
								String add = data[3].trim();
								Person p = new Person(numero, name, birth, add); 										
								listPerson.addPerson(p);
								count++;
							}catch(NumberFormatException e){
								System.out.println("This line is incorrect!");								
							}catch(IllegalArgumentException e){
								System.out.println("This line is incorrect!");
							}							
						}
					}
				}				
			}			
			br.close();
			fr.close();
		}catch(FileNotFoundException e){			
			e.printStackTrace();
			return false;
		}catch(NullPointerException e){			
			e.printStackTrace();
			return false;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * Read data from default file
	 * Input: 
	 * 		default input data file
	 * Output:
	 * 		true: if file is readable
	 * 		list of person
	 */
	public static boolean readData(ListPerson listPerson){
		return readData(INPUT_FILE, listPerson);
	}
		
	/*
	 * Write data to file
	 * Input: 
	 * 		name of output data file
	 * 		list of person
	 * Output:
	 * 		true: if file is writable	
	 */
	public static boolean writeData(String fileName, ListPerson listPerson){
		try{
			File file = new File(fileName);			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			// Write the header file
			bw.write(HEADER_FILE);			
		
			if (listPerson!=null){
				// Write the contents
				for (int i=1; i<=listPerson.getNumPer();i++){
					String data = listPerson.getPerson(i).toStringFile();
					bw.write(data);
				}
			}
			
			// Write the footer file
			bw.write(FOOTER_FILE);
			// Close
			bw.close();
			fw.close();			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * Write data to file
	 * Input: 
	 * 		name of output data file
	 * 		list of person
	 * Output:
	 * 		true: if file is writable	
	 */
	public static boolean writeData(String fileName, ArrayListPersonE listPerson){
		try{
			File file = new File(fileName);			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			// Write the header file
			bw.write(HEADER_FILE);			
		
			if (listPerson!=null){
				// Write the contents
				for (int i=1; i<=listPerson.size();i++){
					String data = listPerson.getPerson(i).toStringFile();
					bw.write(data);
				}
			}
			
			// Write the footer file
			bw.write(FOOTER_FILE);
			// Close
			bw.close();
			fw.close();			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * Write data to default file
	 * Input: 	
	 * 		list of person
	 * Output:
	 * 		true: if file is writable	
	 */
	public static boolean writeData(ListPerson listPerson){
		return writeData(OUTPUT_FILE, listPerson);
	}
	
	/*
	 * Process the file name
	 */
	public static String updateFileName(String fileName){		
		String[] temp = fileName.split("[/.]");		
		if (temp.length<2){
			fileName = fileName + ".txt";
		}
		return fileName;
	}
}
