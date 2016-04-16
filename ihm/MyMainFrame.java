package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import data.ArrayListPersonE;
import data.Person;
import file.IOTextFile;

public class MyMainFrame extends JFrame implements WindowListener {
	/*
	 * Constants
	 */
	public static final int WHEN_START = 0;
	public static final int WHEN_OPEN = 1;
	/*
	 * Attributes
	 */
	public static int MAIN_STATUS = WHEN_START;
	
	/*
	 * Data
	 */
	private ArrayListPersonE listPerson = new ArrayListPersonE();
	private String currentFile = "";
	
	/*
	 * IHM
	 */	
	private MyMainMenu myMenu = new MyMainMenu(this);
	private MyToolBar myToolBar = new MyToolBar(this);
	private MyPanelDetail myPanelDetail = new MyPanelDetail(this);
	private MyPanelStatus myPanelStatus = new MyPanelStatus();
	private MyPanelAction myPanelAction = new MyPanelAction(this);
	private MyTablePerson myTablePerson = new MyTablePerson(this);	
	
	/*
	 * Constructor
	 */
	public MyMainFrame(){
		super();
		URL iconURL = this.getClass().getResource("../images/overview.gif");
		this.setIconImage(new ImageIcon(iconURL).getImage());		
		/*
		 * Initialization
		 */
		setResizable(false);
		setTitle("Person");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		setLocation(0, 0);
		/*
		 * Add the menu bar
		 */		
		setJMenuBar(myMenu);
		this.addWindowListener(this);
		/*
		 * Add the interface
		 */
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));		
		contentPanel.setLayout(new BorderLayout(2, 2));
		setContentPane(contentPanel);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "List of persons", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		contentPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(2, 2));
		
		JScrollPane listPanel = new JScrollPane();
		listPanel.setViewportView(myTablePerson);
				
		contentPanel.add(myToolBar, BorderLayout.NORTH);
		contentPanel.add(myPanelStatus, BorderLayout.SOUTH);
		contentPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.add(myPanelDetail, BorderLayout.NORTH);
		centerPanel.add(myPanelAction, BorderLayout.SOUTH);
		centerPanel.add(listPanel, BorderLayout.CENTER);				
	}
	
	public void windowClosing(WindowEvent arg0) {
		this.dispose();
		System.exit(0);
	}	
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}	
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}

	public ArrayListPersonE getListPerson() {
		return listPerson;
	}

	public void setListPerson(ArrayListPersonE listPerson) {
		this.listPerson = listPerson;
	}

	public String getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(String currentFile) {
		this.currentFile = currentFile;
	}

	public MyPanelDetail getMyPanelDetail() {
		return myPanelDetail;
	}

	public MyPanelStatus getMyPanelStatus() {
		return myPanelStatus;
	}	
	
	public MyPanelAction getMyPanelAction() {
		return myPanelAction;
	}	
	
	public MyTablePerson getMyTablePerson() {
		return myTablePerson;
	}
	
	
	public MyToolBar getMyToolBar() {
		return myToolBar;
	}

	/*
	 * Utilities - Action
	 */
	public void openAction(){
		/*
		 * Selected file dialog
		 */
		JFileChooser chooser = new JFileChooser("C:\\");
	    ExampleFileFilter filter = new ExampleFileFilter();
	    filter.addExtension("txt");		    
	    filter.setDescription("Text file selected");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	/*
	    	 * Read data into list
	    	 */		       
	    	String filePath = chooser.getSelectedFile().getPath();		    	
	    	ArrayListPersonE temp = new ArrayListPersonE();
	    	if (IOTextFile.readData(filePath, temp)){
	    		MyMainFrame.MAIN_STATUS = WHEN_OPEN;
	    		
	    		/*
	    		 * Update into current data
	    		 */
	    		setCurrentFile(filePath);
	    		setListPerson(temp);
	    		getMyTablePerson().setMyData(temp);
	    		/*
	    		 * Update the IHM
	    		 */
	    		myPanelStatus.setStatus(filePath);
	    		myMenu.setMenuEnabled(WHEN_OPEN);	    		
	    		myPanelAction.setActionEnabled(WHEN_OPEN);
	    		myToolBar.setActionEnabled(WHEN_OPEN);
	    		if (getListPerson().size()>0){
	    			getMyTablePerson().setRowSelectionInterval(0,0);
	    		}
	    		getMyTablePerson().revalidate();		    				    		
	    	}
	    }
	}
	
	public void closeAction(){
		this.setCurrentFile("");
		this.getListPerson().clear();
		Person.CURRENT_NUMERO = 1;
		MyMainFrame.MAIN_STATUS = WHEN_START;
		/*
		 * Update the IHM
		 */
		myMenu.setMenuEnabled(WHEN_START);
		myPanelStatus.setStatus("");
		myPanelDetail.clearData();
		myPanelAction.setActionEnabled(WHEN_START);
		myToolBar.setActionEnabled(WHEN_START);
		getMyTablePerson().revalidate();
	}
	
	public void saveAction(){
		IOTextFile.writeData(this.getCurrentFile(), listPerson);
	}
	
	public void saveAsAction(){
		/*
		 * Selected file dialog
		 */
		JFileChooser chooser = new JFileChooser("C:\\");					
	    ExampleFileFilter filter = new ExampleFileFilter();
	    filter.addExtension("txt");		    
	    filter.setDescription("Text file selected");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showSaveDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	/*
	    	 * Read data into list
	    	 */		       		    	
	    	String fileName = chooser.getSelectedFile().getName();
	    	String path = chooser.getCurrentDirectory().getPath();
	    	String filePath = path + IOTextFile.updateFileName(fileName);		    	
	    	if (IOTextFile.writeData(filePath, listPerson)){
	    		/*
	    		 * Update into current data
	    		 */
	    		this.setCurrentFile(filePath);
	    		/*
	    		 * Update the IHM
	    		 */
	    		myPanelStatus.setStatus(filePath);
	    	}
	    }
	}
	
	public void exitAction(){
		if (MyMainFrame.MAIN_STATUS!=0){
			int result = JOptionPane.showConfirmDialog(this, "Do you want to save the data?", 
					"Confirm:", JOptionPane.YES_NO_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION){
				/*
				 * Save the current data firstly
				 */
				IOTextFile.writeData(this.getCurrentFile(), listPerson);
				this.dispose();
				System.exit(0);
			}				
			if (result == JOptionPane.NO_OPTION){				
				this.dispose();
				System.exit(0);
			}
		}else{
			this.dispose();
			System.exit(0);
		}
	}
	
	public void helpAction(){
		MyHelpDialog myHelpDialog = new MyHelpDialog(this);
		myHelpDialog.setVisible(true);
	}
}
