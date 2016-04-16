package ihm;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class MyToolBar extends JToolBar implements ActionListener {
	/*
	 * Attributes
	 */
	private JButton btnOpen;
	private JButton btnClose;
	private JButton btnSave;
	private JButton btnSaveas;
	private JButton btnExit;
	private JButton btnHelp;
	private MyMainFrame myFrame = null;
	/*
	 * Constructors
	 */
	public MyToolBar(MyMainFrame myFrame){
		super();
		this.myFrame = myFrame;
		this.setRollover(true);
		this.setFloatable(true);
		/*
		 * Initialization all buttons
		 */		
		btnOpen = new JButton(new ImageIcon(this.getClass().
				getResource("../images/open.gif")));
		btnOpen.setToolTipText("Open data file ...");
		
		btnClose = new JButton(new ImageIcon(this.getClass().
				getResource("../images/close.gif")));
		btnClose.setToolTipText("Close data file ...");
		
		btnSave = new JButton(new ImageIcon(this.getClass().
				getResource("../images/save.gif")));
		btnSave.setToolTipText("Save data file ...");
		
		btnSaveas = new JButton(new ImageIcon(this.getClass().
				getResource("../images/saveas.gif")));
		btnSaveas.setToolTipText("Save as data file ...");
		
		btnExit = new JButton(new ImageIcon(this.getClass().
				getResource("../images/exit.gif")));
		btnExit.setToolTipText("Exit this application ...");
		
		btnHelp = new JButton(new ImageIcon(this.getClass().
				getResource("../images/help.gif")));
		btnHelp.setToolTipText("About me ...");
		
		this.add(btnOpen);
		this.add(btnClose);
		this.addSeparator();
		this.add(btnSave);
		this.add(btnSaveas);
		this.addSeparator();
		this.add(btnExit);
		this.addSeparator(new Dimension(580, 0));
		this.add(btnHelp);
		
		/*
		 * Action listeners
		 */
		btnOpen.addActionListener(this);
		btnClose.addActionListener(this);
		btnSave.addActionListener(this);
		btnSaveas.addActionListener(this);
		btnExit.addActionListener(this);
		btnHelp.addActionListener(this);
		
		/*
		 * Initialization
		 */
		setActionEnabled(MyMainFrame.WHEN_START);
	}
	
	/*
	 * Set enable when needed
	 */
	public void setActionEnabled(int status){
		btnOpen.setEnabled(true);
		btnExit.setEnabled(true);
		btnHelp.setEnabled(true);
		switch (status){
		case MyMainFrame.WHEN_START:			
			btnClose.setEnabled(false);
			btnSave.setEnabled(false);
			btnSaveas.setEnabled(false);
			break;
		case MyMainFrame.WHEN_OPEN:
			btnClose.setEnabled(true);
			btnSave.setEnabled(true);
			btnSaveas.setEnabled(true);
			break;
		default:
			break;				
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(btnOpen)){
			myFrame.openAction();
		}
		if (ae.getSource().equals(btnSave)){
			myFrame.saveAction();
		}
		if (ae.getSource().equals(btnSaveas)){
			myFrame.saveAsAction();
		}
		if (ae.getSource().equals(btnClose)) {
			myFrame.closeAction();	
		}
		if (ae.getSource().equals(btnExit)) {
			myFrame.exitAction();
		}
		if (ae.getSource().equals(btnHelp)) {
			myFrame.helpAction();
		}
	}
}
