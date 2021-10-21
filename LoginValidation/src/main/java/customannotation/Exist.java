package customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import validators.ExistConstraintValidator;


@Constraint(validatedBy=ExistConstraintValidator.class)	//who is going to validate
@Target(ElementType.FIELD)							    //over which we can use this annotation
@Retention(RetentionPolicy.RUNTIME)						//its lifetime by default its class
public @interface Exist {


	String message () default "User Exist ";
	 Class<?>[]groups() default {};
	 Class<? extends Payload>[] payload() default {};
	
}
