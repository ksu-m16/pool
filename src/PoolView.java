import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

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
	private AbstractButton radioButton;
	private AbstractButton radioButton_1;
	private AbstractButton radioButton_2;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;
	private JRadioButton radioButton_9;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_7;
	private JRadioButton radioButton_10;
	private JRadioButton radioButton_12;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_8;
	private JRadioButton radioButton_11;
	private JRadioButton radioButton_13;
	private JRadioButton radioButton_14;
	private JButton btnCalculate;
	private JButton btnNext;

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
//		btnNext.setEnabled(false);
	}

	/**
	 * Create the frame.
	 */
	public PoolView() {
		setTitle("Pool Set Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("48dlu"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(4dlu;default)"),
				ColumnSpec.decode("max(65dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		txtrSet = new JLabel();
		
		
		
		contentPane.add(txtrSet, "2, 2, 8, 1, fill, top");
		
		radioButton = new JRadioButton("");
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton, "11, 2");
		
		radioButton_1 = new JRadioButton("");
		radioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_1, "9, 4");
		
		radioButton_5 = new JRadioButton("");
		radioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_5, "13, 4");
		
		radioButton_2 = new JRadioButton("");
		radioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_2, "7, 6");
		
		radioButton_6 = new JRadioButton("");
		radioButton_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_6, "11, 6");
		
		radioButton_9 = new JRadioButton("");
		radioButton_9.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_9, "15, 6");
		
		radioButton_3 = new JRadioButton("");
		radioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_3, "5, 8");
		
		radioButton_7 = new JRadioButton("");
		radioButton_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_7, "9, 8");
		
		radioButton_10 = new JRadioButton("");
		radioButton_10.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_10.setBackground(Color.BLACK);
		radioButton_10.setForeground(Color.LIGHT_GRAY);
		contentPane.add(radioButton_10, "13, 8, fill, fill");
		
		radioButton_12 = new JRadioButton("");
		radioButton_12.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_12, "17, 8");
		
		radioButton_4 = new JRadioButton("");
		radioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_4, "3, 10");
		
		radioButton_8 = new JRadioButton("");
		radioButton_8.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_8, "7, 10");
		
		radioButton_11 = new JRadioButton("");
		radioButton_11.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_11, "11, 10");
		
		radioButton_13 = new JRadioButton("");
		radioButton_13.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_13, "15, 10");
		
		radioButton_14 = new JRadioButton("");
		radioButton_14.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(radioButton_14, "19, 10");
		
		
		btnCalculate = new JButton("Calculate!");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.generateSets();
						
				try {
					setButtons(controller.getNextSet());
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
		
		
		
		btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setButtons(controller.getNextSet());
				txtrSet.setText("Set " + controller.getSetNum() + " / " + controller.getCount());
			}
		});
		contentPane.add(btnCalculate, "7, 14, 9, 1");
		contentPane.add(btnNext, "7, 16, 9, 1");

	}

	private void setButtons(int[] set){
		radioButton.setSelected(set[0] != 1);
		radioButton_1.setSelected(set[1] != 1);
		radioButton_2.setSelected(set[2] != 1);
		radioButton_3.setSelected(set[3] != 1);
		radioButton_4.setSelected(set[4] != 1);
		radioButton_5.setSelected(set[5] != 1);
		radioButton_6.setSelected(set[6] != 1);
		radioButton_7.setSelected(set[7] != 1);
		radioButton_8.setSelected(set[8] != 1);
		radioButton_9.setSelected(set[9] != 1);
		radioButton_10.setSelected(set[10] != 1);
		radioButton_11.setSelected(set[11] != 1);
		radioButton_12.setSelected(set[12] != 1);
		radioButton_13.setSelected(set[12] != 1);
		radioButton_14.setSelected(set[14] != 1);
		
	}
}
