package test;

import form_builder.Aplication_controller;
import java.util.List;


import java.awt.*;
import form_builder.Button;

public class AlumnoDBTest
{
	public static void main(String[] args)
	{
		List<Alumno> lst = AlumnosDB.buscarTodos();
		for(Alumno a:lst)
		{
			System.out.println(a.getLegajo()+", "+a.getNombre()+", "+a.getNota());
		}
		
		System.out.println("---");
		
		Alumno x = AlumnosDB.buscarAlumno(2);
		if( x!=null )
		{
			System.out.println(x.getLegajo()+", "+x.getNombre()+", "+x.getNota());			
		}
		else
		{
			System.out.println("Alumno no encontrado");
		}
		
		System.out.println("---");
		int id = AlumnosDB.addAlumno("Jose",10);
		System.out.println("Id Asignado: "+id);
		lst = AlumnosDB.buscarTodos();
		for(Alumno a:lst)
		{
			System.out.println(a.getLegajo()+", "+a.getNombre()+", "+a.getNota());
		}
		System.out.println("---");
		Alumno p = AlumnosDB.buscarAlumno(4);
		System.out.println(p.getLegajo()+", "+p.getNombre()+", "+p.getNota());
		AlumnosDB.updateAlumno(4,"Jose Alberto",9);
		p = AlumnosDB.buscarAlumno(4);
		System.out.println(p.getLegajo()+", "+p.getNombre()+", "+p.getNota());

	//    codigo de inicializacion
		
		
		Aplication_controller controlador = new Aplication_controller();
		VentanaPrueba miVentana = new VentanaPrueba(600,600,"ventana tabla");
		VentanaPrueba2 miVentana2 = new VentanaPrueba2(600,600,"ventana guardar");
		
		
		
		controlador.add_form("form1",miVentana);
		controlador.add_form("form2",miVentana2);
		
		
		miVentana.setVisible(true);
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
