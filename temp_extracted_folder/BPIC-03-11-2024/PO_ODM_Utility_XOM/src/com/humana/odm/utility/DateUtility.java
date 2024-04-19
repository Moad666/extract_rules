/**
 * 
 */
package com.humana.odm.utility;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author cxa9177
 * 
 */
public final class DateUtility {
	private final static String NA = "NA";

	private final static String TIME_FORMAT = "HH:mm:ss";
	private final static DateTime OPEN_ENDED_DATE = new DateTime(9999, 12, 31, 0, 0, 0, 0);
	private final static String DATE_FORMAT_FOR_IIB = "yyyy-MM-dd hh:mm:ss";
	private final static String COMMON_DATE_FORMAT = "MM/dd/yyyy"; // "MM/dd/yyyy"
																	// "MM/dd/yyyy"

	private final static String CONVERTEDTOUTC_METHOD_DATE_FORMAT = "yyyy-MM-dd";
	private final static String CONVERTEDTOUTC_METHOD_TIMEZONE_UTC = "UTC";
	private final static String CONVERTSTRINGTODATE_METHOD_DATEFORMAT = "yyyy-mm-dd hh:mm:ss";

	private final static String SUNDAY = "Sunday";
	private static final String[] DATE_FORMATS = { "yyyy/MM/dd", "dd-MMM-yy", "yyyy-MM-dd" };

	private final static int DAY = 1;
	private final static String DATE_FORMAT_CHECK = ("[0-9]{4}[-][0-9]{2}[-][0-9]{2}");
	private static final String DATE_FORMAT = "MM/dd";

