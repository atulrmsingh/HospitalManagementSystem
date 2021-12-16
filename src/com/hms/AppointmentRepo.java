package com.hms;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepo {

	List appointmentList = new ArrayList();

	public void add(Appointment apt) {

		appointmentList.add(apt);

	}

	public List getAllAppointment() {
		return appointmentList;
	}

}