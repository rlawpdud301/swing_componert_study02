package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JButtonEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JButtonEx frame = new JButtonEx();
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
	public JButtonEx() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("call~~");
		String iconPath1 = System.getProperty("user.dir")+"\\images\\";
		btnNewButton.setIcon(new ImageIcon(iconPath1+"normalIcon.gif"));
		ImageIcon bt1 = new ImageIcon(iconPath1+"pressedIcon.gif");
		ImageIcon bt2 = new ImageIcon(iconPath1 +"rolloverIcon.gif");
		btnNewButton.setPressedIcon(bt1);
		btnNewButton.setRolloverIcon(bt2);
		contentPane.add(btnNewButton);
	}

}
