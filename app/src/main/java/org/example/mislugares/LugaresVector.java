package org.example.mislugares;

import java.util.ArrayList;
import java.util.List;

public class LugaresVector implements Lugares {

    protected List<Lugar> vectorLugares = ejemploLugares();

    public LugaresVector() {
        this.vectorLugares =  ejemploLugares();
    }

    public Lugar elemento(int id) {
        return this.vectorLugares.get(id);
    }

    public void anyade(Lugar lugar) {
        this.vectorLugares.add(lugar);
    }

    public int nuevo() {
        Lugar lugar = new Lugar();
        this.vectorLugares.add(lugar);
        return this.vectorLugares.size()-1;
    }

    public void borrar(int id) {
        this.vectorLugares.remove(id);
    }

    public int tamanyo() {
        return this.vectorLugares.size();
    }

    public void actualizar(int id, Lugar lugar) {
        this.vectorLugares.set(id,lugar);
    }

    public static ArrayList<Lugar> ejemploLugares(){
            ArrayList<Lugar> lugares = new ArrayList<Lugar>();
            lugares.add(new Lugar("Santuario Ayinrehue","Fancisco Salazar",-38.7513177,-72.6173259,90878878,
                    "" + "sin pagina","Lugar de meditación",10, TipoLugar.RELIGION));
            lugares.add(new Lugar("UFRO","Fancisco Salazar",-38.7513177,-72.6173259,65456785,
                "" + "www.ufro.cl","Universidad estatal",10, TipoLugar.EDUCACION));
            lugares.add(new Lugar("Casa","Cielo",-38.7513177,-72.6173259,65456785,
                "" + "www.casa.cl","Por ahi",10, TipoLugar.HOTEL));
            return lugares;
    }
}
