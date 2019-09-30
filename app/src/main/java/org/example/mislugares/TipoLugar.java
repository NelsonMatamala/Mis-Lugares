package org.example.mislugares;

public enum TipoLugar {
    OTROS ("Otros", 5),
    RESTAURANTE ("Restaurante", 2),
    BAR ("Bar", R.drawable.bar),
    RELIGION ("Religion" , R.drawable.religion),
    HOTEL ("Hotel", R.drawable.hotel),
    COMPRAS ("Compras",0),
    NATURALEZA ("Naturaleza",0),
    EDUCACION ("Educacion",R.drawable.educacion);

    private final String texto;
    private final int recurso;

    TipoLugar(String texto, int recurso) {
        this.texto = texto;
        this.recurso = recurso;
    }

    public String getTexto() {
        return texto;
    }

    public int getRecurso() {
        return recurso;
    }

    public static String[] getNombres(){
        String[] resultado = new String[TipoLugar.values().length];
        for(TipoLugar tipo : TipoLugar.values()){
            resultado[tipo.ordinal()] = tipo.texto;
        }
        return resultado;
        
    }
}
