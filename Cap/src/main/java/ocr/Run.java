package ocr;


import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class Run {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Crawler();
		//StringBuffer sb = new StringBuffer();
		Detect detect = new Detect();
		String path = "./src/main/resources/webtoon_img/_14.jpg";
		File f = new File("./text/lines.txt");
		PrintStream p;	
		Coordinator coordinator;
		Calculator calculator;		
		
		try {		
			p = new PrintStream(f);
			detect.detectText(path, p);		
				
			coordinator = new Coordinator(detect.getDes(),detect.getCoord());
			coordinator.coordinate();
			calculator = new Calculator(coordinator.getDes(),coordinator.getCoordParent());
			calculator.print1();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
