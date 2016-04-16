package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import data.Person;

public class MyPanelAction extends JPanel implements ActionListener {
	/*
	 * Attributes
	 */
	private JButton btnInsert = new JButton("Insert");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnModify = new JButton("Modify");
	private MyMainFrame myFrame;
	/*
	 * Constructors
	 */	
	public MyPanelAction(MyMainFrame _myFrame){
		super();		
		this.myFrame = _myFrame;
		
		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "", 
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));		
		
		btnInsert.setMnemonic(KeyEvent.VK_I);
		btnInsert.addActionListener(this);
		this.add(btnInsert);
				
		btnDelete.setMnemonic(KeyEvent.VK_D);
		btnDelete.addActionListener(this);
		this.add(btnDelete);
		
		btnModify.setMnemonic(KeyEvent.VK_M);
		btnModify.addActionListener(this);
		this.add(btnModify);
		
		this.setActionEnabled(MyMainFrame.MAIN_STATUS);		
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();		
		if (command.equals(btnInsert.getText())){
			MyPanelDetail myPanelDetail = myFrame.getMyPanelDetail();
			String name = myPanelDetail.txfName.getText().trim();			
			Date birth = myPanelDetail.txfBirth.getDate();
			String add = myPanelDetail.txfAddress.getText().trim();
			if (name.equals("") || birth==null){
				JOptionPane.showMessageDialog(myFrame, "Error: data is invalid.");
			}else{								
				int result = JOptionPane.showConfirmDialog(myFrame, "Do you want to insert new person?", 
							"Confirm:", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.OK_OPTION){
					Person p = new Person(name, birth, add);
					myFrame.getListPerson().addPerson(p);						
					int index = myFrame.getListPerson().size() - 1;
					myFrame.getMyTablePerson().setRowSelectionInterval(index,index);
					myFrame.getMyTablePerson().revalidate();
				}
			}
		}
		if (command.equals(btnDelete.getText())){
			int index = myFrame.getMyTablePerson().getSelectedRow();
			if (index>=0){
				int result = JOptionPane.showConfirmDialog(myFrame, "Do you want to delete this person?", 
						"Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.OK_OPTION){
					myFrame.getListPerson().removePerson(index+1);
					myFrame.getMyTablePerson().getSelectionModel().clearSelection();
					/*
					 * Selection
					 */
					int size = myFrame.getListPerson().size();
					if (index<size){
						myFrame.getMyTablePerson().setRowSelectionInterval(index,index);
					}else{
						if (size>0){
							myFrame.getMyTablePerson().setRowSelectionInterval(0,0);
						}
					}
					myFrame.getMyTablePerson().revalidate();
				}				
			}
		}
		if (command.equals(btnModify.getText())){
			int index = myFrame.getMyTablePerson().getSelectedRow();
			if (index>=0){				
				MyPanelDetail myPanelDetail = myFrame.getMyPanelDetail();
				String name = myPanelDetail.txfName.getText().trim();			
				Date birth = myPanelDetail.txfBirth.getDate();
				String add = myPanelDetail.txfAddress.getText().trim();
				if (name.equals("") || birth==null){
					JOptionPane.showMessageDialog(myFrame, "Error: data is invalid.");
				}else{
					int result = JOptionPane.showConfirmDialog(myFrame, "Do you want to modify this person?", 
							"Confirm:", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.OK_OPTION){
						Person p = myFrame.getListPerson().getPerson(index+1);
						p.setData(name, birth, add);		
						myFrame.getMyTablePerson().getMyTableModel().fireTableRowsUpdated(index, index);
						myFrame.getMyTablePerson().revalidate();
					}
				}
			}
		}
	}
	
	/*
	 * Set enable when needed
	 */
	public void setActionEnabled(int status){		
		switch (status){
		case MyMainFrame.WHEN_START:			
			btnInsert.setEnabled(false);
			btnDelete.setEnabled(false);
			btnModify.setEnabled(false);
			break;
		case MyMainFrame.WHEN_OPEN:
			btnInsert.setEnabled(true);
			btnDelete.setEnabled(true);
			btnModify.setEnabled(true);
			break;
		default:
			break;				
		}
	}
	
}
