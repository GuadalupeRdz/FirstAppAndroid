package com.hetherlat.numerallove;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SecondActivityTest extends AppCompatActivity {

    //Aqui vamos a declarar los objetos que participan del Layout (grafico) en los eventos (código java)
    TextView txvNumeroPersona1;
    TextView txvNumeroPersona2;
    TextView txvResumenCompatibilidad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity_test);

        //Aqui vamos a "llenar" con los parametros que nos mando la otra vista, los TextView

        txvNumeroPersona1 = (TextView) findViewById(R.id.txvNumeroPersona1);
        txvNumeroPersona2 = (TextView) findViewById(R.id.txvNumeroPersona2);
        txvResumenCompatibilidad = (TextView) findViewById(R.id.txvResumenCompatibilidad);

        //Aqui indico que estos elementos los voy a cachar en un bundle zip, mediante el getExtras del intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //Valido el bundle
        if (bundle != null){
            //Extraigo la info del bundle extras y lo asigno al edittext
            String strNumeroPersona1 = (String) bundle.get("NumeroPersona1").toString();
            txvNumeroPersona1.setText("Numero Persona 1:" + strNumeroPersona1);

            String strNumeroPersona2 = (String) bundle.get("NumeroPersona2").toString();
            txvNumeroPersona2.setText(strNumeroPersona2);

            String strResumenCompatibilidad =  (String) bundle.get("ResumenCompatibilidad").toString();
            txvResumenCompatibilidad.setText(strResumenCompatibilidad);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_activity_test, menu);
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
