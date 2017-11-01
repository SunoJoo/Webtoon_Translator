package ocr;

import java.util.ArrayList;



public class Calculator {
	private ArrayList<String> des;
	private ArrayList<ArrayList<Integer>> coordParent;
	private ArrayList<ArrayList<Integer>> sentenceIndex;
	private ArrayList<Integer> sentenceLocation;
	private String[] sentenceArray;
	private int sentenceNum = 0;
	private int[] leftTop = new int[2];
	private int[] rightTop = new int[2];
	private int[] leftBottom = new int[2];
	private int[] rightBottom = new int[2];
	private boolean rightTopSet =false;
	private boolean leftTopSet =false;
	private boolean leftBottomSet =false;
	private boolean rightBottomSet =false;
	
		Calculator(ArrayList<String> des, ArrayList<ArrayList<Integer>> coordParent){
			this.des = des;
			this.coordParent = coordParent;
			sentenceNum = initSentenceSize();
		}	
		
		/**
		 * @param coordParent
		 * @return
		 * 왼쪽 상단 좌표를 얻기 위함
		 */
		public int[] returnLeftTopArray(ArrayList<Integer> coordParent) {
			int[] leftTop = new int[2];
			for(int i = 0; i<leftTop.length; i++)	
				leftTop[i] = coordParent.get(i);
			
			return leftTop;
			}
		/**
		 * @param coordParent
		 * @return
		 * 좌측 하단 좌표를 얻기 위함
		 */
		public int[] returnLeftButtomArray(ArrayList<Integer> coordParent) {
			int[] leftButtom = new int[2];
			for(int i = 0; i<leftButtom.length; i++)	
				leftButtom[i] = coordParent.get(i+6);
			
			return leftButtom;
			}
		/**
		 * @param coordParent
		 * @return
		 * 우측 상단 좌표를 얻기 위함
		 */
		public int[] returnRightTopArray(ArrayList<Integer> coordParent) {
			int[] rightTop = new int[2];
			for(int i = 0; i<rightTop.length; i++)	
				rightTop[i] = coordParent.get(i+2);
			
			return rightTop;
			}
		/**
		 * @param coordParent
		 * @return
		 * 우측 하단 좌표를 얻기 위함
		 */
		public int[] returnRightButtomArray(ArrayList<Integer> coordParent) {
			int[] rightButtom = new int[2];
			for(int i = 0; i<rightButtom.length; i++)		
				rightButtom[i] = coordParent.get(i+4);
			
			return rightButtom;			
		}
		/**
		 * @param coordParent
		 * @return
		 * 좌측 상,하단의 평균 값을 반환
		 * 
		 */
		public int[] returnLeftTopButtom_MiddleArray(int num, ArrayList<Integer> coordParent) {
			int[] leftTop = returnLeftTopArray(coordParent);
			int[] leftButtom = returnLeftButtomArray(coordParent);			
			int[] leftTopButtom_Middle = new int[2];
			for(int i = 0; i<leftTopButtom_Middle.length; i++) 	
				leftTopButtom_Middle[i] = Math.abs((leftTop[i]+leftButtom[i])/2);	
			
			return leftTopButtom_Middle;
			}
		/**
		 * @param coordParent
		 * @return
		 * 우측 상,하단의 평균 값을 반환
		 * 
		 */
		public int[] returnRightTopButtom_MiddleArray(int num,ArrayList<Integer> coordParent) {
			int[] rightTop = returnRightTopArray(coordParent);
			int[] rightButtom = returnRightButtomArray(coordParent);
			int[] rightTopButtom_Middle = new int[2];
			for(int i = 0; i<rightTopButtom_Middle.length; i++)	
				rightTopButtom_Middle[i] = Math.abs((rightTop[i]+rightButtom[i])/2);
			
			return rightTopButtom_Middle;
			}
		/**
		 * @param coordParent
		 * @return
		 * 좌측 하단, 우측 하단의 평균 값을 반환
		 * 
		 */
		public int[] returnLeftButtomRightButtom_MiddleArray(ArrayList<Integer> coordParent) {
			int[] leftButtom = returnLeftButtomArray(coordParent);
			int[] rightButtom = returnRightButtomArray(coordParent);
			int[] leftButtomRightButton_Middle = new int[2];
			for(int i = 0; i<leftButtomRightButton_Middle.length; i++)	
				leftButtomRightButton_Middle[i] = Math.abs((leftButtom[i]+rightButtom[i])/2);
			
			return leftButtomRightButton_Middle;
			}
		/**
		 * @param coordParent
		 * @return
		 * 좌측 상단, 우측 상단의 평균 값을 반환
		 * 
		 */
		public int[] returnLeftTopRightTop_MiddleArray(ArrayList<Integer> coordParent) {
			int[] leftTop = returnLeftTopArray(coordParent);
			int[] rightTop = returnRightTopArray(coordParent);
			int[] leftTopRightTop_Middle = new int[2];
			for(int i = 0; i<leftTopRightTop_Middle.length; i++)	
				leftTopRightTop_Middle[i] = Math.abs((leftTop[i]+rightTop[i])/2);
			
			return leftTopRightTop_Middle;
			}
		
		
			//@overriding
		
