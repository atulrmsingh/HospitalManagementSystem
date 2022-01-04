package com.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.print.Doc;

import com.hms.Doctor.WeekDays;

public class UserInterface {
	private static UserInterface instance;
	Scanner sc = new Scanner(System.in);

	private UserInterface() {
	}

	public static UserInterface getInstance() {
		if (instance == null) {
			instance = new UserInterface();

		}
		return instance;

	}

	public int showMainMenue() {
		System.out.println("Press 1.Doctor\n" + "Press 2.Patient\n" + "Press 3.Appointment\n"+ "press " + Constant.SYSTEMEXIT + ".exit");
		int val = sc.nextInt();
		return val;
	}
	
	public int showDoctorMenu() {
		System.out.println("Press 1. Add Doctor\n"+ "Press 2. Remove Doctor\n"+"Press 3. Update Doctor\n"+ "Press 4. Get All Doctors\n"+ "Press 5. Back To Main Menu");
		int option = sc.nextInt();
		return option;
	}

	public int showPatientMenu() {
		System.out.println("Press 1. Add Patient\n"+ "Press 2. Remove Patient\n"+"Press 3. Update Patient\n"+ "Press 4. Get All Patients\n"+ "Press 5. Back To Main Menu");
		int option = sc.nextInt();
		return option;
	}

	public int showAppointmentMenu() {
		System.out.println("Press 1. Add Appointment\n"+ "Press 2. Remove Appointment\n"+"Press 3. Update Appointment\n"+ "Press 4. Get All Appointments\n"+ "Press 5. Back To Main Menu");
		int option = sc.nextInt();
		return option;
	}
	
	
	public void addDoctor(DoctorRepo drrepo) {
		Doctor dr = new Doctor();
		System.out.println("enter doctor id");
		dr.id = sc.next();
		if (!drrepo.isDoctorAvailable(dr.id)) {
			System.out.println("enter doctor name");
			dr.name = sc.next();
			System.out.println("enter doctor Specialist");
			dr.specialist = sc.next();
			System.out.println("enter doctor mobile");
			dr.mobile = sc.nextLong();
			System.out.println("enter email");
			dr.email = sc.next();
			dr.availability = new HashMap<WeekDays, String>();
			dr.availability.put(Doctor.WeekDays.SUNDAY, " 10 am to 12 pm");
			dr.availability.put(Doctor.WeekDays.MONDAY, " 11 am to 12 pm");
			dr.availability.put(Doctor.WeekDays.TUESDAY, " 12 am to 1 pm");
			dr.availability.put(Doctor.WeekDays.WEDNESDAY, " 10 am to 12 pm");
			dr.availability.put(Doctor.WeekDays.THURSDAY, " 10 am to 12 pm");
			dr.availability.put(Doctor.WeekDays.FRIDAY, " 10 am to 12 pm");
			dr.availability.put(Doctor.WeekDays.SATURDAY, " 10 am to 12 pm");

			drrepo.add(dr);
		} else {
			System.out.println("Doctor id already exists");
		}
	}

	public void updateDoctorDetails(DoctorRepo drrepo) {
		System.out.println("Enter Doctor Id to update : ");
		String drId = sc.next();
		Doctor dr1 = drrepo.getDoctor(drId);
		if(dr1 != null) {
			System.out.println("Kindly enter the updated details for doctor id :");
			System.out.println("Press 1. Update Name\n" + "Press 2.Update specialist\n" + "Press 3.Update Mobile\n"
					+ "Press 4.Update email");
			int numSelected = sc.nextInt();
			switch (numSelected) {
			case 1:
				System.out.println("Enter name to update");
				dr1.name = sc.next();
				break;
			case 2:
				System.out.println("Enter specialist to update");
				dr1.specialist = sc.next();
				break;
			case 3:
				System.out.println("Enter mobile to update");
				dr1.mobile = sc.nextLong();
				break;
			case 4:
				System.out.println("Enter email to update");
				dr1.email = sc.next();
				break;
			case Constant.UPDATEDOCTOREXIT:
				break;
			default:
				System.out.println("invalid selection");
			}
			System.out.println("Details Updated");
		}else {
			System.out.println("No Doctor found");
		}
		

	}

