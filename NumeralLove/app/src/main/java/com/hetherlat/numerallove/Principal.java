package com.hetherlat.numerallove;

import android.content.Intent;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Principal extends AppCompatActivity {

    ListView ls;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Se completa la vista, del list view
        Actividades renglones_actividad[] = new Actividades[]{
                new Actividades(R.mipmap.ic_ac_personal_number, "Numero Personalidad"),
                new Actividades(R.mipmap.ic_ac_test_love, "Compatibilidad Amor"),
                new Actividades(R.mipmap.ic_about, "Acerca de...")
        };

        //A este adpatador le vamos a pasar el contexto (this),
        //el layout o diseño que se va a utilizar (layout.renglon)
        //y la fuente de los datos a utilizar (renglones_datos).
        ActividadAdapter adapter = new ActividadAdapter(this, R.layout.actividad, renglones_actividad);

        ls = (ListView) findViewById(R.id.lstActivities);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                TextView v = (TextView) arg1.findViewById(R.id.txvTextoActividad);
                String strMenuSeleccionado = v.getText().toString();
                Intent intIntentActivity = null;

                switch (strMenuSeleccionado) {
                    case "Numero Personalidad":
                        intIntentActivity  = new Intent(getApplicationContext(), NumeroPersonalidadActivity.class);
                        startActivity(intIntentActivity);
                        break;
                    case "Compatibilidad Amor":
                        intIntentActivity  = new Intent(getApplicationContext(), CompatibilidadAmorosaActivity.class);
                        startActivity(intIntentActivity);
                        break;
                    case "Acerca de...":
                        intIntentActivity  = new Intent(getApplicationContext(), AcercaDeActivity.class);
                        startActivity(intIntentActivity);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), strMenuSeleccionado, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