		/**
		 * @param coordParentCurrent
		 * @param coordParentNext
		 * @--- X축의 평균을 구함
		 * @return
		 */
		public int[] returnLeftTopButtom_MiddleArray(ArrayList<Integer> coordParentCurrent ,ArrayList<Integer> coordParentNext ) {
			int[] leftTop = returnLeftTopArray(coordParentNext);
			int[] leftButtom = returnLeftButtomArray(coordParentNext);			
			int[] leftTopButtom_Middle = new int[2];
			for(int i = 0; i<leftTopButtom_Middle.length; i++) 	
				leftTopButtom_Middle[i] = Math.abs((leftTop[i]+leftButtom[i])/2);	
			
			return leftTopButtom_Middle;
			}
		
		/**
		 * @param coordParentCurrent
		 * @param coordParentNext
		 * @--- Y축의 평균을 구함
		 * @return
		 */
		public int[] returnLeftTopRightTop_MiddleArray(ArrayList<Integer> coordParentCurrent, ArrayList<Integer> coordParentNext) {
			int[] leftTop = returnLeftTopArray(coordParentNext);
			int[] rightTop = returnRightTopArray(coordParentNext);
			int[] leftTopRightTop_Middle = new int[2];
			for(int i = 0; i<leftTopRightTop_Middle.length; i++)	
				leftTopRightTop_Middle[i] = Math.abs((leftTop[i]+rightTop[i])/2);
			
			return leftTopRightTop_Middle;
			}
		
		/**
		 * @param coordParentCurrent
		 * @param coordParentNext
		 * @--- X축의 평균을 구함
		 * @return
		 */
		
		public int[] returnRightTopButtom_MiddleArray(ArrayList<Integer> coordParentCurrent, ArrayList<Integer> coordParentNext) {
			int[] rightTop = returnRightTopArray(coordParentCurrent);
			int[] rightButtom = returnRightButtomArray(coordParentCurrent);
			int[] rightTopButtom_Middle = new int[2];
			for(int i = 0; i<rightTopButtom_Middle.length; i++)	
				rightTopButtom_Middle[i] = Math.abs((rightTop[i]+rightButtom[i])/2);
			
			return rightTopButtom_Middle;
			}
		/**
		 * @param coordParentCurrent
		 * @param coordParentNext
		 * @--- Y축의 평균을 구함
		 * @return
		 */
		public int[] returnLeftButtomRightButtom_MiddleArray(ArrayList<Integer> coordParentCurrent,  ArrayList<Integer> coordParentNext) {
			int[] leftButtom = returnLeftButtomArray(coordParentCurrent);
			int[] rightButtom = returnRightButtomArray(coordParentCurrent);
			int[] leftButtomRightButton_Middle = new int[2];
			for(int i = 0; i<leftButtomRightButton_Middle.length; i++)	
				leftButtomRightButton_Middle[i] = Math.abs((leftButtom[i]+rightButtom[i])/2);
			
			return leftButtomRightButton_Middle;
			}
		
		
		/**
		 * @param coordParent
		 * @return
		 * X축의 형태소와의 거리 판단
		 * 
		 */
		public boolean checkRow(ArrayList<Integer> coordParent, ArrayList<Integer> coordParentGet) {		
			int x1Data = returnRightTopButtom_MiddleArray(coordParent, coordParentGet)[0];
			int x2Data = returnLeftTopButtom_MiddleArray(coordParent, coordParentGet)[0];				
			
			if(Math.abs((x1Data-x2Data))<15)			
				return true;
			else
				return false;
		}
		/**
		 * @param coordParent
		 * @return
		 * Y축의 형태로와 거리 판단
		 * 
		 */
		public boolean checkColumn(ArrayList<Integer> coordParent, ArrayList<Integer> coordParentGet) {
		
			int y1Data = returnLeftButtomRightButtom_MiddleArray(coordParent, coordParentGet)[1];
			int y2Data = returnLeftTopRightTop_MiddleArray(coordParent, coordParentGet)[1];

			if(Math.abs((y1Data-y2Data))<15)
				return true;
			else				
				return false;
		}
		/**
		 * @param coordParent
		 * @return
		 * Sentence와 Sentence위치를 저장할 공간의 크기 구함
		 * 
		 */
		public int initSentenceSize() {
			int sentenceNum = 0;
			for(int i = 2; i<coordParent.size(); i++) {
				if(i==2&&!coordParent.isEmpty())
					sentenceNum = sentenceNum+1;
				if(!checkRow(coordParent.get(i-1), coordParent.get(i))&&!checkColumn(coordParent.get(i-1), coordParent.get(i))) {
					sentenceNum = sentenceNum + 1;
					}			
			}
			
			return sentenceNum;
		}
		/**
		 * @param coordParent
		 * @return
		 * 실제 사용할 Sentence(Des)와 Sentence의 좌표 (SentenceIndex)를 구하는 메소드
		 * 
		 */
		public void calresult() {
			
			StringBuffer sentence = new StringBuffer();			
			int num=0;		
		
			sentenceArray = new String[sentenceNum];
			sentenceIndex = new ArrayList<ArrayList<Integer>>();
			sentenceLocation = new ArrayList<Integer>();
			
			System.out.println(sentenceArray.length);
			for(int i = 2, index=0; i<coordParent.size(); i++) {		
						
				if(i==2)
				{
					sentence.append(des.get(1));			
				}
				if(!checkRow(coordParent.get(i-1), coordParent.get(i))&&!checkColumn(coordParent.get(i-1), coordParent.get(i))) {
					
					sentenceArray[num] = sentence.toString();
					insertSentenceLocation();				
					intsertSentenceIndex(num);
					setDeaultBooleanSet();
					num++;
					sentence.delete(0, sentence.length());
					sentence.append(des.get(i));
					index = index + 1;						
					setDefaultSentenceLocation();
				
					}
				
				else if(checkRow(coordParent.get(i-1), coordParent.get(i))){
					sentence.append(des.get(i));
					checkLeftTop(i);
					checkRightTop(i);
					checkRightBottom(i);
					checkLeftBottom(i);					
					}
				else if(checkColumn(coordParent.get(i-1), coordParent.get(i))) {
					sentence.append(des.get(i));	
					checkLeftTop(i);
					checkRightTop(i);
					checkRightBottom(i);
					checkLeftBottom(i);
					}
				if(i==coordParent.size()-1) {
					sentenceArray[num] = sentence.toString();
					insertSentenceLocation();
					intsertSentenceIndex(num);
				}
				}
			
		}
		
