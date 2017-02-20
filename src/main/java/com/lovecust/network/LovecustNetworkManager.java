package com.lovecust.network;

import com.lovecust.network.entities.AppFeedback;
import com.lovecust.network.entities.AppProfile;
import com.lovecust.network.entities.AppProfileAvatar;
import com.lovecust.network.entities.AppUpdateStatus;
import com.lovecust.network.entities.InternetStatus;
import com.lovecust.network.entities.Nothing;

import java.io.File;

import rx.Observable;

/**
 * Created by Fisher on 12/18/2016 at 22:56.
 * <p>
 * Api Manager for Ecust module.
 */
public class LovecustNetworkManager {

	private LovecustNetworkInterface mApiInterface;

	public LovecustNetworkManager(String agent, String header) {
		mApiInterface = NetworkUtil.getBaseRetrofit(agent, header)
				.create(LovecustNetworkInterface.class);
	}

	/**
	 * Update user profile.
	 *
	 * @param profile Profile detail.
	 */
	public Observable<Nothing> updateProfile(AppProfile profile) {
		return ensure(mApiInterface.updateProfile(profile));
	}

	/**
	 * Update user avatar.
	 *
	 * @param avatar Avatar detail.
	 */
	public Observable<AppProfileAvatar> updateProfileAvatar(File avatar) {
		return ensure(mApiInterface.updateProfileAvatar(NetworkUtil.getPartFromFile(avatar, "avatar")));
	}

	/**
	 * Get unread feedback.
	 */
	public Observable<AppFeedback[]> getUnreadFeedback() {
		return ensure(mApiInterface.getUnreadFeedback());
	}

	/**
	 * Post feedback.
	 *
	 * @param nick  User nickname.
	 * @param value Feedback content.
	 */
	public Observable<AppFeedback> postFeedback(String nick, String value) {
		return ensure(mApiInterface.postFeedback(nick, value));
	}

	/**
	 * Get android apk version info.
	 */
	public Observable<AppUpdateStatus> getAndroidVersionInfo() {
		return ensure(mApiInterface.getAndroidVersionInfo());
	}

	/**
	 * Get internet status.
	 */
	public Observable<InternetStatus> getInternetStatus(long usingTime, String acID) {
		return ensure(mApiInterface.getInternetStatus(usingTime, acID));
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
