package com.capgemini.doctors.bean;

import java.time.LocalDate;

public class DoctorAppointment
{
	private int appointmentId;						//class member variables
	private String patientName;
	private String phoneNumber;
	private String email;
	private String gender;
	private LocalDate appointmentDate;
	private int age;
	private String problemName;
	private String doctorName;
	private String appointmentStatus;
	
	//------------constructors-----------
	
	public DoctorAppointment() {
		super();
	}



	public DoctorAppointment(int appointmentId) {
		super();
		this.appointmentId = appointmentId;
	}



	public DoctorAppointment(String patientName, String phoneNumber, String email, String gender,
			LocalDate appointmentDate, int age, String problemName, String doctorName, String appointmentStatus) {
		super();
		this.patientName = patientName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.gender = gender;
		this.appointmentDate = appointmentDate;
		this.age = age;
		this.problemName = problemName;
		this.doctorName = doctorName;
		this.appointmentStatus = appointmentStatus;
	}



	public DoctorAppointment(int appointmentId, String patientName, String phoneNumber, String email, String gender,
			LocalDate appointmentDate, int age, String problemName, String doctorName, String appointmentStatus) {
		super();
		this.appointmentId = appointmentId;
		this.patientName = patientName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.gender = gender;
		this.appointmentDate = appointmentDate;
		this.age = age;
		this.problemName = problemName;
		this.doctorName = doctorName;
		this.appointmentStatus = appointmentStatus;
	}


	//-------------getters and setters------------------
	
	
	public int getAppointmentId() {
		return appointmentId;
	}



	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}



	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getProblemName() {
		return problemName;
	}



	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}



	public String getDoctorName() {
		return doctorName;
	}



	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}



	public String getAppointmentStatus() {
		return appointmentStatus;
	}



	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	//------------hashCode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appointmentId;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoctorAppointment other = (DoctorAppointment) obj;
		if (appointmentId != other.appointmentId)
			return false;
		return true;
	}


	//--------toString()----------

	@Override
	public String toString() {
		return "DoctorAppointment [appointmentId=" + appointmentId + ", patientName=" + patientName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", gender=" + gender + ", appointmentDate=" + appointmentDate
				+ ", age=" + age + ", problemName=" + problemName + ", doctorName=" + doctorName
				+ ", appointmentStatus=" + appointmentStatus + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
