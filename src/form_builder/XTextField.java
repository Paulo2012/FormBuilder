package form_builder;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class XTextField extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	JTextField textField;
	 public XTextField() {
	        initUI();
	    }
	 
	 private void initUI() {
		 
		 	
	        textField = new JTextField();
	        textField.setColumns(10);

	                
	        add(textField);

	    }
	 
	 public JTextField get_componente(){
	 return textField;	 
	 }
	 

	 
}
