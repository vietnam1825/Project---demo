package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMainMenu extends JMenuBar implements ActionListener{
	/*
	 * Attributes
	 */
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmOpen = new JMenuItem("Open");
	private JMenuItem mntmClose = new JMenuItem("Close");
	private JMenuItem mntmSave = new JMenuItem("Save ...");
	private JMenuItem mntmSaveas = new JMenuItem("Save as ...");
	private JMenuItem mntmExit = new JMenuItem("Exit");
	private JMenu mnAbout = new JMenu("About");
	private JMenuItem mntmAboutMe = new JMenuItem("About me");	
	private MyMainFrame myFrame = null;
	
	/*
	 * Constructor
	 */
	public MyMainMenu(MyMainFrame _frame){
		super();
		this.myFrame = _frame;
		this.add(mnFile);
		this.add(mnAbout);
		/*
		 * Sub menu
		 */
		mnFile.setMnemonic(KeyEvent.VK_F);
		mntmOpen.setMnemonic(KeyEvent.VK_O);
		mntmClose.setMnemonic(KeyEvent.VK_C);
		mntmExit.setMnemonic(KeyEvent.VK_X);
		mnAbout.setMnemonic(KeyEvent.VK_A);
		/*
		 * Add
		 */
		mnFile.add(mntmOpen);		
		mnFile.add(mntmClose);		
		mnFile.addSeparator();
		mnFile.add(mntmSave);
		mnFile.add(mntmSaveas);
		mnFile.addSeparator();
		mnFile.add(mntmExit);		
		mnAbout.add(mntmAboutMe);		
		/*
		 * Add the action listeners
		 */
		mntmOpen.addActionListener(this);
		mntmClose.addActionListener(this);
		mntmSave.addActionListener(this);
		mntmSaveas.addActionListener(this);
		mntmExit.addActionListener(this);
		mntmAboutMe.addActionListener(this);
		/*
		 * Initialization
		 */
		setMenuEnabled(MyMainFrame.WHEN_START);
	}
	
	/*
	 * Action performed
	 */
	public void actionPerformed(ActionEvent arg){
		String command = arg.getActionCommand();				
		if (command.equals(mntmOpen.getText())){
			myFrame.openAction();
		}
		if (command.equals(mntmSave.getText())){
			myFrame.saveAction();			
		}
		if (command.equals(mntmSaveas.getText())){
			myFrame.saveAsAction();
		}
		if (command.equals(mntmClose.getText())){
			myFrame.closeAction();
		}
		if (command.equals(mntmExit.getText())){
			myFrame.exitAction();
		}
		if (command.equals(mntmAboutMe.getText())){
			myFrame.helpAction();
		}
	}
	/*
	 * Set enable when needed
	 */
	public void setMenuEnabled(int status){
		mntmOpen.setEnabled(true);
		mntmExit.setEnabled(true);
		mntmAboutMe.setEnabled(true);
		switch (status){
		case MyMainFrame.WHEN_START:			
			mntmClose.setEnabled(false);
			mntmSave.setEnabled(false);
			mntmSaveas.setEnabled(false);
			break;
		case MyMainFrame.WHEN_OPEN:
			mntmClose.setEnabled(true);
			mntmSave.setEnabled(true);
			mntmSaveas.setEnabled(true);
			break;
		default:
			break;				
		}
	}
}
