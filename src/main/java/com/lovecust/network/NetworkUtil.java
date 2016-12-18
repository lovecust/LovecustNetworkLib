package com.lovecust.network;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fisher at 11:32 PM on 12/3/16.
 * <p>
 * Network util.
 */

class NetworkUtil {
	/**
	 * Get part from file for form-data http protocol.
	 *
	 * @param file File to be used.
	 * @param name File name.
	 * @return Form-data part.
	 */
	static MultipartBody.Part getPartFromFile(File file, String name) {
		if (null == file) {return null;}
		// create RequestBody instance from file
		RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
		// MultipartBody.Part is used to send also the actual file name
		MultipartBody.Part body = MultipartBody.Part.createFormData(name, file.getName(), requestFile);
		return body;
	}

	/**
	 * Make sure the return observable run on the main thread.
	 *
	 * @param obj observable object.
	 * @param <T> Api Response.
	 * @return Processed observable object.
	 */
	static <T> Observable<T> ensure(Observable<T> obj) {
		return obj.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread());
	}

	/**
	 * Get base retrofit.
	 */
	static Retrofit getBaseRetrofit(String agent, String header) {
		return new Retrofit.Builder()
				.baseUrl(NetworkConstant.server)
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.client(getBaseClient(agent, header))
				.build();
	}

	/**
	 * Get base client.
	 *
	 * @param agent  Client agent.
	 * @param header Client header.
	 * @return Base client.
	 */
	private static OkHttpClient getBaseClient(String agent, String header) {
		return new OkHttpClient.Builder()
				.addInterceptor(chain -> {
					Request request = chain.request()
							.newBuilder()
							.addHeader("x-agent", agent)
							.addHeader("lovecust", header)
							.build();
					return chain.proceed(request);
				})
				.readTimeout(20, TimeUnit.SECONDS)
				.build();
	}
}
