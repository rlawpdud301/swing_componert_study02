package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class JComponerntMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnCheckboxitemeventex;
	private JButton btnJbuttonex;
	private JButton btnJcomponent;
	private JButton btnJlabelex;
	private JButton btnJlistandjcomboex;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private CheckBoxEx CheckBoxExFrame;
	private CheckBoxItemEventEx CheckBoxItemEventExFrame;
	private JButtonEx JButtonExFrame;
	private JComponent JComponentFrame;
	private JLabelEx JLabelExFrame;
	private JListAndJComboEx JListAndJComboExFrame;
	private JTextFieldOtherEx JTextFieldOtherExFrame;
	private RadioButtonItemEventEx RadioButtonItemEventExFrame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private JComponerntMain frame;

			public void run() {
				try {
					frame = new JComponerntMain();
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
	public JComponerntMain() {
		setTitle("모든 JComponet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));
		
		btnNewButton = new JButton("CheckBoxEx");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		btnCheckboxitemeventex = new JButton("CheckBoxItemEventEx");
		btnCheckboxitemeventex.addActionListener(this);
		contentPane.add(btnCheckboxitemeventex);
		
		btnJbuttonex = new JButton("JButtonEx");
		btnJbuttonex.addActionListener(this);
		contentPane.add(btnJbuttonex);
		
		btnJcomponent = new JButton("JComponent");
		btnJcomponent.addActionListener(this);
		contentPane.add(btnJcomponent);
		
		btnJlabelex = new JButton("JLabelEx");
		btnJlabelex.addActionListener(this);
		contentPane.add(btnJlabelex);
		
		btnJlistandjcomboex = new JButton("JListAndJComboEx");
		btnJlistandjcomboex.addActionListener(this);
		contentPane.add(btnJlistandjcomboex);
		
		btnNewButton_1 = new JButton("JTextFieldOtherEx");
		btnNewButton_1.addActionListener(this);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("RadioButtonItemEventEx");
		btnNewButton_2.addActionListener(this);
		contentPane.add(btnNewButton_2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			try {
				do_btnNewButton_1_actionPerformed(e);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnJlistandjcomboex) {
			do_btnJlistandjcomboex_actionPerformed(e);
		}
		if (e.getSource() == btnJlabelex) {
			do_btnJlabelex_actionPerformed(e);
		}
		if (e.getSource() == btnJcomponent) {
			do_btnJcomponent_actionPerformed(e);
		}
		if (e.getSource() == btnJbuttonex) {
			do_btnJbuttonex_actionPerformed(e);
		}
		if (e.getSource() == btnCheckboxitemeventex) {
			do_btnCheckboxitemeventex_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		CheckBoxExFrame = new CheckBoxEx();
		CheckBoxExFrame.setVisible(true);
		CheckBoxExFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	protected void do_btnCheckboxitemeventex_actionPerformed(ActionEvent e) {
		CheckBoxItemEventExFrame = new CheckBoxItemEventEx();
		CheckBoxItemEventExFrame.setVisible(true);
		CheckBoxItemEventExFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	protected void do_btnJbuttonex_actionPerformed(ActionEvent e) {
		JButtonExFrame = new JButtonEx();
		JButtonExFrame.setVisible(true);
		JButtonExFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	protected void do_btnJcomponent_actionPerformed(ActionEvent e) {
		JComponentFrame = new JComponent();
		JComponentFrame.setVisible(true);
		JComponentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	protected void do_btnJlabelex_actionPerformed(ActionEvent e) {
		JLabelExFrame = new JLabelEx();
		JLabelExFrame.setVisible(true);
		JLabelExFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	protected void do_btnJlistandjcomboex_actionPerformed(ActionEvent e) {
		JListAndJComboExFrame = new JListAndJComboEx();
		JListAndJComboExFrame.setVisible(true);
		JListAndJComboExFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) throws ParseException {
		JTextFieldOtherExFrame = new JTextFieldOtherEx();
		JTextFieldOtherExFrame.setVisible(true);
		JTextFieldOtherExFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		RadioButtonItemEventExFrame = new RadioButtonItemEventEx();
		RadioButtonItemEventExFrame.setVisible(true);
		RadioButtonItemEventExFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
