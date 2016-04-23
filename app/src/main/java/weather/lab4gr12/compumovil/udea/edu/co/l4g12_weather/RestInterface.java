package weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by kundan on 8/8/2015.
 */
public interface RestInterface {

    @GET("/weather?q=London,uk&appid=fa3fdff5301a355cbad7173b5314ea78")
    void getWheatherReport(Callback<Model> cb);

}
