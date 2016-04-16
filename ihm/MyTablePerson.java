package ihm;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import data.ArrayListPersonE;
import data.Person;

public class MyTablePerson extends JTable{
	/*
	 * Attributes
	 */
	private MyTableModel myTableModel = new MyTableModel();
	private ArrayListPersonE myData;
	private String[] myHeaders = { "ID", "Name", "Birthdate", "Address" , "P"};
	private Class[] myClass = { Integer.class, String.class, Date.class,
			String.class, Boolean.class };	

	/*
	 * Constructors
	 */
	public MyTablePerson(MyMainFrame myFrame) {
		super();
		this.myData = myFrame.getListPerson();
		this.setModel(myTableModel);
		/*
		 * Display the header
		 */
		this.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 11));
		this.getTableHeader().setPreferredSize(new Dimension(0, 30));
		/*
		 * Display on IHM
		 */
		this.setRowHeight(20);
		this.getColumnModel().getColumn(0).setPreferredWidth(40);
		this.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.getColumnModel().getColumn(2).setPreferredWidth(100);
		this.getColumnModel().getColumn(3).setPreferredWidth(400);
		this.getColumnModel().getColumn(4).setPreferredWidth(20);			
		/*
		 * Add listeners
		 */		
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getSelectionModel().addListSelectionListener(
				new MyListSelectionHandler(myFrame));		
	}
	
	public MyTableModel getMyTableModel() {
		return myTableModel;
	}

	public ArrayListPersonE getMyData() {
		return myData;
	}
	
	public void setMyData(ArrayListPersonE myData) {
		this.myData = myData;
	}

	/*
	 * Inner class
	 */
	class MyListSelectionHandler implements ListSelectionListener {
		/*
		 * Attributes
		 */
		MyMainFrame myFrame;
		/*
		 * Constructors
		 */
		public MyListSelectionHandler(MyMainFrame myFrame){
			this.myFrame = myFrame;
		}
		/*
		 * (non-Javadoc)
		 * @see javax.swing.event.ListSelectionListener
		 * #valueChanged(javax.swing.event.ListSelectionEvent)
		 */
        public void valueChanged(ListSelectionEvent e) {        	
            int index = getSelectedRow();
            if (index>=0){            	
            	myFrame.getMyPanelDetail().updateData(index);
            }
        }
    }
	
	class MyTableModel extends AbstractTableModel {		
		/*
		 * Constructor 
		 */
		public MyTableModel(){
			super();				
		}
		
		/*
		 * Override all default functions
		 */
		public int getColumnCount() {
			return myHeaders.length;
		}

		public String getColumnName(int cols) {
			return myHeaders[cols];
		}

		public Class getColumnClass(int cols) {
			return myClass[cols];
		}

		public int getRowCount() {
			return myData.size();
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		public Object getValueAt(int rows, int cols) {
			Person person = (Person) myData.get(rows);
			switch (cols) {
			case 0:				
				return new Integer(person.getNumero());
			case 1:				
				return person.getName();
			case 2:
				return person.getBirth();
			case 3:
				return person.getAdd();
			case 4:
				return new Boolean(true);
			default:
				throw new RuntimeException("No column selected");
			}
		}		
	}	
}
