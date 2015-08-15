package com.hetherlat.numerallove;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Guadalupe on 09/08/2015.
 */
public class ActividadAdapter extends ArrayAdapter<Actividades> {

    //Elementos que voy a utilizar
    //context, colocar el recurso, y el conjunt de datos

    Context context;
    int layoutResourceId;
    Actividades datos[] = null;


    //Vista que va ir colocando los elementos conforme se van recibiendo
    public ActividadAdapter(Context context, int layoutResourceId, Actividades[] datos) {
        super(context, layoutResourceId, datos);

        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.datos = datos;
    }

    //Vista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View actividad = convertView;

        //Holder, mantener referencia a cada uno de los elementos que tengamos para manipularlos
        //Con esto se ccede de manera sencilla al elemento; se usa para disminuir recursos
        ActividadHolder holder = null;

        if (actividad == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            actividad = inflater.inflate(layoutResourceId, parent, false);

            holder = new ActividadHolder();
            holder.imagen = (ImageView) actividad.findViewById(R.id.imgImagenActividad);
            holder.texto = (TextView) actividad.findViewById(R.id.txvTextoActividad);
            actividad.setTag(holder);

        } else {
            holder = (ActividadHolder) actividad.getTag();
        }

        Actividades actividades = datos[position];
        holder.texto.setText(actividades.actividadNombre);
        holder.imagen.setImageResource(actividades.actividadImagen);

        return actividad;
    }

    static class ActividadHolder {
        ImageView imagen;
        TextView texto;
    }
}
