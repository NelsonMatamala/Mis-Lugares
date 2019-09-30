package org.example.mislugares;

public interface Lugares {

    Lugar elemento(int id);

    void anyade(Lugar lugar);

    int nuevo();

    void borrar(int id);

    int tamanyo();

    void actualizar(int id, Lugar lugar);

}
