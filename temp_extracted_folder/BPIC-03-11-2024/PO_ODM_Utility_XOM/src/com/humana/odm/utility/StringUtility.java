/**
 * 
 */
package com.humana.odm.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.ofbiz.base.util.UtilValidate;

/**
 * @author RXB4571
 *
 */
public final class StringUtility {

	private final static String LOWERCASE_REGEX = "^(.*[a-z].*)+$";
	private final static String MEDICARE_ID_VALIDATION_REGEX = "^([1-9]{1})((?:(?![SLOIBZ])[A-Z]){1})((?:(?![SLOIBZ])[A-Z0-9]){1})([0-9]{1})((?:(?![SLOIBZ])[A-Z]){1})((?:(?![SLOIBZ])[A-Z0-9]){1})([1-9]{1})((?:(?![SLOIBZ])[A-Z]){2})([1-9]{2})+$";;
	private final static String REMOVE_SPECIAL_CHARACTER_REGEX = "[^a-zA-Z0-9/]";
	private final static String SPACE_CHAR = "";
	private final static String SLASH_CHAR = "/";
	private final static String SPECIAL_CHAR_CHECK = "[$&+,:;=\\\\\\\\?@#|/'<>.^*()%!-]";

	public static String SPECIAL_CHAR_PRESENT_ERROR_MSG = "Bad Input Data:Special char is present inside :";
	
	public static String concatenateWithDelimiter(String str1, String str2, String delimiter) {
        // Check for null values to avoid NullPointerException
        if (str1 == null) {
            str1 = "";
        }
        if (str2 == null) {
            str2 = "";
        }

        // Concatenate strings with the delimiter in between
        return str1 + delimiter + str2;
    }

	public static int getStringLength(String str) {

		try {
			if (null != str) {
				return str.trim().length();
			}
		} catch (Exception e) {

		} finally {
			str = null;
		}
		return 0;
	}

	public static int getStringLength(String str, boolean spaces) {

		try {
			if (null != str) {
				if (spaces)
					return str.trim().length();
				else
					return UtilValidate.stripWhitespace(str).trim().length();
			}
		} catch (Exception e) {

		} finally {
			str = null;
		}
		return 0;
	}

	/* This method is for check whether the zip code is valid or not */

	public static boolean isValidZipCode(String zipCode) {
		String zipCodePattern = "\\d{5}(-\\d{4})?";
		String invalidZipCodes = "00000, 11111, 33333, 66666, 77777, 88888, 99999";
		try {
			if (zipCode.matches(zipCodePattern)) {
				if (invalidZipCodes.contains(zipCode)) {
					return false;
				} else {
					return true;
				}
			}
		} catch (Exception e) {

		} finally {
			zipCode = null;
			zipCodePattern = null;
			invalidZipCodes = null;

		}

		return false;
	}

	/* This method is to check for four digit length string */
	public static boolean isFourDigitLength(String digit) {
		String digitPattern = "^\\d{4}";
		String digitString = null;
		try {
			digitString = String.valueOf(digit);
			return digitString.matches(digitPattern);
		} catch (Exception e) {

		} finally {
			digitString = null;
			digitPattern = null;
			digit = null;

		}

		return false;

	}

	/**
	 * This method is to check if the input string is having Alphabets, special
	 * characters
	 * 
	 * @param inputString
	 *            - Input String
	 * @return boolean - true/false
	 */
	public static boolean isNumeric(String inputString) {

		try {
			return NumberUtils.isDigits(inputString);
		}

		catch (Exception e) {

		} finally {
			inputString = null;

		}

		return false;
	}

	public static String toLowerCase(String text) {
		return text.toLowerCase();
	}

	/*
	 * This method is to validate if Phone or SSN contains specified pattern.
	 */
	public static boolean isValidPhone(String str) {
		String invalidstr = "1234567890, 0987654321, 0000000000, 1111111111, 2222222222, 3333333333, 4444444444, 5555555555, 6666666666, 7777777777, 8888888888, 9999999999";

		try {
			if (invalidstr.contains(str))
				return false;

			else
				return true;
		} catch (Exception e) {

		} finally {
			invalidstr = null;
			str = null;

		}

		return true;
	}

	public static boolean isDummySSN(String str) {
		String invalidstr = "123456789,111111111,222222222,333333333,444444444,555555555,666666666,777777777,888888888,999999999,012345678,987654321";

		try {
			if (invalidstr.contains(str))
				return true;
			else
				return false;
		} catch (Exception e) {

		} finally {
			invalidstr = null;
			str = null;

		}

		return false;
	}

	public static boolean compareStringIgnoringCase(String str1, String str2) {
		boolean compareFlag = false;
		str1 = str1.trim();
		str2 = str2.trim();
		try {
			if (null != str1 && str1.length() > 0 && null != str2 && str2.length() > 0) {
				return str1.equalsIgnoreCase(str2);
			}
		}

		catch (Exception e) {

		} finally {
			str1 = null;
			str2 = null;

		}
		return compareFlag;
	}

