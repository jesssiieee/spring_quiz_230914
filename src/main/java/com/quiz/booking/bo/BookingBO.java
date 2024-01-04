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
	    List<Booking> bookings = (List<Booking>) bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);

	    if (!bookings.isEmpty()) {
	        return bookings.get(0); // 여러 개 중 첫 번째 결과를 사용
	    } else {
	        return null; // 예약이 없을 경우 null 반환
	    }
	}
}
