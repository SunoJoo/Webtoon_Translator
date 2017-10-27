package ocr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWR {
	FileWriter filewriter;
	FileReader filereader;
	File file;
	BufferedReader br;
	BufferedWriter bw;
	StringBuffer stringbuffer;
	
	public String[] readFromFile() {
		file = new File("./text/lines.txt");
		
		try {
			stringbuffer = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			//filereader = new FileReader(file,"uft-8");
			while(br.read()!=-1)
				
				stringbuffer.append((char)br.read());
			
			System.out.println(stringbuffer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return null;	
	}
	
	public void writeToFile() {
		
	}
}
