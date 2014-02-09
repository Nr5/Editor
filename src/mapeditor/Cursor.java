package mapeditor;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cursor {
private static BufferedImage gr;
private static BufferedImage sa;
private static BufferedImage X_wa;
private static BufferedImage be;
private static BufferedImage ka;
private static BufferedImage pla;
private static BufferedImage tree;
private static BufferedImage X_Lat;
private static BufferedImage wall;
private static BufferedImage car;
private static BufferedImage roof;
private static BufferedImage door_SE;
private static BufferedImage door_SW;

private static BufferedImage tiled;

public static int ebene = 0;
public static BufferedImage tile[] = new BufferedImage[2];
public static String mode = "brush";
public static String item[] = new String[2];
public static int size = 0;

Cursor(){
	try {
		gr    = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/gr.png"));
		sa    = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/sa.png"));
		X_wa  = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/X_wa.png"));
		be    = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/be.png"));
		ka    = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/ka.png"));
		pla   = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/pla.png"));
		tiled   = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/tiled.png"));
		
		tree   = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/tree.png"));
		X_Lat  = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/X_Lat.png"));
		wall   = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/X_ma.png"));
		car   = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/car.png"));
		roof   = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/roof.png"));
		door_SE   = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/door_SE.png"));
		door_SW   = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/door_SW.png"));
			
		} catch (IOException e) {System.out.println("missing tiles!!!");}
}



static void setMode(String m){
	mode = m;
}
static void setItem(String i){
	if(i.equals("grass"))    {tile[0] = gr;    ebene = 0;}
	if(i.equals("sand") )     {tile[0] = sa;    ebene = 0;}
	if(i.equals("water"))    {tile[0] = X_wa;  ebene = 0;}
	if(i.equals("sidewalk"))  {tile[0] = pla;   ebene = 0;}
	if(i.equals("concrete")) {tile[0] = be;    ebene = 0;}
	if(i.equals("tiled"))    {tile[0] = tiled; ebene = 0;}
	
	if(i.equals("tree") )    {tile[1] = tree;  ebene = 1;}
	if(i.equals("streetlight"))   {tile[1] = X_Lat; ebene = 1;}
	if(i.equals("wall") )    {tile[1] = wall;  ebene = 1;}
	if(i.equals("car") )     {tile[1] = car;  ebene = 1;}
	if(i.equals("roof") )    {tile[1] = roof;  ebene = 1;}
	if(i.equals("door") )    {tile[1] = door_SW;  ebene = 1;}
	
	item[ebene] = i;
	
	if(i=="erase")	  {tile[1] = null;  ebene = 1; item[1] = null;}
	
	System.out.println(i);
	
}




static void addToSize(int s){
	size += s;
}
static BufferedImage getTile(String i){
	if(i.equals("grass"))     return gr;
	if(i.equals("sand"))      return sa;
	if(i.equals("water"))     return X_wa;
	if(i.equals("sidewalk"))  return pla;
	if(i.equals("concrete"))  return be;
	if(i.equals("tiled"))     return tiled;
	
	if(i.equals("tree"))          return tree;
	if(i.equals("streetlight"))   return X_Lat;
	if(i.equals("wall"))     	  return wall;
	if(i.equals("car"))           return car;
	if(i.equals("roof"))          return roof;
	if(i.equals("door"))          return door_SW;

	return null;
}



static void action(){
	if (mode=="brush");
		
	
}






}
