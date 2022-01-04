package com.hms;


import java.util.Scanner;

public class App {
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

		} while (result != Constant.SYSTEMEXIT);

	}
	
	void handleDoctorSelection(int val) {
		switch(val) {
		case 1:
			ui.addDoctor(drrepo);
			break;
		case 2:
			ui.removeDoctor(drrepo);
			break;
		case 3:
			ui.updateDoctorDetails(drrepo);
			break;
		case 4:
			drrepo.getAllDoctors();
			break;
		case 5 : 
			System.out.println("Doctor System Exit");
			break;
			default : 
				System.out.println("Invalid Selection");
				break;
		}
	}
	
	void handlePatientSelection(int val) {
		switch(val) {
		case 1:
			ui.addPatient(patRepo);
			break;
		case 2:
			ui.removePatient(patRepo);
			break;
		case 3:
			ui.updatePatientDetails(patRepo);
			break;
		case 4:
			patRepo.getAllPatient();
			break;
		case 5 : 
			System.out.println("Patient System Exit");
			break;
			default : 
				System.out.println("Invalid Selection");
				break;
		}
	}

	void handleAppointmentSelection(int val) {
		switch(val) {
		case 1:
			ui.addAppointment(drrepo, patRepo, appRepo);
			break;
		case 2:
			ui.removeAppointment(appRepo);
			break;
		case 3:
			ui.updateAppointmentDetails(drrepo, patRepo, appRepo);
			break;
		case 4:
			appRepo.getAllAppointment();
			break;
		case 5 : 
			System.out.println("Appointment System Exit");
			break;
			default : 
				System.out.println("Invalid Selection");
				break;
		}
	}
	
	void handleUserSelection(int val) {
		switch (val) {
		case 1:
			int val1;
			do {
			val1 = ui.showDoctorMenu();
			handleDoctorSelection(val1);
			}while(val1 != Constant.DOCTOREXIT);
		case 2:
			int val2;
			do {
			val2 = ui.showPatientMenu();
			handlePatientSelection(val2);
			}while(val2 != Constant.PATIENTEXIT);
		case 3:
			int val3;
			do{
			val3 = ui.showAppointmentMenu();
			handleAppointmentSelection(val3);
			}while(val3 != Constant.APPOINTMENTEXIT);
		case Constant.SYSTEMEXIT:
			System.out.println("Application Closed");
			break;
		default:
			System.out.println("Invalid Choice .. Try Again.");
		}
	}

}
