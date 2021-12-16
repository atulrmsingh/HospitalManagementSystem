package com.hms;

import java.util.Map;

public class Doctor {

	enum WeekDays {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	String id;
	String name;
	String specialist;
	Long mobile;
	String email;
	Map<WeekDays, String> availability;

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialist=" + specialist + ", mobile=" + mobile + ", email="
				+ email + ", availability=" + availability + "]";
	}

}
