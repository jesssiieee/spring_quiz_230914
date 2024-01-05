package com.quiz.booking.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data // getter / setter	
public class Booking {

	private int id;
	private String name;
	private int headcount;
	private int day;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String phoneNumber;
	private String state;
	private Date createdAt;
	private Date updatedAt;
	
	
	
	
	
}
