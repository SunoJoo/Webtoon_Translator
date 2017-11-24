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
		//new Crawler();		
		Detect detect = new Detect();
		
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of 3747e7f... Merge branch 'master' of
		String path = "./src/main/resources/webtoon_img/_13.jpg";
=======
		String path = "./src/main/resources/webtoon_img/_42.jpg";
>>>>>>> parent of c90041f... 32
		File f = new File("./text/lines.txt");
		PrintStream p;	
		Coordinator coordinator;
		Calculator calculator;		
		
		try {		
			p = new PrintStream(f);
<<<<<<< HEAD
			detect.detectText(path, p);
<<<<<<< HEAD
=======
			
			new Crawler("http://comic.naver.com/webtoon/detail.nhn?titleId=679519&no=147&weekday=mon");		
			System.out.println("크롤링 완료");
			String imgPath = "C:/Users/kingt/git/Webtoon_Translator/Cap/src/main/resources/webtoon_img";
			/*ImageProcessing ip = new ImageProcessing(imgPath);
			ip.start();*/
			Detect detect = new Detect();		
			String path = imgPath+"/_13.jpg";
			
			File f = new File("C:/Users/kingt/git/Webtoon_Translator/Cap/text/lines.txt");
			PrintStream p;	
			Coordinator coordinator;
			Calculator calculator;		
			ResultData result = new ResultData();
			
			try {		
				p = new PrintStream(f);
				detect.detectText(path, p);		
					
				coordinator = new Coordinator(detect.getDes(),detect.getCoord());
				coordinator.coordinate();
				calculator = new Calculator(coordinator.getDes(),coordinator.getCoordParent());
				calculator.calResult();		
>>>>>>> branch 'master' of https://github.com/SunoJoo/Webtoon_Translator.git
=======
			detect.detectText(path, p);		
>>>>>>> parent of c90041f... 32
=======
>>>>>>> parent of 3747e7f... Merge branch 'master' of
				
			coordinator = new Coordinator(detect.getDes(),detect.getCoord());
			coordinator.coordinate();
			calculator = new Calculator(coordinator.getDes(),coordinator.getCoordParent());
			calculator.calresult();
			for(int i = 0; i<calculator.getSentenceArray().length;i++) {				
				System.out.println(calculator.getSentenceArray()[i]);
				System.out.println(calculator.getSentenceIndex().get(i));						
			}
			
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
			
			
		
			
			
			
			
>>>>>>> parent of c90041f... 32
=======
>>>>>>> parent of 3747e7f... Merge branch 'master' of
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
