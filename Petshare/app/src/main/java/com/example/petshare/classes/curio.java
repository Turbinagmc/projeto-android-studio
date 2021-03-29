package com.example.petshare.classes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petshare.R;

public class curio extends AppCompatActivity {

    TextView cachorro, gato;
    ImageButton btcachorro, btgato;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("curiosidades");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setContentView(R.layout.activity_curi);
        gato = findViewById(R.id.textViewgato);
        cachorro = findViewById(R.id.textViewcachorro);
        btcachorro = findViewById(R.id.btcachorro);
        btgato = findViewById(R.id.btgato);

        btcachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btcachorro = new Intent(curio.this,curiosidadescachorro.class);
                startActivity(btcachorro);
            }
        });
        btgato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btgato = new Intent(curio.this,curiosidadegato.class);
                startActivity(btgato);
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