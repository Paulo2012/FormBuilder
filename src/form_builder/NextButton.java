package form_builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;




public class NextButton extends JButton
{
    
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	private Aplication_controller controller;
	private String next_form;
	private Windows_form main_form;
	
	public  NextButton(String nombre, String name_next_form,Aplication_controller x,Windows_form form)
	{
		super(nombre);
		this.set_controller(x);
		next_form=name_next_form;
		//this.addActionListener(new Button_listener());
		main_form=form;
	}
	
	public void set_controller(Aplication_controller obj_controller)
	{
		controller = obj_controller;
	}
	
	
	
}

