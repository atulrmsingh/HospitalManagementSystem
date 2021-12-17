package com.hms;

import java.util.ArrayList;
import java.util.List;

public class PatientRepo {

	List patientList = new ArrayList();

	public void add(Patient pt) {

		patientList.add(pt);

	}

	public List getAllPatient() {
		return patientList;
	}

	public boolean isPatientAvailable(PatientRepo patrepo, String id) {
		List patientList = patrepo.getAllPatient();
		boolean result = false;
		for (int i = 0; i < patientList.size(); i++) {
			Patient pt = (Patient) patientList.get(i);
			if (pt.id.equals(id)) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
}