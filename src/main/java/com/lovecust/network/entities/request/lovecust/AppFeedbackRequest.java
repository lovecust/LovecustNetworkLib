package com.lovecust.network.entities.request.lovecust;

import com.lovecust.network.entities.AppFeedback;

/**
 * Created by fisher at 3:23 AM on 12/19/16.
 * <p>
 * Request entity for post feedback.
 */

public class AppFeedbackRequest {

	public AppFeedbackRequest(String nick, String value) {
		this.nick = nick;
		this.value = value;
		this.to = AppFeedback.LOVECUST_ADMIN;
	}

	private int id;
	private String value;
	private long ctime;
	private String nick;
	private String from;
	private String to;
	private boolean read = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getCtime() {
		return ctime;
	}

	public void setCtime(long ctime) {
		this.ctime = ctime;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}


}
