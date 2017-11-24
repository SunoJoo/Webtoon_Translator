<<<<<<< HEAD
package ocr;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;

/*
 * �ٽ� ������ ��ǥ�� ��Ȯ���� ����!!!
 */

public class InputText {
	
	ResultData resultData;
	String[] st;
	int[][] arr;
	
	public InputText(ResultData rd){
		this.resultData = rd;
		convertTextData();
		convertPositionData();
	}
	
	public void convertTextData() {
		st = (String[]) resultData.getText().toArray(new String[resultData.getText().size()]);
		
	}
	
	public void convertPositionData() {
		arr = new int[resultData.getPosition().size()][resultData.getPosition().get(0).size()];
		for(int i = 0 ; i<resultData.getPosition().size(); i++) {
			for(int j = 0; j<resultData.getPosition().get(i).size();j++) {
				arr[i][j] = resultData.getPosition().get(i).get(j);
			}
		}		
	}
	
	public void start() {
		int firsttextX;
		int firsttextY;
		int firstX;
		int firstY;
		int width;
		int height;
		
		
		
		/*
		 *ArrayList�� �� �������� �����ϸ� �� 
		 */
		
		//������ ���� ����(ArrayList�̶�� �����ϰ� ����)
		/*String[] st = {
				//9
				"I do not think so.",
				"I think I have something on my neck.",
				"Hook Endoscope ...?",
				"I can not really do that because I'm not good at it.",
				"A neck endoscope is a way of seeing a doctor holding a tongue and lighting his throat"
				
				//3
				"I swallowed it, but it's gone.",
				"It's a weekend, so I'm planning a hospital.",
				"I think he's gotten very tight.",
				"You seem to be crazy too.",
				"The spiny fairy will solve it while you sleep!"
				
				
				//8
				"Something is getting bigger and bigger.",
				"I can not see it. I'll take an x-ray.",
				"Would you like to change clothes to your patient's clothes?",
				"I started discussing the x-ray picture within three minutes of my young doctor.",
				"I think this is poetry.",
				"Ah, a little ambiguous."
				
				
				//13
				"I got some money, but it's okay! I've confirmed that there is no thorn!",
				"So you do not feel anymore?",
				"Not as it is",
				"And the next day was as it was.",
				"Help me."
				
		};*/
		
		//��ǥ(��Ȯ���� ���� ��ǥ�� ������ �ʿ��ϴ�)ArrayList��� ������
		/*int[][] arr = {
				//9
				{271, 246, 570, 246, 570, 275, 271, 275},
				{52, 621, 438, 621, 438, 686, 52, 686},
				{443, 731, 635, 731, 635, 760, 443, 760},
				{315, 1181, 636, 1181, 636, 1244, 315, 1244},
				{72, 1473, 638, 1473, 638, 1542, 72, 1542}
				
				//3
				{68, 262, 426, 262, 426, 327, 68, 327},
				{523, 375, 664, 377, 664, 476, 524, 479},
				{434, 855, 667, 855, 667, 883, 434, 883},
				{140, 989, 404, 989, 404, 1018, 140, 1018},
				{292, 1229, 567, 1229, 567, 1294, 292, 1294}
				
				
				//8
				{213, 107, 553, 107, 553, 135, 213, 135},
				{29, 193, 326, 193, 326, 258, 29, 258},
				{88, 625, 499, 625, 499, 780, 91, 785},
				{53, 1118, 634, 1118, 634, 1181, 53, 1181},
				{50, 1277, 227, 1276, 227, 1305, 50, 1306},
				{446, 1444, 634, 1444, 634, 1472, 446, 1472}
				
				
				//13
				{68, 233, 493, 233, 493, 297, 68, 297},
				{35, 381, 315, 381, 315, 446, 35, 446},
				{485, 869, 642, 869, 642, 897, 485, 897},
				{136, 1146, 654, 1146, 654, 1175, 136, 1175},
				{142, 1237, 600, 1237, 600, 1317, 142, 1318}
				
		};*/

		int x1 = 10;
		/*int x2 = 40;*/
		/*int x2 = (arr[0][2]-arr[0][0])/15;*/
		//System.out.println(x2);
		
		
		// 1����ǥ�� x��� 3�� ������ x���� �������� ��ǳ���� String�迭�� ������!
		for (int i = 0; i < arr.length; i++) {
			int x2 = (arr[i][2]-arr[i][0])/7;
			System.out.println(x2);
			
			firsttextX = arr[i][0];
			firsttextY = arr[i][1] + 10;
			
			firstX = arr[i][0] - 10;
			firstY = arr[i][1];
			width = arr[i][2] - arr[i][0] + 10;
			height = arr[i][5] - arr[i][3] + 10;
			
			TextTogether tt = new TextTogether(x1, x2, st[i]);
			hj hj = new hj(tt);
			hj.go(arr,firsttextX,firsttextY,firstX,firstY,width,height);
		}
	}
}

