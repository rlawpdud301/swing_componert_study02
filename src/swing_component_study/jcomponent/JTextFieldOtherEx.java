package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class JTextFieldOtherEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfid;
	private JTextField tfdata;
	private JButton btnOk;
	private JPasswordField pfpwd;
	private JPasswordField pfpwd2;
	private JLabel lblcomfom;
	private JTextArea ta;
	private JButton btnCencle;
	private JFormattedTextField tfdata1;

	

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public JTextFieldOtherEx() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pContent = new JPanel();
		pContent.setBorder(new TitledBorder(null, "textField\uC0AC\uC6A9\uC608", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pContent, BorderLayout.NORTH);
		pContent.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblid = new JLabel("ID:");
		lblid.setHorizontalAlignment(SwingConstants.LEFT);
		pContent.add(lblid);
		
		tfid = new JTextField();
		pContent.add(tfid);
		tfid.setColumns(10);
		
		JLabel lblpwd = new JLabel("PASSWORD:");
		lblpwd.setHorizontalAlignment(SwingConstants.LEFT);
		pContent.add(lblpwd);
		
		pfpwd = new JPasswordField();
		pContent.add(pfpwd);
		
		JLabel lblPassword = new JLabel("PASSWORD 확인");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		pContent.add(lblPassword);
		
		pfpwd2 = new JPasswordField();
		pContent.add(pfpwd2);
		
		JPanel pBlank = new JPanel();
		pContent.add(pBlank);
		
		lblcomfom = new JLabel("");
		lblcomfom.setForeground(Color.RED);
		pContent.add(lblcomfom);
		
		JLabel lbldata = new JLabel("DATA");
		lbldata.setHorizontalAlignment(SwingConstants.LEFT);
		pContent.add(lbldata);
		
		MaskFormatter mf = new MaskFormatter("####-##-##");
		mf.setPlaceholderCharacter('_');
		tfdata1 = new JFormattedTextField(mf);
		tfdata1.setValue(LocalDate.now());;
		/*tfdata = new JTextField();*/
		pContent.add(tfdata1);
		tfdata1.setColumns(10);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pContent.add(btnOk);
		
		btnCencle = new JButton("초기화");
		btnCencle.addActionListener(this);
		pContent.add(btnCencle);
		
		ta = new JTextArea();
		contentPane.add(ta, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCencle) {
			do_btnCencle_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			do_btnOk_actionPerformed(e);
		}
	}
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		boolean checked= validCheck();
		if(checked==true) {
			String pwd2 = new String(pfpwd2.getPassword());
			String pwd = new String(pfpwd.getPassword());
			
			if(pwd.equals(pwd2)) {
				lblcomfom.setText("일치");
			}else {
				lblcomfom.setText("불일치");
				boolean checkedpwd = checkpwd();
				if(checkedpwd==false) {
					return;
				}
				
			}
			
			String date = tfdata1.getText();
			String message = String.format("id = %s%n" 
					+"passed1 = %s%n"
					+"passed2 = %s%n"
					+"DATA = %s%n"
					, tfid.getText().trim(),pwd,pwd2,date);
			JOptionPane.showMessageDialog(null, message);
			
			ta.append(message);
			tfid.requestFocus();
			tfid.selectAll();
			pfpwd.requestFocus();
			pfpwd.selectAll();
			pfpwd2.requestFocus();
			pfpwd2.selectAll();
			
			ta.setCaretPosition(ta.getDocument().getLength());
		}
		JOptionPane.showMessageDialog(null, "비밀번호 확인을 확인하세요");
		pfpwd2.requestFocus();
			
	}

	private boolean checkpwd() {
		JOptionPane.showMessageDialog(null, "비밀번호 확인을 확인하세요");
		pfpwd2.setText("");
		pfpwd2.requestFocus();
		return false;
	}
	protected void do_btnCencle_actionPerformed(ActionEvent e) {
		
		tfid.setText("");		
		pfpwd.setText("");		
		pfpwd2.setText("");
		tfdata1.setValue(LocalDate.now());
		tfid.requestFocus();
	}
	
	private boolean validCheck() {
		if (tfid.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디빔");			
			tfid.requestFocus();
			return false;
		}
		String pwd2 = new String(pfpwd2.getPassword());
		String pwd = new String(pfpwd.getPassword());
		if (pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "비번빔");			
			pfpwd.requestFocus();
			return false;
		}
		if (pwd2.equals("")) {
			JOptionPane.showMessageDialog(null, "비번확인빔");			
			pfpwd2.requestFocus();
			return false;
		}
		return true;
	}
}
