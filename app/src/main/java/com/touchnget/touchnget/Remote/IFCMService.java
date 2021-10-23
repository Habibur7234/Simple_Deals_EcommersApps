package com.touchnget.touchnget.Remote;

import com.touchnget.touchnget.Model.FCMResponse;
import com.touchnget.touchnget.Model.FCMSendData;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAA1vEC2fM:APA91bEL87-ec0FBv-Fxoc8Z8lUy3S7z7Q8yR_4CAnYczw9LsrY21iWGMZ7TqjDZuc8gJH6StMWYPC3LmebHndWSdSL7Y9UFhLv4EjPGXnvo7eppWWRlvL8MadGXe8y38MnXLAPsgDS4"
    })
    @POST("fcm/send")
    Observable<FCMResponse> sendNotification(@Body FCMSendData body);
}
