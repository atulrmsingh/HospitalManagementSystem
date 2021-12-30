package com.hms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AppointmentRepo {
	Scanner sc = new Scanner(System.in);
	private static AppointmentRepo instance;
	Set<Appointment> appointmentList = new HashSet<Appointment>();

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

	public Set<Appointment> getAllAppointment() {
		return appointmentList;
	}

	/*
	 * public void getAllAppointments() { List<Appointment> appointmentList =
	 * getAllAppointment(); for (int i = 0; i < appointmentList.size(); i++) {
	 * 
	 * System.out.println(appointmentList.get(i)); }
	 * 
	 * }
	 */
	public void getAllAppointments(DoctorRepo drrepo, PatientRepo patrepo) {
		Set<Appointment> appointmentList = getAllAppointment();
		for (Appointment app : appointmentList) {
			Doctor dr = drrepo.getDoctor(app.doctorId);
			Patient pt = patrepo.getPatient(app.patientId);
			System.out.println("Appointment Details : \n"
					+" Appointment Id: "+ app.appointmentId +"\n"
					+" Doctor Id : "+app.doctorId +"\n"
					+" Doctor Name: "+ dr.name +"\n"
					+" Doctor specialist: "+ dr.specialist +"\n"
					+" Patient Id: "+app.patientId +"\n"
					+" Patient Name: "+pt.name +"\n"
					+" Patient Age: "+ pt.age +"\n"
					+" Patient Gender: "+pt.gender +"\n"
					+" Patient Disease: "+pt.Disease +"\n"
					+" Appointment date: "+app.appointmentDate);
		}
	}

	public Appointment getAppointment(String aptid) {
		Set<Appointment> appointmentList = getAllAppointment();
		for (Appointment app : appointmentList) {
			if (app.appointmentId.equalsIgnoreCase(aptid)) {
				return app;
			}
		}

		return null;
	}

}