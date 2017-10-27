package ocr;

import java.util.ArrayList;

public class Calculator {
	ArrayList<String> des;
	ArrayList<ArrayList<Integer>> coordParent;
	
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
		}	
		
		public int[] insertLeftTopArray(ArrayList<Integer> coordParent) {
			int[] leftTop = new int[2];
			for(int i = 0; i<leftTop.length; i++)	
				leftTop[i] = coordParent.get(i);
			
			return leftTop;
			}
		
		public int[] insertLeftButtomArray(ArrayList<Integer> coordParent) {
			int[] leftButtom = new int[2];
			for(int i = 0; i<leftButtom.length; i++)	
				leftButtom[i] = coordParent.get(i+6);
			
			return leftButtom;
			}
		
		public int[] insertRightTopArray(ArrayList<Integer> coordParent) {
			int[] rightTop = new int[2];
			for(int i = 0; i<rightTop.length; i++)	
				rightTop[i] = coordParent.get(i+2);
			
			return rightTop;
			}
			
		public int[] insertRightButtomArray(ArrayList<Integer> coordParent) {
			int[] rightButtom = new int[2];
			for(int i = 0; i<rightButtom.length; i++)		
				rightButtom[i] = coordParent.get(i+4);
			
			return rightButtom;			
		}
		
		public int[] insertLeftTopButtom_MiddleArray(int num, ArrayList<Integer> coordParent) {
			int[] leftTop = insertLeftTopArray(coordParent);
			int[] leftButtom = insertLeftButtomArray(coordParent);			
			int[] leftTopButtom_Middle = new int[2];
			for(int i = 0; i<leftTopButtom_Middle.length; i++) 	
				leftTopButtom_Middle[i] = Math.abs((leftTop[i]+leftButtom[i])/2);	
			
			return leftTopButtom_Middle;
			}
		public int[] insertRightTopButtom_MiddleArray(int num,ArrayList<Integer> coordParent) {
			int[] rightTop = insertRightTopArray(coordParent);
			int[] rightButtom = insertRightButtomArray(coordParent);
			int[] rightTopButtom_Middle = new int[2];
			for(int i = 0; i<rightTopButtom_Middle.length; i++)	
				rightTopButtom_Middle[i] = Math.abs((rightTop[i]+rightButtom[i])/2);
			
			return rightTopButtom_Middle;
			}
		
		public int[] insertLeftButtomRightButtom_MiddleArray(ArrayList<Integer> coordParent) {
			int[] leftButtom = insertLeftButtomArray(coordParent);
			int[] rightButtom = insertRightButtomArray(coordParent);
			int[] leftButtomRightButton_Middle = new int[2];
			for(int i = 0; i<leftButtomRightButton_Middle.length; i++)	
				leftButtomRightButton_Middle[i] = Math.abs((leftButtom[i]+rightButtom[i])/2);
			
			return leftButtomRightButton_Middle;
			}
		
		public int[] insertLeftTopRightTop_MiddleArray(ArrayList<Integer> coordParent) {
			int[] leftTop = insertLeftTopArray(coordParent);
			int[] rightTop = insertRightTopArray(coordParent);
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
		public int[] insertLeftTopButtom_MiddleArray(ArrayList<Integer> coordParentCurrent ,ArrayList<Integer> coordParentNext ) {
			int[] leftTop = insertLeftTopArray(coordParentNext);
			int[] leftButtom = insertLeftButtomArray(coordParentNext);			
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
		public int[] insertLeftTopRightTop_MiddleArray(ArrayList<Integer> coordParentCurrent, ArrayList<Integer> coordParentNext) {
			int[] leftTop = insertLeftTopArray(coordParentNext);
			int[] rightTop = insertRightTopArray(coordParentNext);
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
		
		public int[] insertRightTopButtom_MiddleArray(ArrayList<Integer> coordParentCurrent, ArrayList<Integer> coordParentNext) {
			int[] rightTop = insertRightTopArray(coordParentCurrent);
			int[] rightButtom = insertRightButtomArray(coordParentCurrent);
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
		public int[] insertLeftButtomRightButtom_MiddleArray(ArrayList<Integer> coordParentCurrent,  ArrayList<Integer> coordParentNext) {
			int[] leftButtom = insertLeftButtomArray(coordParentCurrent);
			int[] rightButtom = insertRightButtomArray(coordParentCurrent);
			int[] leftButtomRightButton_Middle = new int[2];
			for(int i = 0; i<leftButtomRightButton_Middle.length; i++)	
				leftButtomRightButton_Middle[i] = Math.abs((leftButtom[i]+rightButtom[i])/2);
			
			return leftButtomRightButton_Middle;
			}
		
		
		
		public boolean checkRow(ArrayList<Integer> coordParent, ArrayList<Integer> coordParentGet) {		
			int x1Data = insertRightTopButtom_MiddleArray(coordParent, coordParentGet)[0];
			int x2Data = insertLeftTopButtom_MiddleArray(coordParent, coordParentGet)[0];				
			
			if(Math.abs((x1Data-x2Data))<30)			
				return true;
			else
				return false;
		}
		
		public boolean checkColumn(ArrayList<Integer> coordParent, ArrayList<Integer> coordParentGet) {
		
			int y1Data =	insertLeftButtomRightButtom_MiddleArray(coordParent, coordParentGet)[1];
			int y2Data = insertLeftTopRightTop_MiddleArray(coordParent, coordParentGet)[1];

			if(Math.abs((y1Data-y2Data))<40)
				return true;
			else				
				return false;
		}
		
		
		public void print1() {
			StringBuffer sentence = new StringBuffer();		
			sentence.append(des.get(1));
			for(int i = 2 ; i<7; i++) {
				
				if(checkRow(coordParent.get(i-1), coordParent.get(i))){					
					sentence.append(des.get(i));
					}
				}
			System.out.println(sentence);
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


