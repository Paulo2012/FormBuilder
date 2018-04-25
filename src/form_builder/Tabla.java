package form_builder;
import java.lang.annotation.*;



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Tabla
{

		
		String nombre();
		int cant_filas();
		int ancho();
		int alto();

	
}
