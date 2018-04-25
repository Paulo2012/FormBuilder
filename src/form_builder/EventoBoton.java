package form_builder;

import java.awt.event.*;
import javax.swing.*;

public class EventoBoton implements ActionListener
{

private JTextField cuadroTexto;
	
	
	public EventoBoton (JTextField cuadroTexto)
	{
		this.cuadroTexto=cuadroTexto;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null,cuadroTexto.getText());
		
	}
	

	
	
	
	
}
