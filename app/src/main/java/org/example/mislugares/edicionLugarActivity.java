package org.example.mislugares;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class edicionLugarActivity extends AppCompatActivity {
    private long id;
    private Lugar lugar;
    private EditText nombre;
    private Spinner tipo;
    private EditText direccion;
    private EditText telefono;
    private EditText url;
    private EditText comentario;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicion_lugar);
        Bundle extras = getIntent().getExtras();
        id = extras.getLong("id", -1);
        lugar = ScrollingActivity.lugares.elemento((int) id);

        nombre = findViewById(R.id.id_nombre);
        direccion = findViewById(R.id.id_direccion);
        telefono = findViewById(R.id.id_telefono);
        url = findViewById(R.id.id_url);
        comentario = findViewById(R.id.id_comentario);

        nombre.setText(lugar.getNombre());
        direccion.setText(lugar.getComentario());
        telefono.setText(Integer.toString(lugar.getTelefono()));
        url.setText(lugar.getUrl());
        comentario.setText(lugar.getComentario());

        tipo = findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,TipoLugar.getNombres());
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
        tipo.setAdapter(adaptador);
        tipo.setSelection(lugar.getTipo().ordinal());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edicion,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.cancelar:
                Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.guardar:

                lugar.setNombre(nombre.getText().toString());
                lugar.setTipo(TipoLugar.values()[tipo.getSelectedItemPosition()]);
                lugar.setDireccion(direccion.getText().toString());
                lugar.setTelefono(Integer.parseInt(telefono.getText().toString()));
                lugar.setUrl(url.getText().toString());
                lugar.setComentario(comentario.getText().toString());
                ScrollingActivity.lugares.actualizar((int)id,lugar);
                Log.e("mensaje",""+lugar);

                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
