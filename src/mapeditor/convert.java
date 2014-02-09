package mapeditor;

import java.awt.Point;

public class convert {
	public static double field_width = Math.hypot(15,15); 
	
	public static Point px(Point k){

	return (new Point( (k.x)*20 - (k.y)*20,(k.y)*15 + (k.x)*15 ));
	
	}
	

	
	public static Point map(Point k){
				
				int x = k.x;
			    int y = k.y;
			    
			    k.x =  (int) (((x*.75* Math.cos(36.9) - (y)* Math.sin(36.9))/field_width));
				k.y =  (int) (((x*.75* Math.sin(36.9) + (y)* Math.cos(36.9))/field_width));

		return (k);

	
	}

	
	
}
