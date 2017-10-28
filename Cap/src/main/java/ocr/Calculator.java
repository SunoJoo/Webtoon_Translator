package ocr;

import java.util.ArrayList;



public class Calculator {
	ArrayList<String> des;
	ArrayList<ArrayList<Integer>> coordParent;
	ArrayList<ArrayList<Integer>> sentenceLocation;
	String[] sentenceArray;
	int sentenceNum = 0;
	
	/*String[] element;
	String[] comparison;
	int[] elementToInt;
	int[] comparisonToInt;
	String[] temp;
	String[] elementTemp;
	String[] comparisonTemp;*/
	
		Calculator(ArrayList<String> des, ArrayList<ArrayList<Integer>> coordParent){
			this.des = des;
			this.coordParent = coordParent;
			sentenceNum = initSentenceSize();
		}	
		
		public int[] returnLeftTopArray(ArrayList<Integer> coordParent) {
			int[] leftTop = new int[2];
			for(int i = 0; i<leftTop.length; i++)	
				leftTop[i] = coordParent.get(i);
			
			return leftTop;
			}
		
		public int[] returnLeftButtomArray(ArrayList<Integer> coordParent) {
			int[] leftButtom = new int[2];
			for(int i = 0; i<leftButtom.length; i++)	
				leftButtom[i] = coordParent.get(i+6);
			
			return leftButtom;
			}
		
		public int[] returnRightTopArray(ArrayList<Integer> coordParent) {
			int[] rightTop = new int[2];
			for(int i = 0; i<rightTop.length; i++)	
				rightTop[i] = coordParent.get(i+2);
			
			return rightTop;
			}
			
		public int[] returnRightButtomArray(ArrayList<Integer> coordParent) {
			int[] rightButtom = new int[2];
			for(int i = 0; i<rightButtom.length; i++)		
				rightButtom[i] = coordParent.get(i+4);
			
			return rightButtom;			
		}
		
		public int[] returnLeftTopButtom_MiddleArray(int num, ArrayList<Integer> coordParent) {
			int[] leftTop = returnLeftTopArray(coordParent);
			int[] leftButtom = returnLeftButtomArray(coordParent);			
			int[] leftTopButtom_Middle = new int[2];
			for(int i = 0; i<leftTopButtom_Middle.length; i++) 	
				leftTopButtom_Middle[i] = Math.abs((leftTop[i]+leftButtom[i])/2);	
			
			return leftTopButtom_Middle;
			}
		public int[] returnRightTopButtom_MiddleArray(int num,ArrayList<Integer> coordParent) {
			int[] rightTop = returnRightTopArray(coordParent);
			int[] rightButtom = returnRightButtomArray(coordParent);
			int[] rightTopButtom_Middle = new int[2];
			for(int i = 0; i<rightTopButtom_Middle.length; i++)	
				rightTopButtom_Middle[i] = Math.abs((rightTop[i]+rightButtom[i])/2);
			
			return rightTopButtom_Middle;
			}
		
		public int[] returnLeftButtomRightButtom_MiddleArray(ArrayList<Integer> coordParent) {
			int[] leftButtom = returnLeftButtomArray(coordParent);
			int[] rightButtom = returnRightButtomArray(coordParent);
			int[] leftButtomRightButton_Middle = new int[2];
			for(int i = 0; i<leftButtomRightButton_Middle.length; i++)	
				leftButtomRightButton_Middle[i] = Math.abs((leftButtom[i]+rightButtom[i])/2);
			
			return leftButtomRightButton_Middle;
			}
		
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
		
		
		
		public boolean checkRow(ArrayList<Integer> coordParent, ArrayList<Integer> coordParentGet) {		
			int x1Data = returnRightTopButtom_MiddleArray(coordParent, coordParentGet)[0];
			int x2Data = returnLeftTopButtom_MiddleArray(coordParent, coordParentGet)[0];				
			
			if(Math.abs((x1Data-x2Data))<10)			
				return true;
			else
				return false;
		}
		