	public void addPatient(PatientRepo patRepo) {
		Patient pt = new Patient();
		System.out.println("enter patient id ");
		pt.id = sc.next();
		System.out.println("enter patient name ");
		pt.name = sc.next();
		System.out.println("enter patient age ");
		pt.age = sc.nextInt();
		System.out.println("Enter Gender : \n" + "Press 1 for Male\n" + "Press 2 for Female\n" + "Press 3 for others");
		int gender = sc.nextInt();
		pt = patRepo.setGender(pt, gender);

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

	public void updatePatientDetails(PatientRepo patRepo) {
		System.out.println("Enter Patient Id to update : ");
		String ptId = sc.next();
		Patient pt1 = patRepo.getPatient(ptId);
		if(pt1 != null) {
			System.out.println("Kindly enter the updated details for Patient id :");
			System.out.println("Press 1. Update Name\n" + "Press 2.Update age\n" + "Press 3.Update gender\n"
					+ "Press 4.Update mobile\n" + "Press 5.Update email\n" + "Press 6.Update city\n"
					+ "Press 7.Update Disease");
			int numSelected = sc.nextInt();
			switch (numSelected) {
			case 1:
				System.out.println("Enter name to update");
				pt1.name = sc.next();
				break;
			case 2:
				System.out.println("Enter age to update");
				pt1.age = sc.nextInt();
				break;
			case 3:
				System.out.println(
						"Update Gender : \n" + "Press 1 for Male\n" + "Press 2 for Female\n" + "Press 3 fro others");
				int gender = sc.nextInt();
				pt1 = patRepo.setGender(pt1, gender);
				break;
			case 4:
				System.out.println("Enter mobile to update");
				pt1.mobile = sc.nextLong();
				break;
			case 5:
				System.out.println("Enter email to update");
				pt1.email = sc.next();
				break;
			case 6:
				System.out.println("Enter city to update");
				pt1.city = sc.next();
				break;
			case 7:
				System.out.println("Enter Disease to update");
				pt1.Disease = sc.next();
				break;
			case Constant.UPDATEPATIENTEXIT:
				break;

			default:
				System.out.println("invalid selection");
			}
			System.out.println("Details Updated");
		}else {
			System.out.println("No Patient found");
		}		
	}

	public void addAppointment(DoctorRepo drrepo, PatientRepo patrepo, AppointmentRepo appRepo) {
		Appointment apt = new Appointment();
		System.out.println("enter appointment id");
		apt.appointmentId = sc.next();
		System.out.println("enter doctor id");
		apt.doctorId = sc.next();
		if (drrepo.isDoctorAvailable(apt.doctorId)) {
			System.out.println("enter patient id");
			apt.patientId = sc.next();
			if (patrepo.isPatientAvailable(apt.patientId)) {
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

	public void updateAppointmentDetails(DoctorRepo drrepo, PatientRepo patRepo, AppointmentRepo appRepo) {
		System.out.println("Enter appointment id to update");
		String aptid = sc.next();
		Appointment apt = appRepo.getAppointment(aptid);
		if (apt != null) {
			System.out.println(
					"Press 1. Update doctorId\n" + "Press 2.Update patientId\n" + "Press 3.Update appointmentDate");
			int numSelected = sc.nextInt();
			switch (numSelected) {
			case 1:
				System.out.println("Enter doctorId to update");
				String doctorId = sc.next();
				if (drrepo.isDoctorAvailable(doctorId)) {
					apt.doctorId = doctorId;
				} else {
					System.out.println("Doctor not found");
				}
				break;
			case 2:
				System.out.println("Enter patientId to update");
				String patientId = sc.next();
				if (patRepo.isPatientAvailable(patientId)) {
					apt.patientId = patientId;
				} else {
					System.out.println("Patient not found");
				}
				break;
			case 3:
				System.out.println("enter date in DD-MM-YYYY format to update ");
				String aptDate = sc.next();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				try {
					Date date = formatter.parse(aptDate);
					apt.appointmentDate = date;
				} catch (ParseException e) {

					System.out.println("Invalid Date");
				}
				break;
			case Constant.UPDATEAPPOINTMENTEXIT:
				break;
			}
			System.out.println("Details updated");

		} else {
			System.out.println("Appointment id not found");
		}

	}
	
	public void removeDoctor(DoctorRepo drrepo) {
		System.out.println("Enter Doctor Id to remove : ");
		String drId = sc.next();
		Doctor dr = drrepo.getDoctor(drId);
		if(dr != null) {
			drrepo.remove(dr);
			System.out.println("Doctor removed");
		}else {
			System.out.println("No Doctor found");
		}
	}

	public void removePatient(PatientRepo patRepo) {
		System.out.println("Enter Patient Id to remove : ");
		String ptId = sc.next();
		Patient pt = patRepo.getPatient(ptId);
		if(pt != null) {
			patRepo.remove(pt);
			System.out.println("Patient removed");
		}else {
			System.out.println("No Patient found");
		}
	}
	
	public void removeAppointment(AppointmentRepo appRepo) {
		System.out.println("Enter Appointment Id to remove : ");
		String appId = sc.next();
		Appointment app = appRepo.getAppointment(appId);
		if(app != null) {
			appRepo.remove(app);
			System.out.println("Patient removed");
		}else {
			System.out.println("No Patient found");
		}
	}
}
