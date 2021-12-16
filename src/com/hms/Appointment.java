package com.hms;

import java.util.Date;

public class Appointment {

	String appointmentId;
	String doctorId;
	String patientId;
	Date appointmentDate;

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", doctorId=" + doctorId + ", patientId=" + patientId
				+ ", appointmentDate=" + appointmentDate + "]";
	}

}
