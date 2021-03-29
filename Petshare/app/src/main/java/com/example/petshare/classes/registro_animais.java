package com.example.petshare.classes;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petshare.R;
import com.example.petshare.crud.DatabaseHelp;
import com.example.petshare.utils.MaskEdiUtils;

public class registro_animais extends AppCompatActivity {


    EditText number,data,descricao,bairro;
    EditText Cor,raca,porte,sexo,animaldes;
    Button btRegister;
    DatabaseHelp db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_animais);



        number = findViewById(R.id.NumContato);
        number.addTextChangedListener(MaskEdiUtils.insert(MaskEdiUtils.FORMAT_FONE,number));
        data = findViewById(R.id.Data);
        data.addTextChangedListener(MaskEdiUtils.insert(MaskEdiUtils.FORMAT_DATA,data));
        descricao = findViewById(R.id.Descricao);
        bairro = findViewById(R.id.Bairro);
        Cor = findViewById(R.id.Cor);
        raca = findViewById(R.id.Raca);
        porte = findViewById(R.id.Porte);
        sexo = findViewById(R.id.Sexo);
        animaldes = findViewById(R.id.AnimalDes);
        btRegister = findViewById(R.id.register);
        db = new DatabaseHelp(this);


        getSupportActionBar().setTitle("Registro");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nu = number.getText().toString();
                String da = data.getText().toString();
                String de = descricao.getText().toString();
                String bai = bairro.getText().toString();
                String cor = Cor.getText().toString();
                String por = porte.getText().toString();
                String se = sexo.getText().toString();
                String ani = animaldes.getText().toString();
                String ra = raca.getText().toString();
                 if(nu.equals("") || da.equals("") || de.equals("") || bai.equals("") || cor.equals("") || por.equals("") || se.equals("") || ani.equals("") || ra.equals("")){
                     Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                 }else {
                     Boolean insert = db.insertanimais(nu,da,de,ra,cor,por,se,ani,bai);

                         Toast.makeText(getApplicationContext(), "Registrado com sucesso!", Toast.LENGTH_SHORT).show();
                         finish();

                 }

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