package com.humana.odm.utility;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ofbiz.base.util.UtilValidate;

public final class CommonUtility {

	/* This method is to check whether the input SSN is valid or not */
	public static boolean isValidSSN(String ssn) {

		String regex = "^(?!000)[0-9]{3}(-?)[0-9]{2}(-?)(?!0000)[0-9]{4}$";
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(ssn);
			return matcher.matches();
		} catch (Exception e) {

		} finally {
			regex = null;
			ssn = null;
		}

		return false;
	}

	public static Date currentDate() {

		return new Date();
	}

	public static int incrementNumber(int number, int incrementBy) {
		return number + incrementBy;
	}

	public static boolean areEquals(String str1, String str2) {
		try {

			return UtilValidate.areEqual(str1, str2);
		}

		catch (Exception e) {

		} finally {
			str1 = null;
			str2 = null;
		}
		return false;
	}
	/* This method is to check whether the entered zipCode is valid zipCode */

	public static boolean isValidZipCode(String zipCode) {
		String invalidZipCodes = "00000, 11111, 33333, 66666, 77777, 88888, 99999";
		try {
			if (UtilValidate.isZipCode(zipCode)) {
				if (invalidZipCodes.contains(zipCode)) {
					return false;
				} else {
					return true;
				}
			}
		} catch (Exception e) {

		} finally {
			invalidZipCodes = null;
			zipCode = null;
		}
		return false;
	}

	/* this method is to check the input value is an integer or not */
	public static boolean isInteger(String inputString) {
		try {
			return UtilValidate.isInteger(inputString);
		} catch (Exception e) {

		} finally {
			inputString = null;
		}
		return false;
	}

	/* This method is to check whether the input string is alpha numeric */

	public static boolean isAlphaNumeric(String inputString) {
		try {
			return UtilValidate.isAlphanumeric(UtilValidate.stripWhitespace(inputString));
		} catch (Exception e) {

		} finally {
			inputString = null;
		}
		return false;
	}

	/* This method is to check whether the input string is alphabetic */

	public static boolean isAlphabetic(String inputString) {
		try {
			return UtilValidate.isAlphabetic(UtilValidate.stripWhitespace(inputString));
		} catch (Exception e) {

		} finally {
			inputString = null;
		}
		return false;
	}

	/* This method is to check whether the input string is having white spaces */

	public static boolean isWhiteSpace(String inputString) {

		try {
			return UtilValidate.isWhitespace(inputString);
		} catch (Exception e) {

		} finally {
			inputString = null;
		}
		return false;

	}

	public static boolean isEmailAddressValid(String emailAddress) {

		try {
			return UtilValidate.isEmail(emailAddress);
		} catch (Exception e) {

		} finally {
			emailAddress = null;
		}
		return false;

	}

	public static boolean isThreeDigitAreaCodeValid(String phoneNumber) {
		String invalidAreasCodes = "911,555,000";
		try {
			if (null != phoneNumber && phoneNumber.length() == 10) {
				if (invalidAreasCodes.contains(phoneNumber.substring(0, 3))) {
					return false;
				}
			}
		} catch (Exception e) {

		} finally {
			phoneNumber = null;
			invalidAreasCodes = null;
		}
		return true;
	}

	/* This method checks whether the entered state is valid USA State */
	public static boolean isValidUSStateCode(String state) {

		try {
			return UtilValidate.isStateCode(state.toUpperCase());
		} catch (Exception e) {

		} finally {
			state = null;
		}
		return false;
	}

	/* This method is for calculating age */
	public static int calculateAge(Date birthdate) {

		String dateFormat = "MM/dd/yyyy";
		if (null == birthdate) {
			return 0;
		}
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		format.format(birthdate);
		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();
		int age = 0;
		try {
			birthDate.setTime(birthdate);
			if (birthDate.after(today)) {
				// throw new
				// IllegalArgumentException("Can't be born in the future");
				return 0;
			}
			age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
			// If birth date is greater than todays date (after 2 days adjustment of
			// leap year) then decrement age one year
			if ((birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3)
					|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
				age--;
				// If birth date and todays date are of same month and birth day of
				// month is greater than todays day of month then decrement age
			} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		} catch (Exception e) {

		}

		dateFormat = null;

		return age;
	}

	/* This method is for calculating age */
	public static int calculateAgeAtEffectiveDate(Date birthdate, Date effectiveDate) {
		String dateFormat = "MM/dd/yyyy";
		int age = 0;
		if (null == birthdate) {
			return 0;
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			format.format(birthdate);
			Calendar groupEffectiveDate = Calendar.getInstance();
			groupEffectiveDate.setTime(effectiveDate);
			Calendar birthDate = Calendar.getInstance();
			birthDate.setTime(birthdate);
			if (birthDate.after(groupEffectiveDate)) {
				// throw new
				// IllegalArgumentException("Can't be born in the future");
				return 0;
			}
			age = groupEffectiveDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
			// If birth date is greater than todays date (after 2 days adjustment of
			// leap year) then decrement age one year
			if ((birthDate.get(Calendar.DAY_OF_YEAR) - groupEffectiveDate.get(Calendar.DAY_OF_YEAR) > 3)
					|| (birthDate.get(Calendar.MONTH) > groupEffectiveDate.get(Calendar.MONTH))) {
				age--;
				// If birth date and todays date are of same month and birth day of
				// month is greater than todays day of month then decrement age
			} else if ((birthDate.get(Calendar.MONTH) == groupEffectiveDate.get(Calendar.MONTH))
					&& (birthDate.get(Calendar.DAY_OF_MONTH) > groupEffectiveDate.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		} catch (Exception e) {

		}

		dateFormat = null;

		return age;
	}

	/* This method is for calculating Years Of Service */
	public static int yearsOfService(Date dateOfHire) {
		int yearsOfService = 0;
		String dateFormat = "MM/dd/yyyy";
		if (null == dateOfHire) {
			return 0;
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			format.format(dateOfHire);
			Calendar today = Calendar.getInstance();
			Calendar hireDate = Calendar.getInstance();

			hireDate.setTime(dateOfHire);
			if (hireDate.after(today)) {
				return 0;
			}
			yearsOfService = today.get(Calendar.YEAR) - hireDate.get(Calendar.YEAR);
			// If hire date is greater than todays date (after 2 days adjustment of
			// leap year) then decrement year of hire one year
			if ((hireDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3)
					|| (hireDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
				yearsOfService--;
				// If hire date and todays date are of same month and hire day of
				// month is greater than todays day of month then decrement year of hire
			} else if ((hireDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (hireDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH))) {
				yearsOfService--;
			}
		} catch (Exception e) {

		}

		dateFormat = null;

		return yearsOfService;
	}

	public static float calculatePercentage(int partNumber, int totalNumber) {
		return ((partNumber * 100) / totalNumber);
	}

	// Checks if string is alphanumeric with exception to specChars
	public static boolean isSpecialCharacters(String text) {
		String specChars = "[/]";
		String space = "";
		String temp = null;
		try {
			temp = text.replaceAll(specChars, space);
			return UtilValidate.isAlphanumeric(UtilValidate.stripWhitespace(temp));

		} catch (Exception e) {

		} finally {
			text = null;
			specChars = null;
			temp = null;

		}
		return false;
	}

	public static boolean isInteger(Integer num) {
		String text = num.toString();
		try {
			if (UtilValidate.isInteger(text))
				return true;
		} catch (Exception e) {

		} finally {
			text = null;
		}

		return false;
	}

	public static boolean isBigDecimalZero(BigDecimal num) {
		boolean flag = false;

		if (null == num) {
			num = new BigDecimal(0);
		}

		if ((null != num) && (num.compareTo(BigDecimal.ZERO) == 0)) {
			flag = true;
		}

		return flag;

	}

	public static Integer SetNullNumber(Integer num) {
		return num = null;

	}

	public static boolean isNullNumber(Integer num) {
		boolean flag = false;
		if (num == null)
			flag = true;
		else
			flag = false;
		return flag;
	}

}
