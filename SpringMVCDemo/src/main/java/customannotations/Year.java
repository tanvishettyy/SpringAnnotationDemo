package customannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import validators.YearConstraintValidator;

@Constraint(validatedBy=YearConstraintValidator.class)//who is going to validate
@Target(ElementType.FIELD)//over which we can use this annotation
@Retention(RetentionPolicy.RUNTIME) //its lifetime by default its class
public @interface Year {
	
	int value();  //exposes the value of Year. its type//variable name not method
    String message() default "invalid year "; //display of message           
    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};
}
