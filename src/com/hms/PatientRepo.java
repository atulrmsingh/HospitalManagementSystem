package com.hms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hms.Patient.Gender;

public class PatientRepo {
	Scanner sc = new Scanner(System.in);
	private static PatientRepo instance;
	List<Patient> patientList = new ArrayList<Patient>();

	private PatientRepo() {

	}

	public static PatientRepo getInstance() {
		if (instance == null) {
			instance = new PatientRepo();

		}
		return instance;

	}

	public void add(Patient pt) {
		patientList.add(pt);
	}

	public List<Patient> getAllPatient() {
		return patientList;
	}

	public boolean isPatientAvailable(String id) {
		for (int i = 0; i < patientList.size(); i++) {
			Patient pt = (Patient) patientList.get(i);
			if (pt.id.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public Patient setGender(Patient pt1,int num) {
		switch (num) {
		case 1: 
			pt1.gender = Gender.Male;
			break;
		case 2:
			pt1.gender = Gender.Female;
			break;
		default : 
			pt1.gender = Gender.Others;
			break;
		}
		return pt1;
	}

	public void getAllPatients() {
		for (int i = 0; i < patientList.size(); i++) {
			System.out.println(patientList.get(i));
		}
		if(patientList.isEmpty()) {
			System.out.println("patient not found");
		}
	}

	public void remove(Patient pt) {
		patientList.remove(pt);
	}

	public Patient getPatient(String id) {
		for (int i = 0; i < patientList.size(); i++) {
			Patient pt = (Patient) patientList.get(i);
			if (pt.id.equals(id)) {
				return pt;
			}
		}
		return null;
	}

}