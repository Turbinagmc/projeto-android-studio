package com.example.petshare.classes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petshare.R;

public class animais_desaparecidos extends AppCompatActivity {

    Button btRegistro,btLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animais_desaparecidos);
        btRegistro = findViewById(R.id.btDesaparecido);
        btLista = findViewById(R.id.btListaAnimais);
        getSupportActionBar().setTitle("Animais desaparecidos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent en = new Intent(animais_desaparecidos.this, registro_animais.class);
                startActivity(en);
            }
        });
       btLista.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            Intent lv = new Intent(animais_desaparecidos.this, lista_animais.class);
            startActivity(lv);
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
