package com.hms;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepo {
	private static DoctorRepo instance;
	public List<Doctor> doctorList = new ArrayList<Doctor>();

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
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).id.equals(id)) {
				return true;
			}
		}
		return false;
	}

	public Doctor getDoctor(String id) {
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).id.equals(id)) {
				return doctorList.get(i);
			}
		}
		return null;
	}

	public void getAllDoctors() {
		if (!doctorList.isEmpty()) {
			for (int i = 0; i < doctorList.size(); i++) {
				System.out.println(doctorList.get(i));
			}
		} else {
			System.out.println("no doctor found");
		}
	}

}