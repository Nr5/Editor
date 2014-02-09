package mapeditor;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MapPanel extends JPanel{
	private static final long serialVersionUID = 1L;
private Map map;
private BufferedImage img[] = new BufferedImage[2];
private Point mappos = new Point(0,0); 
private Graphics2D g2d[] = new Graphics2D[2];
private ScrollPane screen;
public Point mousepos = new Point(0,0);
MouseInputListener m = new MouseInputListener() {
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {	}
	@Override
	public void mouseExited(MouseEvent arg0) {map.refresh();}
	@Override
	public void mousePressed(MouseEvent e) {
		mousepos.x =  e.getX();
		mousepos.y =  e.getY();
		
		
		draw(new Point(e.getX(),e.getY()));
		//Frame.minimap.setImage(img);
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {map.refresh();}
	@Override
	public void mouseDragged(MouseEvent e) {
		mousepos.x =  e.getX();
		mousepos.y =  e.getY();
		
		draw(new Point(e.getX(),e.getY()));
		//Frame.minimap.setImage(img);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	mousepos.x =  e.getX();
	mousepos.y =  e.getY();
	repaint();
	}

};
	MapPanel(Map map){
	requestFocus();
	setBackground(Color.BLACK);
	this.map=map;
	this.map.setPanel(this);
	setPreferredSize(new Dimension(img[0].getWidth(),img[0].getHeight()));
	
	g2d[0] = img[0].createGraphics();
	g2d[1] = img[1].createGraphics();
    
	addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {mappos.x+=10;}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {mappos.x-=10;}
		if(e.getKeyCode() == KeyEvent.VK_UP) {mappos.y+=10;}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {mappos.y-=10;}
		
		if (mappos.x>0)mappos.x=0;
		if (mappos.y>0)mappos.y=0;
		if (mappos.x<screen.getSize().width-img[0].getWidth())  mappos.x=screen.getSize().width-img[0].getWidth();
		if (mappos.y<screen.getSize().height-img[0].getHeight()) mappos.y=screen.getSize().height-img[0].getHeight();
		
		if(img[0].getWidth()<800){
			mappos.x = (screen.getSize().width-img[0].getWidth())/2;
			mappos.y = (screen.getSize().height-img[0].getHeight())/2;
		}
		
		
		repaint();
		}
	});
	
	
	addMouseListener(m);
	addMouseMotionListener(m);
	
	}
	
	public void paint(Graphics g){
	     super.paint(g);
	     ((Graphics2D) g).setStroke(new BasicStroke(2));
	
	     
	Point p = new Point (convert.px(convert.map(new Point(mousepos.x-map.height*20-20,mousepos.y))).x +map.height*20-20, convert.px(convert.map(new Point(mousepos.x-map.height*20-20,mousepos.y))).y);
	 	    
	g.drawImage(img[0],0,0, null);     
		g.setColor(Color.lightGray);
		
		g.drawLine(p.x+20,p.y   , p.x+40,p.y+15);
		g.drawLine(p.x+20,p.y   , p.x   ,p.y+15);
		g.drawLine(p.x+20,p.y-60   , p.x+20,p.y);
		
	g.drawImage(img[1],0,0, null);     
		g.setColor(Color.white);
	
		g.drawLine(p.x+20,p.y+30, p.x+40,p.y+15);
		g.drawLine(p.x+20,p.y+30, p.x   ,p.y+15);
	
		g.drawLine(p.x+20,p.y-60   , p.x+40,p.y+15-60);
		g.drawLine(p.x+20,p.y+30-60, p.x+40,p.y+15-60);
		g.drawLine(p.x+20,p.y+30-60, p.x   ,p.y+15-60);
		g.drawLine(p.x+20,p.y-60   , p.x   ,p.y+15-60);
	
		g.drawLine(p.x+20,p.y+30-60, p.x+20,p.y+30);
		g.drawLine(p.x+40,p.y+15, 	 p.x+40,p.y+15-60);
		g.drawLine(p.x   ,p.y+15, 	 p.x   ,p.y+15-60);
	
	
	
	Frame.minimap.update(mappos);
	}	

	
	
	public void setImage(BufferedImage[] img2){
	this.img=img2;
	mappos.x = 0;//(800-img.getWidth())/2;
	mappos.y = 0;//(600-img.getHeight())/2;
	repaint();
	//Frame.minimap.setImage(img2);
	
	}



	private void draw(Point p) {
		p = convert.map(new Point(p.x-map.height*20-20,p.y));
		for (int i= -Cursor.size/2;i<=Cursor.size;i++)	
			for (int j= -Cursor.size/2;j<=Cursor.size;j++)	
			if(p.x+i < map.width && p.x+i >= 0 && p.y+j < map.height && p.y+j >= 0){
				map.field[Cursor.ebene][new Point(p.x+i,p.y+j).x][new Point(p.x+i,p.y+j).y]=Cursor.item[Cursor.ebene];
				if(Cursor.tile[Cursor.ebene]!= null) g2d[Cursor.ebene].drawImage(Cursor.tile[Cursor.ebene],convert.px(new Point(p.x+i,p.y+j)).x+map.height*20-Cursor.tile[Cursor.ebene].getWidth()/2, convert.px(new Point(p.x+i,p.y+j)).y -Cursor.tile[Cursor.ebene].getHeight()+30, null);
				else{g2d[0].drawImage(Cursor.getTile(map.field[0][p.x][p.y]),convert.px(new Point(p.x+i,p.y+j)).x+map.height*20-Cursor.tile[0].getWidth()/2, convert.px(new Point(p.x+i,p.y+j)).y -Cursor.tile[0].getHeight()+30, null);}
				
			}
		repaint();
		
	}

	public void setScreen(ScrollPane scrollPane) {
	screen=scrollPane;	
	}

}
