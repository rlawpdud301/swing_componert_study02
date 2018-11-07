package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RadioButtonItemEventEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private String iconPath1;
	private JLabel lblNewLabel;

	

	/**
	 * Create the frame.
	 */
	public RadioButtonItemEventEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		rdbtnNewRadioButton = new JRadioButton("사과");
		rdbtnNewRadioButton.addItemListener(this);
		buttonGroup.add(rdbtnNewRadioButton);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("배");
		rdbtnNewRadioButton_1.addItemListener(this);
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("체리");
		rdbtnNewRadioButton_2.addItemListener(this);
		buttonGroup.add(rdbtnNewRadioButton_2);
		panel.add(rdbtnNewRadioButton_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		iconPath1 = System.getProperty("user.dir")+"\\images\\fruits\\cherry.jpg";
		lblNewLabel.setIcon(new ImageIcon(iconPath1));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

	


	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == rdbtnNewRadioButton_2) {
			do_rdbtnNewRadioButton_2_itemStateChanged(e);
		}
		if (e.getSource() == rdbtnNewRadioButton_1) {
			do_rdbtnNewRadioButton_1_itemStateChanged(e);
		}
		if (e.getSource() == rdbtnNewRadioButton) {
			do_rdbtnNewRadioButton_itemStateChanged(e);
		}
		
		lblNewLabel.setIcon(new ImageIcon(iconPath1));
	}
	protected void do_rdbtnNewRadioButton_itemStateChanged(ItemEvent e) {
		iconPath1 = System.getProperty("user.dir")+"\\images\\fruits\\apple.jpg";		
	}
	protected void do_rdbtnNewRadioButton_1_itemStateChanged(ItemEvent e) {
		iconPath1 = System.getProperty("user.dir")+"\\images\\fruits\\pear.jpg";
	}
	protected void do_rdbtnNewRadioButton_2_itemStateChanged(ItemEvent e) {
		iconPath1 = System.getProperty("user.dir")+"\\images\\fruits\\cherry.jpg";
		
	}
}
