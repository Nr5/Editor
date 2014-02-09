package mapeditor;

import java.awt.Component;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Itembrowser extends JTree {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	File f = new File("C:/Kram/programmieren/Java/2/mapeditor/resources/editor_path");
	LinkedList<DefaultMutableTreeNode> node = new LinkedList<DefaultMutableTreeNode>();
	Itembrowser() {
	

		//scrollPane.setViewportView(this);
		
		

		node.add(new DefaultMutableTreeNode("Elements"));
		setModel(new DefaultTreeModel(node.get(0))); 			
	
		count(f,1);
		
		
		addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if((((DefaultMutableTreeNode) getSelectionPath().getLastPathComponent()).isLeaf()))
					Cursor.setItem(getSelectionPath().getLastPathComponent().toString());
			}
		});

		
		
		
	
	
	}
void count(File f,int depth){
	node.add(new DefaultMutableTreeNode());
	String s = "";
	for (int d = 0;d<depth;d++)s+="	";
	
	for (int i =0;i<f.list().length;i++) {
		System.out.println(s+i+" "+" "+depth+" "+f.list()[i]);
		node.set(depth,new DefaultMutableTreeNode(f.list()[i].replace(".xml","")   ));
		node.get(depth-1).add(node.get(depth));
		
		if (f.listFiles()[i].isDirectory())count(f.listFiles()[i],depth+1);
	}
}
}
