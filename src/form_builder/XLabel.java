package form_builder;



import javax.swing.*;

public class XLabel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;

	public XLabel(String label) {
        initUI(label);
    }
 
	private void initUI(String label) {
		JLabel labelx = new JLabel(label);
		add(labelx);	 
    }
}
