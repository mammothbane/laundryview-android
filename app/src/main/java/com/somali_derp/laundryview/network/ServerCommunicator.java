package com.somali_derp.laundryview.network;

import com.somali_derp.laundryview.models.Machine;

import java.lang.reflect.Type;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;
import rx.Observable;

/**
 * Created by mammothbane on 8/29/2014.
 *
 * class to communicate with laundryview servers
 *
 */
public class ServerCommunicator {
    public static final String baseUrl = "http://www.laundryview.com/";

    static RestAdapter adapter = new RestAdapter.Builder().setEndpoint(baseUrl)
            .setLogLevel(RestAdapter.LogLevel.BASIC)
            .setConverter(new Converter() {
                @Override
                public Object fromBody(TypedInput body, Type type) throws ConversionException {



                    return null;
                }

                @Override
                public TypedOutput toBody(Object object) {
                    return null;
                }
            })
            .build();
    public static LaundryService service = adapter.create(LaundryService.class);

    private interface LaundryService {
        @GET("lvs.php")
        Observable<Response> listRooms();

        @GET("staticRoomData.php")
        Observable<List<Machine>> getStaticData(@Query("location") String roomId);

        @GET("dynamicRoomData.php")
        Observable<List<Machine>> getDynamicData(@Query("location") String roomId);
    }



}
