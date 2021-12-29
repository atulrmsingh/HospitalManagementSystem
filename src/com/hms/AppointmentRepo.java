package com.hms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentRepo {
	Scanner sc = new Scanner(System.in);
	private static AppointmentRepo instance;
	List<Appointment> appointmentList = new ArrayList<Appointment>();

	private AppointmentRepo() {

	}

	public static AppointmentRepo getInstance() {
		if (instance == null) {
			instance = new AppointmentRepo();

		}
		return instance;

	}

	public void add(Appointment apt) {

		appointmentList.add(apt);

	}

	public List<Appointment> getAllAppointment() {
		return appointmentList;
	}


	public void getAllAppointments() {
		List<Appointment> appointmentList = getAllAppointment();
		for (int i = 0; i < appointmentList.size(); i++) {
			System.out.println(appointmentList.get(i));
		}

	}

}