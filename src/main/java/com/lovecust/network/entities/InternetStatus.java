package com.lovecust.network.entities;

/**
 * Created by fisher at 12:41 AM on 12/19/16.
 * <p>
 * Internet status.
 */

public class InternetStatus {

	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isOkay() {
		return 0 == code;
	}
}
