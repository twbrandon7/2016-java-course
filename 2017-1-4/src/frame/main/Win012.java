package frame.main;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import frame.libs.Myfun;

@SuppressWarnings("serial")
public class Win012 extends Frame implements MouseListener{
	
	Button btns[] = new Button[5];
	Button btnChange;
	static Win012 frame;
	Card card[] = new Card[5];
	
	int number[] = new int[5];
	int color[] = new int[5];
	boolean toChange[] = new boolean[5];
	
	public Win012(int x, int y, int w, int h){
		this.setLocation(x, y);
		this.setSize(w, h);
		this.setVisible(true);
		this.setClose();
		this.setLayout(null);
		
		this.initCard();
		for(int i = 0; i < 5; i++){
			card[i] = new Card(number[i], color[i]);
		}
		
		this.initComponent();
	}
	
	public static void main(String[] arg){
		frame = new Win012(100, 100, 800, 600);
	}
	
	void setClose(){
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	void initCard(){
		boolean flag = false;
		for(int i = 0; i < 5; i++){
			do{
				flag = false;
				number[i] = Myfun.random(1, 13);
				color[i] = Myfun.random(1, 4);
				for(int j = 0; j < i; j++){
					if((number[i] == number[j]) && (color[i] == color[j])){
						flag = true;
					}
				}
			}while(flag);
		}
	}
	
	void initComponent(){
		for(int i = 0; i < btns.length; i++){
			btns[i] = new Button();
			btns[i].setLocation(70 + 150*i, 325);
			btns[i].setSize(50, 50);
			this.add(btns[i]);
			btns[i].addMouseListener(this);
		}
		
		btnChange = new Button("´«µP");
		btnChange.setLocation(345, 400);
		btnChange.setSize(100, 50);
		this.add(btnChange);
		btnChange.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g){
		for(int i = 0; i < 5; i++){
			try{
				card[i].show(i*150+30, 100, 0.95f, g, this);
			}catch(Exception e){
				System.out.println(number[i] + " / " + color[i]);
			}
			
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == btnChange){
			for(int i = 0; i < toChange.length; i++){
				int nu = 0, co = 0;
				if(toChange[i]){
					boolean again = false;
					do{
						again = false;
						nu = Myfun.random(1, 13);
						co = Myfun.random(1, 4);
						for(int j = 0;j < card.length; j++){
							if(number[j] == nu && color[j] == co){
								again = true;
							}
						}
					}while(again);
					
					card[i].change(nu, co);
					number[i] = nu;
					color[i] = co;
					this.repaint();
				}
			}
		}
		for(int i = 0; i < btns.length; i++){
			if(obj == btns[i]){
				if(btns[i].getLabel().equals("V")){
					btns[i].setLabel("");
					toChange[i] = false;
				}else{
					btns[i].setLabel("V");
					toChange[i] = true;
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}


}