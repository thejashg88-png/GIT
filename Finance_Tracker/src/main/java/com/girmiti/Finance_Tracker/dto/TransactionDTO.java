package com.girmiti.Finance_Tracker.dto;

public record TransactionDTO(
	    String description, 
	    Double amount, 
	    String category, 
	    String date
	) {

}
