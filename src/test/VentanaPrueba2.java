package test;


import form_builder.XLabel;
import form_builder.Border;
import form_builder.XTextField;
import form_builder.Next_button;
import form_builder.Control;
import form_builder.Windows_form;
import form_builder.NextButton;

@Border(izquierda=50,derecha=0,arriba=50,abajo=0)
public class VentanaPrueba2 extends Windows_form
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;

	
	public VentanaPrueba2(int ancho,int alto,String titulo_ventana)
	{
		super(ancho,alto,titulo_ventana);
		// TODO Auto-generated constructor stub
	}
		//@Button(label="cancelar",orientation=BorderLayout.CENTER,methodName="metodo_boton_cancelar")
		
		
	
		@Control(label="Id Alumno",nombre="label1", type=XLabel.class)
		@Control(nombre="textField1", type=XTextField.class)
		public String linea1;
		
		@Control(label="Nombre",nombre="label2", type=XLabel.class)
		@Control(nombre="textField2", type=XTextField.class)
		public String linea2;
		
		
		@Control(label="Nota",nombre="label3", type=XLabel.class)
		@Control(nombre="textField3", type=XTextField.class)
		public String linea3;
		
		
		@Next_button(nombre="siguiente",next_form="form1",methodName="metodo_next_button2",type=NextButton.class)
		public String boton;
	
	
		public boolean metodo_next_button2(){
			
		return true;	
		}
	

}
