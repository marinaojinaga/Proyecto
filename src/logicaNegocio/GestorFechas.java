package logicaNegocio;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestorFechas {
    public Calendar deStringsAFecha(String día, String mes, String anyo){
        int d = Integer.parseInt(día);
        int m = Integer.parseInt(mes);
        int a = Integer.parseInt(anyo);
        Calendar fecha = Calendar.getInstance();
        fecha.set(a,m,d);
        return fecha;
    }
}
