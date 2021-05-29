import java.awt.*;
import javax.swing.*;

public class Request {
    JTextField app_title;
    JTextField link;
    Request() 
    {
  
        app_title = new JTextField(10);
        link = new JTextField(10);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.add(new JLabel("App title:"));
        panel.add(app_title);
        panel.add(new JLabel("Link to App:"));
        panel.add(link);
        int result = JOptionPane.showConfirmDialog(null, panel, "Test",
        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
        	System.out.println(app_title.getText() + "\n" + link.getText());
        } else {
        	System.out.println("Cancelled");
        }
    }
	
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable()
        {
              public void run()
              {
                    new Request();
              }
        });
    }
}
