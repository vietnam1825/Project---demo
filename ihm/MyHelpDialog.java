package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MyHelpDialog extends JDialog implements ActionListener{
	/*
	 * Attributes
	 */
	private JButton btnCloseD = new JButton("Close");	
	/*
	 * Constructors
	 */
	public MyHelpDialog(MyMainFrame myFrame){
		super(myFrame);
		/*
		 * IHM - Show
		 */
		setResizable(false);
		setTitle("About me ...");
		setBounds(myFrame.getLocation().x + 200,
				myFrame.getLocation().y + 250, 400, 200);
		getContentPane().setLayout(new BorderLayout(2,2));
		/*
		 * IHM
		 */
		URL iconURL = this.getClass().getResource("../images/overview.gif");
		JLabel myLabelImage = new JLabel(new ImageIcon(iconURL));
		JTextArea myTextArea = new JTextArea();
		this.getContentPane().add(myLabelImage, BorderLayout.WEST);
		this.getContentPane().add(myTextArea, BorderLayout.CENTER);
		this.getContentPane().add(btnCloseD, BorderLayout.SOUTH);
		
		myTextArea.setEditable(false);
		myTextArea.setBackground(myLabelImage.getBackground());
		myTextArea.setForeground(Color.RED);
		/*
		 * Data
		 */
		myTextArea.setFont(new Font("Times New Roman", Font.BOLD, 13));
		myTextArea.setText("\n\n");
		myTextArea.append("\t Created by: Nguyen Trong Phuc\n\n");		
		myTextArea.append("\t Date created: 2012-03-15\n\n");
		myTextArea.append("\t Last modified: 2012-03-30\n");
		/*
		 * Action listeners
		 */
		btnCloseD.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(btnCloseD)){
			this.setVisible(false);
		}
		
	}
}
