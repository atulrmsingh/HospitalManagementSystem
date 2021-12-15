package com.hms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		UserInterface ui = new UserInterface();
		int result = ui.showMainMenue();
		
		App app = new App();
		app.handleUserSelection(result);
	}	
	
	void handleUserSelection(int val) {
		
		switch(val) {
		
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;	
		case 13:
				break;
		case 14:
				break;
		case 15:
			break;
	}
		
	}
	public void addDoctor() {
		Doctor dr = new Doctor();
		System.out.println("enter doctor id");
		Scanner sc = new Scanner(System.in);
		String ID = sc.next();
		System.out.println("enter doctor name");
		String name = sc.next();
		System.out.println("enter doctor Specialist");
		String Specialist = sc.next();
		System.out.println("enter doctor mobile");
		Long mobile = sc.nextLong();
		System.out.println("enter email");
		String email = sc.next();
		
		
		dr.availability = new HashMap();
		dr.availability.put(Doctor.WeekDays.SUNDAY, " 10 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.MONDAY, " 11 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.TUESDAY, " 12 am to 1 pm");
		dr.availability.put(Doctor.WeekDays.WEDNESDAY, " 10 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.THURSDAY, " 10 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.FRIDAY, " 10 am to 12 pm");
		dr.availability.put(Doctor.WeekDays.SATURDAY, " 10 am to 12 pm");
	
		
		DoctorRepo drrepo = new DoctorRepo();
		drrepo.add(dr);
		
		
		
	}
		
		
	
		
			
	
}
