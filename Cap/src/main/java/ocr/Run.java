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
		String path = "./src/main/resources/webtoon_img/_35.jpg";
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
			for(int i = 0; i<calculator.getSentenceArray().length;i++) {				
				System.out.println(calculator.getSentenceArray()[i]);
				System.out.println(calculator.getSentenceIndex().get(i));		
				
			}
			//System.out.println(calculator.getSentenceIndex().get(0));
			//System.out.println(calculator.getSentenceIndex().get(1));		
			
		
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
