package model;

import javax.validation.ConstraintViolation;
import javax.validation.Payload;

public class Severity {
	
	public static class Info implements Payload
	{
		void onInfo(ConstraintViolation violation)
		{
			System.out.println("Violation on severity level: INFO");
		}
		
	}

	public static class Error implements Payload
	{
		void onError(ConstraintViolation violation)
		{
			System.out.println("Violation on severity level: Error");
			sendEmail(violation);
		}
	}
	
	public static void sendEmail(ConstraintViolation violation)
	{
		System.out.println("Sending email to hr"+ violation.getMessage());
	}
}

