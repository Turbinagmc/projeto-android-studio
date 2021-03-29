package com.example.petshare.classes;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petshare.R;
import com.example.petshare.crud.DatabaseHelp;

import java.util.ArrayList;

public class listar extends AppCompatActivity {
    // precisa criar uma variavél da classe Databasehelp para usar nessa atual o nome foi db
    ListView lvUsuarios;
    Button btVoltar;
    DatabaseHelp db;
    String mensagem ="";
// a String mensagem serve para escrever o nome dos campos ex nome e-mail...
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        getSupportActionBar().setTitle("cadastro");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // db new e o contexto é this (essa classe)
        db = new DatabaseHelp(this);
        btVoltar = findViewById(R.id.btAtualizar);

        lvUsuarios = findViewById(R.id.lvUsuarios);
        // para exibir os dados do banco de dados em uma liste view é necessário criar um arrylist ja´que a list e o banco de dados
        // são tipos diferentes
        // sendo o arryList<String> precisa ser String pelo menos nesse caso
        // o nome do arry e listar
        ArrayList<String> listar = new ArrayList<>();
        //nova variável do tipo cursor "getLista" para pegar o método getLista da DatabaseHelp
        Cursor getlista = db.getLista();
        // caso não exista registro exibe a mensagem
        // para verificar se existe ou não usa o getCount e o compara a 0
        if(getlista.getCount() == 0){
            Toast.makeText(this, "Não há registros", Toast.LENGTH_SHORT).show();
        } else{
            // faz um while para caso exista mais de um registro
            // com moveToNet() para se mover para o próximo se existir
            while (getlista.moveToNext()){
            //aqui pego a variável listar .add para adicionar na lista
            // a string mensagem para exibir um texto antes de exibir a coluna da tabela
             // + para concatenar getlista.getString onde indico a coluna na tabela o id é no zero e assim por diante
                listar.add(mensagem="id: " + getlista.getString(0));
                listar.add(mensagem="Nome de usuário: " + getlista.getString(4));
                listar.add(mensagem = "Nome: " + getlista.getString(3));
                listar.add(mensagem = "E-mail: " + getlista.getString(1));
                listar.add(mensagem = "Senha : " + getlista.getString(2));
                listar.add(mensagem="\n");
                //crio um listAdapter , o contexto é this, o simple_list-item é uma view do próprio android studio
                //passp o listar pra exibir a lista nessa view
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listar);
                // por fim set no lvUsuarios o listAdapter
                lvUsuarios.setAdapter(listAdapter);
            }
        }
         btVoltar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(getApplicationContext(), "Lista atualizada", Toast.LENGTH_SHORT).show();
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
