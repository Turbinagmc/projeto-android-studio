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

public class Novo_registro extends AppCompatActivity {

    DatabaseHelp db;
    EditText nome,senha,email,nomeus;
    Button btRegistrar,btVoltar;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_novo);
            db = new DatabaseHelp(this);
            nomeus = findViewById(R.id.Nomeus);
            nome = findViewById(R.id.Nome);
            email = findViewById(R.id.Email);
            senha = findViewById(R.id.Senha);
            btVoltar=findViewById(R.id.btVoltar);
            btRegistrar = findViewById(R.id.buttonCadastrar);



            btRegistrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // crio Strings par pegar os dodos digitados agor dentro do botão
                    String ns = nomeus.getText().toString();
                    String n = nome.getText().toString();
                    String s = senha.getText().toString();
                    String em = email.getText().toString();
                    //comparo se os campos estão fazios
                    if(ns.equals("") || n.equals("") || s.equals("") || em.equals("")){
                        //caso estajam vazios exibe a mensagem
                        Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    } else {
                        //verifico se o e-email exite no banco de dados chamando o método verifia e-mail e passo o campo que de fazer essa verificação
                        // true ele naõ existe então realizo a cadastro chamando o métod insert e passo os campos onde o usuario digitou e incluo dentro da banco
                        // de dados
                        Boolean chknomeus = db.chjnomeus(ns);
                        if(chknomeus==true){
                            Boolean chkemail = db.chkemail(em);
                            if(chkemail == true) {
                                Boolean insert = db.insert(n, s, em, ns);
                                Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                                finish();
                            } else{
                                Toast.makeText(getApplicationContext(), "Esse e-mail já está em uso", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // caso o métod retorne false o e-mail já existe o na banco então exibo a mensagem
                            Toast.makeText(getApplicationContext(),"Esse nome de usuário já está em uso",Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            });
            btVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });


            getSupportActionBar().setTitle("Registro");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);



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

