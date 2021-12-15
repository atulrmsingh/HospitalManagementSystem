package com.hms;

import java.util.Scanner;

public class UserInterface {
	
		public int showMainMenue() {
		System.out.println("Press 1.Add doctor\n "+" Press 2.Remove doctor \n"+ "Press 3.Get Doctor \n"+" Press 4.Update Doctor \n"+ "Press 5.Get all Doctor"
		+"Press 6.Add Patient\n "+" Press 7.Remove Patient \n"+ "Press 8.Get Patient \n"+" Press 9.Update Patient \n"+"Press 10.Get all Patient"
		+"Press 11.Add Appointment\n "+" Press 12.Remove Appointment \n"+ "Press 13.Get Appointment \n"+" Press 14.Update Appointment \n"+"Press 15.Get all Appointment");
		
		Scanner sc = new Scanner(System.in);
		int val=sc.nextInt();
		return val;
		
	}
	
}