class hj {
	TextTogether tot;

	hj(TextTogether tot) {
		this.tot = tot;
	}

	public void go(int[][] arr,int firsttextX,int firsttextY,int firstX,int firstY,int width,int height) {
		
		Date date = new Date();
		File loadImage = new File("C:/Users/kingt/git/Webtoon_Translator/Cap/src/main/resources/webtoon_img/_13.jpg");
		File makeImage = new File("C:/Users/kingt/git/Webtoon_Translator/Cap/src/main/resources/webtoon_img/_13.jpg");
		//���� �����̸��� �޸� �ؼ� ���� �����ϰ� ������ �����ϸ� 
		//�����̱������ �Ϸ��� ������ �� �ȵǼ� �ϴ� �̸��� ���� �ؼ� �����̴� ������� ����
		//���� �˸� makeImage�κ��� �����ϱ� �ٶ�
		
		BufferedImage bi = null;
		
		/*for (int i = 0; i < arr.length; i++) {
			System.out.println("�迭 "+i+"��° "+arr[i]);
		}*/ //�׽�Ʈ
		
		try {
			bi = ImageIO.read(loadImage);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Graphics2D g1 = null;
		Graphics2D g2 = null;

		g1 = bi.createGraphics();
		g2 = bi.createGraphics();

		// text�� ������ ��Ʈ ����, �Ʒ� ��Ʈ�� �ý��ۿ� ��ġ �Ǿ� �־�� ����� �� ����
		Font font = new Font("Gungsuh", Font.BOLD, 20);

		// ��Ʈ ���� ����
		g1.setColor(Color.white); // ���
		g2.setColor(Color.DARK_GRAY); // ����

		// ��Ʈ ���� ����
		g2.setFont(font);

		/*for (int i = 0; i < 5; i++) {*/
			/*firsttextX = arr[i][0] + 20;
			firsttextY = arr[i][1];
			firstX = arr[i][0] - 20;
			firstY = arr[i][1];
			width = arr[i][2] - arr[i][0] + 10;
			height = arr[i][5] - arr[i][3] + 10;*/
			
			g1.fillRect(firstX, firstY, width, height);
			
			tot.setOut();
			
			for (int j = 0; j < tot.getText().length; j++) {
				if(tot.getText()[j] == null){
					break;
				}
				g2.drawString(tot.getText()[j], firsttextX, firsttextY + 10 +(25*j));
			}
		/*}*/
		
		//g1.fillRect(162, 727, 160, 70); // �������� ���� ����
		
		// g2.drawString(text1, 162, 727+5); // ���ڸ� �Ŀ� ����

		/*tot.setOut();*/
		
		/*for (int i = 0; i < tot.getText().length; i++) {
			if(tot.getText()[i] == null){
				break;
			}
			System.out.println(tot.getText()[i]);
		}*/
		
		/*for (int i = 0; i < tot.getText().length; i++) {
			if(tot.getText()[i] == null){
				break;
			}
			g2.drawString(tot.getText()[i], firsttextX, firsttextY + 10 +(25*i));
		}*/

		g1.dispose();
		g2.dispose();

		try {
			ImageIO.write(bi, "jpg", makeImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class TextTogether {
	int x1;
	int x2;
	String st;
	int alpa = 1;
	String[] result;

	TextTogether(int x1, int x2, String st) {
		this.x1 = x1;
		this.x2 = x2;
		this.st = st;
	}

	public int pointCalr() {
		int hap = 0;
		hap = (x2 - x1) * alpa;
		return hap;
	}
	public String[] getText() {
		return result;
	}

	public void setOut() {
		int totalLeng = pointCalr();
		result = new String[20];
		int resultCount;
		String stEX;
		int count;
		int j;
		String stArr[] = st.split(" ");
		System.out.println(st);
		stEX = "";
		count = 0;
		j = 0;
		resultCount = 0;

		for (;;) {

			if (j > stArr.length - 1)
				break;

			if (j == stArr.length - 1) {
				count = count + stArr[j].length();
			} else {
				count = count + stArr[j].length() + 1;
			}
			
			//System.out.println("j : " + j);
			//System.out.println("count: " + count);
			//System.out.println("stEX : " + stEX);

			if (count > totalLeng) {
				result[resultCount] = stEX;
				//System.out.println("�߰� : " + stEX);
				stEX = "";
				count = 0;
				resultCount++;
				//System.out.println("reset");

			} else if (count == totalLeng) {
				if (j == stArr.length - 1) {
					stEX = stEX + stArr[j];
				} else {
					stEX = stEX + stArr[j] + " ";
				}
				//System.out.println("�߰� : " + stEX);
				result[resultCount] = stEX;
				stEX = "";
				count = 0;
				resultCount++;
				j++;
				//System.out.println("reset");
			} else if (count < totalLeng) {
				if (j == stArr.length - 1) {
					stEX = stEX + stArr[j];
					result[resultCount] = stEX;
				} else {
					stEX = stEX + stArr[j] + " ";
				}
				j++;
			}
			//System.out.println("---------");
		}

		
		/*
		for (int j1 = 0; j1 < result.length; j1++) {
			result[j1] = "";
		}
		 */
	}

}
=======
package ocr;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;

/*
 * �ٽ� ������ ��ǥ�� ��Ȯ���� ����!!!
 */

public class InputText {
	
	ResultData resultData;
	String[] st;
	int[][] arr;
	
	public InputText(ResultData rd){
		this.resultData = rd;
		convertTextData();
		convertPositionData();
	}
	
	public void convertTextData() {
		st = (String[]) resultData.getText().toArray(new String[resultData.getText().size()]);
		
	}
	
	public void convertPositionData() {
		arr = new int[resultData.getPosition().size()][resultData.getPosition().get(0).size()];
		for(int i = 0 ; i<resultData.getPosition().size(); i++) {
			for(int j = 0; j<resultData.getPosition().get(i).size();j++) {
				arr[i][j] = resultData.getPosition().get(i).get(j);
			}
		}		
	}
	
	public void start() {
		int firsttextX;
		int firsttextY;
		int firstX;
		int firstY;
		int width;
		int height;
		
		
		
		/*
		 *ArrayList�� �� �������� �����ϸ� �� 
		 */
		
		//������ ���� ����(ArrayList�̶�� �����ϰ� ����)
		/*String[] st = {
				//9
				"I do not think so.",
				"I think I have something on my neck.",
				"Hook Endoscope ...?",
				"I can not really do that because I'm not good at it.",
				"A neck endoscope is a way of seeing a doctor holding a tongue and lighting his throat"
				
				//3
				"I swallowed it, but it's gone.",
				"It's a weekend, so I'm planning a hospital.",
				"I think he's gotten very tight.",
				"You seem to be crazy too.",
				"The spiny fairy will solve it while you sleep!"
				
				
				//8
				"Something is getting bigger and bigger.",
				"I can not see it. I'll take an x-ray.",
				"Would you like to change clothes to your patient's clothes?",
				"I started discussing the x-ray picture within three minutes of my young doctor.",
				"I think this is poetry.",
				"Ah, a little ambiguous."
				
				
				//13
				"I got some money, but it's okay! I've confirmed that there is no thorn!",
				"So you do not feel anymore?",
				"Not as it is",
				"And the next day was as it was.",
				"Help me."
				
		};*/
		
		//��ǥ(��Ȯ���� ���� ��ǥ�� ������ �ʿ��ϴ�)ArrayList��� ������
		/*int[][] arr = {
				//9
				{271, 246, 570, 246, 570, 275, 271, 275},
				{52, 621, 438, 621, 438, 686, 52, 686},
				{443, 731, 635, 731, 635, 760, 443, 760},
				{315, 1181, 636, 1181, 636, 1244, 315, 1244},
				{72, 1473, 638, 1473, 638, 1542, 72, 1542}
				
				//3
				{68, 262, 426, 262, 426, 327, 68, 327},
				{523, 375, 664, 377, 664, 476, 524, 479},
				{434, 855, 667, 855, 667, 883, 434, 883},
				{140, 989, 404, 989, 404, 1018, 140, 1018},
				{292, 1229, 567, 1229, 567, 1294, 292, 1294}
				
				
				//8
				{213, 107, 553, 107, 553, 135, 213, 135},
				{29, 193, 326, 193, 326, 258, 29, 258},
				{88, 625, 499, 625, 499, 780, 91, 785},
				{53, 1118, 634, 1118, 634, 1181, 53, 1181},
				{50, 1277, 227, 1276, 227, 1305, 50, 1306},
				{446, 1444, 634, 1444, 634, 1472, 446, 1472}
				
				
				//13
				{68, 233, 493, 233, 493, 297, 68, 297},
				{35, 381, 315, 381, 315, 446, 35, 446},
				{485, 869, 642, 869, 642, 897, 485, 897},
				{136, 1146, 654, 1146, 654, 1175, 136, 1175},
				{142, 1237, 600, 1237, 600, 1317, 142, 1318}
				
		};*/

		int x1 = 10;
		/*int x2 = 40;*/
		/*int x2 = (arr[0][2]-arr[0][0])/15;*/
		//System.out.println(x2);
		
		
		// 1����ǥ�� x��� 3�� ������ x���� �������� ��ǳ���� String�迭�� ������!
		for (int i = 0; i < arr.length; i++) {
			int x2 = (arr[i][2]-arr[i][0])/7;
			System.out.println(x2);
			
			firsttextX = arr[i][0];
			firsttextY = arr[i][1] + 10;
			
			firstX = arr[i][0] - 10;
			firstY = arr[i][1];
			width = arr[i][2] - arr[i][0] + 10;
			height = arr[i][5] - arr[i][3] + 10;
			
			TextTogether tt = new TextTogether(x1, x2, st[i]);
			hj hj = new hj(tt);
			hj.go(arr,firsttextX,firsttextY,firstX,firstY,width,height);
		}
	}
}

class hj {
	TextTogether tot;

	hj(TextTogether tot) {
		this.tot = tot;
	}

	public void go(int[][] arr,int firsttextX,int firsttextY,int firstX,int firstY,int width,int height) {
		
		Date date = new Date();
		File loadImage = new File("C:/Users/kingt/git/Webtoon_Translator/Cap/src/main/resources/webtoon_img/_13.jpg");
		File makeImage = new File("C:/Users/kingt/git/Webtoon_Translator/Cap/src/main/resources/webtoon_img/_13.jpg");
		//���� �����̸��� �޸� �ؼ� ���� �����ϰ� ������ �����ϸ� 
		//�����̱������ �Ϸ��� ������ �� �ȵǼ� �ϴ� �̸��� ���� �ؼ� �����̴� ������� ����
		//���� �˸� makeImage�κ��� �����ϱ� �ٶ�
		
		BufferedImage bi = null;
		
		/*for (int i = 0; i < arr.length; i++) {
			System.out.println("�迭 "+i+"��° "+arr[i]);
		}*/ //�׽�Ʈ
		
		try {
			bi = ImageIO.read(loadImage);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Graphics2D g1 = null;
		Graphics2D g2 = null;

		g1 = bi.createGraphics();
		g2 = bi.createGraphics();

		// text�� ������ ��Ʈ ����, �Ʒ� ��Ʈ�� �ý��ۿ� ��ġ �Ǿ� �־�� ����� �� ����
		Font font = new Font("Gungsuh", Font.BOLD, 20);

		// ��Ʈ ���� ����
		g1.setColor(Color.white); // ���
		g2.setColor(Color.DARK_GRAY); // ����

		// ��Ʈ ���� ����
		g2.setFont(font);

		/*for (int i = 0; i < 5; i++) {*/
			/*firsttextX = arr[i][0] + 20;
			firsttextY = arr[i][1];
			firstX = arr[i][0] - 20;
			firstY = arr[i][1];
			width = arr[i][2] - arr[i][0] + 10;
			height = arr[i][5] - arr[i][3] + 10;*/
			
			g1.fillRect(firstX, firstY, width, height);
			
			tot.setOut();
			
			for (int j = 0; j < tot.getText().length; j++) {
				if(tot.getText()[j] == null){
					break;
				}
				g2.drawString(tot.getText()[j], firsttextX, firsttextY + 10 +(25*j));
			}
		/*}*/
		
		//g1.fillRect(162, 727, 160, 70); // �������� ���� ����
		
		// g2.drawString(text1, 162, 727+5); // ���ڸ� �Ŀ� ����

		/*tot.setOut();*/
		
		/*for (int i = 0; i < tot.getText().length; i++) {
			if(tot.getText()[i] == null){
				break;
			}
			System.out.println(tot.getText()[i]);
		}*/
		
		/*for (int i = 0; i < tot.getText().length; i++) {
			if(tot.getText()[i] == null){
				break;
			}
			g2.drawString(tot.getText()[i], firsttextX, firsttextY + 10 +(25*i));
		}*/

		g1.dispose();
		g2.dispose();

		try {
			ImageIO.write(bi, "jpg", makeImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class TextTogether {
	int x1;
	int x2;
	String st;
	int alpa = 1;
	String[] result;

	TextTogether(int x1, int x2, String st) {
		this.x1 = x1;
		this.x2 = x2;
		this.st = st;
	}

	public int pointCalr() {
		int hap = 0;
		hap = (x2 - x1) * alpa;
		return hap;
	}
	public String[] getText() {
		return result;
	}

	public void setOut() {
		int totalLeng = pointCalr();
		result = new String[20];
		int resultCount;
		String stEX;
		int count;
		int j;
		String stArr[] = st.split(" ");
		System.out.println(st);
		stEX = "";
		count = 0;
		j = 0;
		resultCount = 0;

		for (;;) {

			if (j > stArr.length - 1)
				break;

			if (j == stArr.length - 1) {
				count = count + stArr[j].length();
			} else {
				count = count + stArr[j].length() + 1;
			}
			
			//System.out.println("j : " + j);
			//System.out.println("count: " + count);
			//System.out.println("stEX : " + stEX);

			if (count > totalLeng) {
				result[resultCount] = stEX;
				//System.out.println("�߰� : " + stEX);
				stEX = "";
				count = 0;
				resultCount++;
				//System.out.println("reset");

			} else if (count == totalLeng) {
				if (j == stArr.length - 1) {
					stEX = stEX + stArr[j];
				} else {
					stEX = stEX + stArr[j] + " ";
				}
				//System.out.println("�߰� : " + stEX);
				result[resultCount] = stEX;
				stEX = "";
				count = 0;
				resultCount++;
				j++;
				//System.out.println("reset");
			} else if (count < totalLeng) {
				if (j == stArr.length - 1) {
					stEX = stEX + stArr[j];
					result[resultCount] = stEX;
				} else {
					stEX = stEX + stArr[j] + " ";
				}
				j++;
			}
			//System.out.println("---------");
		}

		
		/*
		for (int j1 = 0; j1 < result.length; j1++) {
			result[j1] = "";
		}
		 */
	}

}
>>>>>>> parent of 4507a42... rollback
