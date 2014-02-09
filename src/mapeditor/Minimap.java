package mapeditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Minimap extends JPanel {
	private BufferedImage img1 = new BufferedImage(180, 135,  BufferedImage.TYPE_INT_ARGB); 
	private BufferedImage img2 =img1; 
	private Point mappos = new Point(0,0); 
	double x; 
	double y;
	Point screensize = new Point(800,600);
	private ScrollPane screen;
	Minimap(){
	
		setBounds(828, 75, 180, 135);
	    setBackground(Color.GRAY);

		
	    

	
	    
	    addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
			mappos.x= -135 ;
			mappos.y= -100 ;
			repaint();
			}
		});
	
	}


	public void paint(Graphics g){
	     super.paint(g);

	g.drawImage(img1,0,0, null);     
	g.setColor(Color.white); g.drawRect((int)(135*-mappos.x/img2.getWidth()*1.35),(int)(100*-mappos.y/img2.getHeight()*1.35), (int)(x*1.35), (int)(y*1.35));
	    
	}




	public void setImage(BufferedImage i){
	
	img1.getGraphics().drawImage(i, 0,0, 180, 135, null);
	img2 = i;
	x =135.00001* ((screen.getSize().width +.00001)/(img2.getWidth() +.00001));
	y =100.00001* ((screen.getSize().height+.00001)/(img2.getHeight()+.00001));
	
	repaint();
	
	}


	public void update(Point m){
	mappos = m;	
	repaint();
	}


	public void setScreenSize(Point size) {
		screensize = size;
	}


	public void setScreen(ScrollPane scrollPane) {
	screen = scrollPane;
	
	
	
	}

	
}
