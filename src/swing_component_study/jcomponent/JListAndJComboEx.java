package swing_component_study.jcomponent;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class JListAndJComboEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JList list_1;
	private ImageIcon[] icons;
	private JTextField tfName;
	private List<String> listNames;
	private JList<String> JListListName;
	private JLabel lblNewLabel_1;

	

	/**
	 * Create the frame.
	 */
	public JListAndJComboEx() {
		initComponents();
	}
	private void initComponents() {
		setTitle("JListAndJComboEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 0));
		
		JPanel pJList = new JPanel();
		pJList.setBorder(new TitledBorder(null, "JList", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJList);
		pJList.setLayout(new GridLayout(0, 3, 10, 0));
		// 과일
		JList<String> list = new JList<>(/*fruits*/);//<>안에 제네릭(타입)선언
		list.setListData(getStringData());
		pJList.add(list);

		list_1 = new JList();
		list_1.setListData(getImgIcons());
		pJList.add(list_1);
		
		JPanel panel = new JPanel();
		pJList.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel pInput = new JPanel();
		panel.add(pInput, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("이름입력 후 <Enter>키");
		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int index = JListListName.getSelectedIndex();
				String name = JListListName.getSelectedValue();
				System.out.println(e);
				//eJListListName.
				JOptionPane.showMessageDialog(null, "선택한 이름은 "+name+"위치는"+index);
			}
			
		});
		pInput.add(lblNewLabel);
		
		listNames = new ArrayList<>();
		
		tfName = new JTextField();
		tfName.addActionListener(this);
		pInput.add(tfName);
		tfName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JListListName = new JList();
		scrollPane.setViewportView(JListListName);
		
		JPanel pJCombo = new JPanel();
		pJCombo.setBorder(new TitledBorder(null, "JComboBox", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJCombo);
		pJCombo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel subPjcombo1 = new JPanel();
		pJCombo.add(subPjcombo1);
		subPjcombo1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		String[] strArr1 = {"apple", "banana", "kiwi"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(strArr1);
		JComboBox<String> cmb1 = new JComboBox<>(model);
		
		subPjcombo1.add(cmb1);
		
		
		String[] strArr2 = {"김보민", "수선미", "황경수","이준민"};
		JComboBox<String> cmb2 = new JComboBox<>();
		
		
		for(int i =0; i<strArr2.length; i++) {
			cmb2.addItem(strArr2[i]);
		}
		subPjcombo1.add(cmb2);
		cmb2.setSelectedIndex(-1);
		
		
		cmb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = (String) cmb2.getSelectedItem();
				int index = cmb2.getSelectedIndex();
				JOptionPane.showMessageDialog(null, index + "번쨰이름" + name);
				
			}
		});
		
		
		JPanel subPjcombo2 = new JPanel();
		pJCombo.add(subPjcombo2);
		subPjcombo2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		subPjcombo2.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		String[] strArr3 = {"apple", "banana", "kiwi", "mango"};
		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(strArr3);
		JComboBox<String> comboBox = new JComboBox<>(model2);
		
		comboBox.addActionListener(new ActionListener() {
		
			
			private String iconPath1;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] images = { "\\images\\fruits\\apple.jpg","\\images\\fruits\\banana.jpg","\\images\\fruits\\kiwi.jpg","\\images\\fruits\\mango.jpg"};
				int index = comboBox.getSelectedIndex();
				iconPath1 = System.getProperty("user.dir")+images[index];
				lblNewLabel_1.setIcon(new ImageIcon(iconPath1));
				
			}
		});
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		subPjcombo2.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1);
	}

	private Object[] getImgIcons() {
		String imgPath = System.getProperty("user.dir")+"\\images\\";
		icons = new ImageIcon[] {
				new ImageIcon(imgPath + "icon1.png"),
				new ImageIcon(imgPath + "icon2.png"),
				new ImageIcon(imgPath + "icon3.png"),
				new ImageIcon(imgPath + "icon4.png"),
		};
		return icons;
	}

	private String[] getStringData() {
		return new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfName) {
			do_tfName_actionPerformed(e);
		}
	}
	protected void do_tfName_actionPerformed(ActionEvent e) {
		
		listNames.add(tfName.getText().trim());
		JListListName.setListData(new Vector<>(listNames));
		tfName.setText("");
		tfName.requestFocus();
		
		
	}
}