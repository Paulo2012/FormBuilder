package form_builder;



import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class XComboBox extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	@SuppressWarnings("rawtypes")
	JComboBox combo = new JComboBox();
	public XComboBox(String[] opciones) {
        initUI(opciones);
    }
 
 @SuppressWarnings("unchecked")
private void initUI(String[] opciones) {
	 
	 	
	 	
	 	for(int i=0; i<opciones.length; i++)
		{
			combo.addItem(opciones[i]);
		}
	 	
	 	       
        add(combo);
        

    }
 
 
 
 public JComboBox get_componente(){
		return combo;	
			
		}
 
 
}