	public static Boolean IsEffectiveEndDateOpenEnded(Date effectiveEndDate) {
		boolean valid = false;
		try {
			if (null != effectiveEndDate) {
				DateTime effEndDate = new DateTime(effectiveEndDate);
				if (OPEN_ENDED_DATE.isEqual(effEndDate))
					valid = true;
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return valid;
	}

	public static Date currentDate() {
		return new Date();
	}

	public static boolean isIncomingDateFutureDate(Date incomingDate) {
		try {
			if (null != incomingDate) {
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, 1);
				Date tomorrow = calendar.getTime();

				if (incomingDate.after(tomorrow)) {
					return true;
				}
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean isDateBetweenTwoDates(String targetDateStr, String startDateStr, String endDateStr) {
		try {
			// Convert strings to Date objects
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date targetDate = dateFormat.parse(targetDateStr);
			Date startDate = dateFormat.parse(startDateStr);
			Date endDate = dateFormat.parse(endDateStr);

			// Check if the targetDate is between startDate and endDate
			return startDate.compareTo(targetDate) <= 0 && targetDate.compareTo(endDate) <= 0;
		} catch (ParseException e) {
			// Handle invalid date format
			System.out.println("Invalid date format. Please use the ISO format (yyyy-MM-dd).");
			return false;
		}
	}

	public static boolean isIncomingDatePastDate(Date incomingDate) {
		try {
			if (null != incomingDate) {
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, -1);
				Date yesterday = calendar.getTime();

				if (incomingDate.before(yesterday)) {
					return true;
				}
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return false;
	}

	public static Boolean getLastDateOfTheMonth(Date incomingDate) {
		try {
			if (null != incomingDate) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(incomingDate);
				int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				calendar.set(Calendar.DAY_OF_MONTH, max);
				if (calendar.getTime().compareTo(incomingDate) == 0)
					return true;
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return false;
	}

	public static Boolean getFirstDateOfTheMonth(Date incomingDate) {
		try {
			if (null != incomingDate) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(incomingDate);
				int min = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
				calendar.set(Calendar.DAY_OF_MONTH, min);
				if (calendar.getTime().compareTo(incomingDate) == 0)
					return true;
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return false;
	}

	public static Boolean checkEndDateIsOpenEndDate(Date stDate, Date eDate) {
		try {
			if (null != stDate && null != eDate) {
				DateTime startDate = new DateTime(stDate);
				startDate = startDate.plusYears(3);

				if (startDate.toDate().compareTo(eDate) > 0)
					return false;
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return true;
	}

	public static Map<Date, Date> getFutureDate(Date contractStrtDate, Date contractEndDate) {
		Map<Date, Date> contractDates = new TreeMap<Date, Date>();
		try {
			if (null != contractStrtDate && null != contractEndDate) {
				DateTime startDate = new DateTime(contractStrtDate);
				DateTime endDate = new DateTime(contractEndDate);

				DateTime nxtEndDate = new DateTime(startDate);
				DateTime newSrtDate = new DateTime(startDate);
				while (nxtEndDate.isBefore(endDate)) {
					startDate = newSrtDate;
					newSrtDate = newSrtDate.plusYears(1);
					nxtEndDate = newSrtDate.minusDays(1);
					contractDates.put(startDate.toDate(), nxtEndDate.toDate());
				}

			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}

		return contractDates;
	}

	public static Map<Date, Date> getFutureDateIfTerminated(Date contractStrtDate, Date contractEndDate) {
		Map<Date, Date> contractDates = new TreeMap<Date, Date>();
		try {
			if (null != contractStrtDate && null != contractEndDate) {
				DateTime startDate = new DateTime(contractStrtDate);
				DateTime endDate = new DateTime(contractEndDate);

				DateTime nxtEndDate = new DateTime(startDate);
				DateTime newSrtDate = new DateTime(startDate);
				while (nxtEndDate.isBefore(endDate)) {
					startDate = newSrtDate;
					newSrtDate = newSrtDate.plusYears(1);
					nxtEndDate = newSrtDate.minusDays(1);
					if (nxtEndDate.isAfter(endDate)) {
						nxtEndDate = endDate;
					}
					contractDates.put(startDate.toDate(), nxtEndDate.toDate());
				}
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}

		return contractDates;
	}

	public static Boolean checkForShortened1stYear(Date shortened1stYrStartDate, Date shortened1stYrEndDate) {
		boolean valid = false;
		try {
			if (null != shortened1stYrStartDate && null != shortened1stYrEndDate) {
				DateTime startDt = new DateTime(shortened1stYrStartDate);
				DateTime endDt = new DateTime(shortened1stYrEndDate);
				DateTime newEndDate = startDt.plusYears(1);
				newEndDate = newEndDate.minusDays(1);

				if (endDt.isBefore(newEndDate))
					valid = true;

			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return valid;
	}

	public static Boolean checkNxtDtForShortened1stYrEndDate(Date shortened1stYrEndDate, Date contractStartDate) {
		try {
			if (null != shortened1stYrEndDate && null != contractStartDate) {
				DateTime shortened1stYrEndDt = new DateTime(shortened1stYrEndDate);
				shortened1stYrEndDt = shortened1stYrEndDt.plusDays(1);

				if (shortened1stYrEndDt.toDate().compareTo(contractStartDate) == 0)
					return true;
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return false;
	}

	public static Boolean checkForFullYearInPlanYears(Date sDate, Date eDate) {
		if (null != sDate && null != eDate) {
			DateTime startDate = new DateTime(sDate);
			DateTime endDate = new DateTime(eDate);
			startDate = startDate.minusDays(1);

			if ((startDate.getDayOfMonth() == endDate.getDayOfMonth())
					&& (startDate.getMonthOfYear() == endDate.getMonthOfYear()))
				return true;
		}
		return false;
	}

	public static Date getEndDateForOpenEndDate(Date stDate) {
		Date eDate = new Date();
		if (null != stDate) {
			DateTime endDate = new DateTime(stDate);

			endDate = endDate.plusYears(2);
			endDate = endDate.minusDays(1);

			eDate = endDate.toDate();
		}
		return eDate;
	}

	public static Date getEndDateForDefaultOpenEndDate(Date stDate) {
		Date eDate = new Date();
		if (null != stDate) {
			DateTime endDate = new DateTime(stDate);

			endDate = endDate.plusYears(3);
			endDate = endDate.minusDays(1);

			eDate = endDate.toDate();
		}
		return eDate;
	}

	public static boolean checkCoverageStartDate(Date groupEffectiveStartDate, Date coverageStartDate) {
		boolean valid = false;
		if (null != groupEffectiveStartDate && null != coverageStartDate) {
			DateTime coverageSDate = new DateTime(coverageStartDate);
			DateTime endDate = new DateTime(groupEffectiveStartDate);
			endDate = endDate.plusYears(1);
			endDate = endDate.minusDays(1);
			if (coverageSDate.isBefore(endDate) || groupEffectiveStartDate.equals(endDate.toDate()))
				valid = true;
		}
		return valid;
	}

	public static Boolean checkCoverageTenure(Date coverageStartDate, Date coverageEndDate) {

		boolean valid = false;
		if (null != coverageStartDate && null != coverageEndDate) {
			DateTime startDt = new DateTime(coverageStartDate);
			DateTime endDt = new DateTime(coverageEndDate);
			DateTime newEndDate = startDt.plusYears(1);
			newEndDate = newEndDate.minusDays(1);

			if (endDt.isBefore(newEndDate) || endDt.equals(newEndDate))
				valid = true;
		}
		return valid;
	}

	// ET specific Utility

	public static int getMonthsDifference(Date date) {
		int monthDifference = 0;
		// SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat format = new SimpleDateFormat(COMMON_DATE_FORMAT);
		try {
			format.format(date);
			DateTime dateTime = new DateTime(date);
			DateTime currentDate = new DateTime(new Date());
			DateTime currentFirstDayOfTheMonth = new DateTime(currentDate.getYear(), currentDate.getMonthOfYear(), 1, 0,
					0, 0, 0);

			monthDifference = Months.monthsBetween(currentFirstDayOfTheMonth, dateTime).getMonths() % 52;

		} catch (Exception e) {
			// System.out.println("getMonthsDifference Error:" + e.getMessage());
		}
		return monthDifference;
	}

	public static Date futureModifiedEffectiveDate(Date effectiveDate, int monthsDifference) {

		if (monthsDifference >= 1) {
			DateTime currentDate = new DateTime(new Date());
			DateTime modifiedCurrentDate = new DateTime(currentDate.getYear(), currentDate.getMonthOfYear(), 1, 0, 0, 0,
					0);
			int modifiedEffectiveYear = 0;
			int modifiedEffecitveMonth = 0;
			if (modifiedCurrentDate.getMonthOfYear() + monthsDifference > 12) {
				modifiedEffecitveMonth = (modifiedCurrentDate.getMonthOfYear() + monthsDifference) - 12;
				modifiedEffectiveYear = modifiedCurrentDate.getYear() + 1;
			} else {
				modifiedEffecitveMonth = modifiedCurrentDate.getMonthOfYear() + monthsDifference;
				modifiedEffectiveYear = modifiedCurrentDate.getYear();
			}

			DateTime modifiedEffectiveDate = new DateTime(modifiedEffectiveYear, modifiedEffecitveMonth, 1, 0, 0, 0, 0);
			// System.out.println(modifiedEffectiveDate.toDate());
			return converttoUTCDate(modifiedEffectiveDate.toDate());

		}
		return converttoUTCDate(effectiveDate);
	}

	public static int theDayOfTheMonth(Date date) {
		if (null == date)
			return 0;
		Calendar calForCurrentDate = Calendar.getInstance();
		calForCurrentDate.setTime(date);
		return calForCurrentDate.get(Calendar.DATE);

	}

	public static Date firstDayOfFollowingMonth(Date effectiveDate) {

		DateTime effectiveDateTime = new DateTime(effectiveDate);
		DateTime effectiveDateFirstDayOfTheMonth = null;
		int effectiveDateFollowingYear = 0;
		int effectiveDateFollowingMonth = 0;
		if (effectiveDateTime.getMonthOfYear() == 12) {
			effectiveDateFollowingYear = effectiveDateTime.getYear() + 1;
			effectiveDateFollowingMonth = 1;
		} else {
			effectiveDateFollowingYear = effectiveDateTime.getYear();
			effectiveDateFollowingMonth = effectiveDateTime.getMonthOfYear() + 1;
		}
		effectiveDateFirstDayOfTheMonth = new DateTime(effectiveDateFollowingYear, effectiveDateFollowingMonth, 1, 0, 0,
				0, 0);
		return converttoUTCDate(effectiveDateFirstDayOfTheMonth.toDate());
	}

	/**
	 * Determine first day of previous month as date
	 * 
	 * @param effectiveDate
	 * @return
	 */
	public static Date firstDayOfPreviousMonth(Date effectiveDate) {

		DateTime effectiveDateTime = new DateTime(effectiveDate);
		DateTime effectiveDateFirstDayOfPreviousMonth = null;
		int effectiveDateYear = 0;
		int effectiveDateMonth = 0;
		if ((effectiveDateTime.getMonthOfYear() == 01) || (effectiveDateTime.getMonthOfYear() == 1)) {
			effectiveDateYear = effectiveDateTime.getYear() - 1;
			effectiveDateMonth = 12;
		} else {
			effectiveDateYear = effectiveDateTime.getYear();
			effectiveDateMonth = effectiveDateTime.getMonthOfYear() - 1;
		}
		effectiveDateFirstDayOfPreviousMonth = new DateTime(effectiveDateYear, effectiveDateMonth, 1, 0, 0, 0, 0);
		return converttoUTCDate(effectiveDateFirstDayOfPreviousMonth.toDate());
	}

	public static boolean isEffectiveDateLessThanCurrentDate(Date effecitveDate) {

		DateTime effecitveDateTime = new DateTime(effecitveDate);
		DateTime currentDate = new DateTime(new Date());
		// get result of comparison
		int result = DateTimeComparator.getDateOnlyInstance().compare(effecitveDateTime, currentDate);
		if (result == -1) {
			return true;
		}
		return false;
	}

	// returns the effectiveDate plus a year
	public static Date nextRenewalDateDate(Date effectiveDate) {

		// System.out.println("(Date)Effective date: " + effectiveDate);

		DateTime temp_date = new DateTime(effectiveDate);
		DateTime renewalDate = new DateTime(temp_date.getYear() + 1, temp_date.getMonthOfYear(), 1, 0, 0, 0, 0);

		// System.out.println("(Date)Renewal Date: " + renewalDate);

		return converttoUTCDate(renewalDate.toDate());

	}

	public static String nextRenewalDateDateS(Date effectiveDate) {

		// System.out.println("(Date)Effective date: " + effectiveDate);

		DateTime temp_date = new DateTime(effectiveDate);
		DateTime renewalDate = new DateTime(temp_date.getYear() + 1, temp_date.getMonthOfYear(), 1, 0, 0, 0, 0);

		// System.out.println("(Date)Renewal Date: " + renewalDate);

		return renewalDate.toString();

	}

	public static String DatetoString(Date inputDate) {
		if (inputDate != null)
			return inputDate.toString();
		else
			return null;
	}

	public static Date addDaystoDate(Date effectiveDate, int days) {
		DateTime dt = new DateTime(effectiveDate);
		DateTime start_date = dt.plusDays(days);
		return converttoUTCDate(start_date.toDate());
	}

	// Following Method subtracts given days from a date
	public static Date subtractDaysFromADate(Date OriginalDate, int days) {
		DateTime dt = new DateTime(OriginalDate);
		DateTime modifiedDate = dt.minusDays(days);
		return converttoUTCDate(modifiedDate.toDate());
	}

	// This method compares if the two dates are same.
	// Removes time stamp from DateTime
	public static Boolean areSameDatesDT(Date date1, Date date2) {
		boolean valid = false;
		// SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat df = new SimpleDateFormat(COMMON_DATE_FORMAT);
		if (null != date1 && null != date2) {
			String strDate1 = df.format(date1);
			String strDate2 = df.format(date2);
			if (null != strDate1 && null != strDate1) {
				if (strDate1.equals(strDate2)) {
					valid = true;
				}
			}
		}
		return valid;
	}

	public static String allowedMonths(int m) {
		String SEMICOLON = ";";
		String temp_string = "";
		try {
			Date today = currentDate();
			// System.out.println("Today: " + today);

			for (int i = 1; i <= m; i++) {
				Date temp = futureModifiedEffectiveDate(today, i);
				DateTime dt = new DateTime(temp);
				DateTimeFormatter fmt = DateTimeFormat.longDate();
				// temp_string += fmt.print(dt) + ";";
				temp_string += fmt.print(dt) + SEMICOLON;
			}

		} catch (Exception e) {

		}

		SEMICOLON = null;

		// System.out.println(temp_string);
		return temp_string;
	}

	public static String paymentDays(int n) {

		String PAYMENT_DAYS_METHOD_ST_STR = "st;";
		String PAYMENT_DAYS_METHOD_ND_STR = "nd;";
		String PAYMENT_DAYS_METHOD_RD_STR = "rd;";
		String PAYMENT_DAYS_METHOD_TH_STR = "th;";

		String days = "";
		try {
			for (int i = 1; i <= n; i++) {
				days += i;
				if (i == 1 || i == 21 || i == 31)
					// days+="st;";
					days += PAYMENT_DAYS_METHOD_ST_STR;
				else if (i == 2 || i == 22)
					// days+="nd;";
					days += PAYMENT_DAYS_METHOD_ND_STR;
				else if (i == 3 || i == 23)
					// days+="rd;";
					days += PAYMENT_DAYS_METHOD_RD_STR;
				else
					// days+="th;";
					days += PAYMENT_DAYS_METHOD_TH_STR;
			}
		} catch (Exception e) {

		}

		PAYMENT_DAYS_METHOD_ST_STR = null;
		PAYMENT_DAYS_METHOD_ND_STR = null;
		PAYMENT_DAYS_METHOD_RD_STR = null;
		PAYMENT_DAYS_METHOD_TH_STR = null;

		// System.out.println(days);
		return days;
	}

	public static String setOEDate(Date effectiveDate, int days) {
		DateTime dt = new DateTime(effectiveDate);
		DateTime start_date = dt.minusDays(days);
		// DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");
		DateTimeFormatter fmt = DateTimeFormat.forPattern(COMMON_DATE_FORMAT);
		return fmt.print(start_date);
	}

	public static Date getNewDateFromExpTermDate(Date expTermDate) {
		Date newDateFromExpTermDate = new Date();
		if (null != expTermDate) {
			DateTime calcDate = new DateTime(expTermDate);

			calcDate = calcDate.plusMonths(1);
			calcDate = calcDate.plusDays(1);

			newDateFromExpTermDate = calcDate.toDate();
		}
		return converttoUTCDate(newDateFromExpTermDate);
	}

	public static Date getNextDayOfADate(Date originalDate) {
		Date nextDayOfOrignicalDate = new Date();
		if (null != originalDate) {
			DateTime calcDate = new DateTime(originalDate);

			calcDate = calcDate.plusDays(1);

			nextDayOfOrignicalDate = calcDate.toDate();
		}
		return converttoUTCDate(nextDayOfOrignicalDate);
	}

	public static boolean valdiateDateForWPA(Date date) {
		boolean isInValidDate = false;
		int year = 0;
		if (null != date) {
			DateTime inDate = new DateTime(date);
			// inDate = inDate.plusYears(1899);
			year = inDate.getYear();
		}

		// if (year == 1900 || year == 1899 || year == 0){
		if (year < 1900) {
			isInValidDate = true;
		}

		return isInValidDate;
	}

	public static Date setInValdiateDateToNull() {
		Date nullDate = null;
		return nullDate;
	}

	public static Date converttoUTCDate(Date sourceDate) {
		DateFormat dateFormat;
		Date utcDate = null;
		// String DATE_FORMAT = "yyyy-MM-dd";
		// String TIMEZONE_UTC = "UTC";
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CONVERTEDTOUTC_METHOD_DATE_FORMAT);
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone(CONVERTEDTOUTC_METHOD_TIMEZONE_UTC));
			String utcTime = simpleDateFormat.format(sourceDate);
			// System.out.println(" UTC Time :" + utcTime);

			dateFormat = new SimpleDateFormat(CONVERTEDTOUTC_METHOD_DATE_FORMAT);
			utcDate = dateFormat.parse(utcTime);
			// System.out.println(" UTC Date :" + utcDate);
		} catch (Exception ex) {
			// System.err.println("Exception occured while extracting the UTC Date"+
			// ex.getMessage());
			// ex.printStackTrace();
		}

		return utcDate;
	}

	public static Date getEndOfYear() {
		DateTime today = new DateTime(currentDate());
		DateTime yearEnd = new DateTime(today.getYear(), 12, 31, 0, 0, 0);
		return converttoUTCDate(yearEnd.toDate());
	}

	// Adds given unit of time to effective date
	public static Date addProvisionCount(Date effectiveDate, int unitCount, String unit) {
		DateTime newDate = null;
		String D_STR = "D";
		String H_STR = "H";
		String M_STR = "M";
		String Y_STR = "Y";
		try {
			DateTime dt = new DateTime(effectiveDate);

			if (unit.compareTo(D_STR) == 0)
				newDate = dt.plusDays(unitCount);
			else if (unit.compareTo(H_STR) == 0)
				newDate = dt.plusHours(unitCount);
			else if (unit.compareTo(M_STR) == 0)
				newDate = dt.plusMonths(unitCount);
			else if (unit.compareTo(Y_STR) == 0)
				newDate = dt.plusYears(unitCount);
			else
				newDate = dt;

			// return newDate.toDate();
		} catch (Exception e) {

		}

		D_STR = null;
		H_STR = null;
		M_STR = null;
		Y_STR = null;

		if (newDate != null)
			return converttoUTCDate(newDate.toDate());
		else
			return null;
	}

	// Adds given unit of time to effective date with provision type
	public static Date addProvisionCount(Date effectiveDate, int unitCount, String unit, String type) {
		DateTime newDate = null;
		Date tempDate = null;
		String D_STR = "D";
		String H_STR = "H";
		String M_STR = "M";
		String Y_STR = "Y";
		String FM_STR = "FM";
		String IM_STR = "IM";
		String GD_STR = "GD";
		String DH_STR = "DH";

		try {
			DateTime dt = new DateTime(effectiveDate);

			// First of the Month Provision
			if (type.compareTo(FM_STR) == 0) {
				if (getFirstDateOfTheMonth(effectiveDate) && unitCount == 0)
					newDate = dt;
				else {
					if (unit.compareTo(D_STR) == 0)
						newDate = dt.plusDays(unitCount);
					else if (unit.compareTo(H_STR) == 0)
						newDate = dt.plusHours(unitCount);
					else if (unit.compareTo(M_STR) == 0)
						newDate = dt.plusMonths(unitCount);
					else if (unit.compareTo(Y_STR) == 0)
						newDate = dt.plusYears(unitCount);
					else
						newDate = dt;

					tempDate = newDate.toDate();
					tempDate = firstDayOfFollowingMonth(tempDate);
					newDate = new DateTime(tempDate);
				}

			}

			// Immediate Provision
			if (type.compareTo(IM_STR) == 0) {
				if (unit.compareTo(D_STR) == 0)
					newDate = dt.plusDays(unitCount);
				else if (unit.compareTo(H_STR) == 0)
					newDate = dt.plusHours(unitCount);
				else if (unit.compareTo(M_STR) == 0)
					newDate = dt.plusMonths(unitCount);
				else if (unit.compareTo(Y_STR) == 0)
					newDate = dt.plusYears(unitCount);
				else
					newDate = dt;
			}

			// Date of Hire/Group Determines Provision
			if (type.compareTo(DH_STR) == 0 || type.compareTo(GD_STR) == 0)
				newDate = dt;
		} catch (Exception e) {
		}

		D_STR = null;
		H_STR = null;
		M_STR = null;
		Y_STR = null;
		FM_STR = null;
		IM_STR = null;
		GD_STR = null;
		DH_STR = null;
		tempDate = null;

		if (newDate != null)
			return converttoUTCDate(newDate.toDate());
		else
			return null;
	}

	public static int dateLength(Date inputDate) {
		int dtlen = 0;

		// inputDate=converttoUTCDate(inputDate);
		// System.out.println(inputDate);
		String inputDateStr = DatetoString(inputDate);
		if (inputDateStr != null)
			dtlen = StringUtility.getStringLength(inputDateStr);

		return dtlen;

	}

	public static String formatDateWithPattern(Date inputDate, String pattern) {
		String dateStr = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			dateStr = sdf.format(inputDate);
		} catch (Exception e) {
			// System.out.println("Error!!");
		}

		inputDate = null;
		pattern = null;

		return dateStr;

	}

	/*
	 * public static void main(String arg[]){
	 * System.out.println(formatDateWithPattern(new Date(),"yyyy-dd-mm"));
	 * 
	 * 
	 * }
	 */

	public static Date setPreviousTermDate(Date effectiveDate, int months) {
		DateTime termDate = new DateTime();
		DateTime tempDate = new DateTime();
		DateTime dt = new DateTime(effectiveDate);
		int currentMonth = dt.getMonthOfYear();
		int lastDay = 0;

		switch (currentMonth - 2) {
		case 2:
			lastDay = 2;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			lastDay = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDay = 30;
			break;
		}

		// System.out.println("Current Month: " + currentMonth);
		// System.out.println("Last Day: " + lastDay);
		tempDate = dt.minusMonths(months);
		termDate = new DateTime(tempDate.getYear(), tempDate.getMonthOfYear(), lastDay, 0, 0, 0);
		return converttoUTCDate(termDate.toDate());
	}

	/**
	 * isThisDateValid
	 * 
	 * @param dateToValidate
	 * @param dateFromat
	 * @return
	 */
	public static boolean isValidDate(Date dateToValidate) {

		String dateStr = formatDateWithPattern(converttoUTCDate(dateToValidate), DATE_FORMAT_FOR_IIB);
		// System.out.println(dateStr);
		return checkDateValid(dateStr);
	}

	// date validation using SimpleDateFormat
	// it will take a string and make sure it's in the proper
	// format as defined by you, and it will also make sure that
	// it's a legal date

	public static boolean checkDateValid(String date) {
		// set date format, this can be changed to whatever format
		// you want, MM-dd-yyyy, MM.dd.yyyy, dd.MM.yyyy etc.
		// you can read more about it here:
		// http://java.sun.com/j2se/1.4.2/docs/api/index.html

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FOR_IIB);

		// declare and initialize testDate variable, this is what will hold
		// our converted string

		Date testDate = null;

		// we will now try to parse the string into date form
		try {
			testDate = sdf.parse(date);
		}

		// if the format of the string provided doesn't match the format we
		// declared in SimpleDateFormat() we will get an exception

		catch (ParseException e) {
			// System.out.println("the date you provided is in an invalid date" + "
			// format.");
			return false;
		}

		// dateformat.parse will accept any date as long as it's in the format
		// you defined, it simply rolls dates over, for example, december 32
		// becomes jan 1 and december 0 becomes november 30
		// This statement will make sure that once the string
		// has been checked for proper formatting that the date is still the
		// date that was entered, if it's not, we assume that the date is
		// invalid

		if (!sdf.format(testDate).equals(date)) {
			// System.out.println("The date that you provided is invalid.");
			return false;
		}

		// if we make it to here without getting an error it is assumed that
		// the date was a valid one and that it's in the proper format

		return true;

	} // end isValidDate

	public static Date setLastDateOfTheMonth(Date incomingDate) {
		DateTime tempDate = new DateTime(incomingDate);
		int currentMonth = tempDate.getMonthOfYear();
		int currentYear = tempDate.getYear();
		currentMonth = currentMonth + 1;
		if (currentMonth == 13) {
			currentMonth = 1;
			currentYear = currentYear + 1;
		}
		DateTime newDate = new DateTime(currentYear, currentMonth, 1, 0, 0, 0);
		newDate = newDate.minusDays(1);
		return converttoUTCDate(newDate.toDate());
	}

	public static int getMonthsDiffFromCurrentdate(Date inDate) {
		int monthDiff = 0;
		// SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat format = new SimpleDateFormat(COMMON_DATE_FORMAT);
		try {
			format.format(inDate);
			LocalDate incomingDate = LocalDate.fromDateFields(inDate);
			LocalDate currentDate = LocalDate.fromDateFields(currentDate());
			Period p = new Period(incomingDate, currentDate);

			monthDiff = ((p.getYears() * 12) + p.getMonths());

		} catch (Exception e) {
			// System.out.println("Error");
		}
		return monthDiff;
	}

	public static boolean isHoliday(Date inDate) {

		DateTime tempDate = null;
		boolean isBusinessDay = false;

		try {
			if (null != inDate) {
				tempDate = new DateTime(inDate);
				int month = tempDate.getMonthOfYear();
				int dayMonth = tempDate.getDayOfMonth();
				int dayYear = tempDate.getDayOfYear();

				// New Years Day
				if (dayYear == 1)
					isBusinessDay = true;

				// July 4th
				if (month == 7 && dayMonth == 4)
					isBusinessDay = true;

				// Christmas
				if (month == 12 && dayMonth == 25)
					isBusinessDay = true;

				// Memorial Day
				if (month == 5) {
					DateTime memDay = new DateTime(tempDate.getYear(), 5, 31, 0, 0, 0);
					while (memDay.getDayOfWeek() != 1) {
						memDay = memDay.minusDays(1);
					}
					if (tempDate.equals(memDay))
						isBusinessDay = true;
				}

				// Labor Day
				if (month == 9) {
					DateTime labDay = new DateTime(tempDate.getYear(), 9, 1, 0, 0, 0);
					while (labDay.getDayOfWeek() != 1) {
						labDay = labDay.plusDays(1);
					}
					if (tempDate.equals(labDay))
						isBusinessDay = true;
				}

				// Thanksgiving Black Friday
				if (month == 11) {
					DateTime tDay = new DateTime(tempDate.getYear(), 11, 1, 0, 0, 0);
					while (tDay.getDayOfWeek() != 4) {
						tDay = tDay.plusDays(1);
					}
					tDay = tDay.plusDays(21);
					if (tempDate.equals(tDay) || tempDate.equals(tDay.plusDays(1)))
						isBusinessDay = true;
				}
			}
		} catch (Exception e) {

		} finally {
			tempDate = null;
		}

		return isBusinessDay;
	}

	public static boolean isBusinessDay(Date inDate) {

		DateTime tempDate = null;
		boolean isBusinessDay = true;
		try {
			if (null != inDate) {
				tempDate = new DateTime(inDate);
				int dayWeek = tempDate.getDayOfWeek();

				if (dayWeek == 1) {
					tempDate = tempDate.minusDays(1);
					if (isHoliday(tempDate.toDate()))
						isBusinessDay = false;
					if (isHoliday(inDate))
						isBusinessDay = false;
				}

				if (dayWeek == 5) {
					tempDate = tempDate.plusDays(1);
					if (isHoliday(tempDate.toDate()))
						isBusinessDay = false;
					if (isHoliday(inDate))
						isBusinessDay = false;
				}

				if (dayWeek == 6 || dayWeek == 7)
					isBusinessDay = false;

				if (isHoliday(inDate))
					isBusinessDay = false;
			}
		} catch (Exception e) {

		} finally {
			tempDate = null;
		}

		return isBusinessDay;

	}

	public static Date addBusinessDays(Date inDate, int days) {
		DateTime tempDate = null;
		Date newDate = null;
		try {
			if (null != inDate) {
				tempDate = new DateTime(inDate);
				int x = 1;
				while (x < days) {
					tempDate = tempDate.plusDays(1);
					if (isBusinessDay(tempDate.toDate())) {
						x = x + 1;
					}
				}
				newDate = tempDate.toDate();
			}
		} catch (Exception e) {

		} finally {
			tempDate = null;
		}

		return converttoUTCDate(newDate); // need to check the business need to determine what will be return value if
											// inDate is null
	}

	public static Date convertStringToDate(String strDate) {

		SimpleDateFormat sdf = new SimpleDateFormat(CONVERTSTRINGTODATE_METHOD_DATEFORMAT);
		Date date = new Date();
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// System.out.println(e.getMessage());
		}
		return converttoUTCDate(date);
	}

	/**
	 * getDifferenceInMinutes
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */

	public static int getDifferenceInMinutes(Date date1, Date date2) {

		long differenceInMinutes = 0;
		if (date1 == null || date2 == null)
			return -1;

		/*
		 * if (!areSameDatesDT(date1, date2)) return 0;
		 */
		long time1 = date1.getTime();
		long time2 = date2.getTime();

		differenceInMinutes = (time1 - time2);

		if (differenceInMinutes < 0)
			differenceInMinutes = differenceInMinutes * (-1);

		return (int) (differenceInMinutes / (1000 * 60));

	}

	/**
	 * isDateBetweenRange
	 * 
	 * @param isoDateToCheck
	 * @param startMonthDay
	 * @param endMonthDay
	 * @return
	 */

	public static boolean isDateBetweenRange(String startMonthDay, String endMonthDay, String isoDateToCheck) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = dateFormat.parse(isoDateToCheck);
			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(startDate);

			Date startDatePart = new SimpleDateFormat(DATE_FORMAT).parse(startMonthDay);
			Date endDatePart = new SimpleDateFormat(DATE_FORMAT).parse(endMonthDay);

			Calendar startPartCalendar = Calendar.getInstance();
			startPartCalendar.setTime(startDatePart);
			startPartCalendar.set(Calendar.YEAR, startCalendar.get(Calendar.YEAR));

			Calendar endPartCalendar = Calendar.getInstance();
			endPartCalendar.setTime(endDatePart);
			endPartCalendar.set(Calendar.YEAR, startCalendar.get(Calendar.YEAR));

			return startCalendar.after(startPartCalendar) && startCalendar.before(endPartCalendar);
		} catch (ParseException e) {
			e.printStackTrace(); // Handle the exception based on your requirements
			return false;
		}
	}

	/**
	 * timeRangeCheck
	 * 
	 * @param time1
	 * @param time2
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */

	public static boolean timeRangeCheck(String time1, String time2, Date dateTime) throws ParseException {

		Format formatter = new SimpleDateFormat(TIME_FORMAT);
		String currentTime = formatter.format(dateTime);
		// System.out.println("Current Time:" + currentTime);
		boolean check = isTimeBetweenTwoTime(time1, time2, currentTime);

		return check;
	}

	/**
	 * isTimeBetweenTwoTime
	 * 
	 * @param argStartTime
	 * @param argEndTime
	 * @param argCurrentTime
	 * @return
	 * @throws ParseException
	 */
	private static boolean isTimeBetweenTwoTime(String argStartTime, String argEndTime, String argCurrentTime)
			throws ParseException {

		String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
		//
		if (argStartTime.matches(reg) && argEndTime.matches(reg) && argCurrentTime.matches(reg)) {
			boolean valid = false;
			// Start Time
			java.util.Date startTime = new SimpleDateFormat(TIME_FORMAT).parse(argStartTime);
			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(startTime);

			// Current Time
			java.util.Date currentTime = new SimpleDateFormat(TIME_FORMAT).parse(argCurrentTime);
			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.setTime(currentTime);

			// End Time
			java.util.Date endTime = new SimpleDateFormat(TIME_FORMAT).parse(argEndTime);
			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(endTime);

			//
			if (currentTime.compareTo(endTime) < 0) {

				currentCalendar.add(Calendar.DATE, 1);
				currentTime = currentCalendar.getTime();

			}

			if (startTime.compareTo(endTime) < 0) {

				startCalendar.add(Calendar.DATE, 1);
				startTime = startCalendar.getTime();

			}
			//
			if (currentTime.before(startTime)) {

				// System.out.println(" Time is Lesser ");

				valid = false;
			} else {

				if (currentTime.after(endTime)) {
					endCalendar.add(Calendar.DATE, 1);
					endTime = endCalendar.getTime();

				}

				// System.out.println("Comparing , Start Time /n " + startTime);
				// System.out.println("Comparing , End Time /n " + endTime);
				// System.out.println("Comparing , Current Time /n " + currentTime);

				if (currentTime.before(endTime)) {
					// System.out.println("RESULT, Time lies b/w");
					valid = true;
				} else {
					valid = false;
					// System.out.println("RESULT, Time does not lies b/w");
				}

			}
			return valid;

		} else {
			throw new IllegalArgumentException("Not a valid time, expecting HH:MM:SS format");
		}

	}

	public static Date validDateCheck(Date inputDate) {
		Date responseDate = null;
		if (inputDate != null) {
			DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FOR_IIB);
			String strDate = sdf.format(inputDate);
			try {
				responseDate = sdf.parse(strDate);
			} catch (ParseException e) {
				// System.err.println("Error");
			}
		}
		return responseDate;
	}

	public static Date checkValidDate(String inputDate) {
		Date outputDate = null;
		if (inputDate != null && !inputDate.isEmpty() && !inputDate.equalsIgnoreCase("NA")) {
			for (String parse : DATE_FORMATS) {
				SimpleDateFormat sdf = new SimpleDateFormat(parse);
				sdf.setLenient(false);
				try {
					outputDate = sdf.parse(inputDate);
					// System.out.println("Printing the value of " + sdf.parse(inputDate));
				} catch (ParseException e) {
					// System.err.println("Error");
				}
			}
		}
		return outputDate;
	}

	public static int getDateDifference(Date startDate, Date endDate) {
		DateTime dateOfBirth = new DateTime(startDate);
		DateTime currentDate = new DateTime(endDate);
		return Days.daysBetween(dateOfBirth, currentDate).getDays();
	}

	public static boolean dayCheck(String inputDate) {
		Date validDate = checkValidDate(inputDate);
		if (validDate == null) {
			return false;
		} else {
			DateTime dateCheck = new DateTime(validDate);
			if ((dateCheck.dayOfWeek().getAsText()).equalsIgnoreCase(SUNDAY))
				return true;
		}
		return false;
	}

	/**
	 * This method is created for DEP project This method will validate whether a
	 * date is calendar date or not
	 */
	public static boolean checkValidCalendarDate(String incomingDate) {
		SimpleDateFormat format = null;
		try {
			if (null != incomingDate && !incomingDate.isEmpty()) {
				format = new SimpleDateFormat(CONVERTEDTOUTC_METHOD_DATE_FORMAT);
				format.setLenient(false);
				format.parse(incomingDate);
			} else {
				return false;
			}
		} catch (ParseException | IllegalArgumentException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * This method is created for DEP project This method will convert string to
	 * date
	 */
	public static Date convertStringToDateFormat(String incomingDate) {
		SimpleDateFormat sdf = null;
		Date dateobj = null;
		try {
			if (null != incomingDate && !incomingDate.isEmpty()) {
				sdf = new SimpleDateFormat(CONVERTEDTOUTC_METHOD_DATE_FORMAT);
				dateobj = sdf.parse(incomingDate);

			}
		} catch (Exception e) {

		}
		return dateobj;

	}

	/**
	 * This method is created for DEP project This method will validate whether
	 * input date is future date or not
	 */
	public static boolean isInputDateFutureDate(Date inputDate) {
		try {
			if (null != inputDate) {
				Calendar calendar = Calendar.getInstance();
				Date today = calendar.getTime();
				if (inputDate.after(today)) {
					return true;
				}
			}
		} catch (Exception e) {

		}
		return false;
	}

	/**
	 * This method is created for DEP project This method will override incoming
	 * dates's day to 01
	 */
	public static String OverrideFirstDayOfMonth(String incomingDate) {
		SimpleDateFormat sdf = null;
		Date dateobj = null;

		try {
			if (null != incomingDate && !incomingDate.isEmpty()) {
				sdf = new SimpleDateFormat(CONVERTEDTOUTC_METHOD_DATE_FORMAT);
				dateobj = sdf.parse(incomingDate);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dateobj);
				calendar.set(Calendar.DAY_OF_MONTH, DAY);
				dateobj = calendar.getTime();
				return sdf.format(dateobj);
			}
		} catch (ParseException e) {

		}
		return incomingDate;

	}

	/**
	 * This method is created for DEP project This method will check whether
	 * incoming date is in required format
	 */
	public static Boolean checkDateFormat(String date) {

		try {
			if (null != date && !date.isEmpty()) {
				if (date.matches(DATE_FORMAT_CHECK)) {
					return true;
				} else
					return false;
			}
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * convertStringToDateGeneric
	 * 
	 * @param inputDate
	 * @param dateFormat
	 * @return
	 */

	public static Date convertStringToDateGeneric(String inputDate, String dateFormat) {
		Date outputDate = null;
		if (inputDate != null && !inputDate.isEmpty() && !inputDate.equalsIgnoreCase(NA)) {

			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			sdf.setLenient(false);
			try {
				outputDate = sdf.parse(inputDate);
			} catch (ParseException e) {

			}

		}
		return outputDate;
	}

	/**
	 * Below method is created for Project Go365WellNext . Created Date : 06/21/2023
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDateDifferenceIncludingEndDate(Date startDate, Date endDate) {
		DateTime eventDate = null;
		DateTime currentDate = null;
		try {
			if (null != startDate && null != endDate) {

				eventDate = new DateTime(startDate);
				currentDate = new DateTime(endDate);
				DateTime modifiedDate = currentDate.plusDays(1);
				return Days.daysBetween(eventDate, modifiedDate).getDays();
			}
		} catch (Exception e) {

		}
		return 0;
	}

}
