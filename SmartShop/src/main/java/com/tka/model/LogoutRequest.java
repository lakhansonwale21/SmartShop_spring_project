package com.tka.model;

public class LogoutRequest {
	private Integer id;
	private String customerName;

	public LogoutRequest(Integer id, String customerName) {
		super();
		this.id = id;
		this.customerName = customerName;
	}

	public LogoutRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "LogoutRequest [id=" + id + ", customerName=" + customerName + "]";
	}

}
