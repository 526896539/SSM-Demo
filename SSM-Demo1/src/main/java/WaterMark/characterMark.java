package WaterMark;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class characterMark {

		public static void main(String[] args) throws Exception {
			
			characterMarkTest();
		}
		
		public static void  characterMarkTest() throws IOException {
			BufferedImage sourImage = ImageIO.read(new File("f:/5.png"));
			int w = sourImage.getWidth();
			int h = sourImage.getHeight();
			Graphics2D g = (Graphics2D)sourImage.getGraphics();
			
			String watermark = "版权所有，盗版必究！";
			
			Font font  = new Font("黑体", Font.BOLD, 50);
			g.setFont(font);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
			g.rotate(Math.toRadians(30));
			TextLayout layout = new TextLayout(watermark,font,g.getFontRenderContext());
			Rectangle2D bounds = layout.getBounds();
			int textW = (int)bounds.getWidth();
			int textH = (int)bounds.getHeight();
			
			int intervalX = 80;
			int intervalY = 80; 
			for(int x =-w;x<w;x+=(intervalX+textW)){
				for (int y=-h;y<h;y+=(intervalY+textH)) {
					g.drawString(watermark,x ,y);
				} 
			}
			ImageIO.write(sourImage, "png", new File("f:/2.png"));
		}
}
