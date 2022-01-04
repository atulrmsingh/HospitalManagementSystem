package com.hms;

import java.util.Map;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(email, id, mobile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(mobile, other.mobile);
	}

}
