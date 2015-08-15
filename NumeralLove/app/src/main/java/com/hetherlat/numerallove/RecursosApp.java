package com.hetherlat.numerallove;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Guadalupe on 06/08/2015.
 */
public class RecursosApp {

    public RecursosApp() {
        super();
    }

    public boolean ValidaEntradaFechas(String Fecha){
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(Fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
}

    public int getNumeroVida(String FechaCalculos) {
        int NumeroVida = 0;
        int intResultadoNumeroVida = 0;
        try {
            NumeroVida += Integer.parseInt(FechaCalculos.substring(0, 1));
            NumeroVida += Integer.parseInt(FechaCalculos.substring(1, 2));
            NumeroVida += Integer.parseInt(FechaCalculos.substring(3, 4));
            NumeroVida += Integer.parseInt(FechaCalculos.substring(4, 5));
            NumeroVida += Integer.parseInt(FechaCalculos.substring(6, 7));
            NumeroVida += Integer.parseInt(FechaCalculos.substring(7, 8));
            NumeroVida += Integer.parseInt(FechaCalculos.substring(8, 9));
            NumeroVida += Integer.parseInt(FechaCalculos.substring(9, 10));
            intResultadoNumeroVida = ReduceNumero(NumeroVida);

        } catch (Exception e) {
            NumeroVida = 0;
        }
        return intResultadoNumeroVida;
    }

    private int ReduceNumero(int NumeroVida) {
        int Resultado = 0;
        if (NumeroVida <= 9) {
            Resultado = NumeroVida;
        } else {
            String auxString = String.valueOf(NumeroVida);
            Resultado += Integer.parseInt(auxString.substring(0, 1));
            Resultado += Integer.parseInt(auxString.substring(1, 2));
            ReduceNumero(Resultado);
        }
    return Resultado;
}

    public String getNivelCompatibilidad(int NumeroPersona1, int NumeroPersona2) {
        int auxSuma = 0;
        int divSuma = 0;
        String strNivelCompatibilidad = "";
        try {
            auxSuma = NumeroPersona1 + NumeroPersona2;
            if (auxSuma<=9){
                divSuma = auxSuma;
            }
            else{
                divSuma = auxSuma / 3;
            }


            if (divSuma <= 3) {
                strNivelCompatibilidad = "Baja";
            } else if ( divSuma <= 6) {
                strNivelCompatibilidad = "Media";
            } else {
                strNivelCompatibilidad = "Alta";
            }
        } catch (Exception e) {
            strNivelCompatibilidad = "";
        }
        return strNivelCompatibilidad;
    }


}
