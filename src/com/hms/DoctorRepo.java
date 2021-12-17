package com.hms;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepo {

	public List<Doctor> doctorList = new ArrayList();

	public void add(Doctor dr) {
		doctorList.add(dr);
	}

	public List getAllDoctors() {
		return doctorList;
	}

	public boolean isDoctorAvailable(DoctorRepo drrepo, String id) {
		List doctorList = drrepo.getAllDoctors();
		boolean result = false;
		for (int i = 0; i < doctorList.size(); i++) {
			Doctor dr = (Doctor) doctorList.get(i);
			if (dr.id.equals(id)) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
}
