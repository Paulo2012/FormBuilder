package form_builder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class XPasswordField extends JPanel
{
	private static final long serialVersionUID=1L;
	JPasswordField textpass; ;
	 public XPasswordField() {
	        initUI();
	    }
	 
	 private void initUI() {
		 
		 	JLabel labelx = new JLabel();
	        textpass = new JPasswordField();
	        textpass.setColumns(10);


	        
	        add(textpass);

	    }
	 
	 public JPasswordField get_componente(){
	 return textpass;	 
	 }
	
	
}
