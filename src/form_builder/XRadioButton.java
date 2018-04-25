package form_builder;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class XRadioButton extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;

	public XRadioButton(String[] opciones) {
        initUI(opciones);
    }
 
	private void initUI(String[] opciones) {
		ButtonGroup grupo = new ButtonGroup();
		for(String opcion:opciones)
		{
			JRadioButton radioButton = new JRadioButton(opcion);
			grupo.add(radioButton);
			add(radioButton);
		}
	 
    }
}
