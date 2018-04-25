package form_builder;
import java.lang.annotation.*;

@Repeatable(Controls.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Control
{
	String label() default "";
	String nombre();
	Class<?> type();

}
