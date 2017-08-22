package QRCode;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * 
 * @author Administrator
 *
 */
public class testCode {
	/**
	 * 
	 * @param width --宽
	 * @param height --高
	 * @param codePath --生成二维码路径
	 * @param contents --内容
	 * @param type -- 图片类型
	 * @param imgPath -- 生成带图片二维码所需图片路径
	 * @param outputPath -- 生成带图片二维码的路径
	 * @param kind  --是否生成中间带图片的二维码
	 * @param imgWidth -- 中间图片宽度
	 * @param imgHeight -- 中间图片高度
	 * @throws Exception
	 * @author Administrator
	 * @param  
	 * @time 2017/8/15
	 */
	public static void main(String[] args) throws Exception {
		
		String contents = "http://www.baidu.com";
		String codePath = "E:/2.png";
		String type = "png";
		String imgPath = "f:/5.png";
		String outputPath = "f:/9.png";
		String kind = "1";
		int width = 200;
		int height = 200;
		int imgWidth = 50;
		int imgHeight = 50;
		Map<String, Object> conditionMap = new HashMap<>();
		conditionMap.put("contents", contents);
		conditionMap.put("codePath",codePath);
		conditionMap.put("width",width);
		conditionMap.put("height",height);
		conditionMap.put("type",type);
		conditionMap.put("imgPath",imgPath);
		conditionMap.put("imgWidth",imgWidth);
		conditionMap.put("imgHeight",imgHeight);
		conditionMap.put("outputPath",outputPath);
		conditionMap.put("kind",kind);
		try {
			ORCode(conditionMap);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	public static void ORCode(Map<String, Object> conditionMap) throws Exception {
		try {
			MultiFormatWriter  writer = new MultiFormatWriter();
			HashMap<EncodeHintType, Object> hints = new HashMap<>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//UTF-8
			String contents = (String) conditionMap.get("contents");
			String imgPath = (String) conditionMap.get("imgPath");
			String outputPath = (String) conditionMap.get("outputPath");
			String type = (String) conditionMap.get("type");//(JPG,png)
			String codePath = (String) conditionMap.get("codePath");
			String kind = (String)conditionMap.get("kind");
			int width = (int)conditionMap.get("width");
			int height = (int)conditionMap.get("height");
			int imgWidth = (int)conditionMap.get("imgWidth");
			int imgHeight = (int)conditionMap.get("imgHeight");
			BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			Map<String, Object> nextMap = new HashMap<>();
			nextMap.put("width",width );
			nextMap.put("height", height);
			nextMap.put("bitMatrix",bitMatrix );
			nextMap.put("imgPath",imgPath );
			nextMap.put("imgWidth",imgWidth );
			nextMap.put("imgHeight",imgHeight );
			nextMap.put("outputPath",outputPath );
			if(kind !=""){
				ORCodeAndImage(nextMap);	
			}else{
				MatrixToImageWriter.writeToPath(bitMatrix,type,new File(codePath).toPath());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public static void  ORCodeAndImage(Map<String, Object> nextMap) throws IOException {
		try {
		String imgPath = (String)nextMap.get("imgPath");
		String outputPath = (String)nextMap.get("outputPath");
		int width = (int)nextMap.get("width");
		int height = (int)nextMap.get("height");
		int imgWidth = (int)nextMap.get("imgWidth");
		int imgHeight = (int)nextMap.get("imgHeight");
		BitMatrix bitMatrix = (BitMatrix)nextMap.get("bitMatrix");
		BufferedImage logImage = ImageIO.read(new File(imgPath));	
		Image logoUse = logImage.getScaledInstance(imgWidth, imgHeight, Image.SCALE_FAST);
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (bitMatrix.get(i, j)) {
					img.setRGB(i, j, 0x000000);
				}else {
					img.setRGB(i, j, 0xffffff);
				}
			}
		}
		Graphics g = img.getGraphics();
		int logoX  = (width-imgWidth)/2;
		int logoY = (height - imgHeight)/2;
		g.drawImage(logoUse,logoX,logoY,null);
		ImageIO.write(img, "png", new File(outputPath));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
