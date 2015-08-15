package com.hetherlat.numerallove;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private EditText edtFechaP1;
    private EditText edtFechaP2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFechaP1 = (EditText) findViewById(R.id.edtFechaPersona1);
        edtFechaP2 = (EditText) findViewById(R.id.edtFechaPersona2);

        //Aqui vamos a obtener los recursos, aunque solo quiero uno
        Resources res = getResources();

        //Aqui vamos a obtener del array Resources la FechaDefault , para no hardcodear
        String strFechaDefault = "31/12/2015";
        //Aqui damos el formato a la fecha ue va a ser pasado
        SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");

        Date dateDefault = null;

        try {
            dateDefault = dateF.parse(String.valueOf(strFechaDefault));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        edtFechaP1.setText(dateF.format(dateDefault));
        edtFechaP2.setText(dateF.format(dateDefault));

        Toast.makeText(this, "aaaa", Toast.LENGTH_LONG).show();

        //Aquí es donde se manda a llamar al escuchador de eventos, tanto el objeto como el escuchador y su correspondiente evento
        Button btnCalcular = (Button) findViewById(R.id.btnCalcularNumeroPersonalidad);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intento desde la aplicacion donde estoy hacia la actividad que quiero que abra
                Intent intIntentActivity = new Intent(getApplicationContext(), SecondActivityTest.class);

                String strFechaPersona1 = edtFechaP1.getText().toString();
                String strFechaPersona2 = edtFechaP2.getText().toString();


                RecursosApp reApp = new RecursosApp();


                Integer intNumeroP1 = reApp.getNumeroVida(strFechaPersona1);
                Integer intNumeroP2 = reApp.getNumeroVida(strFechaPersona2);

                intIntentActivity.putExtra("NumeroPersona1", intNumeroP1);
                intIntentActivity.putExtra("NumeroPersona2", intNumeroP2);
                intIntentActivity.putExtra("ResumenCompatibilidad", R.string.DemoResumenCompatibilidad);
                startActivity(intIntentActivity);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
