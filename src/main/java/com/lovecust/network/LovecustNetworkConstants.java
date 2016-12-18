package com.lovecust.network;

/**
 * Created by Fisher on 12/18/2016 at 23:13.
 * <p>
 * Api constants for Ecust module.
 */
class LovecustNetworkConstants {
	public static String server = NetworkConstant.server;
	private static final String API_PREFIX = "/apis/lovecust";

	private static final String USERS = API_PREFIX + "/users";
	/**
	 * Users.Profile part.
	 */
	static final String USERS_PROFILE = USERS + "/profile";
	static final String USERS_PROFILE_AVATAR = USERS_PROFILE + "/avatar";
	/**
	 * Users.Feedback part.
	 */
	static final String USERS_FEEDBACK = USERS + "/feedback";

	/**
	 * General part.
	 */
	private static final String GENERAL = API_PREFIX + "/general";
	static final String GENERAL_APK = GENERAL + "/apk";
	static final String GENERAL_INTERNET = GENERAL + "/internet";
}
