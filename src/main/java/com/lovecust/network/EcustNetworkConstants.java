package com.lovecust.network;

/**
 * Created by Fisher on 12/18/2016 at 23:13.
 * <p>
 * Api constants for Ecust module.
 */
class EcustNetworkConstants {
	public static String server = NetworkConstant.server;
	private static final String API_PREFIX = "/apis/ecust";
	/**
	 * Ecust library module.
	 */
	private static final String LIBRARY = API_PREFIX + "/library";
	static final String LIBRARY_STATUS = LIBRARY + "/status";
	/**
	 * Ecust jwc module.
	 */
	private static final String JWC = API_PREFIX + "/jwc";
	static final String JWC_NEWSES = JWC + "/newses";
	static final String JWC_NEWS = JWC_NEWSES + "/{newsID}";
	static final String JWC_NEWS_COMMENTS = JWC_NEWS + "/comments";
}
