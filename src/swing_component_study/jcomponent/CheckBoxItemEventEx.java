package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CheckBoxItemEventEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JCheckBox ch사과;
	private JCheckBox ch배;
	private JCheckBox ch체리;
	private int sum = 0;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxItemEventEx frame = new CheckBoxItemEventEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckBoxItemEventEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("사과 100원,배500,체리 2000원");
		contentPane.add(label);
		
		ch사과 = new JCheckBox("사과");
		ch사과.addItemListener(this);
		contentPane.add(ch사과);
		
		ch배 = new JCheckBox("배");
		ch배.addItemListener(this);
		contentPane.add(ch배);
		
		ch체리 = new JCheckBox("체리");
		ch체리.addItemListener(this);
		contentPane.add(ch체리);
		
		lblNewLabel = new JLabel("현재"+ sum + "원입니다.");
		contentPane.add(lblNewLabel);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == ch체리) {
			do_ch체리_itemStateChanged(e);
		}
		if (e.getSource() == ch배) {
			do_ch배_itemStateChanged(e);
		}
		if (e.getSource() == ch사과) {
			do_ch사과_itemStateChanged(e);
		}
		lblNewLabel.setText("현재"+ sum + "원입니다.");
	}
	protected void do_ch사과_itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			sum += 100;
		}else {
			sum -= 100;
		}		
	}
	protected void do_ch배_itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			sum += 500;
		}else {
			sum -= 500;
		}
	}
	protected void do_ch체리_itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			sum += 2000;
		}else {
			sum -= 2000;
		}
	}
}
