package mapeditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JScrollPane;

public class ScrollPane extends JScrollPane {
	MapPanel panel;
	ScrollPane(Map m){
		Frame.minimap.setScreen(this);
		setBackground(Color.GRAY);
		MapPanel panel = new MapPanel(m);
		
		panel.setScreen(this);
		
		setViewportView(panel);
		
	}
}
