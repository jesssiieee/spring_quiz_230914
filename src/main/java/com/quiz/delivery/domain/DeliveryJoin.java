package com.quiz.delivery.domain;

public class DeliveryJoin {

	private int id;
	private int storeId;
	private String name;
	private String menu;
	private String userName;
	private double point;
	private String review;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
//	select A.`name`, B.`menu`, B.`userName`, B.`point`, B.`review`
//	from `store` AS A
//	inner join `new_review` AS B
//	on A.`id` = B.`storeId`;
	
}
