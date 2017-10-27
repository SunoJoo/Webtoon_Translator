package ocr;

import java.util.ArrayList;

public class Coordinator {

	ArrayList<String> des;	
	ArrayList<String> coordChild;
	
	ArrayList<ArrayList<Integer>> coordParent;
	
	
	Coordinator(ArrayList<String> des, ArrayList<String> coord){
		this.des = des;
		this.coordChild = coord;
			
	}
	public void coordinate() {		
		coordParent = new ArrayList<ArrayList<Integer>>();		
		ArrayList<Integer> cLChild = new ArrayList<Integer>();
		
		for(int i = 1; i<=coordChild.size();i++) {	
			String[] tempString= new String[2];
			int[] tempInt= new int[2];
			
			tempString = (coordChild.get(i-1).toString().replaceAll("x: ", "").replaceAll("y: ", "").substring(0, coordChild.get(i-1).length()-7).split("\n"));
			
			for(int j = 0; j<tempString.length; j++)
				tempInt[j] = Integer.parseInt(tempString[j]);
				
			
			for(int j = 0 ; j<tempInt.length;j++) {
				cLChild.add(tempInt[j]);
				}			
			
			if(i%4==0) {				
				coordParent.add(cLChild);
				cLChild = new ArrayList<Integer>();
			}
		}		
	}
	public ArrayList<ArrayList<Integer>> getCoordParent() {
		return coordParent;
	}
	public void setCoordParent(ArrayList<ArrayList<Integer>> coordParent) {
		this.coordParent = coordParent;
	}
	public ArrayList<String> getDes() {
		return des;
	}
	public void setDes(ArrayList<String> des) {
		this.des = des;
	}
}
