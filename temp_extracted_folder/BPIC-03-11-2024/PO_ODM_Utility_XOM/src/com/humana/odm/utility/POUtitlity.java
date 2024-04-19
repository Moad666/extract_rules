/**
 * 
 */
package com.humana.odm.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author VXY7376
 * 
 */
public final class POUtitlity {

	/**
	 * For validating email address
	 * 
	 * @param email
	 * @return
	 */
	public static Boolean isValidEmailAddress(String email) {
		
		
		String EMAIL_REGEX = "^[\\S\\-_\\.+]*[\\S\\-_\\.]\\@(?!.*_.*)([\\w-]+\\.)+[A-Za-z]+[A-Za-z]$";
		
		try{
			return email.matches(EMAIL_REGEX);
		}
		
		catch(Exception e)
		{
			
		}
		finally{
			EMAIL_REGEX=null;
			email=null;
		}
			return false;
	}

	/**
	 * @param birthdate
	 * @return Age from the current date
	 */
	public static Integer getAgeOfMemeber(Date birthdate) {
		return getAge(Calendar.getInstance().getTime(), birthdate);
	}

	/**
	 * Calculating age from a current date
	 * 
	 * @param current
	 * @param birthdate
	 * @return Age from the current (arg) date
	 */
	public static Integer getAge(Date current, Date birthdate) {

		if (birthdate == null) {
			return 0;
		}
		if (current == null) {
			return getAgeOfMemeber(birthdate);
		} else {
			final Calendar calend = new GregorianCalendar();
			calend.set(Calendar.HOUR_OF_DAY, 0);
			calend.set(Calendar.MINUTE, 0);
			calend.set(Calendar.SECOND, 0);
			calend.set(Calendar.MILLISECOND, 0);

			calend.setTimeInMillis(current.getTime() - birthdate.getTime());

			int result = 0;
			result = calend.get(Calendar.YEAR) - 1970;
			result += calend.get(Calendar.MONTH) / (float) 12;
			//System.out.println(result);
			return result;
		}

	}

