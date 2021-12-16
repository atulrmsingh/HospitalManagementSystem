package com.hms;

public class Patient {

	enum Gender {
		Male, Female, Others,
	}

	String id;
	String name;
	int age;
	Gender gender;
	Long mobile;
	String email;
	String city;
	String Disease;

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", mobile=" + mobile
				+ ", email=" + email + ", city=" + city + ", Disease=" + Disease + "]";
	}

}
