package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class MyPanelStatus extends JPanel {
	/*
	 * Attributes
	 */
	private JLabel labelNameStatus = new JLabel("Status");
	private JLabel labelInfoStatus = new JLabel("");
	private JLabel labelClockStatus = new JLabel();	
	private MyThreadClock myThread = new MyThreadClock();
	
	/*
	 * Constructors
	 */
	public MyPanelStatus(){
		super();
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setLayout(new BorderLayout(2,2));
		labelClockStatus.setPreferredSize(new Dimension(200, 30));	
		labelNameStatus.setPreferredSize(new Dimension(50, 30));
		labelClockStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelNameStatus, BorderLayout.WEST);
		this.add(labelInfoStatus, BorderLayout.CENTER);
		this.add(labelClockStatus, BorderLayout.EAST);
		myThread.start();		
	}
	
	/*
	 * Update status
	 */
	public void setStatus(String status){
		this.labelInfoStatus.setText(status);
	}
	
	/*
	 * Inner class
	 */
	public class MyThreadClock extends Thread{
		/*
		 * Constructor
		 */
		public MyThreadClock(){
			super();			
		}
		/*
		 * Run
		 */
		public void run(){
			while(true){
				Date date = Calendar.getInstance().getTime();				
				labelClockStatus.setText(date.toLocaleString());
				try{
					MyThreadClock.sleep(1000);
				}catch(InterruptedException ie){
					break;
				}
			}
		}
	}
}
