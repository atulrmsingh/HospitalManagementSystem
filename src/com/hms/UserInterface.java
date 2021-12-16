package com.hms;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

	public int showMainMenue() {
		System.out.println(
				"Press 1.Add doctor\n" + "Press 2.Remove doctor\n" + "Press 3.Get Doctor\n" + "Press 4.Update Doctor\n"
						+ "Press 5.Get all Doctor\n" + "Press 6.Add Patient\n" + "Press 7.Remove Patient\n"
						+ "Press 8.Get Patient\n" + "Press 9.Update Patient\n" + "Press 10.Get all Patient\n"
						+ "Press 11.Add Appointment\n" + "Press 12.Remove Appointment\n" + "Press 13.Get Appointment\n"
						+ "Press 14.Update Appointment\n" + "Press 15.Get all Appointment\n" + "press 16.exit");

		Scanner sc = new Scanner(System.in);
		int val = sc.nextInt();
		return val;
	}

	public void getAllDoctors(DoctorRepo drrepo) {
		List doctorList = drrepo.getAllDoctors();
		for (int i = 0; i < doctorList.size(); i++) {
			System.out.println(doctorList.get(i));
		}
	}

	public void getAllAppointments(AppointmentRepo appRepo) {
		List appointmentList = appRepo.getAllAppointment();
		for (int i = 0; i < appointmentList.size(); i++) {
			System.out.println(appointmentList.get(i));
		}

	}

	public void getAllPatients(PatientRepo patRepo) {
		List patienttList = patRepo.getAllPatient();
		for (int i = 0; i < patienttList.size(); i++) {
			System.out.println(patienttList.get(i));
		}
	}
}
