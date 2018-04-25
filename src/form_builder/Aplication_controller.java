package form_builder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import javax.swing.*;

public class Aplication_controller extends JFrame
{
	
	/**
	 * 
	 */
	public String borderLayout=BorderLayout.CENTER;
	public String borderLayout_south=BorderLayout.SOUTH;
	private static final long serialVersionUID=1L;
	Hashtable<String, Windows_form> forms = new Hashtable<String, Windows_form>();	
	
	public void load_form(Windows_form form){
		 
		
		(new Class_annotation()).process_annotations_class(form,this);
		
		(new Class_annotation()).process_annotations_variable(form,this);
		
					
		
			
		// se ejecuta el metodo init_form 
		form.init_form();
		}
	
	
	public JPanel set_instance_control(Windows_form form,Annotation unaAnotacion,Field variable ) 
			throws InstantiationException, IllegalAccessException, 
				 IllegalArgumentException, InvocationTargetException,
				 NoSuchMethodException,
				 SecurityException
	{
		
		
		variable.setAccessible(true);
		
		final Control anotacion = (Control) unaAnotacion;
		Class<?> claseAnotacion = anotacion.type();
		 
		
		
		
		if(claseAnotacion == XLabel.class)
		{
			
			Constructor<?> constructor = claseAnotacion.getConstructor(String.class);
				
			return (JPanel)constructor.newInstance(anotacion.label());
		}
		
																						
		
		if(claseAnotacion == XTextArea.class || claseAnotacion == XTextField.class || claseAnotacion == XPasswordField.class)
		{
			Constructor<?> constructor = claseAnotacion.getConstructor();
			
			
			
			return (JPanel)constructor.newInstance();
		}
		
		if(claseAnotacion == XCheckBox.class || claseAnotacion == XComboBox.class || claseAnotacion == XRadioButton.class)
		{
			Object value = variable.get((Object)form);
			Constructor<?> constructor = claseAnotacion.getConstructor(String[].class);
			
			
			return (JPanel)constructor.newInstance(value);
			
		}
	
		
		
		return null;
		
		
		
		
		
	}
	
	
	
	public void add_form(String nombre_form,Windows_form miVentana)
	{
		forms.put(nombre_form,miVentana);
		this.load_form(miVentana);
	}
	 
	public Windows_form get_form(String nombre_form){
				
	return forms.get(nombre_form); 	
	}
	
	
	public void run_form(String nombre_form){
		
		
		this.load_form(forms.get(nombre_form));
				
	}
		
		
}




