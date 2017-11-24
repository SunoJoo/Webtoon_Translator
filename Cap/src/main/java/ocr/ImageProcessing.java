package ocr;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageProcessing {
	final static int MAXHEIGHT = 65536;
	
	Graphics2D[] graphics;
	BufferedImage[] image;
	BufferedImage[] mergedImage;
	String path;
	String[] filesName;
	int maxWidth= 0;
	int maxHeight = 0;
	int heightArray[];
	int size;
	ArrayList<Integer> imageNumber;
	ImageProcessing(String path){
		this.path = path;
	}
	public void start() {	
		getFileName();
		for(int i = 0; i<filesName.length;i++) {
			System.out.println(filesName[i]);
		}
		image = new BufferedImage[filesName.length];
		
		
		
		try {			
			insertBufferedImage();
			int width =0;
			int height = 0;	
			
			for(int i = 0; i<image.length; i++) {
				maxWidth =Math.max(maxWidth, image[i].getWidth());				
				width = maxWidth;
				maxHeight = maxHeight + image[i].getHeight();
				height = maxHeight;
				if(height>MAXHEIGHT) {
					imageNumber.add(i-1);
					size = (height/MAXHEIGHT)+1;	
				}
			}
			
			if(height>MAXHEIGHT) {
							
			
				int heightTemp = MAXHEIGHT;
				
				for(int i = 0; i<size; i++) {
					heightArray[i] = heightTemp;
					heightTemp = height%MAXHEIGHT;
				}				
			}	
			
		/*	for(int i = 0; i<heightArray.length;i++) {
				System.out.println(heightArray[i]);
			}*/
		

			mergedImage = new BufferedImage[size];
			for(int i = 0 ;i<mergedImage.length; i++) {
				mergedImage[i] = new BufferedImage(width, heightArray[i], BufferedImage.TYPE_INT_RGB);
				graphics = new Graphics2D[size];
				graphics[i] = (Graphics2D) mergedImage[i].getGraphics();
				graphics[i].setBackground(Color.WHITE);
				
				
			}
				
		

			for(int i = 0; i<size;i++) {
				for(int j = 0;j<imageNumber.get(j);j++) {
					/*graphics.drawImage(image[j], 0, 0, null);
					graphics.drawImage(image[j+1], 0, image[j].getHeight(), null);*/
				}
		
			}
			
			
			
			
			/*ImageIO.write(mergedImage, "jpg", new File("./src/main/resources/webtoon_img/_mergeimage.jpg"));*/			
			// ImageIO.write(mergedImage, "jpg", new File("c:\\mergedImage.jpg"));
			// ImageIO.write(mergedImage, "png", new File("c:\\mergedImage.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		System.out.println("이미지 합성이 완료되었습니다... 에헤라 디야~~");
	}
	
	public void getFileName() {
		File path = new File(this.path);
		File[] files = path.listFiles();
		filesName = new String[files.length];
		for(int i = 0; i<filesName.length; i++) {
			if(files[i].isFile()) {
				filesName[i] = files[i].getName();			
				}
			}
		}
	
	public void insertBufferedImage() throws IOException {
		for(int i = 0; i<image.length; i++)
			 image[i] = ImageIO.read(new File(path+"/_"+(i+1)+".jpg"));
	}
}