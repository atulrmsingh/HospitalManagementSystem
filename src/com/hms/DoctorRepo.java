package com.hms;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepo {

	public List doctorList = new ArrayList();

	public void add(Doctor dr) {

		doctorList.add(dr);

	}

	public List getAllDoctors() {
		return doctorList;
	}

}
