package frame.main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.*;

public class Card {
	int number = 1, color = 1;
	boolean back;
	String cardNames[] = new String[5];
	Image img;
	
	public Card(){
		init();
		number = 1;
		color = 1;
		loadImage();
	}
	
	public Card(int number, int color){
		init();
		this.number = number;
		this.color = color;
		loadImage();
	}
	
	void init(){
		cardNames[1] = "SP";
		cardNames[2] = "HR";
		cardNames[3] = "DM";
		cardNames[4] = "CL";
	}
	
	public void show(int x, int y, int w, int h, Graphics g, Frame f){
		g.drawImage(img, x, y, w, h, f);
	}
	
	public void show(int x, int y, float scale, Graphics g, Frame f){
		g.drawImage(img, x, y, (int)(img.getWidth(f)*scale), (int)(img.getHeight(f)*scale), f);
	}
	
	public void change(int number, int color){
		this.number = number;
		this.color = color;
		loadImage();
	}
	
	private void loadImage(){
		String fileName;
		if(number < 10){
			fileName = "0" + String.valueOf(this.number);
		}else{
			fileName = String.valueOf(this.number);
		}
		fileName = cardNames[color] + fileName + ".jpg";
		
		try{
			img = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/frame/assets/images/" + fileName));
		}catch(Exception e){
			
		}
	}
}
