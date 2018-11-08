package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JOptionPaneExFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tf;
	private JButton btnName;
	private JButton btnconfirm;
	private JButton btnMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneExFrame frame = new JOptionPaneExFrame();
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
	public JOptionPaneExFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnName = new JButton("Name");
		btnName.addActionListener(this);
		contentPane.add(btnName);
		
		btnconfirm = new JButton("confirm");
		btnconfirm.addActionListener(this);
		contentPane.add(btnconfirm);
		
		btnMessage = new JButton("Message");
		btnMessage.addActionListener(this);
		contentPane.add(btnMessage);
		
		tf = new JTextField();
		contentPane.add(tf);
		tf.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMessage) {
			do_btnMessage_actionPerformed(e);
		}
		if (e.getSource() == btnconfirm) {
			do_btnconfirm_actionPerformed(e);
		}
		if (e.getSource() == btnName) {
			do_btnName_actionPerformed(e);
		}
	}
	protected void do_btnName_actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog("이름을입력하세요.");
		if(name != null)
		tf.setText(name);
		
	}
	protected void do_btnconfirm_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null,
				"계속할것입니까?", "Confirm",
				JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION)
				tf.setText("Just Closed without Selection");
				else if(result == JOptionPane.YES_OPTION)
				tf.setText("Yes");
				else
				tf.setText("No");
				
	}
	protected void do_btnMessage_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,
				"조심하세요", "Message",
				JOptionPane.ERROR_MESSAGE);
		
	}
}
