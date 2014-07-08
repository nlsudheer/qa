package com.clh.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * A customized class for generating the time stamps
 * 
 * @author Praveen Ashapure
 * 
 */
public class DateUtil {

	/**
	 * Gets a string with current date and time in
	 * <code>dd-MM-yyyy_hh.mm.ss_a</code> format for the system time
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss_a");
		return df.format(new Date());
	}

	/**
	 * Gets a string with current date and time in
	 * <code>dd-MM-yyyy_hh.mm.ss_a</code> format for the specified
	 * <code>timeZone</code>
	 * 
	 * @param timeZone
	 *            a time zone e.g. PST, IST
	 * @return
	 */
	public static String getTimeStamp(String timeZone) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss_a");
		df.setTimeZone(TimeZone.getTimeZone(timeZone));
		return df.format(new Date());
	}

	/**
	 * Gets the current system time as hex-decimal string
	 * 
	 * @return
	 */
	public static String getTimeStampLong() {
		return Long.toHexString(System.currentTimeMillis());
	}
}
