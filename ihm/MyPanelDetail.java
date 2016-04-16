package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import data.Person;

public class MyPanelDetail extends JPanel{	
	/*
	 * Attributes
	 */
	public JTextField 	txfIdPerson = new JTextField("");
	public JTextField 	txfName = new JTextField("");	
	public JTextField 	txfAddress = new JTextField("");
	public JDateChooser txfBirth = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');	
	private MyMainFrame myFrame;
	
	/*
	 * Constructor
	 */
	public MyPanelDetail(MyMainFrame myFrame){
		super();
		this.myFrame = myFrame;
		/*
		 * Initialization
		 */
		this.setBorder
		(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Data detail:", 
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));			
		this.setLayout(new GridLayout(2, 4, 10, 10));
		/*
		 * Label - Text box
		 */
		JLabel lblidPerson = new JLabel("idPerson:");
		JLabel lblName = new JLabel("Name:");
		JLabel lblBirth = new JLabel("Birth:");
		JLabel lblAddress = new JLabel("Address:");
		
		txfIdPerson.setColumns(20);
		txfName.setColumns(20);
		txfBirth.setPreferredSize(new Dimension(30,20));
		txfAddress.setColumns(20);
		txfIdPerson.setEditable(false);
		
		this.add(lblidPerson);
		this.add(txfIdPerson);		
		this.add(lblName);
		this.add(txfName);
		this.add(lblBirth);
		this.add(txfBirth);
		txfBirth.getJCalendar().setTodayButtonVisible(true);
		this.add(lblAddress);
		this.add(txfAddress);	
		this.clearData();
	}
	
	/*
	 * Update data
	 */
	public void updateData(int index){
		Person p = (Person)myFrame.getListPerson().get(index);
		txfIdPerson.setText("" + p.getNumero());
		txfName.setText(p.getName());
		txfBirth.setDate(p.getBirth());
		txfAddress.setText(p.getAdd());
	}
	
	/*
	 * Clear data
	 */
	public void clearData(){		
		txfIdPerson.setText("");
		txfName.setText("");
		txfBirth.setDate(null);
		txfAddress.setText("");
	}	
}
