package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MenuAndFileDialogExextends extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem Opne;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JFileChooser chooser;
	private FileNameExtensionFilter FileNameExtensionFilterfilter;
	private JMenuItem mntmsave;
	private FileFilter filter;
	private int intret;
	private JMenuItem mntmFileOpen;
	private AbstractButton imageLabel;
	private AbstractButton lblImg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAndFileDialogExextends frame = new MenuAndFileDialogExextends();
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
	public MenuAndFileDialogExextends() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);

		Opne = new JMenuItem("Opne");
		Opne.addActionListener(this);
		mnNewMenu.add(Opne);

		mntmsave = new JMenuItem("save");
		mntmsave.addActionListener(this);
		mnNewMenu.add(mntmsave);
		
		mntmFileOpen = new JMenuItem("파일읽어오기");
		mntmFileOpen.addActionListener(this);
		mnNewMenu.add(mntmFileOpen);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmFileOpen) {
			do_mntmFileOpen_actionPerformed(e);
		}
		if (e.getSource() == mntmsave) {
			do_mntmsave_actionPerformed(e);
		}
		if (e.getSource() == Opne) {
			do_Opne_actionPerformed(e);
		}
	}

	protected void do_Opne_actionPerformed(ActionEvent e) {
		 String currentDirectoryPath = System.getProperty("user.dir") + "\\images\\";
	      
	      JFileChooser chooser = new JFileChooser(currentDirectoryPath);
	      FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF images", "jpg", "gif");
	      chooser.setFileFilter(filter);
	      
	      int ret = chooser.showOpenDialog(null);
	      System.out.println("ret : " + ret);
	      if (ret != JFileChooser.APPROVE_OPTION) {
	         JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
	         return;
	      }
	      
	      String filePath = chooser.getSelectedFile().getPath();
	      lblImg.setIcon(new ImageIcon(filePath));

	}
	protected void do_mntmsave_actionPerformed(ActionEvent e) {
		String currentDirectoryPath = System.getProperty("user.dir") + "\\backup";
		File backupDir = new File(currentDirectoryPath);
		if(!backupDir.exists()) {
			backupDir.mkdirs();
		}
		JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		int ret = chooser.showSaveDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을선택하지않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		String fileName = chooser.getSelectedFile().getName();
		
		JOptionPane.showMessageDialog(null, filePath + ":"+fileName);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
			bw.write("김보민");
			bw.flush();
		} catch  (IOException e1){
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "저장완료");
		
		
	}
	protected void do_mntmFileOpen_actionPerformed(ActionEvent e) {
		String currentDirectoryPath = System.getProperty("user.dir") + "\\backup";
		File backupDir = new File(currentDirectoryPath);
		if(!backupDir.exists()) {
			backupDir.mkdirs();
		}
		JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		int ret = chooser.showSaveDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을선택하지않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line = br.readLine();
			lblImg.setText(line);
		}catch  (FileNotFoundException e1){
			e1.printStackTrace();
		} 
		catch  (IOException e1){
			e1.printStackTrace();
		} 
		
	}
}
