package com.lovecust.network;

import com.lovecust.network.entities.Nothing;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Fisher on 12/18/2016 at 23:13.
 * <p>
 * Api Interface for Lovecust module.
 */
interface DevelopmentNetworkInterface {

	/**
	 * Post chat to turing robot.
	 *
	 * @param message Chat content detail.
	 */
	@FormUrlEncoded
	@POST(DevelopmentNetworkConstants.TRUING_CHATS)
	Observable<Nothing> postTuringChat(@Field("value") String message);

}
