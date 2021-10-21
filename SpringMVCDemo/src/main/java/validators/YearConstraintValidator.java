package validators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import customannotations.Year;

public class YearConstraintValidator implements ConstraintValidator<Year,Date>{  // validate year validation  of type date

	private int expectedYear; 
	public void initialize(Year year){
		expectedYear=year.value();        //setting the expected year value
	}
	@Override
	public boolean isValid(Date dob, ConstraintValidatorContext arg1) {  //main logic 
		if(dob==null)                   //null check. or u can use notnull annotations
			return false;
		
		Calendar cal= Calendar.getInstance();  //using calendar class
		cal.setTime(dob);                     
		int year = cal.get(Calendar.YEAR);      //getting the year
		System.out.println("dob year: "+year);
		return expectedYear==year;              //checking condition
		
	}

}
