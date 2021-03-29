package com.example.petshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petshare.classes.animais_desaparecidos;
import com.example.petshare.classes.artigos;
import com.example.petshare.classes.curio;
import com.example.petshare.classes.listar;
import com.example.petshare.classes.lojas;

public class mainactivity2 extends AppCompatActivity {


    ImageButton btbanco, btlojas, btartigos,btcuriosidades,btdesaparecidos;
    TextView textView4, textView5, textView3, textView2, textView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        btlojas = findViewById(R.id.btlojas);
        btbanco = findViewById(R.id.btbanco);
        btartigos = findViewById(R.id.btartigos);
        btcuriosidades = findViewById(R.id.btcuriosidades);
        btdesaparecidos = findViewById(R.id.btDesaparecidos);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView2 = findViewById(R.id.textView2);
        textView5 = findViewById(R.id.textView5);
        textView9 = findViewById(R.id.textView9);

        getSupportActionBar().setTitle("Tópicos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btbanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btbanco = new Intent(mainactivity2.this, listar.class);
                startActivity(btbanco);
            }
        });
        btcuriosidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btcuriosidades = new Intent(mainactivity2.this, curio.class);
                startActivity(btcuriosidades);
            }
        });
        btartigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btartigos = new Intent(mainactivity2.this, artigos.class);
                startActivity(btartigos);
            }
        });
        btlojas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btlojas = new Intent(mainactivity2.this, lojas.class);
                startActivity(btlojas);
            }
        });
        btdesaparecidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent animaisDes = new Intent(mainactivity2.this, animais_desaparecidos.class);
                startActivity(animaisDes);
            }
        });
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}