package weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by CamiGomez318 on 22/04/2016.
 */
public class SearchCity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {

    }
}
