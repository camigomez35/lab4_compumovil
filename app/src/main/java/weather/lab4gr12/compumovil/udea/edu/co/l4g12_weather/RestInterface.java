package weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather.POJO.Model;

/**
 * Created by kundan on 8/8/2015.
 */
public interface RestInterface {

    @GET("/weather")
    void getWheatherReport(@Query("q") String place,
                           @Query("appid") String appId, Callback<Model> cb);


}
