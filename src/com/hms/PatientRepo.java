package com.hms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.hms.Patient.Gender;

public class PatientRepo {
	Scanner sc = new Scanner(System.in);
	private static PatientRepo instance;
	Set<Patient> patientList = new HashSet<Patient>();

	private PatientRepo() {

	}

	public static synchronized PatientRepo getInstance() {
		if (instance == null) {
			instance = new PatientRepo();

		}
		return instance;

	}

	public void add(Patient pt) {
		patientList.add(pt);
	}

	public Set<Patient> getAllPatient() {
		return patientList;
	}

	public boolean isPatientAvailable(String id) {
		for (Patient pt : patientList) {
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
		for (Patient pt : patientList) {
			System.out.println(pt);
		}
		if(patientList.isEmpty()) {
			System.out.println("patient not found");
		}
	}

	public void remove(Patient pt) {
		patientList.remove(pt);
	}

	public Patient getPatient(String id) {
		for (Patient pt : patientList) {
			if (pt.id.equals(id)) {
				return pt;
			}
		}
		return null;
	}

}