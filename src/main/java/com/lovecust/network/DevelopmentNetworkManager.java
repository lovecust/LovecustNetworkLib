package com.lovecust.network;

import com.lovecust.network.entities.Nothing;

import rx.Observable;

/**
 * Created by Fisher on 12/18/2016 at 22:56.
 * <p>
 * Development Manager for Ecust module.
 */
public class DevelopmentNetworkManager {

	private DevelopmentNetworkInterface mApiInterface;

	public DevelopmentNetworkManager(String agent, String header) {
		mApiInterface = NetworkUtil.getBaseRetrofit(agent, header)
				.create(DevelopmentNetworkInterface.class);
	}

	/**
	 * Post chat to turing robot.
	 *
	 * @param message Chat content.
	 */
	public Observable<Nothing> postTuringChat(String message) {
		return ensure(mApiInterface.postTuringChat(message));
	}


	/**
	 * Make sure the return observable run on the main thread.
	 *
	 * @param obj observable object.
	 * @param <T> Api Response.
	 * @return Processed observable object.
	 */
	private <T> Observable<T> ensure(Observable<T> obj) {
		return NetworkUtil.ensure(obj);
	}
}
