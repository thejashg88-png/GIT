package com.girmiti.StudentManagement.dto;


import java.util.List;

public class StudentDTO {

    private String name;
    private String email;
    private List<AddressDTO> addresses;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<AddressDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}

    // Getters & Setters
    
}