		public void checkLeftTop(int i) {
			int x = returnLeftTopArray(coordParent.get(i))[0];
			int y = returnLeftTopArray(coordParent.get(i))[1];
				if(!leftTopSet)	{			
					leftTop[0] = x;		
					leftTop[1] = y;	
					leftTopSet = true;
					}
				if(leftTopSet)
					if(leftTop[0]>x) 
						leftTop[0] = x;
					if(leftTop[1]>y)
						leftTop[1] = y;
				}

		public void checkRightTop(int i) {	
			int x = returnRightTopArray(coordParent.get(i))[0];
			int y = returnRightTopArray(coordParent.get(i))[1];
	 
			if(!rightTopSet)	{			
					rightTop[0] = x;		
					rightTop[1] = y;	
					rightTopSet = true;
			}
			
			if(rightTopSet) {			
				if(rightTop[0]<x) 
					rightTop[0] = x;				
				if(rightTop[1]>y) 
					rightTop[1] = y;	
			}
			
		}
		
		
		
		
		public void checkRightBottom(int i) {
			int x = returnRightButtomArray(coordParent.get(i))[0];
			int y = returnRightButtomArray(coordParent.get(i))[1];
	
			if(!rightBottomSet)	{			
				rightBottom[0] = x;		
				rightBottom[1] = y;	
				rightBottomSet = true;
				}
			if(rightBottomSet)
				if(rightBottom[0]<x) 
					rightBottom[0] =x;			
				if(rightBottom[1]<y) 
					rightBottom[1] =y;		
		}
		
		public void checkLeftBottom(int i) {
			int x = returnLeftButtomArray(coordParent.get(i))[0];
			int y = returnLeftButtomArray(coordParent.get(i))[1];
	
			if(!leftBottomSet)	{			
				leftBottom[0] = x;		
				leftBottom[1] = y;	
				leftBottomSet = true;
				}
			if(leftBottomSet) {
				if(leftBottom[0]>x) 
					leftBottom[0] =x;			
				if(leftBottom[1]<y) 
					leftBottom[1] =y;	
			}
		}
		
		
		
		public void insertSentenceLocation() {
			for(int i = 0; i<leftTop.length;i++)
				sentenceLocation.add(leftTop[i]);
			
			for(int i = 0; i<rightTop.length;i++)
				sentenceLocation.add(rightTop[i]);
			
			for(int i = 0; i<rightBottom.length;i++)
				sentenceLocation.add(rightBottom[i]);
			
			for(int i = 0; i<leftBottom.length;i++)
				sentenceLocation.add(leftBottom[i]);
			
		}
		
		public void intsertSentenceIndex(int num) {
			sentenceIndex.add(sentenceLocation);
		}
		
		public void setDeaultBooleanSet() {
			rightTopSet =false;
			leftTopSet =false;
			leftBottomSet =false;
			rightBottomSet =false;
		}
		public void setDefaultSentenceLocation() {			
				//sentenceLocation.clear();
				sentenceLocation = new ArrayList<Integer>();
		}
		
		public void setDefaultSentenceIndex() {
				sentenceIndex.clear();
		}
		
		
		public ArrayList<ArrayList<Integer>> getSentenceIndex() {
			return sentenceIndex;
		}

		public void setSentenceIndex(ArrayList<ArrayList<Integer>> sentenceIndex) {
			this.sentenceIndex = sentenceIndex;
		}

		public String[] getSentenceArray() {
			return sentenceArray;
		}

		public void setSentenceArray(String[] sentenceArray) {
			this.sentenceArray = sentenceArray;
		}		
}


