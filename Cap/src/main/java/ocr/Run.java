package ocr;


import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class Run {
	
	
	/**
	 * @param args
	 * Crawler는 스레드가 따로 돌기 때문에 join해줘야함
	 * 아직 join을 안해줬으므로 Crawler먼저 main에서 실행 후 주석처리하고 Detect부터 실행하면 됨
	 * 구글 API는 각자 받은 json파일과 본인 계정을 사용하기 바람(제거는 이미 많이씀..)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String path1 = "./src/main/resources/webtoon_img/";
		//ImageProcessing ip = new ImageProcessing(path1);
		//ip.start(path1);
		//new Crawler("25455","484");		
		/*Detect detect = new Detect();
		
		String path = "./src/main/resources/webtoon_img/_35.jpg";
		File f = new File("./text/lines.txt");
		PrintStream p;	
		Coordinator coordinator;
		Calculator calculator;		
		ResultData result;
		
		try {		
			p = new PrintStream(f);
			detect.detectText(path, p);		
				
			coordinator = new Coordinator(detect.getDes(),detect.getCoord());
			coordinator.coordinate();
			calculator = new Calculator(coordinator.getDes(),coordinator.getCoordParent());
			calculator.calresult();
			result = new ResultData();
			for(int i = 0; i<calculator.getSentenceArray().length;i++) {				
				Trans translator = new Trans();
				result.addText(translator.translator(calculator.getSentenceArray()[i])+"\n");				
			}
			result.setPosition(calculator.getSentenceIndex());			
					
				System.out.println(result.getText());
				System.out.println(result.getPosition());
			
			
			
			
			
		
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

		
	}
}
