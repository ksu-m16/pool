import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;


public class PoolView extends JFrame {

	private JPanel contentPane;
	private JLabel txtrSet;
	private PoolController controller ;
//	private AbstractButton radioButton;
//	private AbstractButton radioButton_1;
//	private AbstractButton radioButton_2;
//	private JRadioButton radioButton_5;
//	private JRadioButton radioButton_6;
//	private JRadioButton radioButton_9;
//	private JRadioButton radioButton_3;
//	private JRadioButton radioButton_7;
//	private JRadioButton radioButton_10;
//	private JRadioButton radioButton_12;
//	private JRadioButton radioButton_4;
//	private JRadioButton radioButton_8;
//	private JRadioButton radioButton_11;
//	private JRadioButton radioButton_13;
//	private JRadioButton radioButton_14;
	private JButton btnCalculate;
	private JButton btnNext;
	private JPanel panel;
	Graphics g ;
	private int currentSet;
	


	public void setController(PoolController controller) {
		this.controller = controller;
	}

	/**
	 * Launch the application.
	 */
	public void run() {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					PoolView.this.setVisible(true);
					btnCalculate.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void initialize() {

	}

	/**
	 * Create the frame.
	 */
	public PoolView() {
		
		setTitle("Pool Set Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("48dlu:grow"),
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("max(65dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		txtrSet = new JLabel();
		
		
		
		contentPane.add(txtrSet, "2, 2, fill, top");
		
		
		btnCalculate = new JButton("Calculate!");
		btnCalculate.setSelected(true);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.generateSets();
				System.out.println(controller.getCount());
				setCurrentSet(controller.getNext());
//				setButtons(controller.getNextSet());
//				drawSolution(g,controller.getNext() );
//				contentPane.paint(g);
				
				System.out.println("num:" + controller.getSetNum());
				
				
				txtrSet.setText("Set 1 / " + controller.getCount());
				btnNext.setEnabled(true);
				btnCalculate.setEnabled(false);
				panel.setVisible(true);
						
				try {
					txtrSet.setText("Set 1 / " + controller.getCount());
					btnNext.setEnabled(true);
					btnCalculate.setEnabled(false);
				}
				catch (NullPointerException e) {
					txtrSet.setText("No solutions found");
					btnNext.setEnabled(false);
					btnCalculate.setEnabled(false);
				}

			}
		});
		
		panel = new JPanel(){
			public void paint(Graphics g) {				
				drawSolution(g);
		};
		};
		panel.setVisible(false);
		contentPane.add(panel, "2, 4, 1, 5, fill, fill");
		contentPane.add(btnCalculate, "4, 6, default, bottom");
		
		
		
		btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("num:" + controller.getSetNum());
				setCurrentSet(controller.getNext());
				txtrSet.setText("Set " + controller.getSetNum() + " / " + controller.getCount());
			}
		});
		contentPane.add(btnNext, "4, 8");

	}

	public void drawSolution(Graphics g) {		
		
		int s = 25; //space between balls
		int d = 25; //ball diameter
		
		Color vc = new Color(0xFF00FF);
		Color gc = new Color(0x00FF00);
		Color bc = new Color(0x000000);
			
		Color f = vc;

		for (int row = 0; row < 5; ++row) {
			for (int col = 0; col < 5 - row; ++col) {
				int x = s + row * (d/2 + s );
				int y = s + d/2 + col*(d + s);
								
				if ((currentSet & 1) != 0) {
					f = vc;
				} else {
					f = gc;
				}
				
				if ((row == 2) && (col == 1)) {
					f = bc;
				}

				g.setColor(f);
				g.fillOval(x - d/2, y - d/2, d, d);
				currentSet >>= 1;
			}			
		}				
	}
	
	
	public void setCurrentSet(int set) {
		   currentSet = set;
		   panel.repaint();
		}

	
	
}
