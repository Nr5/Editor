package mapeditor;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

import javax.swing.JMenuBar;

import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.Box;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JCheckBoxMenuItem;

public class Frame extends JFrame {
private static final long serialVersionUID = 1L;
public static final Frame frame = new Frame();

public static Minimap minimap;
public static Cursor cursor = new Cursor();
public static final List<ScrollPane> maps =new LinkedList<ScrollPane>();

	private JPanel contentPane;


	public static void main(String[] args) {

	}


	public Frame()  {
		setBackground(Color.GRAY);
	    try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
		} catch (InstantiationException e1) {
		} catch (IllegalAccessException e1) {
		} catch (UnsupportedLookAndFeelException e1) {
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/tiles/X_wa.png")));
		setTitle("Editor");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (int)(getToolkit().getScreenSize ().width*.66), (int)(getToolkit().getScreenSize ().height-400*.66));
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 0, 4, 0));
		setJMenuBar(menuBar);
		JButton btnOpen = new JButton("open");
		
		JButton btnSave = new JButton("save");
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(null);
		contentPane.add(panel,BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		panel.add(tabbedPane);
		
		
		
		JButton btnNewButton_1 = new JButton("New");
		btnNewButton_1.setBounds(10, 11, 60, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map m = New.n(getLocationOnScreen(),getSize());
				if(m!=null)
					{
					Cursor.setItem("grass");
					
					maps.add(new ScrollPane(m));
					
					tabbedPane.addTab("map_"+(maps.size()),maps.get(maps.size()-1));
					
					}
				
				
			
			}
		});
		menuBar.add(btnNewButton_1);
		menuBar.add(btnOpen);
		menuBar.add(btnSave);
										
										JPanel panel_1 = new JPanel();
										panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
										contentPane.add(panel_1,BorderLayout.EAST);
										panel_1.setPreferredSize(new Dimension(200,620));
										panel_1.setLayout(new BorderLayout(0, 0));
										
										JScrollPane scrollPane = new JScrollPane();
										panel_1.add(scrollPane);
										
										final Itembrowser tree = new Itembrowser();
										scrollPane.setViewportView(tree);
										tree.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

												
												JPanel panel_3 = new JPanel();
												panel_3.setPreferredSize(new Dimension(200,230));
												panel_1.add(panel_3, BorderLayout.NORTH);
												panel_3.setLayout(null);
												
												minimap = new Minimap();
																		minimap.setBounds(10, 11, 180, 135);
												panel_3.add(minimap);
												minimap.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
												minimap.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
												
												JPanel panel_2 = new JPanel();
												panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
												panel_2.setBounds(10, 168, 180, 49);
												panel_3.add(panel_2);
												panel_2.setLayout(null);
												

												
												JButton btnNewButton = new JButton("");
												btnNewButton.setBounds(10, 11, 25, 23);
												panel_2.add(btnNewButton);
												btnNewButton.setIcon(new ImageIcon(Frame.class.getResource("/icons/maus.png")));
												
												JButton button = new JButton("");
												button.setBounds(45, 11, 25, 23);
												panel_2.add(button);
												
												JButton button_1 = new JButton("");
												button_1.setBounds(97, 11, 25, 23);
												panel_2.add(button_1);
												button_1.setIcon(new ImageIcon(Frame.class.getResource("/icons/pinsel.png")));
												
												JButton button_3 = new JButton("");
												button_3.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {Cursor.addToSize(1);}
												});
												button_3.setBounds(132, 11, 15, 15);
												panel_2.add(button_3);
												button_3.setIcon(new ImageIcon(Frame.class.getResource("/icons/plus.jpg")));
												
												JButton button_2 = new JButton("");
												button_2.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {Cursor.addToSize(-1);}
												});
												button_2.setBounds(132, 29, 15, 15);
												panel_2.add(button_2);
												button_2.setIcon(new ImageIcon(Frame.class.getResource("/icons/minus.jpg")));
												
												Component horizontalStrut = Box.createHorizontalStrut(10);
												panel_1.add(horizontalStrut, BorderLayout.WEST);
												
												Component verticalStrut = Box.createVerticalStrut(7);
												panel_1.add(verticalStrut, BorderLayout.SOUTH);
												
												Component horizontalStrut_2 = Box.createHorizontalStrut(4);
												panel_1.add(horizontalStrut_2, BorderLayout.EAST);
		

		
	
	}
}
