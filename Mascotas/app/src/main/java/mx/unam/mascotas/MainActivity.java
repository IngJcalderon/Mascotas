package mx.unam.mascotas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Mascota mascota;
    ArrayList<Mascota> listMacotas;
    private RecyclerView rvMascotas;
    private TextView tvfavorito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMascotas=(RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        //listMacotas=mascota.InicializarLista();
        InicializarLista();

        InicializarAdaptdor();

        tvfavorito=(TextView)  findViewById(R.id.tvfavorito);

        tvfavorito.setOnClickListener(new AdapterView.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent intent=new Intent(MainActivity.this,Favoritos.class);
                                              startActivity(intent);
                                          }
                                      }
        );



    }

    public void InicializarAdaptdor(){
        MascotaAdaptador adaptador=new MascotaAdaptador(listMacotas);
        rvMascotas.setAdapter(adaptador);
    }


    public void InicializarLista(){
        listMacotas=new ArrayList<Mascota>();
        listMacotas.add(new Mascota("Boby",R.drawable.perro1,2));
        listMacotas.add(new Mascota("Fido",R.drawable.perro2,1));
        listMacotas.add(new Mascota("Spy",R.drawable.perro3,2));
        listMacotas.add(new Mascota("Chester",R.drawable.perro4,1));
        listMacotas.add(new Mascota("Yago",R.drawable.perro5,2));
    }

    public void agregarFAB(){
        FloatingActionButton miFAB=(FloatingActionButton) findViewById(R.id.btnCamara);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
