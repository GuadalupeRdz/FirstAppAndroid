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

import org.w3c.dom.Text;


public class MuestraCompatibilidadActivity extends AppCompatActivity {
    ImageView imgNumeroPersona1;
    ImageView imgNumeroPersona2;
    ImageView imgNivelCompatibilidad;
    TextView txvTituloCompatibilidad;
    TextView txvDescripcionCompatibilidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_compatibilidad);
        //Aqui vamos a "llenar" con los parametros que nos mando la otra vista, los TextView

        imgNumeroPersona1 = (ImageView) findViewById(R.id.imgNumeroPersona1);
        imgNumeroPersona2 = (ImageView) findViewById(R.id.imgNumeroPersona2);
        imgNivelCompatibilidad = (ImageView) findViewById(R.id.imgNivelCompatibilidad);
        txvDescripcionCompatibilidad = (TextView) findViewById(R.id.txvDescripcionCompatibilidad);
        txvTituloCompatibilidad = (TextView) findViewById(R.id.txvTituloCompatibilidad);

        //Aqui indico que estos elementos los voy a cachar en un bundle zip, mediante el getExtras del intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int intNumeroPersona1 = 0;
        int intNumeroPersona2 = 0;
        String strNivelCompatibilidad = "";

        //Valido el bundle
        if (bundle != null) {
            //Extraigo la info del bundle extras y lo asigno al edittext
            intNumeroPersona1 = Integer.parseInt(bundle.get("NumeroPersona1").toString());
            intNumeroPersona2 = Integer.parseInt(bundle.get("NumeroPersona2").toString());
            strNivelCompatibilidad = bundle.get("NivelCompatibilidad").toString();
        }
        Resources res = getResources();

        switch (intNumeroPersona1) {
            case 1:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_1);
                break;
            case 2:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_2);
                break;
            case 3:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_3);
                break;
            case 4:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_4);
                break;
            case 5:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_5);
                break;
            case 6:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_6);
                break;
            case 7:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_7);
                break;
            case 8:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_8);
                break;
            case 9:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_9);
                break;
            default:
                imgNumeroPersona1.setImageResource(R.mipmap.ic_np_0);
                break;
        }

        switch (intNumeroPersona2) {
            case 1:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_1);
                break;
            case 2:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_2);
                break;
            case 3:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_3);
                break;
            case 4:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_4);
                break;
            case 5:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_5);
                break;
            case 6:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_6);
                break;
            case 7:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_7);
                break;
            case 8:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_8);
                break;
            case 9:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_9);
                break;
            default:
                imgNumeroPersona2.setImageResource(R.mipmap.ic_np_0);
                break;
        }
        switch (strNivelCompatibilidad) {
            case "Baja":
                imgNivelCompatibilidad.setImageResource(R.mipmap.ic_comp_low);
                txvTituloCompatibilidad.setText(strNivelCompatibilidad);
                txvDescripcionCompatibilidad.setText(res.getString(R.string.mcp_DescCompatibilidadBaja));
                break;
            case "Media":
                imgNivelCompatibilidad.setImageResource(R.mipmap.ic_comp_medium);
                txvTituloCompatibilidad.setText(strNivelCompatibilidad);
                txvDescripcionCompatibilidad.setText(res.getString(R.string.mcp_DescCompatibilidadMedia));
                break;
            case "Alta":
                imgNivelCompatibilidad.setImageResource(R.mipmap.ic_comp_hig);
                txvTituloCompatibilidad.setText(strNivelCompatibilidad);
                txvDescripcionCompatibilidad.setText(res.getString(R.string.mcp_DescCompatibilidadAlta));
                break;
            default:
                imgNivelCompatibilidad.setImageResource(R.mipmap.ic_comp_na);
                txvTituloCompatibilidad.setText(strNivelCompatibilidad);
                txvDescripcionCompatibilidad.setText(res.getString(R.string.mcp_DescCompatibilidadNA));
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_muestra_compatibilidad, menu);
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
