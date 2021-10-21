package validators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import customannotation.Exist;



public class ExistConstraintValidator implements ConstraintValidator<Exist,String>{
	
	public boolean isValid(String name, ConstraintValidatorContext arg1) {
		if(name.equals(null))
			return false;

		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_info","root","tanvi");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select username from details");
		while(rs.next())
		{
			if(rs.getString(1).equals(name))
			{
				return false;
			}
			else
				return true;
		}
		con.close();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return false;
	}
	
	

}
