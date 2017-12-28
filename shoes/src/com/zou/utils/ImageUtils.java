package com.zou.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageUtils {
	private static String code;
	

	public static String getCode() {
		return code;
	}


	public static BufferedImage createImage(int width, int height, int n) {
		// 指定验证码的高度
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获得该图片的画笔
		Graphics g = image.getGraphics();
		// 设置填充色进行填充
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 设置画笔颜色，准备绘制
		g.setColor(Color.BLACK);
		// 从给定的字符中随机生成4个字符
		char[] element = "123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
		String checkcode = "";
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int randomIndex = Math.abs(random.nextInt()) % element.length;
			checkcode = checkcode + element[randomIndex];
		}
		g.drawString(checkcode, 10, 16);
		code=checkcode;
		return image;
	}
	public static BufferedImage createMulImage(int width,int height,int n){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();    					//获取Graphics类的对象
		Graphics2D g2d = (Graphics2D) g;
		Random random = new Random();						//实例化一个Random对象
		Font mFont = new Font("黑体", Font.BOLD, 17);			//通过Font构造字体
		g.setColor(getRandColor(200, 250)); 					//设置颜色
		g.fillRect(0, 0, width, height);    						//绘制验证码背景
		g.setFont(mFont);						//设置字体
		g.setColor(getRandColor(180, 200));		//设置颜色
		// 画随机的线条
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);	//生成起始点x轴的坐标
			int y = random.nextInt(height - 1);	//生成起始点y轴的坐标
			int x1 = random.nextInt(6) + 1;	//生成结束点x轴的坐标
			int y1 = random.nextInt(12) + 1;	//生成结束点y轴的坐标
			BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);
			Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
			g2d.setStroke(bs);
			g2d.draw(line);     //绘制直线
		}
		String sRand = "";
		// 输出随机的验证文字
		String ctmp = "";
		int itmp = 0;
		for (int i = 0; i < n; i++) {
			if((random.nextInt(2)+1)==1){
				itmp = random.nextInt(10) + 48; // 生成0~9的数字
				ctmp = String.valueOf((char) itmp);
			}else{
				itmp = random.nextInt(26) + 65; // 生成A~Z的字母
				ctmp = String.valueOf((char) itmp);
			}
			sRand += ctmp;
			Color color = new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110));
			g.setColor(color);		//设置文字颜色
			/** **随机缩放文字并将文字旋转指定角度* */
			// 将文字旋转指定角度
			Graphics2D g2d_word = (Graphics2D) g;
			AffineTransform trans = new AffineTransform();
			trans.rotate(random.nextInt(45) * 3.14 / 180, 15 * i + 8, 7);
			// 缩放文字
			float scaleSize = random.nextFloat() +0.8f;
			if (scaleSize > 1f)	scaleSize = 1f;
			trans.scale(scaleSize, scaleSize);
			g2d_word.setTransform(trans);
			/** ********************* */
			g.drawString(ctmp, 15 * i + 18, 14);

		}
		
		code=sRand;
		return image;
	}
	// 获取随机颜色
		public static Color getRandColor(int s, int e) {
			Random random = new Random();
			if (s > 255) s = 255;
			if (e > 255) e = 255;
			int r = s + random.nextInt(e - s);		//随机生成RGB颜色中的r值
			int g = s + random.nextInt(e - s);		//随机生成RGB颜色中的g值
			int b = s + random.nextInt(e - s);		//随机生成RGB颜色中的b值
			return new Color(r, g, b);
		}
}
