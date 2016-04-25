package weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by CamiGomez318 on 22/04/2016.
 */
public class SearchCity extends Activity implements View.OnClickListener{

    EditText ciudad;
    Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ciudad = (EditText)findViewById(R.id.search_city);
        buscar = (Button)findViewById(R.id.bt_search);
        buscar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_search:
                String city = String.valueOf(ciudad.getText());
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("CIUDAD", city);
                startActivity(i);
                break;
        }

    }
}
