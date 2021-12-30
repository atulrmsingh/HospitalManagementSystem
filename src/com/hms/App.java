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
	//final static int EXIT = 16;
	Scanner sc = new Scanner(System.in);
	DoctorRepo drrepo = DoctorRepo.getInstance();
	AppointmentRepo appRepo = AppointmentRepo.getInstance();
	PatientRepo patRepo = PatientRepo.getInstance();
	static UserInterface ui = UserInterface.getInstance();

	public static void main(String[] args) {
		int result;
		App app = new App();
		do {
			result = ui.showMainMenue();

			app.handleUserSelection(result);

		} while (result != Constant.EXIT);

	}

	void handleUserSelection(int val) {

		switch (val) {

		case 1:
			ui.addDoctor(drrepo);
			break;
		case 2:
			System.out.println("Enter the doctor id to remove that doctor");
			String doctorid = sc.next();
			Doctor dr = drrepo.getDoctor(doctorid);
			if (dr != null) {
				drrepo.remove(dr);
				System.out.println("Doctor removed");
			} else {
				System.out.println("doctor not found");
			}

			break;
		case 3:
			break;
		case 4:
			System.out.println("Enter doctor id to update");
			String id1 = sc.next();
			Doctor dr1 = drrepo.getDoctor(id1);
			if (dr1 != null) {
				ui.updateDoctorDetails(drrepo, dr1);
			} else {
				System.out.println("doctor not found");
			}

			break;
		case 5:
			drrepo.getAllDoctors();
			break;
		case 6:
			ui.addPatient(patRepo);
			break;
		case 7:
			System.out.println("enter patient id to remove patient");
			String patientId = sc.next();
			Patient pt = patRepo.getPatient(patientId);
			if (pt != null) {
				patRepo.remove(pt);
				System.out.println("Patient removed");
			} else {
				System.out.println("Patient not found");
			}

			break;
		case 8:
			System.out.println("enter patient id to check");
			String id = sc.next();
			Patient pat = patRepo.getPatient(id);
			if (pat != null) {
				System.out.println(pat);
			} else {
				System.out.println("Patient not found");
			}
			break;
		case 9:
			System.out.println("Enter Patient id to update");
			String pid = sc.next();
			Patient pt1 = patRepo.getPatient(pid);
			if (pt1 != null) {
				ui.updatePatientDetails(patRepo, pt1);
			} else {
				System.out.println("patient not found");
			}

			break;
		case 10:
			patRepo.getAllPatients();
			break;
		case 11:
			ui.addAppointment(drrepo, patRepo, appRepo);
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			ui.updateAppointmentDetails(drrepo, patRepo, appRepo);
			break;
		case 15:
			appRepo.getAllAppointments(drrepo, patRepo);
			break;
		case Constant.EXIT:
			System.out.println("application closed");
			break;
		default:
			System.out.println("Invalid Choice .. Try Again.");
		}
	}

}
