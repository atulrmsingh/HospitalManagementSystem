package com.hms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoctorRepo {
	private static DoctorRepo instance;
	public Set<Doctor> doctorList = new HashSet<Doctor>();

	private DoctorRepo() {

	}

	public static DoctorRepo getInstance() {
		if (instance == null) {
			instance = new DoctorRepo();
		}
		return instance;
	}

	public void add(Doctor dr) {
		doctorList.add(dr);
	}
	
	public void remove(Doctor doctor) {
		doctorList.remove(doctor);
	}

	public boolean isDoctorAvailable(String id) {
		for (Doctor dr : doctorList) {
			if (dr.id.equals(id)) {
				return true;
			}
		}
		return false;
	}

	public Doctor getDoctor(String id) {
		for (Doctor dr : doctorList) {
		if(dr.id.equals(id)) {
				return dr;
			}
		}
		return null;
	}

	public void getAllDoctors() {
		if (!doctorList.isEmpty()) {
			for (Doctor dr : doctorList) {
				System.out.println(dr);
			}
		} else {
			System.out.println("no doctor found");
		}
	}

}