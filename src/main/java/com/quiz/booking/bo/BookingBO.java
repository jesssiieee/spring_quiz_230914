package com.quiz.booking.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;
import com.quiz.lesson06.domain.BookMark;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	// get booking list
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// add booking
	public void addBookingList(String name, Date date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBookingList(name, date, day, headcount, phoneNumber);
	}
	
	// delete booking
	public int deleteBookingListById(int id) {
		return bookingMapper.deleteBookingListById(id);
	}
	
	// public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		
	// }
	
	
	public boolean isDuplicationByNamePhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingList(name, phoneNumber);
		return bookingList.isEmpty() ? false : true;
	}
	
}
