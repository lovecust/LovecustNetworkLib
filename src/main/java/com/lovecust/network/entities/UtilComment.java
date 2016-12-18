package com.lovecust.network.entities;


public class UtilComment {
	private String fid;
	private String nick;
	private String avatar;
	private String value;
	private String html;
	private int favorite;
	private long ctime;
	private long atime;


	private UtilComment(String fid, String value) {
		this.ctime = System.currentTimeMillis();
		this.favorite = 0;
		this.fid = fid;
		// Interval time in milliseconds.
		this.atime = 5 * 24 * 3600 * 1000;
		this.value = value;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getNick() {
		return nick;
	}

	public UtilComment setNick(String nick) {
		this.nick = nick;
		return this;
	}

	public String getValue() {
		return value;
	}

	public UtilComment setValue(String value) {
		this.value = value;
		return this;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}


	public long getCtime() {
		return ctime;
	}

	public void setCtime(long ctime) {
		this.ctime = ctime;
	}

	public long getAtime() {
		return atime;
	}

	public UtilComment setAtime(long atime) {
		this.atime = atime;
		return this;
	}

	public String getAvatar() {
		return avatar;
	}

	public UtilComment setAvatar(String avatar) {
		this.avatar = avatar;
		return this;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
}
