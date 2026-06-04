package com.tka.Response;

import java.time.LocalDateTime;

public class ApiResponse<T> {

	private String serverTime;
	private Integer shResult;
	private String message;
	private T data;

	// Default Constructor
	public ApiResponse() {
		this.serverTime = LocalDateTime.now().toString();
	}

	// Parameterized Constructor
	public ApiResponse(Integer shResult, String message, T data) {
		this.serverTime = LocalDateTime.now().toString();
		this.shResult = shResult;
		this.message = message;
		this.data = data;
	}

	// Getters and Setters
	public String getServerTime() {
		return serverTime;
	}

	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}

	public Integer getShResult() {
		return shResult;
	}

	public void setShResult(Integer shResult) {
		this.shResult = shResult;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiResponse [serverTime=" + serverTime + ", shResult=" + shResult + ", message=" + message + ", data="
				+ data + "]";
	}

}