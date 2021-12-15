package com.hms;

import java.util.Map;

public class Doctor {
	
	enum WeekDays{
		SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
	}
	String id;
	String name;
	String Specialist;
	Long mobile;
	String email;
	Map<WeekDays, String> availability;
	
}
