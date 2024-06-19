package com.nothing.howlong;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;


public class MyDateUtils {

	public static String parsePostDuration(Duration howLongD) {
		howLongD = howLongD.abs();
		Integer hours = howLongD.toHoursPart();
		Long days = howLongD.toDaysPart();
		Integer seconds = howLongD.toSecondsPart();
		Integer minutes = howLongD.toMinutesPart();
	
		System.out.println("before (hours) : " + hours);
		System.out.println("before (minutes) : " + minutes);
		System.out.println("before (seconds) : " + seconds);
		System.out.println("before (days) : " + days);
	
		Integer weeks = days.intValue() / 7;
		Integer month = weeks / 4;
		Integer year = month / 13;
	
		System.out.println("after (year) : " + year);
		System.out.println("after (month) : " + month);
		System.out.println("after (weeks) : " + weeks);
		System.out.println("after (hours) : " + hours);
		System.out.println("after (minutes) : " + minutes);
		System.out.println("after (seconds) : " + seconds);
		System.out.println("after (days) : " + days);
	
		// weeks
	
		MyDuration duration;
		// PT-3H-30M-41.6589405S
	
		String[] args = "PT-3H-30M-41.6589405S".split("-");
	
		String message = null;
	
		duration = getInterval(hours, days, seconds, minutes, weeks, month, year);
	
		switch (duration) {
	
		case HOURS:
			//System.out.println(duration.getDurationMessage());
			message = duration.getDurationMessage();
			break;
	
		case MINUTES:
			//System.out.println(duration.getDurationMessage());
			message = duration.getDurationMessage();
			break;
	
		case SECONDS:
			//System.out.println(duration.getDurationMessage());
			message = duration.getDurationMessage();
			break;
	
		case DAYS:
			//System.out.println(duration.getDurationMessage());
			message = duration.getDurationMessage();
			break;
	
		case WEEKS:
			//System.out.println(duration.getDurationMessage());
			message = duration.getDurationMessage();
			break;
	
		case MONTHS:
			//System.out.println(duration.getDurationMessage());
			message = duration.getDurationMessage();
			break;
	
		case YEARS:
			//System.out.println(duration.getDurationMessage());
			message = duration.getDurationMessage();
			break;
			
			default :
				break;
	
		}
	
		return message;
	}

	private static MyDuration getInterval(Integer hours, Long days, Integer seconds, Integer minutes, Integer weeks, Integer month,
			Integer year) {
				MyDuration duration;
				String message = null;
				
				
				if (year.intValue() != 0) {
			
					System.out.println("@@ years");
			
					duration = MyDuration.YEARS;
			
					if (year.toString().contains("-")) {
			
						
			
							if (year < 1) {
			
								message = year.toString().replace("-", "") + " year " + " ago ";
			
							} else {
			
								message = year.toString().replace("", "") + " years " + " ago ";
			
							}
			
			
					} else {
			
						message = year.toString() + " years " + " ago ";
			
					}
					
					duration.setDurationMessage(message);
					return duration;
			
				}
			
				if (month.intValue() != 0) {
			
					duration = MyDuration.MONTHS;
			
					
					System.out.println("@@ months");
			
					if (month.toString().contains("-")) {
						
			
			
			
							if (month < 1) {
			
								message = month.toString().replace("-", "") + " month " + " ago ";
			
							} else {
			
								message = month.toString().replace("", "") + " months " + " ago ";
			
							}
			
			
					} else {
			
						message = month.toString() + " months " + " ago ";
			
					}
					
					duration.setDurationMessage(message);
			
			
					return duration;
				}
			
				if (weeks.intValue() != 0) {
			
					
					System.out.println("@@ weeks");
			
					duration = MyDuration.WEEKS;
			
					
			
						if (weeks <= 1) {
							message = weeks.toString() + " week " + " ago ";
	
						}
			
					 else {
			
						message = weeks.toString()+ " weeks " + " ago ";
			
			
					}
					
					duration.setDurationMessage(message);
			
					return duration;
			
			
				}
			
				if (days.intValue() !=0 ) {
					
					System.out.println("@@ days");
			
			
					duration = MyDuration.DAYS;
					
					if (days <= 1) {
						message = days.toString() + " day " + " ago ";

					}
		
				 else {
		
					message = days.toString()+ " days " + " ago ";
		
		
				}
				
		
			
					duration.setDurationMessage(message);
			
					return duration;
				}
			
				// hours
				if (hours.intValue() != 0) {
					
					System.out.println("@@ hours");
			
			
					duration = MyDuration.HOURS;
			
					if (hours.toString().contains("-")) {
			
						message = hours.toString().replace("-", "") + " hours " + " ago ";
			
			
					} else {
			
			
						message = hours.toString().replace("", "") + " hours " + " ago ";
			
					}
			
					duration.setDurationMessage(message);
					return duration;
				}
			
				if (minutes.intValue() != 0) {
			
					
					System.out.println("@@ minutes");
					duration = MyDuration.MINUTES;
			
					if (minutes.toString().contains("-")) {
			
						message = minutes.toString().replace("-", "") + " minutes " + " ago ";
			
			
					} else {
						
						message = minutes.toString().replace("", "") + " minutes " + " ago ";
			
			
					}
					
					duration.setDurationMessage(message);
			        return duration;
			
				}
			
				if (seconds.intValue() < 60) {
					
					System.out.println("@@ seconds");
			
			
					duration = MyDuration.SECONDS;
			
					if (seconds.toString().contains("-")) {
			
						message = "just now";
			
			
					} else {
			
						
						message = "just now";
			
			
					}
					
					duration.setDurationMessage(message);
			
					return duration;
			
				}
				
				
				return null;
			}

	public MyDateUtils() {
		super();
	}
	
	
	public static Duration periodNow(String submittedDateTime) {
		ZonedDateTime theParsedDateTime =	ZonedDateTime.parse(submittedDateTime);
	    System.out.println("@@ :: " + submittedDateTime);
		Duration howLongD = Duration.between(ZonedDateTime.now(), theParsedDateTime);
		return howLongD;
	}	

}