package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class JSliderChangeEventEx extends JFrame implements ActionListener, ChangeListener {

	private JPanel contentPane;
	private JButton btnok;
	private JSlider slider;
	private JSlider lblR;
	private JLabel lblvalue;
	private JSlider lblB;
	private JLabel lblcolor;
	private JSlider lblG;
	private Color color;
	private Color color2;
	private JPanel pspinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JButton btnNewButton;
	private JSpinner spinner;
	private JLabel label;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSliderChangeEventEx frame = new JSliderChangeEventEx();
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
	public JSliderChangeEventEx() {
		setTitle("JSliderChangeEventEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 476, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));
		
		JPanel pBasicslider = new JPanel();
		pBasicslider.setBorder(new TitledBorder(null, "\uC2AC\uB77C\uC774\uB354 \uCEF4\uD3EC\uB10C\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pBasicslider);
		
		slider = new JSlider();
		slider.addChangeListener(this);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		pBasicslider.add(slider);
		
		btnok = new JButton("슬라이더값확인");
		btnok.addActionListener(this);
		pBasicslider.add(btnok);
		
		lblvalue = new JLabel("");
		pBasicslider.add(lblvalue);
		
		JPanel pAdavanceslider = new JPanel();
		pAdavanceslider.setBorder(new TitledBorder(null, "\uC774\uBCA4\uD2B8\uB97C \uC801\uC6A9\uD55C\uC2AC\uB77C\uC774\uB354", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pAdavanceslider);
		
		lblR = new JSlider();
		
		lblR.setMaximum(250);
		lblR.setForeground(Color.RED);
		lblR.setMinorTickSpacing(10);
		lblR.setMajorTickSpacing(50);
		lblR.setPaintTicks(true);
		lblR.setPaintLabels(true);
		pAdavanceslider.add(lblR);
		
		lblG = new JSlider();
		lblG.setValue(100);

		lblG.setMaximum(250);
		lblG.setForeground(Color.GREEN);
		lblG.setMinorTickSpacing(10);
		lblG.setMajorTickSpacing(50);
		lblG.setPaintTicks(true);
		lblG.setPaintLabels(true);
		pAdavanceslider.add(lblG);
		
		lblB = new JSlider();
		lblB.setMaximum(250);
		lblB.setForeground(Color.blue);
		lblB.setMinorTickSpacing(10);
		lblB.setMajorTickSpacing(50);
		lblB.setPaintTicks(true);
		lblB.setPaintLabels(true);
		pAdavanceslider.add(lblB);
		
		lblcolor = new JLabel("SLIDER EXAMPLE");
		
		
		setbackground();
		//lblcolor.setOpaque(true);
		pAdavanceslider.add(lblcolor);
		
		pspinner = new JPanel();
		contentPane.add(pspinner);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"\uC18C\uC124", "\uC7A1\uC9C0", "\uC804\uACF5\uC11C\uC801", "\uCDE8\uBBF8"}));
		Calendar cal = Calendar.getInstance();
		Date value = cal.getTime();
		
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date start = cal.getTime();
		
		cal.add(Calendar.YEAR, 100);
		Date end = cal.getTime();
		
		pspinner.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1541602800000L), null, null, Calendar.DAY_OF_MONTH));
		spinner_1.setEditor(new JSpinner.DateEditor(spinner_1,"yyyy/mm/dd"));
		pspinner.add(spinner_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(0)));
		pspinner.add(spinner_2);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		pspinner.add(btnNewButton);
		
		lblNewLabel = new JLabel("New label");
		pspinner.add(lblNewLabel);
		
		//label = new JLabel("");
		//pspinner.add(label);
		lblG.addChangeListener(this);
		lblB.addChangeListener(this);
		lblR.addChangeListener(this);
	}

	private void setbackground() {
		int valuR = lblR.getValue();
		int valuG = lblG.getValue();
		int valuB = lblB.getValue();
		color = new Color(valuR,valuG,valuB);
		lblcolor.setBackground(color);
		lblcolor.setOpaque(true);
		color2 = new Color(250-valuR,250-valuG,250-valuB);
		lblcolor.setForeground(color2);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnok) {
			do_btnok_actionPerformed(e);
		}
	}
	protected void do_btnok_actionPerformed(ActionEvent e) {
		int valu = slider.getValue();
		JOptionPane.showMessageDialog(null, "슬라이더의 값은 "+valu);
	}
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == lblG) {
			do_slider_1_stateChanged(e);
		}
		if (e.getSource() == lblB) {
			do_lblB_stateChanged(e);
		}
		if (e.getSource() == lblR) {
			do_lblR_stateChanged(e);
		}
		if (e.getSource() == slider) {
			do_slider_stateChanged(e);
		}
	}
	protected void do_slider_stateChanged(ChangeEvent e) {
		int vaule = slider.getValue();
		lblvalue.setText(vaule+"");
	}
	protected void do_lblR_stateChanged(ChangeEvent e) {
		setbackground();
	}
	protected void do_lblB_stateChanged(ChangeEvent e) {
		setbackground();
	}
	protected void do_slider_1_stateChanged(ChangeEvent e) {
		setbackground();
	}

	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String strval = (String) spinner.getValue();
		int intvalu = (int) spinner_2.getValue();
		Date dateva = (Date) spinner_1.getValue();
		String full =strval+intvalu+dateva;
		lblNewLabel.setText(full);
		//System.out.println(full);
		pspinner.add(lblNewLabel);
		
	}
}
