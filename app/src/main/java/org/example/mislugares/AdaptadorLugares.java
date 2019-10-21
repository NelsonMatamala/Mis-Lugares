package org.example.mislugares;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdaptadorLugares extends RecyclerView.Adapter<AdaptadorLugares.ViewHolder> {
    protected Lugares lugares;
    protected LayoutInflater inflador;
    protected Context contexto;
    protected View.OnClickListener onClickListener;
    public AdaptadorLugares(Context contexto,Lugares lugares){
        this.contexto = contexto;
        this.lugares = lugares;
        inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //Creamos nuestro ViewHolder, con los tipos de elementos a modificar
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre, direccion;
        public ImageView foto;
        public RatingBar valoracion;
        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            direccion = itemView.findViewById(R.id.direccion);
            foto = itemView.findViewById(R.id.foto);
            valoracion= itemView.findViewById(R.id.valoracion);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflador.inflate(R.layout.elemento_lista,viewGroup,false);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorLugares.ViewHolder viewHolder, int i) {
        Lugar lugar = lugares.elemento(i);
        personalizaVista(viewHolder,lugar);
    }

    // Personalizamos un ViewHolder a partir de un lugar
    public void personalizaVista(ViewHolder holder,Lugar lugar) {
        holder.nombre.setText(lugar.getNombre());
        holder.direccion.setText(lugar.getDireccion());
        int id = R.drawable.otros;
        switch(lugar.getTipo()) {

            case BAR:    id = R.drawable.bar;     break;
            case RELIGION:    id = R.drawable.religion;     break;
            case HOTEL:   id = R.drawable.hotel;    break;
            case EDUCACION: id = R.drawable.educacion;  break;}

            holder.foto.setImageResource(id);
            holder.foto.setScaleType(ImageView.ScaleType.FIT_END);
            holder.valoracion.setRating(lugar.getValoracion());
        }


    @Override
    public int getItemCount(){
        return lugares.tamanyo();
    }


}
