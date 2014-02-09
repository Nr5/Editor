package mapeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import Tools.CounterButton;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;


public class New extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	static int x =0;
	static int y =0;
	static String s = "";
	public static Map n(Point loc, Dimension dimension){
		x=0;		
		new New(loc,dimension);
		if (x==0)return null;
		Cursor.setItem(s);
		return new Map(x,y);
		
	}

	public New(Point loc, Dimension dimension) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setResizable(false);
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(loc.x+dimension.width/2 -125, loc.y+dimension.height/2-100, 250, 200);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(30, 144, 255));
		contentPanel.setBorder(new MatteBorder(7, 7, 0, 7, (Color) new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
			
			
				final CounterButton counterButton_1 = new CounterButton("Width", 10, 100,true);
				counterButton_1.setForeground(new Color(250, 235, 215));
				counterButton_1.setBackground(new Color(100, 149, 237));
				counterButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				counterButton_1.setBounds(20, 21, 132, 30);
				contentPanel.add(counterButton_1);
			
			
				final CounterButton counterButton_2 = new CounterButton("Height", 10, 100,true);
				counterButton_2.setForeground(new Color(250, 235, 215));
				counterButton_2.setBackground(new Color(100, 149, 237));
				counterButton_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				counterButton_2.setBounds(20, 62, 132, 30);
				contentPanel.add(counterButton_2);
			
				{
				JLabel label1 = new JLabel("(10-250)");
				label1.setBackground(new Color(0, 0, 0));
				label1.setForeground(new Color(0, 0, 0));
				label1.setBounds(172, 21, 65, 30);
				contentPanel.add(label1);
				}
			
				{
				JLabel label2 = new JLabel("(10-250)");
				label2.setBackground(new Color(0, 0, 0));
				label2.setForeground(new Color(0, 0, 0));
				label2.setBounds(172, 62, 65, 30);
				contentPanel.add(label2);
				}
			
			JLabel label = new JLabel("");
			label.setBounds(28, 164, 182, 14);
			contentPanel.add(label);
			
			final JComboBox comboBox = new JComboBox();
			comboBox.setForeground(new Color(0, 0, 0));
			comboBox.setBackground(new Color(100, 149, 237));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"grass","water","sand","concrete","sidewalk"}));
			comboBox.setToolTipText("");
			comboBox.setBounds(20, 113, 75, 20);
			contentPanel.add(comboBox);
			
			
			
			{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(0, 0, 128));
			buttonPane.setBorder(new MatteBorder(0, 7, 7, 7, (Color) new Color(0, 0, 0)));
			buttonPane.setBackground(new Color(30, 144, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
			
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(0, 0, 0));
				okButton.setBackground(new Color(32, 178, 170));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						x = counterButton_1.getValue();
						y = counterButton_2.getValue();
						s = (String) comboBox.getSelectedItem();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				}
			
				{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(0, 0, 128));
				cancelButton.setBackground(new Color(32, 178, 170));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				}

			
				setModal(true);
				setVisible(true);

			}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
