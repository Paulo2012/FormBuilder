package form_builder;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.swing.JPanel;

public class Class_annotation
{
	public String borderLayout=BorderLayout.CENTER;
	public String borderLayout_south=BorderLayout.SOUTH;
	public void process_annotations_class(Windows_form form,Aplication_controller ac)
	{
		
		try	{
			Class<? extends Windows_form> clase_form = form.getClass();
			final Field[] variables = clase_form.getDeclaredFields();
				Annotation[] anotacionesDeClase = clase_form.getAnnotations();
				for (Annotation unaAnotacion: anotacionesDeClase)
				{
					if(unaAnotacion instanceof Border)
					{
						form.set_border_panel(((Border)unaAnotacion).izquierda(),
												((Border)unaAnotacion).derecha(),
												((Border)unaAnotacion).arriba(),
												((Border)unaAnotacion).abajo());
					}
					
					
				}
	
		
		}	
		catch (Exception e ){System.err.println("Error: " + e.getMessage());}
		
	}
	
	
	public void process_annotations_variable(final Windows_form form,Aplication_controller ac)
	{
		
try	{
		Class<? extends Windows_form> clase_form = form.getClass();
		final Field[] variables = clase_form.getDeclaredFields();
					
			for (final Field variable : variables) 
				    {
					final Annotation[] anotacionObtenidas = variable.getAnnotations();
							
								JPanel panelh = new JPanel();
								FlowLayout f = new FlowLayout();
								f.setAlignment(FlowLayout.LEFT);
								panelh.setLayout(f);
							for(Annotation unaAnotacion: anotacionObtenidas)
							{
								
									if(unaAnotacion instanceof Set_aligment){
										f.setAlignment(((Set_aligment)unaAnotacion).value());
										panelh.setLayout(f);
										
									}
									if (unaAnotacion instanceof Tabla){
										variable.setAccessible(true);
										final Tabla anotacion = (Tabla) unaAnotacion;
										Class<XJtable> ClaseXJtable = XJtable.class;
										Constructor<?> constructor =ClaseXJtable.getConstructor(String[].class,
																								int.class, 
																								int.class,
																								int.class);
										Object value = variable.get((Object)form);
										final XJtable tabla=(form_builder.XJtable)constructor.newInstance(value,
																								   anotacion.ancho(),
																								   anotacion.alto(),
																								   anotacion.cant_filas());
										form.add_componente(tabla,anotacion.nombre(),borderLayout);
										
										
											
												
												tabla.addKeyListener( new KeyAdapter()
											       {
											 	      @Override
											 	      public void keyReleased( KeyEvent e ) 
											 	      {
											 	         if( tabla.get_componente().getSelectedRows().length > 0 )
											 	         {
											 	        	form.jtable_key_event(); 
											 	         }
											 	      }
											       
											       });	
									}	
									if (unaAnotacion instanceof Next_button)
									{// te crea un form en el pie del form
										final Next_button anotacion = (Next_button) unaAnotacion;
										Class<?> NextButton=anotacion.type();
										Constructor<?> constructor = NextButton.getConstructor(new Class[]{String.class, 
																							   String.class,
																							   Aplication_controller.class,
																							   Windows_form.class});
										NextButton boton=(form_builder.NextButton)constructor.newInstance(anotacion.nombre(),
																										 anotacion.next_form(),
																										 ac,
																										 form);
										panelh.add(boton);
										form.add(panelh,borderLayout_south);
										Method metodo = clase_form.getMethod(anotacion.methodName());
										
										boton.addActionListener((ActionEvent event) -> {
											try
											{
												if((boolean)metodo.invoke(form))
												{
												Windows_form next_form= ac.get_form(anotacion.next_form());
												next_form.setVisible(true);
												form.setVisible(false);
												Hashtable<String,String> info=form.get_data_component_form();
												next_form.setReceive_data_form(info);
												ac.get_form(anotacion.next_form()).setVisible(true);
												}
											
												
											}
											catch(IllegalAccessException e)
											{
												// TODO Auto-generated catch block
												
												e.printStackTrace();
											}
											catch(IllegalArgumentException e)
											{
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											catch(InvocationTargetException e)
											{
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
								        	
								        });
										
																			
									}	
									
									
									
									if (unaAnotacion instanceof Control)
									{
									
									panelh.add(ac.set_instance_control(form,unaAnotacion,variable),borderLayout);								
									form.add_componente(panelh,((Control)unaAnotacion).nombre(),borderLayout);
									}
									
									if (unaAnotacion instanceof Controls)
									{
										
									    
										Annotation[] lista = ((Controls)unaAnotacion).value();
										for(Annotation x:lista)
											{
											JPanel cp=(JPanel)ac.set_instance_control(form,x,variable);
											form.registrar_componente(((Control)x).nombre(),cp);
											panelh.add((Component)cp);
											}
										form.add(panelh,borderLayout);
										
									}
									
									
									
																		
									if(unaAnotacion instanceof Button)
									{
										variable.setAccessible(true);
										final Button anotacion = (Button) unaAnotacion;
										Simple_button boton = new Simple_button(anotacion.label());
										panelh.add(boton);
										form.add(panelh,anotacion.orientation());
										
										
										Method metodo = clase_form.getMethod(anotacion.methodName());
										
										boton.addActionListener((ActionEvent event) -> {
											try
											{
												metodo.invoke(form);
											}
											catch(IllegalAccessException e)
											{
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											catch(IllegalArgumentException e)
											{
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											catch(InvocationTargetException e)
											{
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
								        	
								        });
										
									}
									
									
							}
						
					 }
			
			
			
			
			}
		catch (Exception e ){System.err.println("Error: " + e.getMessage());}	
		
	}
	
	
	
}
