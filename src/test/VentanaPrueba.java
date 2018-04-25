package test;



import form_builder.Border;
import form_builder.Tabla;
import form_builder.XJtable;
import form_builder.Next_button;
import form_builder.Set_aligment;
import form_builder.Windows_form;
import form_builder.NextButton;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import form_builder.Button;

@Border(izquierda=10,derecha=10,arriba=10,abajo=10)
public class VentanaPrueba extends Windows_form
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;


	public VentanaPrueba(int ancho,int alto,String titulo_ventana)
	{
		super(ancho,alto,titulo_ventana);
		// TODO Auto-generated constructor stub
				
	}
    
	
	
	
	@Set_aligment(value=FlowLayout.CENTER)
	@Tabla(nombre="tabla1",cant_filas=20,ancho=500,alto=200)
	public String[] columnas ={"id","nombre","nota"};
	
	
	@Next_button(nombre="siguiente",next_form="form2",methodName="metodo_next_button",type=NextButton.class)
	public String boton;
	
	
	public boolean metodo_next_button(){
		
		
	return true;	
	}
	
	@Override
	public void init_form()
	{
		AlumnosDB alum = new AlumnosDB();
		
		XJtable tabla = (XJtable)componentes.get("tabla1");
		TableModel  modelo=  (TableModel)tabla.get_componente().getModel();
		//System.out.println();
		//ArrayList<?> a= (ArrayList<?>)alum.buscarTodos()
		//model;
		
		
	}
	
	

}
