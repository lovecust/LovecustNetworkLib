package com.lovecust.network;

import com.lovecust.network.entities.AppFeedback;
import com.lovecust.network.entities.AppProfile;
import com.lovecust.network.entities.AppProfileAvatar;
import com.lovecust.network.entities.AppUpdateStatus;
import com.lovecust.network.entities.InternetStatus;
import com.lovecust.network.entities.Nothing;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Fisher on 12/18/2016 at 23:13.
 * <p>
 * Api Interface for Lovecust module.
 */
interface LovecustNetworkInterface {

	/**
	 * Update user profile.
	 *
	 * @param profile Profile detail.
	 */
	@PATCH(LovecustNetworkConstants.USERS_PROFILE)
	Observable<Nothing> updateProfile(@Body AppProfile profile);

	/**
	 * Update user avatar.
	 *
	 * @param avatar Avatar detail.
	 */
	@Multipart
	@PUT(LovecustNetworkConstants.USERS_PROFILE_AVATAR)
	Observable<AppProfileAvatar> updateProfileAvatar(@Part() MultipartBody.Part avatar);

	/**
	 * Get unread feedback.
	 */
	@GET(LovecustNetworkConstants.USERS_FEEDBACK)
	Observable<AppFeedback[]> getUnreadFeedback();

	/**
	 * Post feedback.
	 *
	 * @param nick  User nickname.
	 * @param value Feedback content.
	 */
	@FormUrlEncoded
	@POST(LovecustNetworkConstants.USERS_FEEDBACK)
	Observable<AppFeedback> postFeedback(
			@Field("nick") String nick
			, @Field("value") String value
	);

	/**
	 * Get android apk version info.
	 */
	@GET(LovecustNetworkConstants.GENERAL_APK)
	Observable<AppUpdateStatus> getAndroidVersionInfo();

	/**
	 * Get internet status.
	 */
	@GET(LovecustNetworkConstants.GENERAL_INTERNET)
	Observable<InternetStatus> getInternetStatus(
			@Query("usingTime") long usingTime,
	        @Query("acID") String acID
	);
}
