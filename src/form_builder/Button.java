package form_builder;
import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Button
{
	String label();
	String orientation();
	String methodName();

}
