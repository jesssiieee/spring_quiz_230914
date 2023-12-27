package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@Controller
@RequestMapping("/weather_history")
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// url : http://localhost:8080/weather_history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	// url : http://localhost:8080/weather_history/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView(
			Model model,
			@ModelAttribute WeatherHistory weatherHistory ) {
		
		weatherHistoryBO.addWeather(weatherHistory);
		
		List<WeatherHistory> weatherList = (List<WeatherHistory>) weatherHistoryBO.getWeatherHistoryById();
		model.addAttribute("weatherList", weatherList);
		
		return "weather_history/weatherList";
	}
	
	
}
