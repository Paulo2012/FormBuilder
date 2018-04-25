package form_builder;

import java.awt.Dimension;


import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class XTextArea extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	JTextArea textArea;
	public XTextArea() {
        initUI();
    }
 
	private void initUI() {
				
		textArea = new JTextArea();
	
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		scrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(200, 50));
		add(scrollPane);
	 
    }
	
	public JTextArea get_componente(){
	return textArea;	
		
	}
	
	
}
