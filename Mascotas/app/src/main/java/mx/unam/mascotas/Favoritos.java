package mx.unam.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by john on 21/08/2016.
 */
public class Favoritos extends AppCompatActivity {
   // Mascota mascota;
    private ImageView ivRegresar;
    ArrayList<Mascota> listMacotasFavoritas;
    private RecyclerView rvMascotasFavoritas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos);

        rvMascotasFavoritas=(RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotasFavoritas.setLayoutManager(llm);

        //listMacotasFavoritas=mascota.ListaFavoritos();
        InicializarLista();

        InicializarAdaptdor();

        ivRegresar = (ImageView) findViewById(R.id.ivRegresar);

        ivRegresar.setOnClickListener(new AdapterView.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent intent=new Intent(Favoritos.this,MainActivity.class);
                                              startActivity(intent);
                                          }
                                      }
        );

    }

    public void InicializarAdaptdor(){
        MascotaAdaptador adaptador=new MascotaAdaptador(listMacotasFavoritas);
        rvMascotasFavoritas.setAdapter(adaptador);
    }

    public void InicializarLista(){
        listMacotasFavoritas=new ArrayList<Mascota>();
        listMacotasFavoritas.add(new Mascota("Boby",R.drawable.perro1,2));
        listMacotasFavoritas.add(new Mascota("Fido",R.drawable.perro2,1));
    }

}
