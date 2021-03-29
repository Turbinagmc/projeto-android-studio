package com.example.petshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petshare.classes.Novo_registro;
import com.example.petshare.crud.DatabaseHelp;

public class MainActivity extends AppCompatActivity {

    EditText name,senha;
    Button btentrar, btcadastro;
    DatabaseHelp db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelp(this);
        name = findViewById(R.id.editTextname);
        senha = findViewById(R.id.editTextsenha);
        btentrar = findViewById(R.id.btentrar);
        btcadastro = findViewById(R.id.btcadastro);

        btentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no = name.getText().toString();
                String se = senha.getText().toString();
                if(no.equals("") || se.equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha todos os campos",Toast.LENGTH_SHORT).show();
                } else {
                    Boolean chknomesenha = db.nomesenha(no,se);
                    if(chknomesenha == true) {
                        Intent btentrar = new Intent(MainActivity.this, mainactivity2.class);
                        startActivity(btentrar);
                    } else {
                        Toast.makeText(getApplicationContext(),"usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btcadastro = new Intent(MainActivity.this, Novo_registro.class);
                startActivity(btcadastro);

            }
        });
    }



}
