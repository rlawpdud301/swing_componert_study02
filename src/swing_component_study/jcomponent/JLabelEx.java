package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class JLabelEx extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public JLabelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel txtLable = new JLabel("사랑합니다");
		contentPane.add(txtLable);
		
		JLabel lblNewLabel = new JLabel("");
		String iconPath1 = System.getProperty("user.dir")+"\\images\\";
		lblNewLabel.setIcon(new ImageIcon(iconPath1+"beauty.jpg"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("보고싶으면 카톡하세요");
		lblNewLabel_1.setIcon(new ImageIcon(iconPath1 + "normalIcon.gif"));
		contentPane.add(lblNewLabel_1);
	}

}
