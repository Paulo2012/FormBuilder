package form_builder;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Next_button
{

	String nombre();
	String next_form();
	String methodName();
	Class<NextButton> type();
	

}
