package form_builder;


import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class XCheckBox extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;

	public XCheckBox(String[] opciones) {
        initUI(opciones);
    }
 
	private void initUI(String[] opciones) {
		
		
		
		for(String opcion:opciones)
		{
			JCheckBox chekBox = new JCheckBox(opcion);
			add(chekBox);
		}
	 
    }
}
