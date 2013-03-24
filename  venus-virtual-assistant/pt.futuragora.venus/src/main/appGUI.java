package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class appGUI extends JFrame{
	
	//private objects for use in the GUI
	private static JFrame frame;
	private static JPanel panel;
	private static JTextField txtUserMessage;
	private static JLabel lblVenusMessage;
	
	//private variables for external access
	private static String VenusOutput;
	private static String UserMessage;
	private static Boolean newMessage;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					app window = new app();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * Constructor Method; initialises all the window positions, sizes and so on of the bot output text and user input message.
	 */
	public appGUI() {
		initialize();
		appGUI.frame.setVisible(true);
		txtUserMessage.setText("Type here.");
		lblVenusMessage.setText("Please talk with me.");
		newMessage=true;
		//panel.add(lblVenusMessage);
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 12, 426, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][342.00,grow,center][]", "[][][156.00,top][]"));
		
		lblVenusMessage = new JLabel("VenusMessage");
		lblVenusMessage.setVerticalAlignment(SwingConstants.TOP);
		lblVenusMessage.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblVenusMessage, "cell 1 2");
		
		//sets TextField userMessage on the GUI window
		txtUserMessage = new JTextField(); //Creates a new object and assigns to the variable txtUserMessage defined at top of file.
		txtUserMessage.setText("UserMessage");//sets the default user message that shows up inside the TextField in the GUI
		panel.add(txtUserMessage, "cell 1 3,growx");//Adds it to the panel so we can see the actual TextField on screen
		txtUserMessage.setColumns(10);// sets the size of the textField?
		
		//When user press enter what to do with the TextField message
		txtUserMessage.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				UserMessage = txtUserMessage.getText();
				txtUserMessage.setText("");
			}
		});
	}
	public static String getVenusOutput() {
		VenusOutput = lblVenusMessage.getText();
		return VenusOutput;
	}

	public void setVenusOutput(String venusOutput) {
		VenusOutput = venusOutput;
		lblVenusMessage.setText(VenusOutput);
		lblVenusMessage.repaint();
		//panel.add(lblVenusMessage);
	}

	public String getUserMessage() {
		
		return UserMessage;
	}

	public static void setUserMessage(String userMessage) {
		UserMessage = userMessage;
	}
	
	public Boolean getNewMessage() {
		return newMessage;
	}

	public void setNewMessage(Boolean newMessage) {
		appGUI.newMessage = newMessage;
	}

}
