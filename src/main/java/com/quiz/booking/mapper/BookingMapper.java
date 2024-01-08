package com.quiz.booking.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {

	// get booking list
	public List<Booking> selectBookingList();
	
	// duplication
	public List<Booking> selectBookingList(
			@Param("name")String name,
			@Param("phoneNumber")String phoneNumber );
	
	// add booking list
	public void insertBookingList(
			@Param("name") String name, 
			@Param("date") Date date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	// delete booking list
	public int deleteBookingListById(int id);
	
	// input : name, phoneNumber
	// output : List
	public List<Booking> selectBookingListByNamePhoneNumber(
		    @Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
	
}
