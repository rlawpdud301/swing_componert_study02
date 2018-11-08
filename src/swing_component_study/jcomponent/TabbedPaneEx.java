package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class TabbedPaneEx extends JFrame {

	private JPanel contentPane;
	private String imgPath;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabbedPaneEx frame = new TabbedPaneEx();
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
	public TabbedPaneEx() {
		imgPath = System.getProperty("user.dir") + "\\images\\";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(imgPath + "img1.jpg"));
		tabbedPane.addTab("tap1", null, lblNewLabel, "몰라");
		
		JLabel lblNewLabel2 = new JLabel(new ImageIcon(imgPath + "img2.jpg"));
		tabbedPane.addTab("tap2", null, lblNewLabel2, "몰라");
		
		TablePanel panel = new TablePanel();
		tabbedPane.addTab("tap3", null, panel, "테이블");
	}

}
