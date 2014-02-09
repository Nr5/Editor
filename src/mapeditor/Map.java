package mapeditor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Map {
public int width;
public int height;
public BufferedImage[] img = new BufferedImage[2];
public String[][][] field;
private MapPanel panel;
private Graphics2D[] g2d = new Graphics2D[2];

public Map(int x,int y) {
	width=x;
	height=y;
	field = new String[2][width][height];
	img[0] = new BufferedImage(width*20+height*20,width*15+height*15, 1);
	img[1] = new BufferedImage(width*20+height*20,width*15+height*15, 2);
	
	g2d[0] = img[0].createGraphics();
	g2d[1] = img[1].createGraphics();
	
	for (int j = 0 ;j<height;j++){
		for (int i = 0 ;i<width;i++){
			field[0][i][j]=Cursor.item[0];
			g2d[0].drawImage(Cursor.tile[0],convert.px(new Point(i,j)).x+height*20-20, convert.px(new Point(i,j)).y, null);
			//g2d.drawImage(Cursor.getImage(),convert.px(convert.map(convert.px(new Point(i,j)))).x+height*20-20, convert.px(convert.map(convert.px(new Point(i,j)))).y, null);
			}
	}
    
}

public void refresh(){
	g2d[0].setColor(Color.BLACK);g2d[0].fillRect(0,0,width*20+height*20,width*15+height*15);
	
	for (int h = 0 ;h<2;h++)
	for (int j = 0 ;j<height;j++){
		for (int i = 0 ;i<width;i++){
			if (field[h][i][j] != null && field[h][i][j] != "")	g2d[h].drawImage(Cursor.getTile(field[h][i][j]),convert.px(new Point(i,j)).x+height*20-Cursor.getTile(field[h][i][j]).getWidth()/2, convert.px(new Point(i,j)).y-Cursor.getTile(field[h][i][j]).getHeight()+30, null);
		}
	}
    
	
	
	panel.setImage(img);
}

















public BufferedImage[] getImage() {return img;}

public void setPanel (MapPanel panel) {
	this.panel=panel;
	panel.setImage(img);
	}


}
