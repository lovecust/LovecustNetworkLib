package com.lovecust.network;

import android.support.annotation.Nullable;

import com.lovecust.network.entities.EcustJwcNews;
import com.lovecust.network.entities.EcustLibraryStatus;
import com.lovecust.network.entities.Nothing;
import com.lovecust.network.entities.UtilComment;
import com.lovecust.network.entities.request.ecust.JwcNewsCommentRequest;

import rx.Observable;

/**
 * Created by Fisher on 12/18/2016 at 22:56.
 * <p>
 * Api Manager for Ecust module.
 */
public class EcustNetworkManager {

	private EcustNetworkInterface mApiInterface;

	public EcustNetworkManager(String agent, String header) {
		mApiInterface = NetworkUtil.getBaseRetrofit(agent, header)
				.create(EcustNetworkInterface.class);
	}

	/**
	 * Get current library status.
	 */
	public Observable<EcustLibraryStatus> getLibraryStatus() {
		return ensure(mApiInterface.getLibraryStatus());
	}

	/**
	 * Get jwc newses list.
	 */
	public Observable<EcustJwcNews[]> getJwcNewses() {
		return ensure(mApiInterface.getJwcNewses());
	}

	/**
	 * Get the specific jwc news detail.
	 *
	 * @param newsID Jwc news id (md5).
	 */
	public Observable<EcustJwcNews> getJwcNewsDetail(String newsID) {
		return ensure(mApiInterface.getJwcNewsDetail(newsID));
	}

	/**
	 * Get the specific jwc news comments.
	 *
	 * @param newsID Jwc news id (md5).
	 */
	public Observable<UtilComment[]> getJwcNewsComments(String newsID) {
		return ensure(mApiInterface.getJwcNewsComments(newsID));
	}

	/**
	 * Post a comment into the specific jwc news.
	 *
	 * @param newsID News id.
	 * @param value  Comment detail.
	 * @param nick   User nick.
	 * @param avatar User avatar.
	 */
	public Observable<Nothing> postJwcNewsComment(String newsID, String value, String nick, @Nullable String avatar) {
		JwcNewsCommentRequest request = new JwcNewsCommentRequest(nick, value);
		request.setAvatar(avatar);
		return ensure(mApiInterface.postJwcNewsComment(newsID, request));
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
