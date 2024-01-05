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
	
	@SuppressWarnings("unchecked")
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
	   
		// 없는 경우 : [] null, 존재하는 경우[...] 객체
		List<Booking> bookingList =  bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);
		
//		if (bookingList.isEmpty()) {
//			return null;
//		} else {
//			return bookingList.get(bookingList.size() - 1); // 마지막 인덱스 
//		}
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
			
		
		
		
	}
}
