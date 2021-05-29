import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LogIn {
	JTextField user_name;
    JTextField password;
    String usernameString;
    String passwordString;
    LogIn() 
    {
  
        user_name = new JTextField(10);
        password = new JTextField(10);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.add(new JLabel("Username:"));
        panel.add(user_name);
        panel.add(new JLabel("Password:"));
        panel.add(password);
        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
        	usernameString = user_name.getText();
        	passwordString = password.getText();
        	System.out.println(usernameString + "\n" + passwordString);
        } else {
        	System.out.println("Cancelled");
        }
    }
	
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable()
        {
              public void run()
              {
                    new LogIn();
              }
        });
    }
}
