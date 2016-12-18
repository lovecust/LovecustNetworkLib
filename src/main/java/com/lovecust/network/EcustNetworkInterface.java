package com.lovecust.network;

import com.lovecust.network.entities.EcustJwcNews;
import com.lovecust.network.entities.EcustLibraryStatus;
import com.lovecust.network.entities.Nothing;
import com.lovecust.network.entities.UtilComment;
import com.lovecust.network.entities.request.ecust.JwcNewsCommentRequest;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Fisher on 12/18/2016 at 23:13.
 * <p>
 * Api Interface for Ecust module.
 */
interface EcustNetworkInterface {

	/**
	 * Get current library status.
	 */
	@GET(EcustNetworkConstants.LIBRARY_STATUS)
	Observable<EcustLibraryStatus> getLibraryStatus();

	/**
	 * Get jwc newses list.
	 */
	@GET(EcustNetworkConstants.JWC_NEWSES)
	Observable<EcustJwcNews[]> getJwcNewses();

	/**
	 * Get the specific jwc news detail.
	 *
	 * @param newsID Jwc news id (md5).
	 */
	@GET(EcustNetworkConstants.JWC_NEWS)
	Observable<EcustJwcNews> getJwcNewsDetail(@Path("newsID") String newsID);

	/**
	 * Get the specific jwc news comments.
	 *
	 * @param newsID Jwc news id (md5).
	 */
	@GET(EcustNetworkConstants.JWC_NEWS_COMMENTS)
	Observable<UtilComment[]> getJwcNewsComments(@Path("newsID") String newsID);

	/**
	 * Post a comment into the specific jwc news.
	 *
	 * @param newsID News id.
	 * @param comment Comment detail.
	 */
	@POST(EcustNetworkConstants.JWC_NEWS_COMMENTS)
	Observable<Nothing> postJwcNewsComment(
			@Path("newsID") String newsID,
			@Body JwcNewsCommentRequest comment
	);

}
