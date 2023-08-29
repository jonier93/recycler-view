package com.example.recyclerview_class_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recybleBooks;
    private TextView tvTitulo;
    private TextView tvEscritor;
    private ImageView imagen;
    private int fotos [];
    private String titulos [];
    private  String escritores [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
        LinearLayoutManager objLayourManager = new LinearLayoutManager(MainActivity.this);
        recybleBooks.setLayoutManager(objLayourManager);
        recybleBooks.setAdapter(new AdapterBook());
    }

    private void inicializar() {
        recybleBooks = findViewById(R.id.recyclerBooks);
        fotos = new int [] {R.drawable.cien_years_soledad, R.drawable.conde_monte_cristo,
            R.drawable.la_iliada, R.drawable.el_principito};
        titulos = new String[] {"Cien años de soledad", "El conde de montecristo", "La iliada",
                "El principito"};
        escritores = new String[] {"Gabriel Garcia Marquez", "Alejandro Dumas", "Homero",
                "Antoine de Saint"};
    }

    public class AdapterBook extends RecyclerView.Adapter<AdapterBook.AdapterHolder> {
        @NonNull
        @Override
        public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdapterHolder(getLayoutInflater().inflate(R.layout.cardview, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return escritores.length;
        }

        public class AdapterHolder extends RecyclerView.ViewHolder {
            public AdapterHolder(@NonNull View itemView) {
                super(itemView);
                imagen = itemView.findViewById(R.id.imagen);
                tvTitulo = itemView.findViewById(R.id.tvTitulo);
                tvEscritor = itemView.findViewById(R.id.tvEscritor);
            }

            public void imprimir(int position) {
                imagen.setImageResource(fotos[position]);
                tvTitulo.setText(titulos[position]);
                tvEscritor.setText(escritores[position]);
            }
        }
    }

}