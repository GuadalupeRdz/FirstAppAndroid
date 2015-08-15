package com.hetherlat.numerallove;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class MuestraNumeroPersonalidadActivity extends AppCompatActivity {

    //Aqui vamos a declarar los objetos que participan del Layout (grafico) en los eventos (código java)
    ImageView imgNumeroPersonalidad;
    TextView txvTituloPersonalidad;
    TextView txvDescripcionPersonalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_numero_personalidad);

        //Aqui vamos a "llenar" con los parametros que nos mando la otra vista, los TextView

        imgNumeroPersonalidad = (ImageView) findViewById(R.id.imgNumeroPersonalidad);
        txvTituloPersonalidad = (TextView) findViewById(R.id.txvTituloNumeroPersonalidad);
        txvDescripcionPersonalidad = (TextView) findViewById(R.id.txvDescripcionNumeroPersonalidad);

        //Aqui indico que estos elementos los voy a cachar en un bundle zip, mediante el getExtras del intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int intNumeroPersonal = 0;

        //Valido el bundle
        if (bundle != null){
            //Extraigo la info del bundle extras y lo asigno al edittext
             intNumeroPersonal = Integer.parseInt( bundle.get("NumeroPersonalidad").toString());
        }
        Resources res = getResources();

       switch (intNumeroPersonal) {
           case 1:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_1);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad1));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad1));
               break;
           case 2:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_2);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad2));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad2));
               break;
           case 3:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_3);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad3));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad3));
               break;
           case 4:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_4);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad4));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad4));
               break;
           case 5:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_5);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad5));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad5));
               break;
           case 6:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_6);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad6));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad6));
               break;
           case 7:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_7);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad7));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad7));
               break;
           case 8:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_8);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad8));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad8));
               break;
           case 9:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_9);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad9));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad9));
               break;
           default:
               imgNumeroPersonalidad.setImageResource(R.mipmap.ic_np_0);
               txvTituloPersonalidad.setText(res.getString(R.string.mnp_Nombre_Personalidad0));
               txvDescripcionPersonalidad.setText(res.getString(R.string.mnp_Desc_Personalidad0));
               break;
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_muestra_numero_personalidad, menu);
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