	/**
	 * For validating name
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isValidName(String name) {
		String NAME_REGEX = "^[a-zA-Z\\s-]*$";
		
		
		try{
			return name.matches(NAME_REGEX);
		}
		catch(Exception e)
		{
			
		}
		finally{
			NAME_REGEX=null;
			name=null;
		}
		return false;
		
	}

	/**
	 * validate Date Format
	 * 
	 * @param dateFormat
	 * @param date
	 * @return
	 */
	public static Boolean isValidDate(String dateFormat, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try {
			sdf.parse(date.toString());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	/**
	 * validate SSN
	 * 
	 * // ^(?!(000|666|9))\\d{3}[- ](?!00)\\d{2}[- ](?!0000)\\d{4}$ //
	 * ^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$ //
	 * ^(?!(000|666|9))\\d{3}[- ]?\\d{2}[- ]?\\d{4}$
	 * 
	 * @param ssn
	 * @return
	 */
	public static boolean isSSNValid(String ssn) {

		String expression = "^(?!000|666)[0-8][0-9]{2}(-?)(?!00)[0-9]{2}(-?)(?!0000)[0-9]{4}$";
		try{
				CharSequence inputStr = ssn;
				Pattern pattern = Pattern.compile(expression);
				Matcher matcher = pattern.matcher(inputStr);
				if (matcher.matches()) {
					
					return true;
				}
				return false; 
					
		}
		catch(Exception e)
		{
			
		}
		finally{
			expression=null;
			ssn=null;
		}
		return false;
	}

	/**
	 * For validating middle initial
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isValidMiddleInitial(String initial) {
		String MIDDLE_INITIAL_REGEX = "([a-zA-Z]+)*";
		
		try{
			return initial.matches(MIDDLE_INITIAL_REGEX);
		}
		catch(Exception e)
		{
			
		}
		finally{
			initial=null;
			MIDDLE_INITIAL_REGEX=null;
		}
		return false;
	}

	/**
	 * validate Zip Code
	 * 
	 * @param zip
	 * @return
	 */
	public static boolean isZipCodeValid(String zip) {
		String expression = "^\\d*$";
		try{
				CharSequence inputStr = zip;
				Pattern pattern = Pattern.compile(expression);
				Matcher matcher = pattern.matcher(inputStr);
				if (matcher.matches()) {
					return true;
				}
				else
					return false;
		}
		catch(Exception e)
		{
			
		}
		finally{
			expression=null;
			zip=null;
		}
		return false;
	}

	/**
	 * validate Phone Number
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static boolean isPhoneNumberValid(String phoneNumber) {
		String expression = "^\\d{10}$";
		try{
				CharSequence inputStr = phoneNumber;
				Pattern pattern = Pattern.compile(expression);
				Matcher matcher = pattern.matcher(inputStr);
				if (matcher.matches()) {
					return true;
				}else
					return false;
		}
		
		catch(Exception e)
		{
			
		}
		finally{
			expression=null;
			phoneNumber=null;
		}
		
		return false;
	}

	/**
	 * This Method is unit tested properly for very different cases , taking
	 * care of Leap Year days difference in a year, and date cases month and
	 * Year boundary cases (12/31/1980, 01/01/1980 etc)
	 **/

	public static int calculateAge(Date dateOfBirth) {

		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		int age = 0;
		if (null == dateOfBirth) {
			return 0;
		}
		birthDate.setTime(dateOfBirth);
		if (birthDate.after(today)) {
			// throw new
			// IllegalArgumentException("Can't be born in the future");
			return 0;
		}

		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		// If birth date is greater than todays date (after 2 days adjustment of
		// leap year) then decrement age one year
		if ((birthDate.get(Calendar.DAY_OF_YEAR)
				- today.get(Calendar.DAY_OF_YEAR) > 3)
				|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
			age--;

			// If birth date and todays date are of same month and birth day of
			// month is greater than todays day of month then decrement age
		} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (birthDate.get(Calendar.DAY_OF_MONTH) > today
						.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}
		//System.out.println("Age is " + age);
		return age;
	}

	/**
	 * THis method check whether incoming value is String
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		try {
			if (null != str) {
				@SuppressWarnings("unused")
				double d = Double.parseDouble(str);
			} else {
				return false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * To check if the incoming value is alphanumeric
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAlphaNumeric(String value) {
		String ALPHA_NUMERIC_REGEX = "^[a-zA-Z0-9]*$";
		try{
			if (null != value) {
				return value.matches(ALPHA_NUMERIC_REGEX);
			} else {
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			ALPHA_NUMERIC_REGEX=null;
			value=null;
		}
		return false;
	}

	/**
	 * To check if the incoming value is alphanumeric and space
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAlphaNumericWithSpace(String value) {
		String ALPHA_NUMERIC_SPACE_REGEX = "^[a-zA-Z0-9\\s]*$";
		try{
				if (null != value) {
					return value.matches(ALPHA_NUMERIC_SPACE_REGEX);
				} else {
					return false;
				}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			ALPHA_NUMERIC_SPACE_REGEX=null;
			value=null;
		}
		return false;
	}

	/**
	 * To check if the incoming value is alphanumeric and space and with atleast
	 * one character
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAlphaNumericWithatleastOneChar(String value) {
		String ALPHA_NUMERIC_SPACE_REGEX = "^[a-zA-Z][a-zA-Z0-9\\s]*$";
		try{
			if (null != value) {
				return value.matches(ALPHA_NUMERIC_SPACE_REGEX);
			} else {
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			ALPHA_NUMERIC_SPACE_REGEX=null;
			value=null;
		}
		return false;
	}
	/**
	 * To check if the incoming value is not null and
	 * should be a number
	 * 
	 * @param fieldName
	 * @return
	 */

	public static boolean isDoubleFieldNull(Double fieldName) {
		boolean matched = false;
		
		if (null == fieldName  || fieldName.isNaN())
			matched = true;
		
		return matched;
	}
	 /**
		 * This method is created for DEP project to check exception flow
		 * This method will convert string to integer
		 */
	public static Integer convertStringToInteger(String str) {
	Integer intObj=null;
	try {
		if(null!=str && str.length()>0) {
		
			intObj=Integer.parseInt(str);
			
	}}
	catch(Exception e) {
	}
	return intObj;
	
	}
}
