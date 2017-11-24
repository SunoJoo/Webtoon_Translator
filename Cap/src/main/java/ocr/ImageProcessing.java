package ocr;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProcessing {
	BufferedImage[] image;
	String path;
	String[] filesName;
	int maxWidth= 0;
	int maxHeight = 0;
	ImageProcessing(String path){
		this.path = path;
	}
	public void start(String path) {	
		getFileName();
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
			}
			
			System.out.println(width);
			System.out.println(height);

			BufferedImage mergedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = (Graphics2D) mergedImage.getGraphics();

			graphics.setBackground(Color.WHITE);
			graphics.drawImage(image[0], 0, 0, null);
			graphics.drawImage(image[1], 0, image[0].getHeight(), null);
			
			
			ImageIO.write(mergedImage, "jpg", new File("./src/main/resources/webtoon_img/_mergeimage.jpg"));
			
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
			 image[i] = ImageIO.read(new File("./src/main/resources/webtoon_img/"+filesName[i]));
	}
}