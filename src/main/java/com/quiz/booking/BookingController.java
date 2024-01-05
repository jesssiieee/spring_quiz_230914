package com.quiz.booking;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingBO bookingBO;

	// 1. 예약목록
	// url : http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {

		// select DB
		List<Booking> bookingList = bookingBO.getBookingList();

		// model에 담기
		model.addAttribute("bookingList", bookingList);

		return "booking/bookingList";
	}

	// 2. 예약하기
	// url : http://localhost:8080/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}

	// 예약 등록하기 - ajax
	@ResponseBody
	@PostMapping("/add-booking-list")
	public Map<String, Object> addBookingList(@RequestParam("name") String name,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam("day") int day,
			@RequestParam("headcount") int headcount, @RequestParam("phoneNumber") String phoneNumber) {

		bookingBO.addBookingList(name, date, day, headcount, phoneNumber);

		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");

		return result;

	}

	// 예약 삭제하기 - ajax
	@ResponseBody
	@DeleteMapping("/delete-booking-list")
	public Map<String, Object> deleteBookingList(@RequestParam("id") int id) {

		// db 삭제
		int rowCount = bookingBO.deleteBookingListById(id);

		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제하는데 실패했습니다.");
		}

		return result;

	}

	// 예약 확인 화면
	// url : http://localhost:8080/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}

	// 예약자 확인 - ajax
	@ResponseBody
	@PostMapping("/check-booking-list")
	public Map<String, Object> checkBookingList(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {

		// {"code": 200, "result":"booking 객체"}
		// {"code": 200, "result":"{"name":"홍길동", ...}"}
		Map<String, Object> result = new HashMap<>();
		
		Booking booking = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
		
		if (booking == null) {
			// {"code": 500, "error_message":"예약 내역이 존재하지 않습니다."}
			result.put("code", 500);
			result.put("error_message", "예약 내역이 존재하지 않습니다.");
		} else {
			result.put("code", 200);
			result.put("result", booking);
		}
		
		return result;
		
	}

}
