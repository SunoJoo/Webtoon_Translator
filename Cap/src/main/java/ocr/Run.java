package ocr;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Crawler();
		
		Detect d = new Detect();
		String path = "./src/main/resources/webtoon_img/_14.jpg";
		File f = new File("text.txt");
		PrintStream p; 
		try {
			p = new PrintStream(f);
			d.detectText(path, p);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
