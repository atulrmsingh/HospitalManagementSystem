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
}