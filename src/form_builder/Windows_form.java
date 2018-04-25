package form_builder;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Enumeration;
import java.util.Hashtable;

public class Windows_form extends JFrame
{
/**
	 * 
	 */
	private static final long serialVersionUID=1L;
String nombreForm;
JPanel panel_principal;
JPanel panel_inferior;
Container c;


public Hashtable<String,JPanel> componentes = new Hashtable<String,JPanel>();
public Hashtable<String,String> receive_data_form = new Hashtable<String,String>();

public Windows_form(int ancho,int alto,String titulo_ventana)
	{
	super(titulo_ventana);
	setSize(alto,ancho);
	setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    c = getContentPane();
    
    panel_principal = new JPanel();
   
    panel_principal.setLayout(new BoxLayout(panel_principal, BoxLayout.Y_AXIS));
 
    
    
    
    panel_inferior = new JPanel();
    panel_inferior.setLayout(new FlowLayout());
	}



public Hashtable<String,String> getReceive_data_form()
{
	return receive_data_form;
}

public void set_border_panel(int izquierda,int derecha,int arriba,int abajo)
{
	
		panel_principal.setBorder(BorderFactory.createEmptyBorder(arriba,izquierda,abajo,derecha));
	
	
}

public void setReceive_data_form(Hashtable<String,String> receive_data_form)
{
	this.receive_data_form=receive_data_form;
}



public void add(JPanel componente,String borderlayout)
{
		
	
	
	if (borderlayout.equals(BorderLayout.CENTER) )
		{
		
		panel_principal.add(componente);
		c.add(panel_principal,BorderLayout.CENTER);
		}
	else{
		panel_inferior.add(componente);
		c.add(panel_inferior,borderlayout);
		}

}

public void registrar_componente(String nombre,JPanel componente){
	
	componentes.put(nombre,componente);	
}



public void add_componente(JPanel componente, String nombre,String borderLayout){
	
registrar_componente(nombre,componente);
this.add(componente,borderLayout);
		
}

public JPanel get_componente(String nombre){
	
return componentes.get(nombre);	
}

public String getNombreForm()
{
	return nombreForm;
}

public void setNombreForm(String nombreForm)
{
	this.nombreForm=nombreForm;
}

public void init_form(){}

public void jtable_key_event(){};

public Hashtable<String,String>  get_data_component_form()
{
	Hashtable<String,String> resultado = new Hashtable<String,String>();
	
	Enumeration<String> e=componentes.keys();
	String clave;
	
	
	
	while (e.hasMoreElements())
	{
					
					
		            clave= e.nextElement();
		            
		            JPanel j=componentes.get(clave);
		            
		           	            
						 if(j instanceof XTextArea)
						 {
				                resultado.put(clave,((XTextArea)j).get_componente().getText());
				                
				                
				         }
						 
						 if(j instanceof XTextField)
						 {
				                resultado.put(clave,((XTextField)j).get_componente().getText());
				                
				                
				         }
						 if(j instanceof XComboBox)
						 {
				                resultado.put(clave,((XComboBox)j).get_componente().getSelectedItem().toString());
				               
				                
				         }
						 
						 if(j instanceof XPasswordField){
							 
							 
							 resultado.put(clave,String.valueOf(((XPasswordField)j).get_componente().getPassword()));
						 }
	
	}

return resultado;	
}

	
}
