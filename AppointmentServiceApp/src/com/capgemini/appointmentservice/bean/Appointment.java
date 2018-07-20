package com.capgemini.appointmentservice.bean;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable
{
	private int id;
	private String patientName;
	private long phoneNumber;
	private String email;
	private int age;
	private String gender;
	private String problem;
	private Date date;
	private String appointmentStatus;
	private String doctorAssigned;
	
	{
		appointmentStatus  = "DISAPPROVED";
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int id) {
		this.id = id;
	}

	public Appointment(String patientName, long phoneNumber, String email, int age, String gender, String problem,
			Date date) {
		super();
		this.patientName = patientName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.problem = problem;
		this.date = date;
	}
	
	public Appointment(int id, String patientName, long phoneNumber, String email, int age, String gender,
			String problem, Date date, String appointmentStatus, String doctorAssigned) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.problem = problem;
		this.date = date;
		this.appointmentStatus = appointmentStatus;
		this.doctorAssigned = doctorAssigned;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public String getDoctorAssigned() {
		return doctorAssigned;
	}

	public void setDoctorAssigned(String doctorAssigned) {
		this.doctorAssigned = doctorAssigned;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patientName=" + patientName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", age=" + age + ", gender=" + gender + ", problem=" + problem + ", date=" + date
				+ ", appointmentStatus=" + appointmentStatus + ", doctorAssigned=" + doctorAssigned + "]";
	}
}
