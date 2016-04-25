package weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather.POJO.Model;

public class MainActivity extends Activity {

    TextView city, temperature, humidity, description;
    ImageView icon;
    String url = "http://api.openweathermap.org/data/2.5";


    AsyncTask<String, Void, Bitmap> asyncTask = new AsyncTask<String, Void, Bitmap>() {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            URL imageUrl;
            Bitmap imagen = null;
            try {
                imageUrl = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
                conn.connect();
                imagen = BitmapFactory.decodeStream(conn.getInputStream());
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "Error cargando la imagen: " + e.getMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

            return imagen;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            icon.setImageBitmap(bitmap);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_city);
        Bundle ciudad = getIntent().getExtras();

        String citySearch = ciudad.getString("CIUDAD");
        city = (TextView) findViewById(R.id.ciudad);
        temperature = (TextView) findViewById(R.id.temperatura);
        humidity = (TextView) findViewById(R.id.humedad);
        description = (TextView) findViewById(R.id.descripcion);
        icon = (ImageView) findViewById(R.id.imagen);

        //making object of RestAdapter
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();

        //Creating Rest Services
        RestInterface restInterface = adapter.create(RestInterface.class);

        //Calling method to get whether report
        restInterface.getWheatherReport(citySearch, "fa3fdff5301a355cbad7173b5314ea78",new Callback<Model>() {
            @Override
            public void success(Model model, Response response) {

                //Nombre de la ciudad
                city.setText(model.getName() +", " + model.getSys().getCountry());
                //Temperatura en grados Celcius
                Double k = model.getMain().getTemp();
                Double c = k - 273.15;
                temperature.setText(c.toString() + "°");
                //Humedad en porcentage
                humidity.setText(model.getMain().getHumidity().toString()+"%");
                description.setText(model.getWeather().get(0).getDescription());
                Uri uri = Uri.parse("http://openweathermap.org/img/w/"
                        + model.getWeather().get(0).getIcon() + ".png");
                asyncTask.execute(uri.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();
            }
        });
    }
}
