package com.abcbank.ib.service.dto;

public class CustomerDTO {
	
	private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String loginId;

    private String dateOfOnboarding;

    private String pan;

    private String firstName;

    private String lastName;

    private String middleName;

    private String status;

    private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getDateOfOnboarding() {
		return dateOfOnboarding;
	}

	public void setDateOfOnboarding(String dateOfOnboarding) {
		this.dateOfOnboarding = dateOfOnboarding;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", name=" + name + ", loginId=" + loginId + ", dateOfOnboarding="
				+ dateOfOnboarding + ", pan=" + pan + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", status=" + status + ", location=" + location + "]";
	}    

}
