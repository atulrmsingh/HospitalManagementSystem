package com.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hms.Patient.Gender;

public class App {
	Scanner sc = new Scanner(System.in);
	DoctorRepo drrepo = new DoctorRepo();
	AppointmentRepo appRepo = new AppointmentRepo();
	PatientRepo patRepo = new PatientRepo();
	static UserInterface ui = new UserInterface();

	public static void main(String[] args) {
		int count = 16;
		int result;

		App app = new App();
		do {
			result = ui.showMainMenue();

			app.handleUserSelection(result);

		} while (result != count);

	}

	void handleUserSelection(int val) {

		switch (val) {

		case 1:
			ui.addDoctor(drrepo);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			ui.getAllDoctors(drrepo);
			break;
		case 6:
			ui.addPatient(patRepo);
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			ui.getAllPatients(patRepo);
			break;
		case 11:
			ui.addAppointment(drrepo, appRepo, patRepo);
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			ui.getAllAppointments(appRepo);
			break;
		case 16:
			System.out.println("application closed");
			break;
		default:
			System.out.println("Invalid Choice .. Try Again.");
		}
	}

}
