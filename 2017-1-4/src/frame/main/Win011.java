package frame.main;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Win011 extends Frame implements MouseListener{
	static Win011 frame;
	Card card;
	Button btn;
	
	public Win011(int x, int y, int w, int h){
		this.setLocation(x, y);
		this.setSize(w, h);
		this.setVisible(true);
		this.setClose();
		this.setLayout(null);
		
		card = new Card(13, 2);
		btn = new Button("Change");
		btn.setLocation(50, 50);
		btn.setSize(100, 50);
		this.add(btn);
		btn.addMouseListener(this);
		
	}
	
	public static void main(String[] arg){
		frame = new Win011(100, 100, 700, 800);
	}
	
	void setClose(){
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g){
		card.show(100, 100, 250, 300, g, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if(source == btn){
			card.change(2, 3);
			this.repaint();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}
}
