package com.example.petshare.classes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petshare.R;

public class artigos extends AppCompatActivity {

    Button art,art2,art3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setTitle("artigos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setContentView(R.layout.activity_artigos);

        art = findViewById(R.id.bt1);
        art2 = findViewById(R.id.bt2);


        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent art = new Intent(artigos.this, art1.class);
                startActivity(art);
            }
        });
        art2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent art2 = new Intent(artigos.this, art2.class);
                startActivity(art2);
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