		public boolean checkColumn(ArrayList<Integer> coordParent, ArrayList<Integer> coordParentGet) {
		
			int y1Data = returnLeftButtomRightButtom_MiddleArray(coordParent, coordParentGet)[1];
			int y2Data = returnLeftTopRightTop_MiddleArray(coordParent, coordParentGet)[1];

			if(Math.abs((y1Data-y2Data))<10)
				return true;
			else				
				return false;
		}
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
		
		public void print1() {
			
			StringBuffer sentence = new StringBuffer();			
			int num=0;
			if(!des.isEmpty())
				sentence.append(des.get(1));		
			
			sentenceArray = new String[sentenceNum];
			sentenceLocation = new ArrayList<ArrayList<Integer>>();
			
			System.out.println(sentenceArray.length);
			for(int i = 2, index=0; i<coordParent.size(); i++) {
				if(!checkRow(coordParent.get(i-1), coordParent.get(i))&&!checkColumn(coordParent.get(i-1), coordParent.get(i))) {
					if(i==2&&!coordParent.isEmpty()) {						
						sentenceLocation.get(index).add(returnLeftTopArray(coordParent.get(i-1))[0]);
						sentenceLocation.get(index).add(returnLeftTopArray(coordParent.get(i-1))[1]);
						//각 덩어리들 위치값 구해서 저장
					}
					sentenceArray[num] = sentence.toString();
					num++;
					sentence.delete(0, sentence.length());
					sentence.append(des.get(i));
				
					}
				else if(checkRow(coordParent.get(i-1), coordParent.get(i))){
					sentence.append(des.get(i));
					}
				else if(checkColumn(coordParent.get(i-1), coordParent.get(i))) {
					sentence.append(des.get(i));
					}
				if(i==coordParent.size()-1)
					sentenceArray[num] = sentence.toString();
				}
			for(int i = 0; i<sentenceArray.length;i++)
				System.out.println(sentenceArray[i]);
		}
		
	
			
			//System.out.println(checkRow(coordParent.get(5), coordParent.get(6)));
			//System.out.println(checkColumn(5, coordParent.get(1), coordParent.get(6)));
		
		
			
				
		/*	for(int i = 1 ; i<coordParent.size() ; i++){
				if(checkRow(i, coordParent)==false) {
					sb.append(des.get(i));
				}				
				
			}
			System.out.println(sb.toString());*/
		
			
		
			
		/*public void print() {
			for(int i = 2 ; i<=coordParent.size();i++) {
				element = coordParent.get(i-1).toArray(new String[coordParent.get(i-1).size()]);
				comparison = coordParent.get(i).toArray(new String[coordParent.get(i).size()]);
			
				elementToInt = new int[element.length*2];
				comparisonToInt = new int[comparison.length*2];
				elementTemp = new String[element.length*2];
				comparisonTemp = new String[comparison.length*2];
				
				for(int j = 0, z=0 ; j<element.length;j++) {
					temp = element[j].split("\n");
					for(int k = 0; k<temp.length;k++) {
					elementTemp[z] = temp[k];
					z++;
					}
				}
				
				for(int j = 0, z=0 ; j<comparison.length;j++) {
					temp = comparison[j].split("\n");
					for(int k = 0; k<temp.length;k++) {
						comparisonTemp[z] = temp[k];
					z++;
					}
				}
				for(int j = 0 ; j<elementTemp.length;j++)					
					System.out.println(elementTemp[j]);
				//elementToInt = convertStringtoInt(elementTemp);
				//comparisonToInt = convertStringtoInt(comparisonTemp);
				
			}
		}*/
		
		/*public int[] convertStringtoInt(String[] Temp) {
			int[] intElementTemp= new int[elementTemp.length];
			for(int i = 0 ; i<elementTemp.length;i++) {
				intElementTemp[i]=Integer.parseInt(elementTemp[i]);
			}
				
				return intElementTemp;
		}*/
		
		

				
		
		
		public boolean generatorSentence(int[] elementToInt, int[] comparisonToInt) {
			
			
			return false;
			
		}
}


