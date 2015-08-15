package com.hetherlat.numerallove;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
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


public class NumeroPersonalidadActivity extends AppCompatActivity {

    private EditText edtFechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_personalidad);

        edtFechaNacimiento = (EditText) findViewById(R.id.edtFechaPersona);

        /*+++++++++++++PRIMERA PARTE++++++++++++++++
        Llenar el Cuadro de Texto con la fecha por default para que
        el usuario la mande correctamente
        ++++++++++++++++++++++++++++++++++++++++++++*/

        //Aqui damos el formato a la fecha ue va a ser pasado
        SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
        Date dateDefault = null;

        try {
            dateDefault = dateF.parse(String.valueOf("31/12/2000"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        edtFechaNacimiento.setText(dateF.format(dateDefault));

        Toast.makeText(this, "Fechas: dd/mm/yyyy", Toast.LENGTH_LONG).show();
        /*+++++++++++++SEGUNDA PARTE++++++++++++++++
        Aquí es donde se manda a llamar al escuchador de eventos,
        tanto el objeto como el escuchador y su correspondiente evento
        ++++++++++++++++++++++++++++++++++++++++++++*/

        Button btnCalcular = (Button) findViewById(R.id.btnCalcularNumeroPersonalidad);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clase que sirve para hacer calculos y validaciones nherentes del proceso como tal
                RecursosApp reApp = new RecursosApp();
                String strFechaNacimiento = edtFechaNacimiento.getText().toString();

                if (reApp.ValidaEntradaFechas(strFechaNacimiento)== true){
                    //Intento desde la aplicacion donde estoy hacia la actividad que quiero que abra
                    Intent intIntentActivity = new Intent(getApplicationContext(), MuestraNumeroPersonalidadActivity.class);
                    Integer intNumeroVida = reApp.getNumeroVida(strFechaNacimiento);

                    intIntentActivity.putExtra("NumeroPersonalidad", intNumeroVida);
                    startActivity(intIntentActivity);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_numero_personalidad, menu);
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
