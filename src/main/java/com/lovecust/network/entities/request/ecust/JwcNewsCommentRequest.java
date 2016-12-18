package com.lovecust.network.entities.request.ecust;

/**
 * Created by fisher at 4:06 AM on 12/19/16.
 * <p>
 * Request entity for jwc news comment.
 */

public class JwcNewsCommentRequest {

	private String fid;
	private String nick;
	private String avatar;
	private String value;
	private String html;

	/**
	 * Nick and comment value are necessary.
	 */
	public JwcNewsCommentRequest(String nick, String value) {
		setNick(nick);
		setValue(value);
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

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
}
