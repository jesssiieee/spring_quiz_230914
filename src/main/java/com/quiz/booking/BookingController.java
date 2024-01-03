package com.quiz.booking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {

	// 1. 예약목록
	// url : http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView() {
		return "booking/bookingList";
	}
	
	// 2. 예약하기
	// url : http://localhost:8080/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
}
