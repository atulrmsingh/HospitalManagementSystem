package com.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.hms.Patient.Gender;

public class UserInterface {
	Scanner sc = new Scanner(System.in);

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

	public void addDoctor(DoctorRepo drrepo) { // Doctor methods
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

	public void getAllDoctors(DoctorRepo drrepo) {
		List doctorList = drrepo.getAllDoctors();
		for (int i = 0; i < doctorList.size(); i++) {
			System.out.println(doctorList.get(i));
		}
	}
	/////////// DOCTOR METHOD ENDED

	public void addPatient(PatientRepo patRepo) { // patient methods
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

		patRepo.add(pt);
	}

	public void getAllPatients(PatientRepo patRepo) {
		List patienttList = patRepo.getAllPatient();
		for (int i = 0; i < patienttList.size(); i++) {
			System.out.println(patienttList.get(i));
		}
	}

	public void addAppointment(DoctorRepo drrepo, AppointmentRepo appRepo, PatientRepo patrepo) { // appointment methods
		Appointment apt = new Appointment();
		System.out.println("enter appointment id");
		apt.appointmentId = sc.next();
		System.out.println("enter doctor id");
		apt.doctorId = sc.next();
		if (drrepo.isDoctorAvailable(drrepo, apt.doctorId)) {
			System.out.println("enter patient id");
			apt.patientId = sc.next();
			if (patrepo.isPatientAvailable(patrepo, apt.patientId)) {
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
			} else {
				System.out.println("Patient not found");
			}
		} else {
			System.out.println("Doctor not found");
		}
	}

	public void getAllAppointments(AppointmentRepo appRepo) {
		List appointmentList = appRepo.getAllAppointment();
		for (int i = 0; i < appointmentList.size(); i++) {
			System.out.println(appointmentList.get(i));
		}

	}

}
