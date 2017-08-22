package WaterMark;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class imageMark {
	public static void main(String[] args) throws Exception {
		String sourcePath = "f:/5.png";
		String imageWaterPath ="f:/2.png";
		String outPath = "f:/3.png";
		String type = "png";
		imageMarkTest(sourcePath,imageWaterPath,outPath,type);
	}
	/**
	 * 
	 * @param sourcePath  -- 原照片路径
	 * @param imageWaterPath -- 水印照片路径
	 * @param outPath -- 生成水印路径
	 * @param type -- 图片类型
	 * @throws Exception
	 */
	public  static void imageMarkTest(String sourcePath,String imageWaterPath,String outPath,String type) throws Exception {
		BufferedImage sImage = ImageIO.read(new File(sourcePath));
		int width = sImage.getWidth();
		int height = sImage.getHeight();
		BufferedImage imageWater = ImageIO.read(new File(imageWaterPath));
		Graphics2D g = (Graphics2D) sImage.getGraphics();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.2f));
		//g.rotate(Math.toRadians(-30));
		Image ImageWater =imageWater.getScaledInstance(width, height, Image.SCALE_FAST);
		g.drawImage(ImageWater, 0, 0, null);
		ImageIO.write(sImage, type, new File(outPath));
	}
}
