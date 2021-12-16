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
			addDoctor();
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
			addPatient();
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
			addAppointment();
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

	public void addDoctor() {
		Doctor dr = new Doctor();
		System.out.println("enter doctor id");
		dr.id = sc.next();
		System.out.println("enter doctor name");
		dr.name = sc.next();
		System.out.println("enter doctor Specialist");
		dr.specialist = sc.next();
		System.out.println("enter doctor mobile");
		dr.mobile = sc.nextLong();
		System.out.println("enter email");
		dr.email = sc.next();

		dr.availability = new HashMap();
		dr.availability.put(Doctor.WeekDays.SUNDAY, " 10 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.MONDAY, " 11 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.TUESDAY, " 12 am to 1 pm");
		dr.availability.put(Doctor.WeekDays.WEDNESDAY, " 10 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.THURSDAY, " 10 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.FRIDAY, " 10 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.SATURDAY, " 10 am to 12 pm");

		drrepo.add(dr);

	}

	public void addPatient() {
		Patient pt = new Patient();
		System.out.println("enter patient id ");
		pt.id = sc.next();
		System.out.println("enter patient name ");
		pt.name = sc.next();
		System.out.println("enter patient age ");
		pt.age = sc.nextInt();
		System.out.println("enter patient gender M/F ");
		String gen = sc.next();
		if (gen.equalsIgnoreCase("M")) {
			pt.gender = Gender.Male;
		} else if (gen.equalsIgnoreCase("F")) {
			pt.gender = Gender.Female;
		} else {
			pt.gender = Gender.Others;
		}

		System.out.println("enter patient mobile ");
		pt.mobile = sc.nextLong();
		System.out.println("enter patient email ");
		pt.email = sc.next();
		System.out.println("enter patient city ");
		pt.city = sc.next();
		System.out.println("enter patient disease ");
		pt.Disease = sc.next();

		// PatientRepo ptrepo = new PatientRepo();
		patRepo.add(pt);
	}

	public void addAppointment() {

		Appointment apt = new Appointment();
		System.out.println("enter appointment id");
		apt.appointmentId = sc.next();
		System.out.println("enter doctor id");
		apt.doctorId = sc.next();
		System.out.println("enter patient id");
		apt.patientId = sc.next();
		System.out.println("enter date in DD-MM-YYYY format");
		String dateInString = sc.next();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date = formatter.parse(dateInString);
			apt.appointmentDate = date;
		} catch (ParseException e) {

			System.out.println("Invalid Date");
		}
		appRepo.add(apt);
	}

}
