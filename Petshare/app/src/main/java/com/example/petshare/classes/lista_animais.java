package com.example.petshare.classes;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petshare.R;
import com.example.petshare.crud.DatabaseHelp;

import java.util.ArrayList;

public class lista_animais extends AppCompatActivity {


    ListView lvanimais;
    String mensagem="";
    DatabaseHelp db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_animais);

        getSupportActionBar().setTitle("Lista ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        lvanimais = findViewById(R.id.lvAnimaisDesaparecidos);
        db = new DatabaseHelp(this);
        ArrayList<String> exibir = new ArrayList<>();
        Cursor getListaAnimais = db.getListaAnimais();

        if(getListaAnimais.getCount() == 0){
            Toast.makeText(getApplicationContext(), "Não há registros", Toast.LENGTH_SHORT).show();
        } else{
            while (getListaAnimais.moveToNext()){
                exibir.add("Id: " + getListaAnimais.getString(0));
                exibir.add("Bairro onde desapareceu: "+ getListaAnimais.getString(9));
                exibir.add("O animal: " + getListaAnimais.getString(8));
                exibir.add("Raça do animal: " + getListaAnimais.getString(4));
                exibir.add("Cor do animal: " + getListaAnimais.getString(5));
                exibir.add("Porte do animal: " + getListaAnimais.getString(6));
                exibir.add("Sexo do animal: " + getListaAnimais.getString(7));
                exibir.add("Numéro de contato: " + getListaAnimais.getString(1));
                exibir.add("Data do desaparecimento: " + getListaAnimais.getString(2));
                exibir.add("Descrição do animal: " + getListaAnimais.getString(3));
                exibir.add(mensagem="\n");
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,exibir);

                lvanimais.setAdapter(listAdapter);
            }
        }
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