	// Strips leading and trailing spaces from a string.
	public static String stripSpaces(String str) {
		return str.trim();
	}

	// Trims string
	public static String trimString(String text, int x) {
		return text.substring(0, x);

	}

	// removes special characters
	public static String removeSpecialCharacters(String text) {
		String removeSpclCharRegEx = "[^a-zA-Z0-9/ ]";
		String spacesChar = "";

		try {
			if (text != null)
				return text.replaceAll(removeSpclCharRegEx, spacesChar);
			else
				return text;
		}

		catch (Exception e) {

		} finally {
			removeSpclCharRegEx = null;
			spacesChar = null;

		}

		return text;
	}

	// removes special characters and numbers
	public static String leaveAlphas(String text) {
		String leaveAlphasRegEx = "[^a-zA-Z ]";
		String spacesChar = "";
		try {
			if (text != null) {
				text = text.replaceAll("-", " ");
				return text.replaceAll(leaveAlphasRegEx, spacesChar);
			} else
				return text;
		} catch (Exception e) {

		} finally {
			leaveAlphasRegEx = null;
			spacesChar = null;

		}
		return text;
	}

	// convert Integer to String value
	public static String IntegerToString(Integer num) {
		return num.toString();
	}

	/**
	 * subStringWithStartEndPosition
	 * 
	 * @param str
	 * @param startPosition
	 * @param endPosition
	 * @return
	 */

	public static String subStringWithStartEndPosition(String str, int startPosition, int endPosition) {

		if (null != str && str.length() >= endPosition)
			return str.substring(startPosition, endPosition);
		else
			return "";

	}

	public static boolean containsListEqualsIgnoreCase(String checkString, List<String> listValues) {
		List<String> lowerCaseValues = new ArrayList<String>(listValues);
		lowerCaseValues.replaceAll(String::toLowerCase);
		return lowerCaseValues.contains(checkString.toLowerCase());
	}

	/**
	 * This method is created for DEP project This method will check whether the
	 * input string contain at least one lower case letter or not
	 */

	public static boolean isStringLowerCase(String str) {
		Pattern p = null;
		Matcher m = null;

		try {
			if (null != str && str.length() > 0) {
				p = Pattern.compile(LOWERCASE_REGEX);
				m = p.matcher(str);
				return m.matches();
			}
		} catch (Exception e) {

		}
		return false;

	}

	/**
	 * This method is created for DEP project This method will convert lower case
	 * string to upper case
	 */
	public static String toUpper(String str) {
		try {
			if (null != str && str.length() > 0) {
				return str.toUpperCase();
			}
		} catch (Exception e) {
		}

		return str;
	}

	/**
	 * This method is created for DEP project This method will validate each
	 * character of Medicare Id
	 */
	public static boolean isValidMedicareId(String str) {
		Pattern p = null;
		Matcher m = null;
		try {
			if (null != str && str.length() > 0) {

				p = Pattern.compile(MEDICARE_ID_VALIDATION_REGEX);
				m = p.matcher(str);
				return m.matches();
			}

		} catch (Exception e) {

		}
		return false;
	}

	/**
	 * This method is created for DEP project This method will remove other than
	 * alphanumeric and remove space anywhere in the string
	 */
	public static String removeSpecialCharactersAndSpace(String input) {
		try {
			if (null != input && input.length() > 0) {
				return (input.replaceAll(SLASH_CHAR, SPACE_CHAR)).replaceAll(REMOVE_SPECIAL_CHARACTER_REGEX,
						SPACE_CHAR);

			} else
				return input;
		}

		catch (Exception e) {

		}

		return input;
	}

	/**
	 * isSpecialCharactersPresent
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isSpecialCharactersPresent(String str, String attributeName) throws Exception {

		SPECIAL_CHAR_PRESENT_ERROR_MSG="Bad Input Data:Special char is present inside :";
		Pattern p = null;
		StringBuilder sb = new StringBuilder(SPECIAL_CHAR_PRESENT_ERROR_MSG);

		boolean specialCharMatch = false;
		try {

			p = Pattern.compile(SPECIAL_CHAR_CHECK, Pattern.CASE_INSENSITIVE);

			Matcher m = p.matcher(str);
			specialCharMatch = m.find();
			if (specialCharMatch == false)
				return specialCharMatch;
			else {
				SPECIAL_CHAR_PRESENT_ERROR_MSG = sb.append(attributeName).toString();
				throw new Exception(SPECIAL_CHAR_PRESENT_ERROR_MSG);
			}

		} catch (Exception e) {
			
			throw new Exception(SPECIAL_CHAR_PRESENT_ERROR_MSG);
		}

	}

}
