package com.spring.transaction.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DateTimeUtil {

	// TODO Shouldn't this just be a static method? [WLW]
	public ZonedDateTime getCurrentDateAndTime() {
		return ZonedDateTime.now();
	}

	public static String toString(Date date) {
		// E.g., Tue May 24 2016 2:03:28 PDT
		DateFormat format = new SimpleDateFormat("EEE MMM d yyyy H:mm:ss z");
		return format.format(date);
	}

	public static String getTimeZoneFreeDate(Date date) {
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		if (date != null) {
			return format.format(date);
		}
		return null;
	}
	
	public static String getTimeZoneFreeDate(Date date, String formatString) {
		if(formatString == null || formatString.trim() == ""){
			return null;
		}
		DateFormat format = new SimpleDateFormat(formatString);
		if (date != null) {
			return format.format(date);
		}
		return null;
	}

	public static Date zeroHoursMinutesSeconds(Date d) {
		Date date = null;
		if (d != null) {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(d.getTime());
			c.set(Calendar.HOUR, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			date = c.getTime();
		}
		return date;
	}

	public static Date adjustDateMax(Date date) {
		Date d = null;
		if (date != null) {

			Calendar dateFrom = Calendar.getInstance();
			dateFrom.setTimeInMillis(date.getTime());
			dateFrom.set(Calendar.HOUR, 11);
			dateFrom.set(Calendar.MINUTE, 59);
			dateFrom.set(Calendar.SECOND, 59);
			dateFrom.set(Calendar.MILLISECOND, 0);
			dateFrom.set(Calendar.AM_PM, Calendar.PM);
			d = dateFrom.getTime();
		}
		return d;
	}
	
	 public static Map<String,Integer> getMonthsAndDaysDifference(Date date1, Date date2) {
		  	Map<String,Integer> monthDayMap = null;
			Calendar startCal = Calendar.getInstance();
			Calendar endCal   = Calendar.getInstance();
			endCal.setTime( date2);
			startCal.setTime(date1);
			 
	      // Account for rule that, months calc subtracts a day
	      // (Jan 1 + 1 month = Jan 31, NOT Feb 1) thus ( Feb 1 - Jan 1 = 1 month + 1 day, NOT 1 month)
	      endCal.add(Calendar.DATE, +1);

	      Calendar lastMonth = Calendar.getInstance();
	      lastMonth.setTime( endCal.getTime() );
	      lastMonth.set(Calendar.DATE, 0);
	      int daysInLastMonth = lastMonth.get(Calendar.DATE);

	      Integer years   = endCal.get(Calendar.YEAR)   - startCal.get(Calendar.YEAR);
	      Integer months  = endCal.get(Calendar.MONTH)  - startCal.get(Calendar.MONTH);
	      Integer days    = endCal.get(Calendar.DATE)   - startCal.get(Calendar.DATE);

	      // Convert Years to Months
	      if ( years > 0 ) { months = months + (years*12); }
	      // If days is negative, borrow from last month
	      if ( days < 0 )
	      {  // Determine number of days in last whole month
	          months = months-1;
	          days = daysInLastMonth + days; // Note that days is a negative number
	          if(days < 0 && (daysInLastMonth == 28 || daysInLastMonth == 29)) {
              	Calendar monthBeforelastMonth = Calendar.getInstance();
              	monthBeforelastMonth.setTime( lastMonth.getTime() );
              	monthBeforelastMonth.set(Calendar.DATE, 0);
              	int daysInMonthBeforelastMonth = monthBeforelastMonth.get(Calendar.DATE);
              	if(months > 0) {
              		months = months - 1;
              		days = daysInMonthBeforelastMonth+days;
              	}
              }
	      }
	      if ( months < 1 )
	      {  // Extra day rule only applies if at least 1 month was specified
	          days = days - 1;
	      }
	      if(months != null && days != null){
	    	  monthDayMap = new HashMap<>();
	    	  monthDayMap.put("Days", days);
	    	  monthDayMap.put("Months", months);
	      }
	      return monthDayMap;
		}

}