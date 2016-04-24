package weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {

    TextView city, temperature, humidity, description;
    String url = "http://api.openweathermap.org/data/2.5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_city);

        city = (TextView) findViewById(R.id.ciudad);
        temperature = (TextView) findViewById(R.id.temperatura);
        humidity = (TextView) findViewById(R.id.humedad);
        description = (TextView) findViewById(R.id.descripcion);

        //making object of RestAdapter
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();

        //Creating Rest Services
        RestInterface restInterface = adapter.create(RestInterface.class);

        //Calling method to get whether report
        restInterface.getWheatherReport(new Callback<Model>() {
            @Override
            public void success(Model model, Response response) {
                city.setText(""+model.getName());
                temperature.setText(""+model.getWeather().get(0).getDescription());
                humidity.setText(""+model.getMain().getHumidity().toString());
                description.setText(""+model.getMain().getPressure().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();
            }
        });

    }


}
